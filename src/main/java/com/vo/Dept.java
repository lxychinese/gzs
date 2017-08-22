package com.vo;


public class Dept{

	private int deptid;
	private String deptname;
	private int parentid;
	private String prity;


	public String getPrity(){
		return prity;
	}

	public void setPrity(String prity){
		this.prity = prity;
	}

	public int getDeptid(){
		return deptid;
	}

	public void setDeptid(int deptid){
		this.deptid = deptid;
	}

	public String getDeptname(){
		return deptname;
	}

	public void setDeptname(String deptname){
		this.deptname = deptname;
	}

	public int getParentid(){
		return parentid;
	}

	public void setParentid(int parentid){
		this.parentid = parentid;
	}
}
