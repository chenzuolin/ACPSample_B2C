package cn.itsource.pay.servlet;

import io.goeasy.GoEasy;
import io.goeasy.publish.GoEasyError;
import io.goeasy.publish.PublishListener;

public class PublishMessageInGoEasy1 {
	public static void main(String[] agrs) {
		
		GoEasy easyObj = new GoEasy("rest-hangzhou.goeasy.io","BC-8a96434d730f45de9a73cdfe101b398f");
		easyObj.publish("GoEasy","�ײ�û����",new PublishListener(){
		@Override
		public void onFailed(GoEasyError error){
			System.out.println("����ʧ����,Error code:"+error.getCode()+"error content:" + error.getContent());
		}
		@Override
		public void onSuccess(){
			System.out.println("��Ϣ���ͳɹ�");
		}
		});
	}
}

