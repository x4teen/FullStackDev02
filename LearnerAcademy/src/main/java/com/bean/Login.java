package com.bean;

public class Login {
	private String email;
	private String password;
	private String name;
	private String role;

	public Login() {
		super();
//		this.email = email;
//		this.password = password;
	}
	
	
	public Login(String email, String password, String name, String role) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.role = role;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}
