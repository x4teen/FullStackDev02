package com.service;

import com.bean.Subject;
import com.dao.SubjectDao;

public class SubjectService {
	SubjectDao sd = new SubjectDao();
	
	public String addSubject(Subject sb, String role) {
		int authLevel = Permissions.getPermission(role);
		if (authLevel >= 4) {
			if(sd.addSubject(sb) > 0) {
				return "Subject was added";
			} else {
				return "Subject could not be added";
			}
		} else {
			return "User is not authorized";
			
		}
		
	}

}
