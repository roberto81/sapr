package org.sapr.service;

import java.util.List;

import org.sapr.dao.DaoFactory;
import org.sapr.dao.IDaoFactory;
import org.sapr.entity.User;
import org.sapr.request.UserReq;
import org.sapr.response.UserResp;

public class UserService implements IUserService {
	
	private IDaoFactory daoFactory = new DaoFactory();

	@Override
	public UserResp readUser(UserReq request) {
		
		User usr = this.daoFactory.getUserDao().readUser(request.getUser());
		UserResp response = new UserResp(usr);
		response.setErrorCode("0");
		response.setMessage("sussifuly");
		response.setResult(true);
		
		return response;
	}

	@Override
	public UserResp getAllUser() {
		
		List<User> userList = this.daoFactory.getUserDao().getAllUser();
		
		UserResp response = new UserResp();
		
		response.setErrorCode("0");
		response.setMessage("sussifuly");
		response.setResult(true);
		response.setUserList(userList);
		
		return response;
	}

	@Override
	public UserResp deleteUser(UserReq request) {
		
		this.daoFactory.getUserDao().deleteUser(request.getUser());
		UserResp response = new UserResp();
		
		response.setErrorCode("0");
		response.setMessage("sussifuly");
		response.setResult(true);
		
		return response;
	}

	@Override
	public UserResp insertUser(UserReq request) {
		Integer outcome;
		
		UserResp response = new UserResp();
		
		outcome = this.daoFactory.getUserDao().insertUser(request.getUser());
		
		if(outcome.equals(0)){
			response.setResult(true);
			response.setErrorCode("0");
			response.setMessage("sussifuly");
		}
		if(outcome.equals(1)){
			response.setErrorCode("1");
			response.setMessage("username gia esistente");
			response.setResult(false);
		}
		
		return response;
	}
	
	

}
