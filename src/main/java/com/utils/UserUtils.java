package com.utils;

import com.vo.User;

import java.sql.*;

public class UserUtils extends DBUtils{
	private JdbcUtils JdbcUtils=new JdbcUtils();
	public User checkUser(User user){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User u=null;
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select * from umuser where accountNo=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getAccountNo());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			while ( rs.next()){
				u = new User();
				u.setUserid(rs.getInt("userid"));
				u.setUsername(rs.getString("username"));
				u.setAccountNo(rs.getString("accountNo"));
				u.setPassword(rs.getString("password"));
			}

		}
		catch (SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtils.free(rs, ps, conn);
		}
		return u;
	}
	
	
	public boolean doLogin(String accountNo,String pass){
	    
	    String sql = "SELECT * FROM umuser where user = '" + accountNo +"' AND password = '" + pass +"'";

        Connection conn= null;
        boolean result = false;
        try{
            conn = JdbcUtils.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()){
                result =  true;
            }
        }catch(SQLException e){
            //
        }finally {
            JdbcUtils.free(null, null, conn);
        }
        return result;
    }
	public User getUser(String accountNo){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User user=null;
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select * from umuser where accountNo=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,accountNo);
			rs = ps.executeQuery();
			while ( rs.next()){
				user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtils.free(rs, ps, conn);
		}
		return user;
	}
	
	
	public int updateUser(User user){
		String sql = "update umuser set password=? where userid=?";
		Object args[] = new Object[]{user.getPassword(), user.getUserid()};
		return super.updateData(sql, args);	
	
	}

	protected Object rowMapper(ResultSet rs)throws SQLException{
		return null;
	}
}
