package com.vo;


public class Product extends ProductType{

	private String id;
	private String proNo;
	private String proName;
	private String proPrice;
	private String type;
	private Integer isTop;
	private Integer isOn;
	private String proDesc;
	private String proSign;
	private String proImageFileName;
	
	//extends
	private String typeName;
	private String isOns;
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Product()
	{
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getProNo()
	{
		return proNo;
	}

	public void setProNo(String proNo)
	{
		this.proNo = proNo;
	}

	public String getProName()
	{
		return proName;
	}

	public void setProName(String proName)
	{
		this.proName = proName;
	}

	public String getProPrice()
	{
		return proPrice;
	}

	public void setProPrice(String proPrice)
	{
		this.proPrice = proPrice;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public Integer getIsTop()
	{
		return isTop;
	}

	public void setIsTop(Integer isTop)
	{
		this.isTop = isTop;
	}

	public Integer getIsOn()
	{
		return isOn;
	}

	public void setIsOn(Integer isOn)
	{
		this.isOn = isOn;
	}

	public String getProDesc()
	{
		return proDesc;
	}

	public void setProDesc(String proDesc)
	{
		this.proDesc = proDesc;
	}

	public String getProImageFileName()
	{
		return proImageFileName;
	}

	public void setProImageFileName(String proImageFileName)
	{
		this.proImageFileName = proImageFileName;
	}

	public String getIsOns() {
		return isOns;
	}

	public void setIsOns(String isOns) {
		this.isOns = isOns;
	}

	public String getProSign() {
		return proSign;
	}

	public void setProSign(String proSign) {
		this.proSign = proSign;
	}
}
