package com.vo;


public class LinkMan{

	private String name;
	private String phone;
	private String email;
	private String qq;

	public LinkMan()
	{
	}

	public LinkMan(String str)
	{
		String temp[] = str.split(",");
		for (int i = 0; i < temp.length; i++)
		{
			String pairs[] = temp[i].split(":");
			if (pairs[0].compareTo("name") == 0)
			{
				if (pairs.length > 1)
					name = pairs[1];
				else
					name = "";
			} else
			if (pairs[0].compareTo("email") == 0)
			{
				if (pairs.length > 1)
					email = pairs[1];
				else
					email = "";
			} else
			if (pairs[0].compareTo("phone") == 0)
			{
				if (pairs.length > 1)
					phone = pairs[1];
				else
					email = "";
			} else
			if (pairs[0].compareTo("qq") == 0)
				if (pairs.length > 1)
					qq = pairs[1];
				else
					qq = "";
		}

	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
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
}
