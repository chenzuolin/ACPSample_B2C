package com.unionpay.acp.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.unionpay.acp.sdk.AcpService;
import com.unionpay.acp.sdk.SDKConfig;
import com.unionpay.acp.sdk.SDKConstants;

/**
 * 鍚嶇О锛�demo涓敤鍒扮殑鏂规硶<br>
 * 鏃ユ湡锛�2015-09<br>
 * 鐗堟湰锛�1.0.0 
 * 鐗堟潈锛�涓浗閾惰仈<br>
 * 璇存槑锛氫互涓嬩唬鐮佸彧鏄负浜嗘柟渚垮晢鎴锋祴璇曡�鎻愪緵鐨勬牱渚嬩唬鐮侊紝鍟嗘埛鍙互鏍规嵁鑷繁闇�锛屾寜鐓ф妧鏈枃妗ｇ紪鍐欍�璇ヤ唬鐮佷粎渚涘弬鑰冦�<br>
 */
public class DemoBase {

	//榛樿閰嶇疆鐨勬槸UTF-8
	public static String encoding_UTF8 = "UTF-8";
	
	public static String encoding_GBK = "GBK";
	//鍏ㄦ笭閬撳浐瀹氬�
	public static String version = "5.0.0";
	
	//鍚庡彴鏈嶅姟瀵瑰簲鐨勫啓娉曞弬鐓�FrontRcvResponse.java
	public static String frontUrl = "http://127.0.0.1:8080/ACPSample_B2C/frontRcvResponse";

	//鍚庡彴鏈嶅姟瀵瑰簲鐨勫啓娉曞弬鐓�BackRcvResponse.java
	public static String backUrl = "http://222.222.222.222:8080/ACPSample_B2C/BackRcvResponse";//鍙楃悊鏂瑰拰鍙戝崱鏂硅嚜閫夊～鍐欑殑鍩焄O]--鍚庡彴閫氱煡鍦板潃

	// 鍟嗘埛鍙戦�浜ゆ槗鏃堕棿 鏍煎紡:YYYYMMDDhhmmss
	public static String getCurrentTime() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
	
	// AN8..40 鍟嗘埛璁㈠崟鍙凤紝涓嶈兘鍚�-"鎴�_"
	public static String getOrderId() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
	
   /**
	 * 缁勮璇锋眰锛岃繑鍥炴姤鏂囧瓧绗︿覆鐢ㄤ簬鏄剧ず
	 * @param data
	 * @return
	 */
    public static String genHtmlResult(Map<String, String> data){

    	TreeMap<String, String> tree = new TreeMap<String, String>();
		Iterator<Entry<String, String>> it = data.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> en = it.next();
			tree.put(en.getKey(), en.getValue());
		}
		it = tree.entrySet().iterator();
		StringBuffer sf = new StringBuffer();
		while (it.hasNext()) {
			Entry<String, String> en = it.next();
			String key = en.getKey(); 
			String value =  en.getValue();
			if("respCode".equals(key)){
				sf.append("<b>"+key + SDKConstants.EQUAL + value+"</br></b>");
			}else
				sf.append(key + SDKConstants.EQUAL + value+"</br>");
		}
		return sf.toString();
    }
    /**
	 * 鍔熻兘锛氳В鏋愬叏娓犻亾鍟嗘埛瀵硅处鏂囦欢涓殑ZM鏂囦欢骞朵互List<Map>鏂瑰紡杩斿洖
	 * 閫傜敤浜ゆ槗锛氬璐︽枃浠朵笅杞藉悗瀵规枃浠剁殑鏌ョ湅
	 * @param filePath ZM鏂囦欢鍏ㄨ矾寰�
	 * @return 鍖呭惈姣忎竴绗斾氦鏄撲腑 搴忓垪鍙�鍜�鍊�鐨刴ap搴忓垪
	 */
	public static List<Map> parseZMFile(String filePath){
		int lengthArray[] = {3,11,11,6,10,19,12,4,2,21,2,32,2,6,10,13,13,4,15,2,2,6,2,4,32,1,21,15,1,15,32,13,13,8,32,13,13,12,2,1,131};
		return parseFile(filePath,lengthArray);
	}
	
	/**
	 * 鍔熻兘锛氳В鏋愬叏娓犻亾鍟嗘埛瀵硅处鏂囦欢涓殑ZME鏂囦欢骞朵互List<Map>鏂瑰紡杩斿洖
	 * 閫傜敤浜ゆ槗锛氬璐︽枃浠朵笅杞藉悗瀵规枃浠剁殑鏌ョ湅
	 * @param filePath ZME鏂囦欢鍏ㄨ矾寰�
	 * @return 鍖呭惈姣忎竴绗斾氦鏄撲腑 搴忓垪鍙�鍜�鍊�鐨刴ap搴忓垪
	 */
	public static List<Map> parseZMEFile(String filePath){
		int lengthArray[] = {3,11,11,6,10,19,12,4,2,21,2,32,2,6,10,13,13,4,15,2,2,6,2,4,32,1,21,15,1,15,32,13,13,8,32,13,13,12,2,1,131};
		return parseFile(filePath,lengthArray);
	}
	
	/**
	 * 鍔熻兘锛氳В鏋愬叏娓犻亾鍟嗘埛 ZM,ZME瀵硅处鏂囦欢
	 * @param filePath
	 * @param lengthArray 鍙傜収銆婂叏娓犻亾骞冲彴鎺ュ叆鎺ュ彛瑙勮寖 绗�閮ㄥ垎 鏂囦欢鎺ュ彛銆�鍏ㄦ笭閬撳晢鎴峰璐︽枃浠�6.1 ZM鏂囦欢鍜�.2 ZME 鏂囦欢 鏍煎紡鐨勭被鍨嬮暱搴︾粍鎴恑nt鍨嬫暟缁�
	 * @return
	 */
	 private static List<Map> parseFile(String filePath,int lengthArray[]){
	 	List<Map> ZmDataList = new ArrayList<Map>();
	 	try {
            String encoding="UTF-8";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //鍒ゆ柇鏂囦欢鏄惁瀛樺湪
                InputStreamReader read = new InputStreamReader(
                new FileInputStream(file),encoding);//鑰冭檻鍒扮紪鐮佹牸寮�
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                	//瑙ｆ瀽鐨勭粨鏋淢AP锛宬ey涓哄璐︽枃浠跺垪搴忓彿锛寁alue涓鸿В鏋愮殑鍊�
        		 	Map<Integer,String> ZmDataMap = new LinkedHashMap<Integer,String>();
                    //宸︿晶娓告爣
                    int leftIndex = 0;
                    //鍙充晶娓告爣
                    int rightIndex = 0;
                    for(int i=0;i<lengthArray.length;i++){
                    	rightIndex = leftIndex + lengthArray[i];
                    	String filed = lineTxt.substring(leftIndex,rightIndex);
                    	leftIndex = rightIndex+1;
                    	ZmDataMap.put(i, filed);
                    }
                    ZmDataList.add(ZmDataMap);
                }
                read.close();
        }else{
            System.out.println("鎵句笉鍒版寚瀹氱殑鏂囦欢");
        }
        } catch (Exception e) {
            System.out.println("璇诲彇鏂囦欢鍐呭鍑洪敊");
            e.printStackTrace();
        }
	 	for(int i=0;i<ZmDataList.size();i++){
	 		System.out.println("琛屾暟: "+ (i+1));
	 		Map<Integer,String> ZmDataMapTmp = ZmDataList.get(i);
	 		
	 		for(Iterator<Integer> it = ZmDataMapTmp.keySet().iterator();it.hasNext();){
	 			Integer key = it.next();
	 			String value = ZmDataMapTmp.get(key);
		 		System.out.println(" "+ key + " 鍊� '"+ value +"'");
		 	}
	 	}
		return ZmDataList;	
	}

		
	public static void main(String[] args) {
		System.out.println(AcpService.encryptTrack("12", "utf-8"));
		SDKConfig.getConfig().loadPropertiesFromSrc();
		
		Map<String,String> customerInfoMap = new HashMap<String,String>();
		//customerInfoMap.put("certifTp", "01");
		//customerInfoMap.put("certifId", "341126197709218366");
		//customerInfoMap.put("customerNm", "浜掕仈缃�);
		customerInfoMap.put("phoneNo", "13552535506");
		//customerInfoMap.put("smsCode", "123456");
		//customerInfoMap.put("pin", "626262");						//瀵嗙爜鍔犲瘑
		//customerInfoMap.put("cvn2", "123");           				//鍗¤儗闈㈢殑cvn2涓変綅鏁板瓧
		//customerInfoMap.put("expired", "1711");  				    //鏈夋晥鏈�骞村湪鍓嶆湀鍦ㄥ悗
		
		//System.out.println(getCustomerInfoWithEncrypt(customerInfoMap,"6217001210048797565"));
		
		parseZMFile("C:\\Users\\wulh\\Desktop\\802310048993424_20150905\\INN15090588ZM_802310048993424");
	}

}