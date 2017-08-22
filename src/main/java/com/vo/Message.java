package com.vo;

public class Message{

	private Integer id;
	private String title;
	private String content;
	private String linkMan;
	private String phone;
	private String email;
	private String qq;
	private Integer state;
	private String createTime;

	public Message()
	{
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getLinkMan()
	{
		return linkMan;
	}

	public void setLinkMan(String linkMan)
	{
		this.linkMan = linkMan;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getQq()
	{
		return qq;
	}

	public void setQq(String qq)
	{
		this.qq = qq;
	}

	public Integer getState()
	{
		return state;
	}

	public void setState(Integer state)
	{
		this.state = state;
	}

	public String getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}
}
