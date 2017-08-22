package com.liu.data.access.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.data.TT;
import com.liu.data.access.ProductAccess;
import com.liu.job.RefreshMemTask;
import com.utils.FreemarkerUtils;
import com.utils.Page;
import com.utils.TimeUtil;
import com.vo.Che;
import com.vo.News;

@Service
public class ProductAccessImpl implements ProductAccess {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private Object time;

	
	
	public void save(Map<String,String> map) throws IllegalAccessException, InvocationTargetException {
		Che che=new Che();
		org.apache.commons.beanutils.BeanUtils.populate(che, map);  
		String sql = "insert into che(start,end,pass,time,ptime,time_memo,mobile,name,surplus,memo,type) values(?,?,?,?,?,?,?,?,?,?,?) ";

		if(StringUtils.isNotEmpty(che.getPass())){
			che.setPass("(途径"+che.getPass()+")");
		}
		if(StringUtils.isNotEmpty(che.getMemo())){
			che.setMemo("备注:"+che.getMemo());
		}
		int i=jdbcTemplate.update(sql,new Object[]{che.getStart(),che.getEnd(),che.getPass(),convertTime(che.getTime()+""),System.currentTimeMillis(),
				che.getTime_memo(),che.getMobile(),che.getName(),che.getSurplus(),che.getMemo(),che.getType()});
		
		System.out.println(i);

	}
	
	
	
	
	
	
	private  long convertTime(String time) {

		String target = "";
		String reg = "(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(time);
		while (m.find()) {
			target = m.group(1) + "-" + m.group(2) + "-" + m.group(3) + " " + m.group(4) + ":" + m.group(5) ;
		}
		long d = TimeUtil.getTime(target, TimeUtil.F_YYYY_MM_DD_HH_MM);
		return d;

	}
	
	private  long convertTime2(String time) {

		long d = TimeUtil.getTime(time, TimeUtil.F_YYYY_MM_DD);
		return d;

	}
	
	
	
	public Page<News> list(Page<News> page, News news) {
		int start = (page.getPageNo() - 1) * page.getPageSize();
		String sql = "select id,title,memo,createTime,content,url,imgSrc from news where 1=1";
		if (news.getType() != 0) {
			sql += " and  type=" + news.getType();
		}
		sql += " order by id desc  limit " + start + "," + page.getPageSize() + "";
		List<News> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(News.class));
		page.setResult(list);
		page.setTotalItems(count());
		return page;
	}
	
	
	
	public Page<Che> listCheJson(Page<Che> page, Che ches) {
		int start = (page.getPageNo() - 1) * page.getPageSize();
		String sql = "select id,start,end,pass,time,ptime,time_memo,mobile,name,surplus,memo,type,fz from che where 1=1";
		if (ches.getType() != 0) {
			sql += " and  type=" + ches.getType();
		}
		sql += " order by id desc  limit " + start + "," + page.getPageSize() + "";
		List<Che> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Che.class));
		
		for(Che che:list){
			String week=TimeUtil.getWeekOfDate(che.getTime());
			che.setWeek(week);	
			che.setPtimedec(TT.format(che.getPtime()));
			if(TimeUtil.isToday(che.getTime())){
				che.setJt(true);
				che.setTimeFmt("今天");
				
			}else{
				che.setJt(false);
				che.setTimeFmt(TimeUtil.getString(che.getTime(), TimeUtil.F_MM_DD));
			};
		}
		
		page.setResult(list);
		page.setTotalItems(count2(ches.getType()));
		
		
	
		return page;
	}
	
	
	

	public int count() {
		String sql = "select count(1) from news order by id desc";
		int count = jdbcTemplate.queryForInt(sql);
		return count;
	}
	
	
	public int count2(int type) {
	
		String sql = "select count(1) from che where type=? ";
		
	   if(type==0){
		   sql = "select count(1) from che";
		   int count = jdbcTemplate.queryForInt(sql);
		   return count;
		}
		int count = jdbcTemplate.queryForInt(sql,type);
		return count;
	}
	
	
	

	public void list(News news, String path) {
		String sql = "select id,title,memo,createTime,content,url from product order by id desc ";
		List<News> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(News.class));
		FreemarkerUtils u = new FreemarkerUtils();

		for (News new1 : list) {
			Map map = new HashMap();

			List lis = list(4);
			map.put("list", lis);
			map.put("news", new1);
			u.geneHtmlFile(path, "view.ftl", map, new1.getUrl());
			System.out.println("gen--" + new1.getId() + ".htm");
			u.geneHtmlFile(path + "/mobile", "m-new.ftl", map, new1.getUrl());// 手机详情页
			u.geneHtmlFile(path, "pro.ftl", map, new1.getUrl());// 手机详情页

		}
	}

	public List<News> list(int index) {
		String sql = "SELECT * FROM product ORDER BY RAND() LIMIT ?";// 尽量不要用*
		List<News> list = jdbcTemplate.query(sql, new Object[] { index }, new BeanPropertyRowMapper(News.class));
		return list;
	}






	@Override
	public void save(String name, String mobile, String start, String end, String pass, String time, String surplus, String memo, String type, String car, String fz) {
		String sql = "insert into che(start,end,pass,time,ptime,time_memo,mobile,name,surplus,memo,type,fz) values(?,?,?,?,?,?,?,?,?,?,?,?) ";
		int i=jdbcTemplate.update(sql,new Object[]{start,end,pass,convertTime2(time),System.currentTimeMillis(),
				car,mobile,name,surplus,memo,type,fz});
		System.out.println(i);
		
	}






}
