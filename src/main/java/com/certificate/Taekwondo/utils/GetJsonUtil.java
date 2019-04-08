package com.certificate.Taekwondo.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

// 通过url发起http请求，获取对应的段位查询结果，以map形式返回
public class GetJsonUtil {

    public static String doHttpRequest(String url) {
        URL urlObject = null;
        HttpURLConnection connection = null;
        DataOutputStream outputStream = null;
        BufferedReader in = null;
        PrintWriter out = null;
        String result = "";
        try {
            urlObject = new URL(url);
            connection = (HttpURLConnection) urlObject.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.connect();
            out = new PrintWriter(new OutputStreamWriter(connection.getOutputStream(),"UTF-8"));
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            //解析json对象
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Map<String, String> getDanJson(String name, String id) {
        Map<String, String> map = new HashMap<String, String>();
        String basic = "http://www.wtf-cn.org.cn/wechat_search/api/danSearch.php?";
        String url = basic + "id=" + id + "&name=" + name;
        String result = doHttpRequest(url);
        String[] strs = result.split(",");
        for(String s : strs) {
            String[] ms = s.split(":");
            map.put(ms[0], ms[1]);
        }
        System.out.println(map.toString());
        return map;

    }

}
