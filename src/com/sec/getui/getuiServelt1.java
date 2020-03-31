package com.sec.getui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.style.Style0;
import com.sec.dao.QunTuiDao;
import com.sec.entity.QunTui;

/**
 * Servlet implementation class getuiServelt1
 */
@WebServlet("/getuiServelt1")
public class getuiServelt1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private static String   appId = "cw0SK1P5l1AZjYuS0QnVa8";
	    private static String appKey = "6twIx84uVu92cK7PU2Hj36";
	    private static String masterSecret = "41B6Ad8oDy5BslFyOxT9g7";
	    String host = "http://sdk.open.api.igexin.com/apiex.htm";
	    static String CID = null;
	    static String Title = null;
	    static String Text = null;
	    static String Adress = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getuiServelt1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		  CID = request.getParameter("Wineshop_CID");//��������CID
		  System.out.println(CID+"CID");
		  
		   Title = request.getParameter("GeTuiTitle");
		      Text = request.getParameter("GeTuiText");
		      Adress = request.getParameter("GeTuiAdress");
		  
		 IGtPush push = new IGtPush(host, appKey, masterSecret);
	        LinkTemplate template = linkTemplateDemo();
	        SingleMessage message = new SingleMessage();
	        message.setOffline(true);
	        // ������Чʱ�䣬��λΪ���룬��ѡ
	        message.setOfflineExpireTime(24 * 3600 * 1000);
	        message.setData(template);
	        // ��ѡ��1Ϊwifi��0Ϊ���������绷���������ֻ����ڵ���������������Ƿ��·�
	        message.setPushNetWorkType(0);
	        Target target = new Target();
	        target.setAppId(appId);
	        target.setClientId(CID);
	        //target.setAlias(Alias);
	        IPushResult ret = null;
	        try {
	            ret = push.pushMessageToSingle(message, target);
	        } catch (RequestException e) {
	            e.printStackTrace();
	            ret = push.pushMessageToSingle(message, target, e.getRequestId());
	        }
	        if (ret != null) {
	            System.out.println(ret.getResponse().toString());
	        } else {
	            System.out.println("��������Ӧ�쳣");
	        }
	        PrintWriter out = response.getWriter();
			out.print("<script language='javascript'>alert('���ͳɹ�');window.location.href='QunTui.jsp'</script>");
	        System.out.println(ret.getResponse().toString());
	}
	
	 public static LinkTemplate linkTemplateDemo() {
		 
	        LinkTemplate template = new LinkTemplate();
	        // ����APPID��APPKEY
	        template.setAppId(appId);
	        template.setAppkey(appKey);

	        Style0 style = new Style0();
	        // ����֪ͨ������������
	        style.setTitle(Title);
	        style.setText(Text);
	        // ����֪ͨ��ͼ��
	        style.setLogo("icon.png");
	        // ����֪ͨ������ͼ��
	        style.setLogoUrl("");
	        // ����֪ͨ�Ƿ����壬�𶯣����߿����
	        style.setRing(true);
	        style.setVibrate(true);
	        style.setClearable(true);
	        template.setStyle(style);

	        // ���ô򿪵���ַ��ַ
	        template.setUrl(Adress);
	        
	        QunTuiDao dao = new QunTuiDao();
	        QunTui quntui = new QunTui();
	       int c = dao.Select(CID);//���ϵĳ���
	       System.out.println(c+"=c");
	       String d = dao.findUserByID1(CID);//�鴦Wineshop_UserName
	       System.out.println(d+"d");
	       if(c==1) {
	    	    String aa = dao.Select1(CID);
	    	    if(aa==null) {
	    	    	
	    	    
	    	    quntui.setWineshop_CID(CID);
	   	        quntui.setQunTui_Title(Title);
	   	        quntui.setQunTui_Text(Text);
	   	        quntui.setQunTui_Adress(Adress);
	   	        dao.update(quntui); 
	    	    }else {
	    	    	quntui.setWineshop_UserName(d);
	  	    	   quntui.setWineshop_CID(CID);
	  	    	   quntui.setQunTui_Title(Title);
	  	    	   quntui.setQunTui_Text(Text);
	  	    	   quntui.setQunTui_Adress(Adress);
	  	    	   dao.add1(quntui);
	    	    }
	       }else {
	    	   
	    	   quntui.setWineshop_UserName(d);
	    	   quntui.setWineshop_CID(CID);
	    	   quntui.setQunTui_Title(Title);
	    	   quntui.setQunTui_Text(Text);
	    	   quntui.setQunTui_Adress(Adress);
	    	   dao.add1(quntui);
	       }
	      
	        
	        return template;
	    } 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
