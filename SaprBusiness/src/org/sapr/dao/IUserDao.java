package org.sapr.dao;

import java.util.List;

import org.sapr.entity.User;

public interface IUserDao {
	User readUser(User user);
	List<User> getAllUser();
	void deleteUser(User user);
	Integer insertUser(User user);
}
