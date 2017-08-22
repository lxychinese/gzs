package com.utils;

import javax.servlet.http.HttpServletRequest;

public class JspUtils {
	
	/**
	 * 获取分页信息JSP页面
	 * @param request
	 * @param page
	 */
	public static void initPageFromExtGridParam(final HttpServletRequest request, final PageRequest page){
		String start = request.getParameter("pageNo");	//当前页数
		String pageSize=request.getParameter("pageSize");
		String sort = request.getParameter("sort");		//排序字段
		String dir = request.getParameter("dir");		//排序方向，升序或降序
		if(pageSize==null){
			pageSize="10";
		}
		String limit  =	pageSize;//limit参数为每次获取的记录数
		if(start != null && start.trim().length() > 0 && limit != null && limit.trim().length() > 0){
			
			int startNo = Integer.valueOf(start); //起始行
			int limitNo = Integer.valueOf(limit); //每页行数大小
			if(startNo >=0 && limitNo > 0){
				//每页行数大小
				page.setPageSize(Integer.valueOf(limit));
				page.setPageNo(startNo);//设置当前页
			}	
		}
		if(sort != null && sort.trim().length() > 0){
			page.setOrderBy(sort);
			
			if(dir != null && (dir.equalsIgnoreCase(PageRequest.Sort.DESC) || dir.equalsIgnoreCase(PageRequest.Sort.ASC))){
				page.setOrderDir(dir.toLowerCase());
			}
		}
		

	}

}
