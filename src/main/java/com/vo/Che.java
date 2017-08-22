package com.vo;

import java.util.Random;

public class Che{

	private int id;
	private String start;
	private boolean jt;
	private long ptime;
	private String ptimedec;
	public String getPtimedec() {
		return ptimedec;
	}
	public void setPtimedec(String ptimedec) {
		this.ptimedec = ptimedec;
	}
	public long getPtime() {
		return ptime;
	}
	public void setPtime(long ptime) {
		this.ptime = ptime;
	}
	private String fz;
	
	public String getFz() {
		return fz;
	}
	public void setFz(String fz) {
		this.fz = fz;
	}
	public boolean isJt() {
		return jt;
	}
	public void setJt(boolean jt) {
		this.jt = jt;
	}
	private String end;
	private String week;
	private String timeFmt;
	
	public String getTimeFmt() {
		return timeFmt;
	}
	public void setTimeFmt(String timeFmt) {
		this.timeFmt = timeFmt;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	private String pass;
	private Long time;
	private String time_memo;
	private String mobile;
	private String name;
	private int surplus;
	private String memo;
	private int read;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public String getTime_memo() {
		return time_memo;
	}
	public void setTime_memo(String time_memo) {
		this.time_memo = time_memo;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSurplus() {
		return surplus;
	}
	public void setSurplus(int surplus) {
		this.surplus = surplus;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getRead() {
		return  (int)Math.random()*150;
	}
	public void setRead(int read) {
		this.read = read;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	private int type;
	@Override
	public String toString() {
		return "Che [id=" + id + ", start=" + start + ", jt=" + jt + ", ptime=" + ptime + ", ptimedec=" + ptimedec + ", fz=" + fz + ", end=" + end + ", week=" + week
				+ ", timeFmt=" + timeFmt + ", pass=" + pass + ", time=" + time + ", time_memo=" + time_memo + ", mobile=" + mobile + ", name=" + name + ", surplus=" + surplus
				+ ", memo=" + memo + ", read=" + read + ", type=" + type + "]";
	}
	
}
