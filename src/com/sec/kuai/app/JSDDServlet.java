package com.sec.kuai.app;

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

import com.sec.dao.CourierDao;
import com.sec.dao.FZDao;
import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.dao.WCDao;
import com.sec.entity.Courier;
import com.sec.entity.FZ;
import com.sec.entity.Indent;
import com.sec.entity.Order;
import com.sec.entity.WC;

/**
 * Servlet implementation class JSDDServlet
 */
@WebServlet("/JSDDServlet")
public class JSDDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSDDServlet() {
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
		String name = request.getParameter("username");//�õ���½����
		System.out.println("usrname="+name);
		int id=Integer.parseInt(request.getParameter("id"));	//�õ��������
		System.out.println("id="+id);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		IndentDao dao1=new IndentDao();		//ʵ����������Dao
		OrderDao dao2 = new OrderDao();		//ʵ����������ϸDao
		Indent indent = new Indent();		//ʵ����������
		Order order = new Order();			//ʵ����������ϸ��
		indent.setIndent_Status("������");	//���������еĶ���״̬��Ϊ ������
		indent.setIndent_ID(id);			//���¶������
		dao1.update1(indent);				//���¶�����
		Indent indent1 = new Indent();
		indent1.setIndent_Check_Type("0");
		indent1.setIndent_ID(id);
		dao1.update2(indent1);
		order.setIndent_Status("������");		//���µ㵥������еĶ���״̬
		order.setOrder_ID(id);				//���¶���������еĶ������
		dao2.update1(order);				//���¶��������
		FZDao dao7 = new FZDao();
		FZ fz = new FZ();
		fz.setCourier_Name(name);
		fz.setIndent_ID(id);
		dao7.updateCourier(fz);
		fz.setPS_Time(df.format(new Date()));
		fz.setIndent_ID(id);
		dao7.updatePSTIME(fz);
		CourierDao aa = new CourierDao();
		List<Courier> list =aa.findUserByID3(name);
		for(Courier courier : list) {
			int Courier_ID=courier.getCourier_ID();
			System.out.println("Courier_ID="+Courier_ID);
			WC wc = new WC();
			wc.setCourier_ID(Courier_ID);
			wc.setIndent_ID(id);
			WCDao bb = new WCDao();
			bb.add(wc);
		}
		
		JSONArray json=JSONArray.fromObject(1);
		PrintWriter out=response.getWriter();
		out.println(json);
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
