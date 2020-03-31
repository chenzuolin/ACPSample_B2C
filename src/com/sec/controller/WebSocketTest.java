package com.sec.controller;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

public class WebSocketTest {
    //��̬������������¼��ǰ������������Ӧ�ð�����Ƴ��̰߳�ȫ�ġ�
    private static int onlineCount = 0;
    //concurrent�����̰߳�ȫSet���������ÿ���ͻ��˶�Ӧ��MyWebSocket������Ҫʵ�ַ�����뵥һ�ͻ���ͨ�ŵĻ�������ʹ��Map����ţ�����Key����Ϊ�û���ʶ
    private static ConcurrentHashMap<String, WebSocketTest> webSocketSet = new ConcurrentHashMap<String, WebSocketTest>();
    //��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
    private Session WebSocketsession;
    //��ǰ����Ϣ����Ա���
    private String userno = "";


    /**
     * ���ӽ����ɹ����õķ���
     *
     * @param session ��ѡ�Ĳ�����sessionΪ��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
     */
    @OnOpen
    public void onOpen(@PathParam(value = "userno") String param, Session WebSocketsession, EndpointConfig config) {
        System.out.println(param);
        userno = param;//���յ�������Ϣ����Ա���
        this.WebSocketsession = WebSocketsession;
        webSocketSet.put(param, this);//����map��
        addOnlineCount();           //��������1
        System.out.println("�������Ӽ��룡��ǰ��������Ϊ" + getOnlineCount());
    }


    /**
     * ���ӹرյ��õķ���
     */
    @OnClose
    public void onClose() {
        if (!userno.equals("")) {
            webSocketSet.remove(userno);  //��set��ɾ��
            subOnlineCount();           //��������1
            System.out.println("��һ���ӹرգ���ǰ��������Ϊ" + getOnlineCount());
        }
    }


    /**
     * �յ��ͻ�����Ϣ����õķ���
     *
     * @param message �ͻ��˷��͹�������Ϣ
     * @param session ��ѡ�Ĳ���
     */
    @SuppressWarnings("unused")
//	@OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("���Կͻ��˵���Ϣ:" + message);
//        session.get
        //Ⱥ����Ϣ
        if (1 < 2) {
            sendAll(message);
        } else {
            //��ָ�����˷���Ϣ
            sendToUser(message);
        }
    }


    /**
     * ��ָ�����˷�����Ϣ
     * @param message
     */
    @OnMessage
    public void sendToUser(String message) {
        String sendUserno = message.split("[|]")[1];
        String sendMessage = message.split("[|]")[0];
        String now = getNowTime();
        try {
            if (webSocketSet.get(sendUserno) != null) {
                webSocketSet.get(sendUserno).sendMessage(now + "�û�" + userno + "������Ϣ��" + " <br/> " + sendMessage);
            } else {
                System.out.println("��ǰ�û�������");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * �������˷���Ϣ
     * @param message
     */
    private void sendAll(String message) {
        String now = getNowTime();
        String sendMessage = message.split("[|]")[0];
        //����HashMap
        for (String key : webSocketSet.keySet()) {
            try {
                //�жϽ����û��Ƿ��ǵ�ǰ����Ϣ���û�
                if (!userno.equals(key)) {
                    webSocketSet.get(key).sendMessage(now + "�û�" + userno + "������Ϣ��" + " <br/> " + sendMessage);
                    System.out.println("key = " + key);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    /**
     * ��ȡ��ǰʱ��
     *
     * @return
     */
    private String getNowTime() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        return time;
    }
    /**
     * ��������ʱ����
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("��������");
        error.printStackTrace();
    }


    /**
     * ������������漸��������һ����û����ע�⣬�Ǹ����Լ���Ҫ��ӵķ�����
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        this.WebSocketsession.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }


    public static synchronized int getOnlineCount() {
        return onlineCount;
    }


    public static synchronized void addOnlineCount() {
        WebSocketTest.onlineCount++;
    }


    public static synchronized void subOnlineCount() {
        WebSocketTest.onlineCount--;
    }




}