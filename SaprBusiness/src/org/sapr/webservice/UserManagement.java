package org.sapr.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.sapr.request.UserReq;
import org.sapr.response.UserResp;
import org.sapr.service.IServiceFactory;
import org.sapr.service.IUserService;
import org.sapr.service.ServiceFactory;

@WebService
public class UserManagement {

	private IServiceFactory serviceFactory = new ServiceFactory();
	private UserResp response = new UserResp();
	
	
	@WebMethod
	public UserResp readUser(UserReq request){
		IUserService userservice = serviceFactory.getUserService();
		this.response = userservice.readUser(request);
		return this.response;
	}
	
	@WebMethod
	public UserResp getAllUser(){
		IUserService userservice = serviceFactory.getUserService();
		this.response = userservice.getAllUser();
		return this.response;
	}
	
	@WebMethod
	public UserResp deleteUser(UserReq request){
		IUserService userservice = serviceFactory.getUserService();
		this.response = userservice.deleteUser(request);
		return this.response;
	}
	
	@WebMethod
	public UserResp insertUser(UserReq request){
		IUserService userservice = serviceFactory.getUserService();
		this.response = userservice.insertUser(request);
		return this.response;
	}
}
