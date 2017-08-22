package com.vo;

public class User {

	private int userid;
	private String accountNo;
	private String password;
	private int gender;
	private int islock;
	private String username;
	private String roleName;
	private int parentid;
	private int isM;
	private int noM;

	public User() {
	}

	public int getIsM() {
		return isM;
	}

	public void setIsM(int isM) {
		this.isM = isM;
	}

	public int getNoM() {
		return noM;
	}

	public void setNoM(int noM) {
		this.noM = noM;
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getIslock() {
		return islock;
	}

	public void setIslock(int islock) {
		this.islock = islock;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
