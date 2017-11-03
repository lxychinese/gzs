package com.liu;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonObject;
import com.utils.WechatTemplateMsg;
import com.vo.Template;
import com.vo.TemplateParam;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.HttpUtil;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Controller
public class WxController {
	public static final String APPID = "wx3c79e0b33145cec2";
	public static final String SECRET = "362e54d69254532086caae6a12c96af2";

	@ResponseBody
	@RequestMapping("/push")
	public void push() throws  Exception{

		String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APPID+"&secret="+SECRET;
		String jsonResult=HttpUtil.httpGet(url);
		JsonObject jsonObject = new Gson().fromJson(jsonResult, JsonObject.class);
		List<String> lines=null;
		try{
			 lines = FileUtils.readLines(new File("config/fans"), "utf-8");
		}catch (Exception e){
			e.printStackTrace();
		}

		for(String id:lines){
			Template tem=new Template();
			tem.setTemplateId("pIqgiK20u1aaLImbL43NFUyrMetWTn3gyR7OOmPvZNE");//任务处理模板
			tem.setTopColor("#00DD00");
			tem.setToUser(id);
			tem.setUrl("http://liuxiaoyang.cn");
			List<TemplateParam> paras=new ArrayList<TemplateParam>();
			paras.add(new TemplateParam("first","垄上工作室，做网站可以的","#FF3333"));
			paras.add(new TemplateParam("keyword1","本公众号已升级为服务号，开放评论功能","#0044BB"));
			paras.add(new TemplateParam("keyword2","垄上服务站，我们是认真的","#0044BB"));
			paras.add(new TemplateParam("remark","感谢你对我们公众号的支持!祝国庆长假节日愉快!","#AAAAAA"));
			tem.setTemplateParamList(paras);
			sendTemplateMsg(jsonObject.get("access_token").getAsString(),tem);
		}

	}

	public static boolean sendTemplateMsg(String token,Template template) throws  Exception{

		boolean flag=false;

		String requestUrl="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
		requestUrl=requestUrl.replace("ACCESS_TOKEN", token);

		String jsonResult=HttpUtil.httpPost(requestUrl, template.toJSON());
		JsonObject jsonObject = new Gson().fromJson(jsonResult, JsonObject.class);
		if(jsonResult!=null){
			int errorCode=jsonObject.get("errcode").getAsInt();
			String errorMessage=jsonObject.get("errmsg").getAsString();
			if(errorCode==0){
				flag=true;
			}else{
				System.out.println("模板消息发送失败:"+errorCode+","+errorMessage);
				flag=false;
			}
		}
		return flag;



	}

	@ResponseBody
	@RequestMapping("/wx")
	public String listJson(HttpServletRequest request, Model model) {
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
		String result = HttpUtil.httpGet(String.format(url, APPID, "http%3a%2f%2fwww.baidu.com"));

		WX1 wx1 = new Gson().fromJson(result, WX1.class);
		String code = wx1.code;

		url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%S&secret=%S&code=%s&grant_type=authorization_code";

		result = HttpUtil.httpGet(String.format(url, APPID, SECRET, code));
		WX2 wx2 = new Gson().fromJson(result, WX2.class);

		String openId = wx2.openid;
		String token = wx2.access_token;

		url = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh-CN";
		result = HttpUtil.httpGet(String.format(url, token, openId));
		WX3 wx3 = new Gson().fromJson(result, WX3.class);
		System.out.println(wx3.nickname + "-" + wx3.openid);
		return "1";

	}

}

class WX1 {
	public String code;
	public String state;
}

class WX2 {
	public String access_token;
	public String openid;
	public String expires_in;
}

class WX3 {
	public String nickname;
	public String openid;
}
