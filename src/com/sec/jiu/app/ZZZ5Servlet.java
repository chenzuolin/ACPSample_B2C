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

import net.sf.json.JSONArray;

import com.sec.dao.FJDao;
import com.sec.dao.FZDao;
import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.entity.FJ;
import com.sec.entity.FZ;
import com.sec.entity.Indent;
import com.sec.entity.Order;
import com.sumeng.kuai.object.Fenjianwanbi;

/**
 * Servlet implementation class ZZZ5Servlet
 */
@WebServlet("/ZZZ5Servlet")
public class ZZZ5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZZZ5Servlet() {
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
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		String aa = request.getParameter("name");
		IndentDao dao = new IndentDao();
		List<Fenjianwanbi> list = dao.indentStatuss3(aa, 1);
		JSONArray json = JSONArray.fromObject(list);
		PrintWriter out = response.getWriter();
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
