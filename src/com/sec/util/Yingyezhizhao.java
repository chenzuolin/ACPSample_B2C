package com.sec.util;

import java.net.URLEncoder;

import com.sumeng.wenzi.Base64Util;
import com.sumeng.wenzi.FileUtil;
import com.sumeng.wenzi.HttpUtil;

/**
 * 该类用于文字识别
 * @author Administrator
 *
 */
public class Yingyezhizhao {
	public static String getAuth(String filePath) {
        // 通用识别url
        String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/business_license";
        String result = null;
        try {
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
            /**
             * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
             */
            String accessToken = AuthService.getAuth();
            result = HttpUtil.post(otherHost, accessToken, params);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
