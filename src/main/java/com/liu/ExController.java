package com.liu;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;






import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liu.data.access.NewsAccess;
import com.liu.data.access.ProductAccess;
import com.liu.job.RefreshMemTask;
import com.utils.ExtUtils;
import com.utils.FreemarkerUtils;
import com.utils.Page;
import com.utils.TimeUtil;
import com.vo.Che;
import com.vo.News;

@Controller
@RequestMapping("/admin/ex")
public class ExController  {
	@Autowired
	private ProductAccess productAccess;
	private Page<News> page = new Page<News>();
	private Gson gson=new Gson();

	private Page<Che> page2 = new Page<Che>();
	
	
	
	@ResponseBody
	@RequestMapping("/listJson")
	public String listJson(HttpServletRequest request, Model model) {
		ExtUtils.initPageFromExtGridParam(request, page);
		String type=request.getParameter("type")==null?"0":request.getParameter("type");
		News news=new News();
		news.setType(Integer.parseInt(type));
		page=productAccess.list(page, news);
		return gson.toJson(page);
	}
	
	@ResponseBody
	@RequestMapping("/getWxJsApi")
	public String getWxJsApi(HttpServletRequest request, Model model) {
		
		Map<String,String> map=new HashMap<>();
	
		map.put("appId", RefreshMemTask.APPID);
		map.put("timestamp", RefreshMemTask.TIMESTMAP);
		map.put("nonceStr", RefreshMemTask.NONCESTR);
		map.put("signature", RefreshMemTask.SIGN);
		
		return gson.toJson(map);
	}
	
	
	@ResponseBody
	@RequestMapping("/ClistJson")
	public String clistJson(HttpServletRequest request, Model model) {
		Page<Che> page2 = new Page<Che>();
		ExtUtils.initPageFromExtGridParam(request, page2);
		String type=request.getParameter("type")==null?"0":request.getParameter("type");
		Che che=new Che();
		che.setType(Integer.parseInt(type));
		page2=productAccess.listCheJson(page2, che);
	
		
		System.out.println(gson.toJson(page2));
		return gson.toJson(page2);
	}
	
	
	
	
	

}
