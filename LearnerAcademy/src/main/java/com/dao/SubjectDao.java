package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Subject;
import com.resource.DbResource;

public class SubjectDao {
	
	public int addSubject(Subject sb) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into subjects values(?,?)");
	        pstmt.setInt(1, sb.getSid());
	        pstmt.setString(2, sb.getSubjectName());
	        int res = pstmt.executeUpdate();
	        return res;
	        } 
		catch (Exception e) {
	            System.out.println("Something went wrong " +e.getMessage());
	            return 0;}
		}
		
	public List<Subject> getSubjects() {
		List<Subject> tl = new ArrayList<>();
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from subjects;");
	        ResultSet res = pstmt.executeQuery();
	        
	        while (res.next()) {
	        	int sid = res.getInt("sid");
	        	String subjectName = res.getString("subjectName");
	        	Subject subject = new Subject(sid, subjectName);
	        	tl.add(subject);
	        }
	        return tl;
	        } 
		catch (Exception e) {
	        System.out.println("Something went wrong " +e.getMessage());
	        return null;}
		}
	
	public Subject getSubjectDetails(int subjectId) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from subjects where sid=(?);");
			pstmt.setInt(1, subjectId);
	        ResultSet res = pstmt.executeQuery();
	        
	        if (res.next()) {
	        	int sid = res.getInt("sid");
	        	String subjectTitle = res.getString("subjectName");
	        	Subject subject = new Subject(sid, subjectTitle);
	        	return subject;
	        } else {
	        	return null;}
	        } 
		catch (Exception e) {
	        System.out.println("Something went wrong " +e.getMessage());
	        return null;}
	}
	
}

