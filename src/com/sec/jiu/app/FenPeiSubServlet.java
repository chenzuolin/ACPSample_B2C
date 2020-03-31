package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.FZDao;
import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.entity.FZ;
import com.sec.entity.Indent;
import com.sec.entity.Order;

/**
 * Servlet implementation class FenPeiSubServlet
 */
@WebServlet("/FenPeiSubServlet")
public class FenPeiSubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FenPeiSubServlet() {
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
		
		int a = Integer.parseInt(request.getParameter("id"));//�������Ķ������
		String b = request.getParameter("FenPei_UserName");//�������ĵ���ջ��˵�����
		
		
		
		Date data = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
		String FenPei_Time = df.format(data);//�����ʱ��
		IndentDao dao = new IndentDao();
		OrderDao dao1 = new OrderDao();
		Indent indent = new Indent();
		Order order = new Order();
		indent.setIndent_Status("�����");
		indent.setIndent_ID(a);
		dao.update1(indent);
		Indent indent1 = new Indent();
		indent1.setIndent_Check_Type("0");
		indent1.setIndent_ID(a);
		dao.update2(indent1);
		order.setIndent_Status("�����");
		order.setIndent_ID(a);
		dao1.update1(order);
		
		
		
		FZDao dao3 = new FZDao();//���¾Ƶ��ջ�Ա�ĵ���ջ�����Ϣ��FZ_table
		FZ fz = new FZ();
		fz.setFenPei_UserName(b);
		fz.setFenPei_Time(FenPei_Time);
		fz.setIndent_ID(a);
		dao3.update100(fz);
		
		PrintWriter out = response.getWriter();
		out.print(1);
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
