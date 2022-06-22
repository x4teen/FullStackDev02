package com.service;

public class Permissions {
	
	public static int getPermission(String role) {
		if (role.equals("admin")) {
			return 4;
		} else if (role.equals("power_user")) {
			return 3;
		} else if (role.equals("user")) {
			return 2;
		} else{
		return 0;}
	}

}
