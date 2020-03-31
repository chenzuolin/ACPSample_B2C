package com.sec.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import net.sf.json.JSONObject;

@ServerEndpoint("/websocket")
public class ChatServer {

	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static Vector<Session> room = new Vector<Session>();
	
	
	/**
	 * �û�����
	 * @param session ��ѡ
	 */
	@OnOpen
	public void onOpen(Session session){
		room.addElement(session);
	}
	
	/**
	 * ���յ������û�����Ϣ
	 * @param message
	 * @param session
	 */
	@OnMessage
	public void onMessage(String message,Session session){

		//���û���������Ϣ����ΪJSON����
		JSONObject obj = JSONObject.fromObject(message);
		//��JSON��������ӷ���ʱ��
		obj.put("date", df.format(new Date()));
		//�����������е����лỰ
		for(Session se : room){
			//������Ϣ�Ƿ�Ϊ�Լ���
			obj.put("isSelf", se.equals(session));
			//������Ϣ��Զ���û�
			se.getAsyncRemote().sendText(obj.toString());
		}
	}
	
	/**
	 * �û��Ͽ�
	 * @param session
	 */
	@OnClose
	public void onClose(Session session){
		room.remove(session);
	}
	
	/**
	 * �û������쳣
	 * @param t
	 */
	@OnError
	public void onError(Throwable t){
		
	}
}
