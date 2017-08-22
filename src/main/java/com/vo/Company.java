package com.vo;


public class Company{

	private Integer id;
	private String cmpName;
	private String corp;
	private String contact;
	private String phone;
	private String fax;
	private String email;
	private String postCode;
	private String addr;
	private String introduction;
	private String oration;
	private String care;
	private String organization;
	private String honor;
	private String linkMan;
	private String logo;


	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public String getCmpName(){
		return cmpName != null ? cmpName : "";
	}

	public void setCmpName(String cmpName){
		this.cmpName = cmpName;
	}

	public String getCorp(){
		return corp != null ? corp : "";
	}

	public void setCorp(String corp){
		this.corp = corp;
	}

	public String getContact(){
		return contact != null ? contact : "";
	}

	public void setContact(String contact){
		this.contact = contact;
	}

	public String getPhone(){
		return phone != null ? phone : "";
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getFax(){
		return fax != null ? fax : "";
	}

	public void setFax(String fax){
		this.fax = fax;
	}

	public String getPostCode(){
		return postCode != null ? postCode : "";
	}

	public void setPostCode(String postCode){
		this.postCode = postCode;
	}

	public String getAddr(){
		return addr != null ? addr : "";
	}

	public void setAddr(String addr)
	{
		this.addr = addr;
	}

	public String getIntroduction(){
		return introduction != null ? introduction : "";
	}

	public void setIntroduction(String introduction){
		this.introduction = introduction;
	}

	public String getLinkMan(){
		return linkMan != null ? linkMan : "";
	}

	public void setLinkMan(String linkMan){
		this.linkMan = linkMan;
	}

	public String getLogo(){
		return logo != null ? logo : "";
	}

	public void setLogo(String logo){
		this.logo = logo;
	}

	public String getOration(){
		return oration != null ? oration : "";
	}

	public void setOration(String oration){
		this.oration = oration;
	}

	public String getCare(){
		return care;
	}

	public void setCare(String care){
		this.care = care;
	}

	public String getOrganization(){
		return organization != null ? organization : "";
	}

	public void setOrganization(String organization){
		this.organization = organization;
	}

	public String getHonor(){
		return honor != null ? honor : "";
	}

	public void setHonor(String honor){
		this.honor = honor;
	}

	public String getInfo(String method){
		if (method != null){
			if (method.compareToIgnoreCase("intr") == 0)
				return introduction != null ? introduction : "";
			if (method.compareToIgnoreCase("org") == 0)
				return organization != null ? organization : "";
			if (method.compareToIgnoreCase("care") == 0)
				return care != null ? care : "";
			if (method.compareToIgnoreCase("ora") == 0)
				return oration != null ? oration : "";
			if (method.compareToIgnoreCase("honor") == 0)
				return honor != null ? honor : "";
		}
		return "";
	}

	public String getEmail(){
		return email != null ? email : "";
	}

	public void setEmail(String email){
		this.email = email;
	}
}
