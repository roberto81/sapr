package org.sapr.response;

import java.util.List;

import org.sapr.entity.User;

public class UserResp extends AbstResponse {
	
	private User user;
	private List<User> userList;
	
	public UserResp(User user) {
		super();
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public UserResp(){
		
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	
}
