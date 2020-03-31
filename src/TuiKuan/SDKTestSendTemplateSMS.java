package TuiKuan;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.sec.dao.WineshopDao;
import com.sec.entity.Wineshop;

public class SDKTestSendTemplateSMS {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, Object> result = null;
		String ACOUNT_SID = "8aaf07086ab0c082016ad90c19191c1a";
		String AUTH_TOKEN = "41d4b2c21fe24dc3a621560611debd4e";
		String APP_ID = "8aaf07086ab0c082016ad90c19671c20";

		//��ʼ��SDK
		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
		
		//******************************ע��*********************************************
		//*��ʼ����������ַ�Ͷ˿�                                                       *
		//*ɳ�л���������Ӧ�ÿ������ԣ���restAPI.init("sandboxapp.cloopen.com", "8883");*
		//*�����������û�Ӧ������ʹ�ã���restAPI.init("app.cloopen.com", "8883");       *
		//*******************************************************************************
		restAPI.init("app.cloopen.com", "8883");
		
		//******************************ע��*********************************************
		//*��ʼ�����ʺź����ʺ�����,��Ӧ�������������˺��µ�ACCOUNT SID��AUTH TOKEN     *
		//*ACOUNT SID��AUTH TOKEN�ڵ�½�������ڡ�Ӧ��-�������̨���в鿴���������˺Ż�ȡ*
		//*����˳�򣺵�һ��������ACOUNT SID���ڶ���������AUTH TOKEN��                   *
		//*******************************************************************************
		restAPI.setAccount(ACOUNT_SID, AUTH_TOKEN);
		
		
		//******************************ע��*********************************************
		//*��ʼ��Ӧ��ID                                                                 *
		//*���Կ�����ʹ�á�����Demo����APP ID����ʽ������Ҫʹ���Լ�������Ӧ�õ�App ID     *
		//*Ӧ��ID�Ļ�ȡ����½�������ڡ�Ӧ��-Ӧ���б������Ӧ�����ƣ���Ӧ�������ȡAPP ID*
		//*******************************************************************************
		restAPI.setAppId(APP_ID);
		
		
		//******************************ע��****************************************************************
		//*���÷���ģ����ŵĽӿڷ��Ͷ���                                                                  *
		//*����˳��˵����                                                                                  *
		//*��һ������:��Ҫ���͵��ֻ����룬�����ö��ŷָ���һ�����֧��100���ֻ���                          *
		//*�ڶ�������:��ģ��ID����ƽ̨�ϴ����Ķ���ģ���IDֵ�����Ե�ʱ�����ʹ��ϵͳ��Ĭ��ģ�壬idΪ1��    *
		//*ϵͳĬ��ģ�������Ϊ������ͨѶ����ʹ�õ�����ͨѶ����ģ�壬������֤����{1}������{2}��������ȷ���롱*
		//*������������Ҫ�滻���������顣																														       *
		//**************************************************************************************************
		
		//**************************************����˵��***********************************************************************
		//*�������ò���Demo��APP ID������ʹ��Ĭ��ģ��ID 1�������ֻ�����1380000     0000���������Ϊ6532��5������÷�ʽΪ           *
		//*result = restAPI.sendTemplateSMS("13800000000","1" ,new String[]{"6532","5"});																		  *
		//*��13800000000�ֻ����յ��Ķ��������ǣ�����ͨѶ����ʹ�õ�����ͨѶ����ģ�壬������֤����6532������5��������ȷ����     *
		//****************************************************  *****************************************************************
		WineshopDao dao = new WineshopDao();
		List<Wineshop> list = dao.findAll1();
		for(Wineshop w : list){
			String aa = w.getWineshop_Telephone();
			String bb = w.getWineshop_Name();
			if(aa == null || aa.equals("")){
				
			}else{
				result = restAPI.sendTemplateSMS(aa,"492529" ,new String[]{"2019-12-20"});
			}
		 
	
		}
		//result = restAPI.sendTemplateSMS("18419062422","492529" ,new String[]{"","2019-12-21"});
		System.out.println("SDKTestGetSubAccounts result=" + result);  
		if("000000".equals(result.get("statusCode"))){
			//�����������data������Ϣ��map��
			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet(); 
			for(String key:keySet){
				Object object = data.get(key);
				System.out.println(key +" = "+object);
			}
		}else{
			//�쳣�������������ʹ�����Ϣ
			System.out.println("������=" + result.get("statusCode") +" ������Ϣ= "+result.get("statusMsg"));
		}
	}


}
