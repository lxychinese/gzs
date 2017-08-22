package com.liu;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liu.data.access.NewsAccess;

@Controller
public class IndexController {
	
	@Autowired
	private NewsAccess newsAccess;
	@RequestMapping("/main")
	public String index(HttpServletRequest request, Model model) {
		return "main";
	}
	
	
	@RequestMapping("/index2")
	public String query(HttpServletRequest request, Model model) {
		return "index2";
	}
	
	@RequestMapping("/app")
	public String app(HttpServletRequest request, Model model) {
		return "app";
	}
	
	@RequestMapping("/3d")
	public String d3(HttpServletRequest request, Model model) {
		return "3d";
	}
	

	
	@RequestMapping("/ab")
	public String ab(HttpServletRequest request, Model model) {
		return "ab";
	}
	
	@RequestMapping("/info")
	public String info(HttpServletRequest request, Model model) {
		return "info";
	}
	@RequestMapping("/weixin")
	public String weixin(HttpServletRequest request, Model model) {
		return "weixin";
	}
	@RequestMapping("/news")
	public String news(HttpServletRequest request, Model model) {
		return "news";
	}
	
	
	@RequestMapping("/test")
	public String test(HttpServletRequest request, Model model) {

		newsAccess.listtest();
		return "news";
	}
	
}
