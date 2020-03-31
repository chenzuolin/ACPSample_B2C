package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.sec.dao.GreensDao;
import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Indent;
import com.sec.entity.JD;
import com.sec.entity.Order;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class JDServlet
 */
@WebServlet("/JDServlet")
public class JDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JDServlet() {
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
		response.setHeader("Access-Control-Allow-Origin", "*");  
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");  
		response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");  
		response.setHeader("X-Powered-By","Jetty");  
		response.setHeader("Access-Control-Allow-Origin", "*");
		IndentDao dao = new IndentDao();	//实例化订单表
		List<JD> lists=new ArrayList<JD>();
		List<Indent> list=dao.findAll();	//查询订单表的所有信息  并返回给list
		System.out.println("list="+list);
		for(int i=0;i<list.size();i++) {	//遍历订单表的所有信息
			Indent indent=list.get(i);		//得到的第i个值 赋值给indent
			if(list.get(i).getIndent_Status().contains("分拣完毕等待快递员接收")) { //查询订单状态为 分拣完毕等待快递员接收 的所有数据
				WineshopDao dao1 = new WineshopDao();		//实例化 酒店表
				List<Wineshop> list6=dao1.findUserByID(list.get(i).getWineshop_ID());  //得到第i个酒店编号 
				for(Wineshop wineshop : list6) {
					String name = wineshop.getWineshop_Name();
					System.out.println("name="+name);
					int id= indent.getIndent_ID();		//从订单表得到订单编号
					String status = indent.getIndent_Status();		//从订单表得到订单状态
							String address=indent.getWineshop_Address();		//得到酒店地址
							String TEL=indent.getWineshop_Telephone();			//得到酒店负责人的
							String Time=indent.getIndent_Time();				//得到下单时间
							JD jd=new JD();
							jd.setAa(id);	//订单编号
							jd.setBb(name);		//酒店名称
							jd.setCc(status);		//订单状态
							jd.setFf(Time);			//下单时间
							jd.setGg(address);	//酒店地址
							jd.setHh(TEL);		//联系电话
							lists.add(jd);
						}
				}
	
				}
		JSONArray json=JSONArray.fromObject(lists);
		System.out.println("lists="+lists);
		PrintWriter out=response.getWriter();
		out.print(json);
		out.close();
		out.flush();


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
