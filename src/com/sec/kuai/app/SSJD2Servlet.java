package com.sec.kuai.app;

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

import com.sec.dao.WineshopDao;
import com.sec.entity.SSJD2;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class SSJD2Servlet
 */
@WebServlet("/SSJD2Servlet")
public class SSJD2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SSJD2Servlet() {
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
		int ID = Integer.parseInt(request.getParameter("id"));
		List<SSJD2> lists = new ArrayList<SSJD2>();
		WineshopDao dao1 = new WineshopDao();
		List<Wineshop> list1 = dao1.findUserByID(ID);
		System.out.println("list1="+list1);
		for(Wineshop wineshop : list1) {
			String name = wineshop.getWineshop_Name();
			System.out.println("name="+name);
			String address = wineshop.getWineshop_Address();
			System.out.println("address="+address);
			String fz = wineshop.getWineshop_Shift_Name();
			System.out.println("fz="+fz);
			String tel = wineshop.getWineshop_Telephone();
			System.out.println("tel="+tel);
			String xingzhi = wineshop.getWineshop_Nature();
			System.out.println("xingzhi="+xingzhi);
			String QQ = wineshop.getWineshop_QQ();
			System.out.println("QQ="+QQ);
			String WX = wineshop.getWineshop_WeChat();
			System.out.println("WX="+WX);
			String number = wineshop.getWineshop_Number();
			System.out.println("number="+number);
			SSJD2 cc = new SSJD2();
			cc.setName(name);
			cc.setAddress(address);
			cc.setFz(fz);
			cc.setTel(tel);
			cc.setXingzhi(xingzhi);
			cc.setQQ(QQ);
			cc.setWX(WX);
			cc.setNumber(number);
			lists.add(cc);
		}
		JSONArray json=JSONArray.fromObject(lists);
		PrintWriter out=response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
