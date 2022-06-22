package com.bean;

public class Teacher {
	private int tid;
	private String teacherName;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(int tid, String teacherName) {
		super();
		this.tid = tid;
		this.teacherName = teacherName;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", teacherName=" + teacherName + "]";
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
}
