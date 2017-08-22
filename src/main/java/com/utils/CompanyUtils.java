package com.utils;

import com.vo.Company;

import java.sql.*;

public class CompanyUtils extends DBUtils{
	private JdbcUtils JdbcUtils=new JdbcUtils();
	public Company getCompany(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Company cmp=null;
		String sql = "select * from company limit 1";
		try{
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			for (rs = ps.executeQuery();
				rs.next(); 
				cmp.setId(Integer.valueOf(rs.getInt("id")))){
				cmp = new Company();
				cmp.setAddr(rs.getString("addr"));
				cmp.setCmpName(rs.getString("cmpname"));
				cmp.setContact(rs.getString("contact"));
				cmp.setCorp(rs.getString("corp"));
				cmp.setEmail(rs.getString("email"));
				cmp.setFax(rs.getString("fax"));
				cmp.setIntroduction(rs.getString("introduction"));
				cmp.setLinkMan(rs.getString("linkMan"));
				cmp.setPhone(rs.getString("phone"));
				cmp.setLogo(rs.getString("logo"));
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally{
			JdbcUtils.free(rs, ps, conn);		
		}
		return cmp;
	}

	public int updateCompany(Company cmp){
		String sql = "update Company set cmpName=?,corp=?,contact=?,phone=?,fax=?,email=?,postCode=?,introduction=?,addr=?,linkMan=?,logo=? where id=?";
		Object args[] = new Object[]{cmp.getCmpName(), cmp.getCorp(), cmp.getContact(), cmp.getPhone(), cmp.getFax(), cmp.getEmail(), cmp.getPostCode(), cmp.getIntroduction(), cmp.getAddr(), cmp.getLinkMan(), cmp.getLogo(), cmp.getId()};
		return super.updateData(sql, args);
	}
	
	protected Object rowMapper(ResultSet rs)throws SQLException{
		return null;
	}
}
