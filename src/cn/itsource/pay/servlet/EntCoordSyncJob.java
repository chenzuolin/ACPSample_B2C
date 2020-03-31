package cn.itsource.pay.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class EntCoordSyncJob {
	static String AK = "mNvlGlTokIKzvrpvI6RZg9qF5rrVSjIv"; // 百度地图密钥

    public static void main(String[] args) {
    	/*String start = "甘肃省兰州市城关区绿色市场";
        String end = "甘肃省兰州市火车站东路393号";
        String startJW = getCoordinate(start);
        System.out.println(startJW);
        String endJW = getCoordinate(end);
        Long dis = getDistance(startJW,endJW);
        System.out.println(dis);
        // System.err.println("######同步坐标已达到日配额6000限制，请明天再试！#####");*/
    }

    // 调用百度地图API根据地址，获取坐标
    public static String getCoordinate(String address) {
        if (address != null && !"".equals(address)) {
            address = address.replaceAll("\\s*", "").replace("#", "栋");
            String url = "http://api.map.baidu.com/geocoder/v2/?address=" + address + "&output=json&ak=" + AK;
            String json = loadJSON(url);
            if (json != null && !"".equals(json)) {
                JSONObject obj = JSONObject.fromObject(json);
                if ("0".equals(obj.getString("status"))) {
                    double lng = obj.getJSONObject("result").getJSONObject("location").getDouble("lng"); // 经度
                    double lat = obj.getJSONObject("result").getJSONObject("location").getDouble("lat"); // 纬度
                    DecimalFormat df = new DecimalFormat("#.######");
                    return df.format(lng) + "," + df.format(lat);
                }
            }
        }
        return null;
    }
    
    public static Long getDistance(String startLonLat, String endLonLat){
        //返回起始地startAddr与目的地endAddr之间的距离，单位：米
        Long result = new Long(0);
        String queryUrl = "http://restapi.amap.com/v3/distance?key=0b0f6666dc3489682ae580adcfe1a40d&origins="+startLonLat+"&destination="+endLonLat;
        String queryResult = getResponse(queryUrl);
        JSONObject jo = new JSONObject().fromObject(queryResult);
        JSONArray ja = jo.getJSONArray("results");
 
        result = Long.parseLong(new JSONObject().fromObject(ja.getString(0)).get("distance").toString());
        return result;
//        return queryResult;
    }
    private static String getResponse(String serverUrl){
        //用JAVA发起http请求，并返回json格式的结果
        StringBuffer result = new StringBuffer();
        try {
            URL url = new URL(serverUrl);
            URLConnection conn = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
 
            String line;
            while((line = in.readLine()) != null){
                result.append(line);
            }
            in.close();
 
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static String loadJSON(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {} catch (IOException e) {}
        return json.toString();
    }

}
