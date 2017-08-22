package com.liu.data.access;

import java.util.List;

import com.utils.Page;
import com.vo.News;

public interface NewsAccess {
	public Page<News> list(Page<News> page, News news);
	public News info(int id);
	public int add(final News news,String path);
	public int update(final News news,String path);
	public List<News> list1() ;
	public void list(News news,String path) ;
	public List<News> indexList(int index);
	
	public void getIndexList(String path);
	public void listtest();

}
