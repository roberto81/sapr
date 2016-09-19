package org.sapr.entity;

public class User {
	private String first_name;
	private String last_name;
	private Integer age;
	private String username;
	private String password;
	private Integer enabled;
	private String role;
	
	public User(){
		
	}

	public User(String first_name, String last_name, Integer age, String username, String password, Integer enabled,
			String role) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
