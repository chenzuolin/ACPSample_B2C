package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.IndentDao;
import com.sec.dao.WineshopDao;
import com.sec.dao.XianZhiDao;
import com.sec.entity.XianZhi;

/**
 * Servlet implementation class LLL10Servlet
 */
@WebServlet("/LLL10Servlet")
public class LLL10Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LLL10Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		String aa = request.getParameter("name");//酒店登录名
		float zz = Float.parseFloat(request.getParameter("total"));
		WineshopDao dao = new WineshopDao();
		int bb = dao.findUserByID2(aa);//酒店ID
		IndentDao daos = new IndentDao();
		int cc = daos.ZZ(bb);//该酒店的订单数量
		if(cc==0){//首次下单
			PrintWriter out = response.getWriter();
			out.print(0);
			out.flush();
			out.close();
		}else{
			 SimpleDateFormat df = new SimpleDateFormat("HH:mm");//设置日期格式
	         String aaa = df.format(new Date());
	         XianZhiDao dao1 = new XianZhiDao();
	         List<XianZhi> list = dao1.findAll();
	         for(XianZhi xx : list){
	        	 String bbb = xx.getNoTime();
	        	 String ccc = xx.getNoTime1();
	        	 float ddd = xx.getPrice_Money();
	        	 try {
					boolean ee = isEffectiveDate(df.parse(aaa), df.parse(bbb), df.parse(ccc));
					if(ee==false){
						if(ddd<zz){
							PrintWriter out = response.getWriter();
							out.print(3);
							out.flush();
							out.close();
						}else{
							PrintWriter out = response.getWriter();
							out.print(2);
							out.flush();
							out.close();
						}
					}else{
						PrintWriter out = response.getWriter();
						out.print(1);
						out.flush();
						out.close();
					}
				} catch (ParseException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
	         }
		}
	}
	
	 public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
	        if (nowTime.getTime() == startTime.getTime()
	                || nowTime.getTime() == endTime.getTime()) {
	            return true;
	        }

	        Calendar date = Calendar.getInstance();
	        date.setTime(nowTime);

	        Calendar begin = Calendar.getInstance();
	        begin.setTime(startTime);

	        Calendar end = Calendar.getInstance();
	        end.setTime(endTime);

	        if (date.after(begin) && date.before(end)) {
	            return true;
	        } else {
	            return false;
	        }
	    }

}
