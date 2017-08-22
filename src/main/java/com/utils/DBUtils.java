package com.utils;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class DBUtils{

	private JdbcUtils JdbcUtils=new JdbcUtils();
	protected abstract Object rowMapper(ResultSet resultset)throws SQLException;

	public int updateData(String sql, Object args[]){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id=0;//保存生成的ID  
		try{
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			System.out.println(sql);
			for (int i = 0; i < args.length; i++)
				ps.setObject(i + 1, args[i]);
			    ps.executeUpdate();
			    rs=ps.getGeneratedKeys();
			    
				if (rs != null&& rs.next()) {  
				    id=rs.getInt(1)  ;
				}  
		}catch (Exception e){
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		}
		finally{
			JdbcUtils.free(rs, ps, conn);
		}

		return id;

	}
	public int getCount(String sql){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String countHql = "select count(*) as num " + removeSelect(removeOrders(sql));
		int i=0;
		try{
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(countHql);
			rs = ps.executeQuery(); 
			while(rs.next()){
				i=rs.getInt("num");
			}
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally{
			JdbcUtils.free(rs, ps, conn);
		}	
		return i;
	}

	private static String removeSelect(String hql) {
		int beginPos = hql.toLowerCase().indexOf("from");
		return hql.substring(beginPos);
	}
	private static String removeOrders(String hql) {
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(hql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}
}
