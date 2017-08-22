package com.utils;

import com.vo.Reply;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


public class ReplyUtils extends DBUtils{
	private JdbcUtils JdbcUtils=new JdbcUtils();
	public List listReply(int msgId){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List list = new ArrayList();
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select * from reply where msgId=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, msgId);
			rs = ps.executeQuery();
			ResultSetToList rl = new ResultSetToList();
			list = ResultSetToList.convertList(rs);
		}
		catch (SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtils.free(rs, ps, conn);		
		}
		return list;
	}

	public void delete(Integer id){
		String sql = "delete from reply where id =?";
		Object args[] =new Object[]{id};
		super.updateData(sql, args);
	}

	public int delete(String ids){
		String sql = "delete from reply where id in (?)";
		Object args[] =new Object[]{ids};
		return super.updateData(sql, args);
	}

	public int save(Reply reply){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String sql = "insert into reply(content, createBy, msgId,createTime) values(?,?,?,?)";
		Object args[] =new Object[]{reply.getContent(),reply.getCreateBy(),reply.getMsgId(),sf.format(new Date())};
		return super.updateData(sql, args);
	}

	public int update(Reply reply){
		String sql = "update reply set content = ? where id = ?";
		Object args[] =new Object[]{reply.getContent(),reply.getId()};
		return super.updateData(sql, args);
	}

	protected Object rowMapper(ResultSet rs)throws SQLException{
		return null;
	}
}
