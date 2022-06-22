package com.service;

import com.bean.Course;
import com.dao.CourseDao;

public class CourseService {
	CourseDao cd = new CourseDao();
	
	public String addCourse(Course cc, String role) {
		int authLevel = Permissions.getPermission(role);
		if (authLevel >= 4) {
			if(cd.addCourse(cc) > 0) {
				return "Course was added";
			} else {
				return "Course could not be added";
			}
		} else {
			return "User is not authorized";
		}
	}
}
