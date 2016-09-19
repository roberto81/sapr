package org.sapr.restcontroller;

import java.security.Principal;
import java.util.List;

import org.sapr.webservice.User;
import org.sapr.webservice.UserManagement;
import org.sapr.webservice.UserManagementService;
import org.sapr.webservice.UserReq;
import org.sapr.webservice.UserResp;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
	
	
	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
	
	@RequestMapping(value ="/getUserInfo", produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody User getUserInfo(String username){
		
		UserManagementService usrMngService = new UserManagementService();
		UserManagement usMng = usrMngService.getUserManagementPort();
		
		User us = new User();
		us.setUsername(username);
		
		UserReq usRqs = new UserReq();
		usRqs.setUser(us);
		
		UserResp usRsp = usMng.readUser(usRqs);
		
		return usRsp.getUser();
		
	}
	
	@RequestMapping(value="/getAllUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<User> getAllUser(){
		
		UserManagementService usrMngService = new UserManagementService();
		UserManagement usMng = usrMngService.getUserManagementPort();
		
		UserResp usRsp = usMng.getAllUser();
		
		return usRsp.getUserList();
	}
	
	@RequestMapping(value="/deleteUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean deleteUser(String username){
		
		UserManagementService usrMngService = new UserManagementService();
		UserManagement usMng = usrMngService.getUserManagementPort();
		
		User us = new User();
		us.setUsername(username);
		
		UserReq request = new UserReq();
		request.setUser(us);
		
		
		UserResp usRsp = usMng.deleteUser(request);
		if(usRsp.getErrorCode().equals("0")){
			return true;
		}
		
		return false;
	}
	
	@RequestMapping(value="/insertUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserResp insertUser(User user){
		
		UserManagementService usrMngService = new UserManagementService();
		UserManagement usMng = usrMngService.getUserManagementPort();
		
		UserReq request = new UserReq();
		request.setUser(user);
		
		UserResp response = usMng.insertUser(request);
		
		return response;
	}
}
