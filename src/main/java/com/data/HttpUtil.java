package com.data;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by YB on 2014/7/10.
 */
public class HttpUtil {
    private static Gson gson = new Gson();

    public static String httpGet(String urlStr) {
        HttpURLConnection uc = null;
        try {
            URL url = new URL(urlStr);

            uc = (HttpURLConnection) url.openConnection();
            uc.setRequestMethod("GET");
            uc.setConnectTimeout(5000); // 五秒连接超时
            uc.setReadTimeout(5000); // 5秒返回超时
            uc.connect();

            StringWriter lines = new StringWriter();
            InputStreamReader reader = new InputStreamReader(uc.getInputStream());
            char[] cbuf = new char[1024];
            int n;
            while ((n = reader.read(cbuf)) != -1) lines.write(cbuf, 0, n);
            return lines.toString();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (uc != null && uc.getInputStream() != null) {
                    uc.disconnect();//释放资源，并有可能影响到持久连接
                    // uc.getInputStream().close();// 只释放实例资源，不会影响持久连接
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String httpPost(String urladdress, String param) {
        HttpURLConnection uc = null;
        try {
            URL url = new URL(urladdress);

            uc = (HttpURLConnection) url.openConnection();
            uc.setDoInput(true);
            uc.setDoOutput(true);
            uc.setInstanceFollowRedirects(true); // 不允许重定向
            uc.setRequestMethod("POST");
            uc.setConnectTimeout(5000); // 五秒连接超时
            uc.setReadTimeout(5000); // 5秒返回超时
            uc.getOutputStream().write(param.getBytes());
            uc.connect();
            String lines = "";
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(uc.getInputStream()));

                while (reader.ready()) {
                    lines += reader.readLine();
                }
                reader.close();
            } catch (Exception e) {
            }
            return lines;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (uc != null && uc.getInputStream() != null) {
                    uc.disconnect();//释放资源，并有可能影响到持久连接
                    // uc.getInputStream().close();// 只释放实例资源，不会影响持久连接
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }


    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static void main(String[] args) {

    }


}
