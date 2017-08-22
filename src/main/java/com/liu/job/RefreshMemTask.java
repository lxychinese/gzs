package com.liu.job;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.data.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


public class RefreshMemTask implements Runnable {

	private static final long interval = 3600000L * 1;
	private boolean running = true;
	private Gson gson = new Gson();
	  public static  String APPID="";
	  public static  String TIMESTMAP="";
	  public static  String NONCESTR="";
	  public static  String SIGN="";
	
	
	@Override
	public void run() {

		while (running) {

			// 无论出现什么问题和异常，这个任务都不可以停下来
			try {
				getWxConfig();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void stop() {
		this.running = false;
	}
	
	
	 public  Map<String, Object> getWxConfig() {  
	        Map<String, Object> ret = new HashMap<String, Object>();  
	        
	        String appId = "wx3c79e0b33145cec2"; // 必填，公众号的唯一标识  
	        String secret = "f13a2467006e6f4c2ed899c20bf1cce1";
	  
	        String requestUrl = "www.liuxiaoyang.cn/che/index.htm";  
	        String access_token = "";  
	        String jsapi_ticket = "";  
	        String timestamp = Long.toString(System.currentTimeMillis() / 1000); // 必填，生成签名的时间戳  
	        String nonceStr = UUID.randomUUID().toString(); // 必填，生成签名的随机串  
	        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+ appId + "&secret=" + secret;  
	          
	        String content = HttpUtil.httpGet(url);  
	        JsonObject jsonObject = gson.fromJson(content, JsonObject.class);
	          //{"access_token":"EB024fxkYNES8rnWMy22PuP93h3ZOfNfQPrh8aIibW7QwI9oYvGl7ixRTAuKiwsx9j43nIHyR8WQ-F51C_2OY_cNnQKjC0NmeWbAOF311pIPhH1AeFcYQijUhsZiD_PUHTFgAHAAMY","expires_in":7200}
	        if (jsonObject != null) {  
	            //要注意，access_token需要缓存  
	            access_token = jsonObject.get("access_token").getAsString();  
	              
	            url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+ access_token + "&type=jsapi";  
	            content =  HttpUtil.httpGet(url);  
	             jsonObject = gson.fromJson(content, JsonObject.class);
	            if (jsonObject != null) {  
	                jsapi_ticket = jsonObject.get("ticket").getAsString();  
	            }  
	        }  
	        String signature = "";  
	        // 注意这里参数名必须全部小写，且必须有序  
	        String sign = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonceStr+ "×tamp=" + timestamp + "&url=" + requestUrl;  
	        try {  
	            MessageDigest crypt = MessageDigest.getInstance("SHA-1");  
	            crypt.reset();  
	            crypt.update(sign.getBytes("UTF-8"));  
	            signature = byteToHex(crypt.digest());  
	        } catch (NoSuchAlgorithmException e) {  
	            e.printStackTrace();  
	        } catch (UnsupportedEncodingException e) {  
	            e.printStackTrace();  
	        }  
	        APPID=appId;
	        TIMESTMAP=timestamp;
	        NONCESTR=nonceStr;
	        SIGN=signature;
	       
	        return ret;  
	    }  
	    
	    private static String byteToHex(final byte[] hash) {  
	        Formatter formatter = new Formatter();  
	        for (byte b : hash) {  
	            formatter.format("%02x", b);  
	        }  
	        String result = formatter.toString();  
	        formatter.close();  
	        return result;  
	  
	    }  
	    
	    
}
