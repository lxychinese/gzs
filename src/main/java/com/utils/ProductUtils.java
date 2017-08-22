

package com.utils;
import com.data.DataCheck;
import com.vo.Product;
import com.vo.ProductType;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


public class ProductUtils extends DBUtils{
	private JdbcUtils jdbcUtils=new JdbcUtils();
	/*
	 * 产品列表
	 */
	public Page<Product> listProduct(Page<Product> page, Product p){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Product product=null;
		List<Product> list = new ArrayList<Product>();
		try{
			conn = jdbcUtils.getConnection();
			int start = (page.getPageNo()-1)*page.getPageSize();
			String sql = "select id, proNo,proPrice,proDesc,proImageFileName,proName,proSign,case when isOn=0 then '是' ELSE '否'  end as isOn,isTop,protype from product ";
			if (!DataCheck.isNull(p) && !DataCheck.isEmpty(p.getProName()))
				sql+= "where  proName like  '%"+p.getProName()+"%'";
			sql += " order by product.id desc limit ?,?";
			System.out.println(sql);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, page.getPageSize());
			rs = ps.executeQuery();
		
			while(rs.next()){
			
				product=new Product();
				product.setId(rs.getString("id"));
				product.setProNo(rs.getString("proNo"));
				product.setProName(rs.getString("proName"));
				product.setProPrice(rs.getString("proPrice"));
				product.setProDesc(rs.getString("proDesc"));
				product.setProImageFileName(rs.getString("proImageFileName"));
				int type=rs.getInt("protype");
				product.setIsOns(rs.getString("isOn"));
				product.setProSign(rs.getString("proSign"));
				product.setType(getProductType(type).getTypeName());
				list.add(product);
			}
			page.setResult(list);
			page.setTotalItems(getCount(sql));
		}
		catch (SQLException e){
			e.printStackTrace();
		}finally{
			jdbcUtils.free(rs, ps, conn);
		}
		return page;
	}


	/*
	 *根据ID找到产品
	 */
	public Product findProduct(int id){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Product p=null;
	    try{
			conn = jdbcUtils.getConnection();
			String sql = "select p.*,pt.typename from product p LEFT JOIN producttype pt on pt.id=p.protype where p.id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery(); 
			while (rs.next()){
				p = new Product();
				p.setId(rs.getString("id"));
				p.setProPrice(rs.getString("proPrice"));
				p.setProDesc(rs.getString("proDesc"));
				p.setProImageFileName(rs.getString("proImageFileName"));
				p.setProName(rs.getString("proName"));
				p.setIsOn(rs.getInt("isOn"));
				p.setIsTop(rs.getInt("isTop"));
				p.setProSign(rs.getString("proSign"));
				p.setType(rs.getString("proType"));
				p.setTypeName(rs.getString("typename"));
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}finally{
			jdbcUtils.free(rs, ps, conn);
		}
		return p;
	}
	
	/*
	 * 删除产品
	 */
	public int deleteProduct(String ids ){
		String sql = "delete  from product where id in (?)";
		Object args[] =new Object[]{ids};
		return super.updateData(sql, args);
	}

	/*
	 * 产品类型列表
	 */
	public Page<Product> listProductType(Page<Product> page,ProductType types){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Product product = null;
		List<Product> list = new ArrayList<Product>();
		try{
			conn = jdbcUtils.getConnection();
			String sql = "select * from product  where 1=1 ";
			System.out.println(sql);
			if(types.getId()!=null && !types.equals("")){
				sql+="and protype="+types.getId();
			}
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while ( rs.next()){
				product = new Product();
				product.setProPrice(rs.getString("proPrice"));
				product.setProDesc(rs.getString("proDesc"));
				product.setProImageFileName(rs.getString("proImageFileName"));
				product.setProName(rs.getString("proName"));
				product.setIsOn(rs.getInt("isOn"));
				product.setIsTop(rs.getInt("isTop"));
				product.setType(rs.getString("proType"));
				list.add(product);
			}
	
			page.setResult(list);
			//page.setTotalItems(getCount(sql));
		}
		catch (SQLException e){
			e.printStackTrace();
		}finally{
			jdbcUtils.free(rs, ps, conn);
		}
		
		return page;
	}

	/*
	 * 根据类型ID得到产品列表
	 */
	public List<Product>  listProductByType(int id){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Product> list = new ArrayList<Product> ();
		Product product = null;
		try{
			conn = jdbcUtils.getConnection();
			String sql = "select * from product  where protype=? ";
			System.out.println(sql);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()){
				product = new Product();
				product.setId(rs.getString("id"));
				product.setProPrice(rs.getString("proPrice"));
				product.setProDesc(rs.getString("proDesc"));
				product.setProImageFileName(rs.getString("proImageFileName"));
				product.setProName(rs.getString("proName"));
				product.setIsOn(rs.getInt("isOn"));
				product.setIsTop(rs.getInt("isTop"));
				product.setProSign(rs.getString("proSign"));
				product.setType(rs.getString("proType"));
				list.add(product);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}finally{
			jdbcUtils.free(rs, ps, conn);
		}
		return list;
	}

	/*
	 * 产品类型列表
	 */
	public List<ProductType> listProductTypeCombo(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ProductType type = null;
		List<ProductType> list = new ArrayList<ProductType>();
		try{
			conn = jdbcUtils.getConnection();
			String sql = "select * from productType order by id desc ";
			System.out.println(sql);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while (rs.next()){
				type = new ProductType();
				type.setTypeName(rs.getString("typeName"));
				type.setId(rs.getString("id"));
				list.add(type);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}finally{
			jdbcUtils.free(rs, ps, conn);
		}
		return list;
	}

	/*
	 * 添加产品
	 */
	public void addProduct(Product pr, int type){
		String sql = "insert into product(proNo,proName,proPrice,proType,isTop,isOn,proSign,proDesc,proImageFileName) values(?,?,?,?,?,?,?,?,?)";
		Object args[] =new Object[] {pr.getProNo(), pr.getProName(), pr.getProPrice(), Integer.valueOf(type), Integer.valueOf(pr.getIsTop()), 
				Integer.valueOf(pr.getIsOn()),pr.getProSign(),pr.getProDesc(), pr.getProImageFileName()};
		 super.updateData(sql, args);
	}
	
	/*
	 * 更新产品
	 */
	public int updateProduct(Product pr, int id){
		String sql = "update product set proName=?,proType=?,proImageFileName=? where id=?";
		Object args[] =new Object[] {pr.getProNo(), pr.getProName(), pr.getProPrice(), Integer.valueOf(id), Integer.valueOf(pr.getIsTop()), Integer.valueOf(pr.getIsOn()), pr.getProDesc(), pr.getProImageFileName()};
		return super.updateData(sql, args);
	}


	/*
	 *更新类型
	 */
	public int updateType(ProductType proType){
		String sql = "update productType set typeName=? where id=?";
		Object args[] =new Object[] {proType.getTypeName(), Integer.valueOf(proType.getId())};
		return super.updateData(sql, args);
	}

	/*
	 * 删除类型
	 */
	public int deleteType(String ids){
		String sql = "delete from  productType where id=?";
		Object args[] =new Object[] {ids};
		return super.updateData(sql, args);
	}

	/*
	 * 添加类型
	 */
	public int addProductType(ProductType p){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String sql = "insert into productType(typeName,createtime) values(?,?)";
		System.out.println(sql);
		Object args[] = new Object[]{p.getTypeName(), sf.format(new Date())};
		return super.updateData(sql, args);
	}
	
	/*
	 * 根据类型ID得到类型
	 */
	private ProductType getProductType(int typeId) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ProductType type = null;
		try{
			conn = jdbcUtils.getConnection();
			String sql="select * from productType  where id="+typeId;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while (rs.next()){
				type = new ProductType();
				type.setTypeName(rs.getString("typeName"));
				type.setId(rs.getString("id"));
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}finally{
			jdbcUtils.free(rs, ps, conn);
		}
		return type;
		
	}


	protected Object rowMapper(ResultSet rs)throws SQLException{
		return null;
	}
	
	
	/*
	 * 产品类型列表
	 */
	public Page<ProductType> listType(Page<ProductType> page,ProductType types){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ProductType type = null;
		List<ProductType> list = new ArrayList<ProductType>();
		try{
			conn = jdbcUtils.getConnection();
			String sql = "select * from producttype order by id desc ";
			System.out.println(sql);
			
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()){
				type = new ProductType();
				type.setTypeName(rs.getString("typename"));
				type.setId(rs.getString("id"));
				type.setCreatetime(rs.getString("createtime"));
				list.add(type);
			}
	
			page.setResult(list);
			page.setTotalItems(getCount(sql));
		}
		catch (SQLException e){
			e.printStackTrace();
		}finally{
			jdbcUtils.free(rs, ps, conn);
		}
		
		return page;
	}
}
