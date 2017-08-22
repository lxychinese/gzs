package com.liu.data.access;


import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import com.utils.Page;
import com.vo.Che;
import com.vo.News;

public interface ProductAccess {
	public Page<News> list(Page<News> page, News news);
	public void list(News news, String path);
	public void save(Map<String,String> map) throws IllegalAccessException, InvocationTargetException;
	public Page<Che> listCheJson(Page<Che> page, Che che);
	public void save(String name, String phone, String start, String end, String pass, String time, String surplus, String memo, String type, String car,String fz);
}
