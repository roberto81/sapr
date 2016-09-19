package org.sapr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.sapr.entity.User;
import org.sapr.resource.IResourceFactory;
import org.sapr.resource.ResourceFactory;

public class UserDao implements IUserDao{
	
	private DataSource dbsource;
	private IResourceFactory resourceFactory;
	private Connection conn;
	private Statement stm;
	private ResultSet rst;

	@Override
	public User readUser(User user) {
		User readUser = new User();
		
		this.resourceFactory = new ResourceFactory();
		this.dbsource = resourceFactory.getDatabaseResource();		
		
		String USER_QUERY = "SELECT first_name,last_name,age,username,enabled FROM users WHERE username='"+ user.getUsername()  +"';";
		String USER_ROLE = "SELECT role FROM user_roles WHERE username='"+ user.getUsername() +"';";
		
		try {
			this.conn = dbsource.getConnection();
			this.stm = conn.createStatement();
			this.rst = this.stm.executeQuery(USER_QUERY);
			
			rst.next();
				
			readUser.setFirst_name(rst.getString("first_name"));
			readUser.setLast_name(rst.getString("last_name"));
			readUser.setAge(Integer.parseInt(rst.getString("age")));
			readUser.setUsername(rst.getString("username"));
			readUser.setEnabled(Integer.parseInt(rst.getString("enabled")));
			
			this.stm.close();
			this.rst.close();
			
			this.stm = conn.createStatement();
			this.rst = this.stm.executeQuery(USER_ROLE);
			
			this.rst.next();
			readUser.setRole(rst.getString("role"));
			
			this.rst.close();
			this.stm.close();
			this.conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		readUser.setPassword("none");
		return readUser;
	}

	@Override
	public List<User> getAllUser() {
		List<User> userList = new ArrayList<User>();
		
		this.resourceFactory = new ResourceFactory();
		this.dbsource = resourceFactory.getDatabaseResource();
		
		String USER_QUERY = "SELECT first_name,last_name,age,users.username,enabled,role FROM users,user_roles where users.username=user_roles.username;";
		try {
			
			this.conn = dbsource.getConnection();
			this.stm = conn.createStatement();
			this.rst = this.stm.executeQuery(USER_QUERY);
			
			while (rst.next()) {
				userList.add(new User(rst.getString("first_name"), rst.getString("last_name"), Integer.parseInt(rst.getString("age")), rst.getString("username"), "none", Integer.parseInt(rst.getString("enabled")), rst.getString("role")));
			}
			
			this.rst.close();
			this.stm.close();
			this.conn.close();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public void deleteUser(User user) {
		this.resourceFactory = new ResourceFactory();
		this.dbsource = resourceFactory.getDatabaseResource();
		
		Statement statementDeleteRole = null;
		Statement statementDeleteUser = null;
		
		String ROLE_QUERY="DELETE FROM user_roles WHERE username='"+ user.getUsername() +"';";
		String USER_QUERY="DELETE FROM users WHERE username='"+ user.getUsername() +"';";
		
		try{
			this.conn = dbsource.getConnection();
			this.conn.setAutoCommit(false);
			
			statementDeleteRole = conn.createStatement();
			statementDeleteRole.executeUpdate(ROLE_QUERY);
			
			statementDeleteUser = conn.createStatement();
			statementDeleteUser.executeUpdate(USER_QUERY);
			
			conn.commit();
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Integer insertUser(User user) {
		this.resourceFactory = new ResourceFactory();
		this.dbsource = resourceFactory.getDatabaseResource();
		
		Statement statementDeleteRole = null;
		Statement statementDeleteUser = null;
		
		String ROLE_QUERY="INSERT INTO user_roles (username, role)VALUES ('" + user.getUsername() + "', '" + user.getRole() +"');";
		String USER_QUERY="INSERT INTO users(first_name,last_name,age,username,password,enabled)VALUES ('"+ user.getFirst_name() + "','"+ user.getLast_name() + "',"+ user.getAge() + ",'"+ user.getUsername()+"','"+ user.getPassword() + "',"+ user.getEnabled() +");";
		
		try{
			this.conn = dbsource.getConnection();
			this.conn.setAutoCommit(false);
			
			statementDeleteUser = conn.createStatement();
			statementDeleteUser.executeUpdate(USER_QUERY);
			
			statementDeleteRole = conn.createStatement();
			statementDeleteRole.executeUpdate(ROLE_QUERY);
			
			conn.commit();
			
		}catch (SQLException e) {
			if(e instanceof SQLIntegrityConstraintViolationException){
				return 1;
			}
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
	}
	
	
}
