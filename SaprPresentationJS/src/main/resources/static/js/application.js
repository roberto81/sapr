var app = angular.module('myApp', ["ngRoute",'ui.bootstrap']);

app.config(function($routeProvider, $httpProvider) {
    $routeProvider
        .when("/", {
            templateUrl : "asset/main.html"
        })
        .when("/pilotarea", {
            templateUrl : "asset/pilotarea.html",
            controller : "pilotCtrl",
            controllerAs : "pctrl"
        })
        .when("/adminarea", {
            templateUrl : "asset/adminarea.html",
                controller : "adminCtrl",
                controllerAs : "actrl"
        }).when("/usermanagement",{
        	templateUrl : "asset/usermanagement.html",
        	controller : 'userManagement',
        	controllerAs : 'usMng'
        }).when("/dronemanagement",{
        	templateUrl : "asset/dronemanagement.html",
            controller : 'droneManagement',
            controllerAs : 'drMng'
        }).when("/managementchecklist",{
        	templateUrl : "asset/managementchecklist.html"
        });
    $httpProvider.defaults.useXDomain = true;
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
});

app.factory('userAccountService',function($http){
	var currentUser;
	
	return {
		getUserInfo: function(username){
			return $http.get(
							'getUserInfo',
							{params:{username:username}}
						);
		}
	};
});

app.factory('userManagementService',function($http){
	var users;
	
	return {
		getAllUser: function(){
			return $http.get('getAllUser');
		},
        deleteUser: function(username){
            return $http.get(
                            'deleteUser',
                            {params:{username:username}}
                );
        },
        insertUser: function(user){
        	return $http.get(
        					'insertUser',
        					{
        						params:{
        							firstName:user.firstName,
        							lastName:user.lastName,
        							age:user.age,
        							username:user.username,
        							password:user.password,
        							role:user.role,
        							enabled:user.enabled
        						}
        					}
        		);
        }
	};
});

app.factory('droneManagementService',function($http){
	return {
		getAllDrone : function(){
			return $http.get("getAllDrone");
		},
		deleteDrone: function(code){
            return $http.get(
                            "deleteDrone",{params:{
                            	code:code
                            }});
        },
        insertDrone: function(drone){
            return $http.get("insertDrone",
                                {
                                    params:{
                                        code:drone.idcode,
                                        brand:drone.brand,
                                        model:drone.model,
                                        numberRotors:drone.numberRotors,
                                        enginePower:drone.enginePower,
                                        weight:drone.weight
                                    }
                                }
                        );
        },
        updateDrone: function(drone){
            return $http.get("updateDrone",
                                {
                                    params:{
                                        code:drone.code,
                                        brand:drone.brand,
                                        model:drone.model,
                                        numberRotors:drone.numberRotors,
                                        enginePower:drone.enginePower,
                                        weight:drone.weight
                                    }
                                }
                        );
        }
	};
});

app.controller('mainCtrl',function($rootScope, $http, $location, $route) {

    var self = this;

    self.tab = function(route) {
        return $route.current && route === $route.current.controller;
    };

    var authenticate = function(credentials, callback) {

        var headers = credentials ? {
            authorization : "Basic "
            + btoa(credentials.username + ":"
                + credentials.password)
        } : {};

        $http.get('user', {
            headers : headers
        }).then(function(response) {
            if (response.data.name) {
            	$rootScope.authenticated = true;
            	$rootScope.authority = response.data.authorities[0].authority;
            	$rootScope.username = response.data.name;
            } else {
                $rootScope.authenticated = false;
            }
            callback && callback($rootScope.authenticated);
        }, function() {
            $rootScope.authenticated = false;
            callback && callback(false);
        });

    };
    authenticate();

    self.credentials = {};
    self.login = function() {
        authenticate(self.credentials, function(authenticated) {
            if (authenticated) {
                console.log("Login succeeded");
                self.error = false;
                $rootScope.authenticated = true;
                
                if($rootScope.authority == "ROLE_USER"){
                	$location.path("/pilotarea");
                }
                if($rootScope.authority =="ROLE_ADMIN"){
                	$location.path("/adminarea");
                }
            } else {
                console.log("Login failed");
                $location.path("/");
                self.error = true;
                $rootScope.authenticated = false;
            }
        })
    };

    self.logout = function() {
        $http.post('logout', {}).finally(function() {
            $rootScope.authenticated = false;
            self.credentials={};
            $location.path("/");
        });
    };

});

app.controller('updateDroneCtrl',function($scope,$location,$uibModalInstance,upDrone,droneManagementService){
    $scope.drone = upDrone;
    $scope.close = function () {
        $uibModalInstance.dismiss('cancel');
        $location.path("/adminarea");
    };

    $scope.updateDrone = function(){
        droneManagementService.updateDrone($scope.drone).success(function(data){
                $uibModalInstance.dismiss('cancel');
                $location.path("/dronemanagement");
        });
    }
});

app.controller('popUserCtrl',function ($scope,$location,$uibModalInstance,messagePopUp){
	$scope.messaggio = messagePopUp;
    $scope.close = function () {
        $uibModalInstance.dismiss('cancel');
        $location.path("/adminarea");
    };
});

app.controller('pilotCtrl',function($rootScope,userAccountService){
	
	var pctrl = this;

	pctrl.username = $rootScope.username;
	
	pctrl.getCurrentUser = function(username){
		userAccountService.getUserInfo(username).success(function(data){
			pctrl.firstName = data.firstName;
			pctrl.lastName = data.lastName;
			pctrl.username = data.username;
			pctrl.role = data.role;
		});
		
	};
	
	pctrl.getCurrentUser(pctrl.username);
});

app.controller('adminCtrl',function($rootScope, userAccountService){
	
	var actrl = this;

	actrl.username = $rootScope.username;
	
	actrl.getCurrentUser = function(username){
		userAccountService.getUserInfo(username).success(function(data){
			actrl.firstName = data.firstName;
			actrl.lastName = data.lastName;
			actrl.username = data.username;
			actrl.role = data.role;
		});
		
	};
	
	actrl.getCurrentUser(actrl.username);
});

app.controller('userManagement',function($rootScope,$scope, $uibModal, userAccountService,userManagementService){
	var usMng = this;

	usMng.username = $rootScope.username;
	usMng.users=[];
    $scope.master = {};

    usMng.user = {};
    $scope.formGlobalError=false;
    
    $scope.formTableUser = true;
    $scope.toggleFormTableUser = function () {
        if($scope.formTableUser) {
            $scope.formTableUser = false;
        }else{
            $scope.formTableUser = true;
        }
    };


    $scope.reset = function(form) {
        if (form) {
            form.$setPristine();
            form.$setUntouched();
            usMng.user = {};
        }
        $scope.user = angular.copy($scope.master);
        $scope.formGlobalError=false;
        $scope.toggleFormTableUser();
    };

    $scope.reset();

	usMng.getCurrentUser = function(username){
		userAccountService.getUserInfo(username).success(function(data){
			usMng.firstName = data.firstName;
			usMng.lastName = data.lastName;
			usMng.username = data.username;
			usMng.role = data.role;
		});
		
	};
	
	usMng.getAllUser = function(){
		userManagementService.getAllUser().success(function(data){
			angular.copy(data,usMng.users);
		});
	};

	usMng.openPopUp = function (message) {
        var uibModalInstance = $uibModal.open({
            templateUrl:'asset/pop.html',
            controller:'popUserCtrl',
            resolve:{
                messagePopUp : function () {
                    return message;
                }
            }
        });
    };

    usMng.deleteUser = function(itemindex){
    	if ($rootScope.username != usMng.users[itemindex].username){
        	userManagementService.deleteUser(usMng.users[itemindex].username).success(function(data){
        	    usMng.users.splice(itemindex,1);
        	});
        }else{
        	usMng.openPopUp('sorry Operation denied...!!!');
        }
    };

    usMng.insertUser = function(user){
    		userManagementService.insertUser(user).success(function(data){
    			if(data.errorCode == "1"){
    				$scope.formGlobalError=true;
    			}else{
    			console.log(data);
    			usMng.openPopUp('Account created..');
    			}
    		});
    };
	
	usMng.getCurrentUser(usMng.username);
	usMng.getAllUser();
});

app.controller('droneManagement',function($rootScope,$scope,$uibModal,userAccountService,droneManagementService){
    var drMng = this;

    drMng.username = $rootScope.username;
    $scope.droneFormTaggle=true;
    drMng.drones=[];
    drMng.drone={};
    $scope.droneformGlobalError=false;

    drMng.getCurrentUser = function(username){
            userAccountService.getUserInfo(username).success(function(data){
                drMng.firstName = data.firstName;
                drMng.lastName = data.lastName;
                drMng.username = data.username;
                drMng.role = data.role;
            });
        
    };

    drMng.getCurrentUser(drMng.username);

    drMng.openUpdatePopUp = function(drone){
        var uibModalInstance = $uibModal.open({
            templateUrl:'asset/updatePop.html',
            controller:'updateDroneCtrl',
            resolve:{
                upDrone: function(){
                    return drone;
                }
            }
        });
    };

    drMng.openPopUp = function (message) {
        var uibModalInstance = $uibModal.open({
            templateUrl:'asset/pop.html',
            controller:'popUserCtrl',
            resolve:{
                messagePopUp : function () {
                    return message;
                }
            }
        });
    };

    $scope.toggleFormTableUser = function () {
        if($scope.droneFormTaggle) {
            $scope.droneFormTaggle = false;
        }else{
            $scope.droneFormTaggle = true;
        }
    };

    $scope.reset = function(form) {
        if (form) {
            form.$setPristine();
            form.$setUntouched();
        }
        $scope.toggleFormTableUser();
    };
    
    $scope.reset();

    drMng.deleteDrone = function(droneIndex){
    	droneManagementService.deleteDrone(drMng.drones[droneIndex].code).success(function(data){
    		drMng.drones.splice(droneIndex,1);
    	});
    };

    drMng.getAllDrone = function(){
    	droneManagementService.getAllDrone().success(function(data){
    		angular.copy(data.droneList,drMng.drones);
    	});
    };

    drMng.updateDrone = function(droneIndex){
        drMng.openUpdatePopUp(drMng.drones[droneIndex]);
    };

    drMng.insertDrone = function(drone){
        droneManagementService.insertDrone(drone).success(function(data){
            if (data.errorCode == "1") {
                console.log("drone esistente");
                $scope.droneformGlobalError=true;
            }else{
                drMng.openPopUp('Drone crated.....');
            }
        });
    };

    drMng.getAllDrone();

});