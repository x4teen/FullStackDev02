package com.bean;

public class Student {
	private int id;
	private String name;
	private int cid;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, int cid) {
		super();
		this.id = id;
		this.name = name;
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", cid=" + cid + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}
	
	
	
}
