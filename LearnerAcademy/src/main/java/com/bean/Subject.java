package com.bean;

public class Subject {
	private int sid;
	private String subjectName;
	
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Subject(int sid, String subjectName) {
		super();
		this.sid = sid;
		this.subjectName = subjectName;
	}
	
	public int getSid() {
		return sid;
	}
	
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	@Override
	public String toString() {
		return "Subject [sid=" + sid + ", subjectName=" + subjectName + "]";
	}
	
	

}
