package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.CGDao;
import com.sec.dao.FZDao;
import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.entity.CG;
import com.sec.entity.FZ;
import com.sec.entity.Indent;
import com.sec.entity.Order;

/**
 * Servlet implementation class KK43Servlet
 */
@WebServlet("/KK43Servlet")
public class KK43Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KK43Servlet() {
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
		int yy = Integer.parseInt(request.getParameter("id"));
		String bb = request.getParameter("name");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(yy);
		CGDao dao8 = new CGDao();
		String aa = null;
		List<CG> lists1 = dao8.findUserByID(bb);
		for(CG cg : lists1){
			aa = cg.getCG_Name();
		}
		IndentDao dao = new IndentDao();
		OrderDao dao1 = new OrderDao();
		Indent indent = new Indent();
		Order order = new Order();
		indent.setIndent_Status("分拣完毕等待快递员接收");
		indent.setIndent_ID(yy);
		dao.update1(indent);
		Indent indent1 = new Indent();
		indent1.setIndent_Check_Type("0");
		indent1.setIndent_ID(yy);
		dao.update2(indent);
		order.setIndent_Status("分拣完毕等待快递员接收");
		order.setIndent_ID(yy);
		dao1.update1(order);
		FZDao dao7 = new FZDao();
		FZ fz = new FZ();
		fz.setFJ_Name(aa);
		fz.setIndent_ID(yy);
		dao7.updateFJ(fz);
		fz.setFJ_Time(df.format(new Date()));
		fz.setIndent_ID(yy);
		dao7.updateFJTIME(fz);
		int a = 1;
		PrintWriter out = response.getWriter();
		out.print(a);
		out.flush();
		out.close();
	}

}
