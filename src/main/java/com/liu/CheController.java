package com.liu;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.liu.data.access.NewsAccess;
import com.liu.data.access.ProductAccess;

@Controller
@RequestMapping("/che")
public class CheController  {
	@Autowired
	private NewsAccess newsAccess;
	
	
	@Autowired
	private ProductAccess productAccess;
	private Gson gson=new Gson();
	
	@ResponseBody
	@RequestMapping(value = "/save", produces = "text/json;charset=UTF-8")
	public String save(HttpServletRequest request, Model model) {

		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String start=request.getParameter("from_place");
		String end=request.getParameter("to_place");
		String pass=request.getParameter("mid_place");
		String time=request.getParameter("start_time");
		String fz=request.getParameter("fz");
		String surplus=request.getParameter("user_count");
		String memo=request.getParameter("note");
		String type=request.getParameter("type");
		String car=request.getParameter("car");
		Map<String,Object> map=new HashMap<>();
		
		
		 String captchaToken = request.getParameter("code");

	        if (StringUtils.isEmpty(captchaToken)) {
	        	map.put("msg", "验证码为空");
				map.put("success", false);
	        }

	        if (captchaToken.equalsIgnoreCase((String) request.getSession().getAttribute("captchaToken"))) {
	        	try {
	    			productAccess.save(name,phone,start,end,pass,time,surplus,memo,type,car,fz);
	    			map.put("msg", "发布成功");
	    			map.put("success", true);
	    		} catch (Exception e) {
	    			map.put("msg", e.getMessage());
	    			map.put("success", false);
	    			e.printStackTrace();
	    		}
	    		
	        }else{
	        	map.put("msg", "验证码不正确");
				map.put("success", false);
	        }
		
		return gson.toJson(map);
		
	}

}
