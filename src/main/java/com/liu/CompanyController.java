package com.liu;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.liu.data.access.NewsAccess;
import com.utils.ExtUtils;
import com.utils.FreemarkerUtils;
import com.utils.Page;
import com.utils.TimeUtil;
import com.vo.News;

@Controller
@RequestMapping("/admin/news")
public class CompanyController  {
	@Autowired
	private NewsAccess newsAccess;
	private Page<News> page = new Page<News>();
	private Gson gson=new Gson();
	/**
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit")
	public String query(HttpServletRequest request, Model model) {
		return "edit";
	}
	
	
	@ResponseBody
	@RequestMapping("/add")
	public String add(News news, HttpServletRequest request, Model model) {
		 String path = request.getRealPath("/");
		try {
			newsAccess.add(news,path);
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "2";
		}
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(News news, HttpServletRequest request, Model model) {
		String path = request.getRealPath("/");
		try {
			newsAccess.update(news,path);
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "2";
		}
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		return "new-list";
	}

	@ResponseBody
	@RequestMapping("/listJson")
	public String listJson(HttpServletRequest request, Model model) {
		ExtUtils.initPageFromExtGridParam(request, page);
		String type=request.getParameter("type")==null?"0":request.getParameter("type");
		News news=new News();
		news.setType(Integer.parseInt(type));
		page=newsAccess.list(page, news);
		return gson.toJson(page);
	}
	
	
	

	
	@ResponseBody
	@RequestMapping("/info1")
	public String info1(HttpServletRequest request, Model model) {
		
		String id=request.getParameter("id");
		News news= newsAccess.info(Integer.parseInt(id));
		return gson.toJson(news);
	}
	
	
	@RequestMapping("/info")
	public String info(HttpServletRequest request, Model model) {
		
		String id=request.getParameter("id");
		News news= newsAccess.info(Integer.parseInt(id));
		model.addAttribute("news", news);
		return "edit";
	}
	
	@ResponseBody
	@RequestMapping("/gen")
	public String gen(HttpServletRequest request, Model model) {
		ExtUtils.initPageFromExtGridParam(request, page);
		List<News> list=newsAccess.list1();
		FreemarkerUtils utils=new FreemarkerUtils();
		Map<String, List<News>> map = new HashMap<String, List<News>>();
		map.put("list", list);
		utils.geneHtmlFile(request.getRealPath("/"), "index.ftl", map, "index.htm");
		System.out.println("ҳ����ɳɹ�");
		return null;
		
	}
}
