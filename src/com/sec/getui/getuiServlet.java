package com.sec.getui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.style.Style0;
import com.sec.dao.GeTuiDao;
import com.sec.entity.GeTui;

/**
 * Servlet implementation class getuiServlet
 */
@WebServlet("/getuiServlet")
public class getuiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private static final String path = "D:\\新项目\\ACPSample_B2C\\WebContent\\dist\\20180531111630_99068.jpg";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getuiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		 String appId = "cw0SK1P5l1AZjYuS0QnVa8";
	     String appKey = "6twIx84uVu92cK7PU2Hj36";
	     String masterSecret = "41B6Ad8oDy5BslFyOxT9g7";
	     String url = "http://sdk.open.api.igexin.com/apiex.htm";
	     String Title = request.getParameter("GeTuiTitle");
	     String Text = request.getParameter("GeTuiText");
	     String Adress = request.getParameter("GeTuiAdress");
	     
	     GeTuiDao dao = new GeTuiDao();
	        GeTui getui = new GeTui();
	        getui.setGeTui_Title(Title);
	        getui.setGeTui_Text(Text);
	        getui.setGeTui_Adress(Adress);
	        dao.add(getui);
	     System.out.println(Title);
	     System.out.println(Text);
	     System.out.println(Adress);

	     IGtPush push = new IGtPush(url, appKey, masterSecret);
	       
	        // 定义"点击链接打开通知模板"，并设置标题、内容、链接
	        LinkTemplate template = new LinkTemplate();
	        template.setAppId(appId);     
	        template.setAppkey(appKey);
	        template.setTitle(Title);
	        template.setText(Text);
	        template.setUrl(Adress);
	        template.setLogo(path);
	        
	        List<String> appIds = new ArrayList<String>();
	        appIds.add(appId);
	        	
	        // 定义"AppMessage"类型消息对象，设置消息内容模板、发送的目标App列表、是否支持离线发送、以及离线消息有效期(单位毫秒)
	        AppMessage message = new AppMessage();
	        message.setData(template);
	        message.setAppIdList(appIds);
	        message.setOffline(true);
	        message.setOfflineExpireTime(1000 * 600);
	        
	        IPushResult ret = push.pushMessageToApp(message);
	        PrintWriter out = response.getWriter();
			out.print("<script language='javascript'>alert('推送成功');window.location.href='getui.jsp'</script>");
	        System.out.println(ret.getResponse().toString());
	}

}
