package com.utils;

import com.vo.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageUtils extends DBUtils{
	private JdbcUtils JdbcUtils=new JdbcUtils();
	/**
	 *message分页对象
	 */
	public Page<Message> listMsg(Page<Message> page,Message mesg){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Message msg = null;
		List<Message> list = new ArrayList<Message>();
		try{
			conn = JdbcUtils.getConnection();
			int start = (page.getPageNo()-1)*page.getPageSize();
			String sql = "select * from message  order by id desc limit "+start+","+page.getPageSize()+"";
			System.out.println(sql);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while ( rs.next()){
				msg = new Message();
				msg.setId(Integer.valueOf(rs.getInt("id")));
				msg.setContent(rs.getString("content"));
				msg.setEmail(rs.getString("email"));
				msg.setLinkMan(rs.getString("linkman"));
				msg.setPhone(rs.getString("phone"));
				msg.setQq(rs.getString("qq"));
				msg.setTitle(rs.getString("title"));
				msg.setCreateTime(rs.getString("createTime"));
				list.add(msg);
			}
			page.setResult(list);
			page.setTotalItems(super.getCount(sql));
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally{
			JdbcUtils.free(rs, ps, conn);
		}
		
		return page;
	}

	/**
	 * 根据ID得到信息详情
	 */
	public Message getInfo(int id){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Message msg=null;
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select * from message where id=?";
			System.out.println(sql);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				msg = new Message();
				msg.setId(Integer.valueOf(rs.getInt("id")));
				msg.setContent(rs.getString("content"));
				msg.setTitle(rs.getString("title"));
				msg.setCreateTime(rs.getString("createtime"));
				msg.setLinkMan(rs.getString("linkman"));
				msg.setPhone(rs.getString("phone"));
				msg.setQq(rs.getString("qq"));
				msg.setEmail(rs.getString("email"));
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtils.free(rs, ps, conn);
		}
		return msg;
	}

	public int addMsg(Message msg)
	{
		String sql = "insert into message(title,content,linkman,phone,email,qq,createtime) values(?,?,?,?,?,?,?)";
		System.out.println(sql);
		Object args[] = new Object[]{msg.getTitle(), msg.getContent(), msg.getLinkMan(), msg.getPhone(), msg.getEmail(), msg.getQq(), msg.getCreateTime()};
		return super.updateData(sql, args);
	}

	public int setState(String ids, int state)
	{
		String sql = "update message set state=? where id in (?)";
		Object args[] = new Object[]{ids, Integer.valueOf(state)};
		return super.updateData(sql, args);
	}

	public int deleteMsg(String ids)
	{
		String sql = "delete from  message  where id in (?)";
		Object args[] = new Object[]{ids};
		return super.updateData(sql, args);
	}

	protected Object rowMapper(ResultSet rs)
		throws SQLException
	{
		return null;
	}
}
