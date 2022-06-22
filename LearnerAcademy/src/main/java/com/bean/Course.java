package com.bean;

public class Course {
	private int cid;
	private String courseTitle;
	private int sid;
	private int tid;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int cid, String courseTitle, int sid, int tid) {
		super();
		this.cid = cid;
		this.courseTitle = courseTitle;
		this.sid = sid;
		this.tid = tid;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", courseTitle=" + courseTitle + ", sid=" + sid + ", tid=" + tid + "]";
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}
	
	

}
