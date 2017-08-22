package com.utils;

import javax.servlet.http.HttpServletRequest;


/**
 * 提供 ExtJS 支持的工具类
 *
 */
public class ExtUtils {

	/**
	 * 获取 Ext Grid 的分页信息
	 * @param request
	 * @param page
	 */
	public static void initPageFromExtGridParam(final HttpServletRequest request, final PageRequest page){
		// Ext Grid 的默认参数
		String start = request.getParameter("start")==null?"1":request.getParameter("start");	//start参数为起始行
		String limit = "10";	//limit参数为每次获取的记录数
	
		if(start != null && start.trim().length() > 0&& limit != null && limit.trim().length() > 0){
			
			int startNo = Integer.valueOf(start); //起始行
			int limitNo = Integer.valueOf(limit); //每页行数大小
			
			if(startNo >=0 && limitNo > 0){
				//每页行数大小
				page.setPageSize(Integer.valueOf(limit));
				page.setPageNo(startNo / limitNo + 1);
			}	
		}
		

	}
	
	/**
	 * 去除EXT树节点的JSON字符串中的空children字符串
	 * @param json
	 * @return
	 */
	public static String removeEmptyChildrenFromTreeNode(String json){
		if(json!=null && json.length() > 0){
			return json.replace("\"children\":[],", "");
		}
		return json;
	}
	
	/**
	 * 判断是否AJAX请求
	 * @param request
	 * @return
	 */
	public static boolean isXmlHttpRequest(HttpServletRequest request){
		boolean result = false;
		
		String isXmlHttpRequest = request.getHeader("x-requested-with");
		if(isXmlHttpRequest != null && isXmlHttpRequest.equals("XMLHttpRequest"))
			result = true;
		
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
