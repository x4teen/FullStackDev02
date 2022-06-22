package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Course;
import com.resource.DbResource;

public class CourseDao {
	
	public int addCourse(Course cc) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into classes values(?,?,?,?)");
	        pstmt.setInt(1, cc.getCid());
	        pstmt.setString(2, cc.getCourseTitle());
	        pstmt.setInt(3, cc.getSid());
	        pstmt.setInt(4, cc.getTid());
	        int res = pstmt.executeUpdate();
	        return res;
	        } 
		catch (Exception e) {
	            System.out.println("Something went wrong " +e.getMessage());
	            return 0;}
		}
	
	public List<Course> getCourses() {
		List<Course> cl = new ArrayList<>();
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from classes;");
	        ResultSet res = pstmt.executeQuery();
	        
	        while (res.next()) {
	        	int cid = res.getInt("cid");
	        	String courseTitle = res.getString("courseTitle");
	        	int sid = res.getInt("sid");
	        	int tid = res.getInt("tid");
	        	Course course = new Course(cid, courseTitle, sid, tid);
	        	cl.add(course);
	        }
	        return cl;
	        } 
		catch (Exception e) {
	        System.out.println("Something went wrong " +e.getMessage());
	        return null;}
		}
	
	public Course getCourseDetails(int courseId) {
		Course course = new Course();
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from classes where cid=(?);");
			pstmt.setInt(1, courseId);
	        ResultSet res = pstmt.executeQuery();
	        
	        if (res.next()) {
	        	int cid = res.getInt("cid");
	        	String courseTitle = res.getString("courseTitle");
	        	int sid = res.getInt("sid");
	        	int tid = res.getInt("tid");
	        	course = new Course(cid, courseTitle, sid, tid);
	        	return course;
	        } else {
	        	return null;}
	        } 
		catch (Exception e) {
	        System.out.println("Something went wrong " +e.getMessage());
	        return null;}
		
		
	}
		
		
}

