package cn.itsource.pay.servlet;

import io.goeasy.GoEasy;
import io.goeasy.publish.GoEasyError;
import io.goeasy.publish.PublishListener;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.GTDao;
import com.sec.entity.GT;

/**
 * Servlet implementation class PublishMessageInGoEasy
 */
@WebServlet("/PublishMessageInGoEasy")
public class PublishMessageInGoEasy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishMessageInGoEasy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String a = request.getParameter("xiaoxi");
		int b = (Integer)request.getSession().getAttribute("w");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		GTDao dao = new GTDao();
		GT gt = new GT();
		gt.setGT_Name(a);
		gt.setAdmin(b);
		gt.setTime(df.format(new Date()));
		dao.add(gt);
		GoEasy easyObj = new GoEasy("rest-hangzhou.goeasy.io","BC-8a96434d730f45de9a73cdfe101b398f");
		easyObj.publish("GoEasy",a,new PublishListener(){
		@Override
		public void onFailed(GoEasyError error){
			System.out.println("推送失败了,Error code:"+error.getCode()+"error content:" + error.getContent());
		}
		@Override
		public void onSuccess(){
			System.out.println("消息推送成功");
				
		}
		
		});
		PrintWriter out = response.getWriter();
		out.print("<script language='javascript'>alert('消息推送成功!!');window.location.href='XXTS.jsp'</script>");
	}

}
