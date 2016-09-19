package org.sapr.service;

public class ServiceFactory implements IServiceFactory{

	@Override
	public IUserService getUserService() {
		IUserService userService = new UserService();
		// TODO Auto-generated method stub
		return userService;
	}

	@Override
	public IDroneService getDroneService() {
		IDroneService droneService = new DroneService();
		return droneService;
	}

}
