package com.user.domain;

public class User {
	public User() {
	}

	public User(int id, String name, String email, String pwd, int grade) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.grade = grade;
	}
	private int id;
	private String name;
	private String email;
	private String pwd;
	private int grade;
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
