package com.sec.util;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class OpenId {
	public  static Map<String,Object> oauth2GetOpenid(String appid,String code,String appsecret) {
   	 String GetPageAccessTokenUrl = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+appsecret+"&js_code="+code+"&grant_type=authorization_code";
   	 
   	 String requestUrl = GetPageAccessTokenUrl.replace("APPID", appid).replace("SECRET", appsecret).replace("CODE", code);  
        HttpClient client = null;  
        Map<String,Object> result =new HashMap<String,Object>();  
        try {     
            client = new DefaultHttpClient();  
            HttpGet httpget = new HttpGet(requestUrl);  
            ResponseHandler<String> responseHandler = new BasicResponseHandler();  
            String response = client.execute(httpget, responseHandler);  
            JSONObject OpenidJSONO=JSONObject.fromObject(response);
            String openid =String.valueOf(OpenidJSONO.get("openid"));
            String session_key=String.valueOf(OpenidJSONO.get("session_key"));
            String unionid=String.valueOf(OpenidJSONO.get("unionid"));
            String errcode=String.valueOf(OpenidJSONO.get("errcode"));
            String errmsg=String.valueOf(OpenidJSONO.get("errmsg"));
            result.put("json", OpenidJSONO);
            result.put("openid", openid);
            result.put("sessionKey", session_key);
            result.put("unionid", unionid);
            result.put("errcode", errcode);
            result.put("errmsg", errmsg);
        } catch (Exception e) {
            e.printStackTrace();   
        } finally {  
            client.getConnectionManager().shutdown();  
        }  
        return result;  
    }  

}
