package com.vo;

import java.util.List;

public class ProductType extends BasicVo{

	private String id;
	private String typeName;
	private String createtime;
	private List<Product> productList;

	public ProductType()
	{
	}

	
	public ProductType(String id) {
	
		this.id = id;
	}


	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getTypeName()
	{
		return typeName;
	}

	public void setTypeName(String typeName)
	{
		this.typeName = typeName;
	}

	public String getCreatetime()
	{
		return createtime;
	}

	public void setCreatetime(String createtime)
	{
		this.createtime = createtime;
	}

	public List<Product> getProductList()
	{
		return productList;
	}

	public void setProductList(List<Product> productList)
	{
		this.productList = productList;
	}
}
