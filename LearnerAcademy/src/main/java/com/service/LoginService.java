package com.service;

import com.bean.Login;
import com.dao.LoginDao;

public class LoginService {
	LoginDao ld = new LoginDao();
	
	public Login checkUser(Login login) {
		StringBuffer sb = new StringBuffer(login.getPassword());
		String reversePassword = sb.reverse().toString();
		login.setPassword(reversePassword);
		
		Login user = ld.checkLoginDetails(login);
		
		return user;
	}
	
	public String createUser(Login login) {
		StringBuffer sb = new StringBuffer(login.getPassword());
		String reversePassword = sb.reverse().toString();
		login.setPassword(reversePassword);
		
		if(ld.createLoginDeatils(login) > 0) {
			return "Account created successfully";
		} else {
			return "Account was not created";
		}
	}

}
