package com.sec.util;

import java.net.URLEncoder;

import com.sumeng.wenzi.Base64Util;
import com.sumeng.wenzi.FileUtil;
import com.sumeng.wenzi.HttpUtil;

/**
 * ������������ʶ��
 * @author Administrator
 *
 */
public class Yingyezhizhao {
	public static String getAuth(String filePath) {
        // ͨ��ʶ��url
        String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/business_license";
        String result = null;
        try {
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
            /**
             * ���ϻ���access_token�й���ʱ�䣬 �ͻ��˿����л��棬���ں����»�ȡ��
             */
            String accessToken = AuthService.getAuth();
            result = HttpUtil.post(otherHost, accessToken, params);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
