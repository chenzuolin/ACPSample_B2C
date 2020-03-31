package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.sec.dao.XianZhiDao;
import com.sec.entity.AAA1;
import com.sec.entity.XianZhi;

/**
 * Servlet implementation class AAA1Servlet
 */
@WebServlet("/AAA1Servlet")
public class AAA1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AAA1Servlet() {
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
		List<AAA1> lists = new ArrayList<AAA1>();
		 SimpleDateFormat df = new SimpleDateFormat("HH:mm");//设置日期格式
         String aa = df.format(new Date());
         XianZhiDao dao = new XianZhiDao();
         List<XianZhi> list = dao.findAll();
         for(XianZhi xx : list){
        	 String bb = xx.getTime_Star();
        	 String cc = xx.getTime_End();
        	 String dd = xx.getTimeOne();
        	 String ff = xx.getTimeTwo();
        	 String gg = xx.getNoTime();
        	 String hh = xx.getNoTime1();
        	 try {
				boolean ee = isEffectiveDate(df.parse(aa), df.parse(dd), df.parse(ff));
				if(ee==true){
					AAA1 as = new AAA1();
					as.setAa(1);
					as.setBb(dd);
					as.setCc(ff);
					lists.add(as);
					JSONArray json = JSONArray.fromObject(lists);
					PrintWriter out = response.getWriter();
					out.print(json);
					out.flush();
					out.close();
				}else{
				boolean zz = isEffectiveDate(df.parse(aa), df.parse(gg), df.parse(hh));
				if(zz==true){
					AAA1 as = new AAA1();
					as.setAa(2);
					as.setBb(bb);
					as.setCc(cc);
					lists.add(as);
					JSONArray json = JSONArray.fromObject(lists);
					PrintWriter out = response.getWriter();
					out.print(json);
					out.flush();
					out.close();
				}else{
					AAA1 as = new AAA1();
					as.setAa(3);
					as.setBb(bb);
					as.setCc(cc);
					lists.add(as);
					JSONArray json = JSONArray.fromObject(lists);
					PrintWriter out = response.getWriter();
					out.print(json);
					out.flush();
					out.close();
				}
				}
				
			} catch (ParseException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
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
