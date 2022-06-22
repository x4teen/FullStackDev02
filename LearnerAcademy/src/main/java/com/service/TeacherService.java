package com.service;

import com.bean.Teacher;
import com.dao.TeacherDao;

public class TeacherService {
	TeacherDao td = new TeacherDao();
	
	public String addTeacher(Teacher tt, String role) {
		int authLevel = Permissions.getPermission(role);
		if (authLevel >= 4) {
			if(td.addTeacher(tt) > 0) {
				return "Teacher was added";
			} else {
				return "Teacher could not be added";
			}
		} else {
			return "User is not authorized";
			
		}
		
	}

}
