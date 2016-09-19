package org.sapr.request;

import org.sapr.entity.User;


public class UserReq extends AbstRequest {
	
	private User user;

	public UserReq(){
		this.user = new User();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
