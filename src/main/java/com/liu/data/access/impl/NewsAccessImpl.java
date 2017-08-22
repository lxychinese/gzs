package com.liu.data.access.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.liu.data.access.NewsAccess;
import com.utils.FreemarkerUtils;
import com.utils.Page;
import com.utils.TimeUtil;
import com.vo.News;

@Service
public class NewsAccessImpl implements NewsAccess {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Page<News> list(Page<News> page, News news) {
		int start = (page.getPageNo() - 1) * page.getPageSize();
		String sql = "select id,title,memo,createTime,content,url from product";

		if (news.getType() != 0) {
			sql += " where type=" + news.getType();
		}

		sql += " order by id desc  limit " + start + "," + page.getPageSize() + "";
		List<News> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(News.class));
		for(News n1:list){
			System.out.println(n1.getContent());
		}
		
		System.out.println("----------------------");
		
		page.setResult(list);
		page.setTotalItems(count(news.getType()));
		return page;
	}
	
	
	public void listtest() {
		String sql = "select * from news where content like '%uweb.net.cn%'";


		List<News> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(News.class));
		for(News n1:list){
			System.out.println(n1.getContent());
			System.out.println("------------------------------------------------"+n1.getId()+"-----------------------------------------------");
		}
	
	}
	
	

	public void list(News news, String path) {
		String sql = "select id,title,memo,createTime,content,url,imgSrc from news order by id desc ";
		List<News> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(News.class));
		FreemarkerUtils u = new FreemarkerUtils();

		for (News new1 : list) {
			System.out.println(new1.getHeight());
			List lis = list(4);
			Map map = new HashMap();
			map.put("news", new1);
			map.put("list", lis);
			System.out.println("gen--" + new1.getId() + ".htm");

			u.geneHtmlFile(path + "/mobile", "m-new.ftl", map, new1.getUrl());//手机详情页
			u.geneHtmlFile(path, "view.ftl", map, new1.getUrl());//手机详情页

		}
	}
	
	

	
	
	

	public void getIndexList(String path) {
		FreemarkerUtils u = new FreemarkerUtils();
		List index = indexList(12);
		List ex = indexList(100);
		Map map = new HashMap();
		List faq=listfaq(6);
		map.put("product", index);
		map.put("faq", faq);
		map.put("ex", ex);
		u.geneHtmlFile(path, "index.ftl", map, "index.htm");
		
		u.geneHtmlFile(path, "anli.ftl", map, "anli.htm");
	}

	public List<News> list(int index) {
		String sql = "SELECT * FROM news ORDER BY RAND() LIMIT ?";
		List<News> list = jdbcTemplate.query(sql,new Object[]{index}, new BeanPropertyRowMapper(News.class));
		return list;
	}
	
	private  List<News> listfaq(int index) {
		String sql = "SELECT * FROM product where type=3 ORDER BY RAND() LIMIT ?";
		List<News> list = jdbcTemplate.query(sql,new Object[]{index}, new BeanPropertyRowMapper(News.class));
		return list;
	}
	
	/**
	 * 首页前12个案例
	 * @return
	 */
	public List<News> indexList(int index) {
		String sql = "select id,title,memo,createTime,content,url,imgSrc from news  limit ? ";
		List<News> list = jdbcTemplate.query(sql, new Object[]{index},new BeanPropertyRowMapper(News.class));
		return list;
	}

	public News info(int id) {
		String sql = "select * from news where id=?";
		News news = (News)jdbcTemplate.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper(News.class));
		return news;
	}

	public int add(final News news, String path) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		final String sql = "insert into news(title,content,createTime,is_use,is_top,type,memo)values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, news.getTitle());
				ps.setString(2, news.getContent());
				ps.setString(3, TimeUtil.getString(new Date(), TimeUtil.F_YYYY_MM_DD_HH_MM));
				ps.setInt(4, news.getIs_use());
				ps.setInt(5, news.getIs_top());
				ps.setInt(6, news.getType());
				ps.setString(7, news.getMemo());
				return ps;
			}
		}, keyHolder);

		// 更新URL
		int num = keyHolder.getKey().intValue();
		String sql1 = "update news set url=? where id=?";
		jdbcTemplate.update(sql1, num + ".htm", num);
		// 使用模板生成静态页面

		Map<String, News> map = new HashMap<String, News>();
		news.setCreateTime(TimeUtil.getString(new Date(), TimeUtil.F_YYYY_MM_DD_HH_MM));
		map.put("news", news);
		String sFileName = "/news/" + num + ".htm";
		FreemarkerUtils fUtils = new FreemarkerUtils();
		fUtils.geneHtmlFile(path, "view.ftl", map, sFileName);
		System.out.println("页面" + sFileName + "生成成功");
		return 0;
	}

	public int update(News news, String path) {
		String sql = "update news set title=?,content=?,is_top=?,is_use=?,type=?,memo=? where id=?";
		int num = jdbcTemplate.update(sql, news.getTitle(), news.getContent(), news.getIs_top(), news.getIs_use(), news.getType(), news.getMemo(), news.getId());
		// 使用模板生成静态页面

		Map<String, News> map = new HashMap<String, News>();
		map.put("news", news);
		String sFileName = "/news/" + num + ".htm";
		FreemarkerUtils fUtils = new FreemarkerUtils();
		fUtils.geneHtmlFile(path, "view.ftl", map, sFileName);
		System.out.println("页面" + sFileName + "更新成功");
		return num;
	}

	public List<News> list1() {
		String sql = "select id,title,memo,createTime,content,url from news order by id desc  limit 0,4";
		List<News> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(News.class));
		return list;
	}
	
	

	public int count(int type) {
		String sql = "select count(1) from product";
		if (type != 0) {
			sql += " where type=" +type;
		}

		sql += " order by id desc";
		int count = jdbcTemplate.queryForInt(sql);
		return count;
	}

}
