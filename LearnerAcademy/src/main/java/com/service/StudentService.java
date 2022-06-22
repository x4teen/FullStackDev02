package com.service;

import com.bean.Student;
import com.dao.StudentDao;

public class StudentService {
	StudentDao sd = new StudentDao();
	
	public String addStudent(Student std, String role) {
		int authLevel = Permissions.getPermission(role);
		if (authLevel >= 4) {
			if(sd.addStudent(std) > 0) {
				return "Student was added";
			} else {
				return "Student could not be added";
			}
		} else {
			return "User is not authorized";
		}
	}
}
