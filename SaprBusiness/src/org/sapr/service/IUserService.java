package org.sapr.service;

import org.sapr.request.UserReq;
import org.sapr.response.UserResp;

public interface IUserService {
	public UserResp readUser(UserReq request);
	public UserResp getAllUser();
	public UserResp deleteUser(UserReq request);
	public UserResp insertUser(UserReq request);
}

