package com.vo;


public class Reply{

	private Integer id;
	private String content;
	private String createBy;
	private String createTime;
	private Integer msgId;

	public Reply()
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

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getCreateBy()
	{
		return createBy;
	}

	public void setCreateBy(String createBy)
	{
		this.createBy = createBy;
	}

	public String getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}

	public Integer getMsgId()
	{
		return msgId;
	}

	public void setMsgId(Integer msgId)
	{
		this.msgId = msgId;
	}
}
