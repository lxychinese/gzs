package com.liu;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.HttpUtil;
import com.google.gson.Gson;
@Controller
public class WxController {
	public static final String APPID = "wx671aaf883e411e83";
	public static final String SECRET = "5aa53b033070ce4efaaf91c157c3dc03";

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
