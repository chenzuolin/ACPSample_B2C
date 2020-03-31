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

import com.sec.dao.GreensDao;
import com.sec.dao.OrderDao;
import com.sec.entity.Greens;
import com.sec.entity.Order;

/**
 * Servlet implementation class SSXXServlet
 */
@WebServlet("/SSXXServlet")
public class SSXXServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SSXXServlet() {
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
		List<SSXX> lists=new ArrayList<SSXX>();
		//��ȡ�������
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println("id="+id);
		//ʵ�������������
		OrderDao dao = new OrderDao();
		//���ݶ�����Ų�ѯ���������
		List<Order> list = dao.findUserByID1(id);	
		System.out.println("list="+list);
		//����list��
		for(int i=0;i<list.size();i++) {
			//�Ӷ���������еõ��߲˱��
			int aa=list.get(i).getGreens_ID();
			System.out.println("aa="+aa);
			int bb=list.get(i).getNumber();
			System.out.println("bb="+bb);
			GreensDao dao2=new GreensDao();
			//ͨ���߲˱�Ų�ѯ�߲˱�
			List<Greens> list2=dao2.findUserByID(aa);
			System.out.println("lsit2="+list2);
			//��������list2
			for(int j=0;j<list2.size();j++) {
				String name=list2.get(j).getGreens_Name();
				float price = list2.get(j).getGreens_Price();
				String unit = list2.get(j).getGreens_Unit();
				System.out.println("name="+name);
				SSXX ssxx=new SSXX();
				ssxx.setTt(name);
				ssxx.setUu(bb);
				ssxx.setPirce(price);
				ssxx.setUnit(unit);
				lists.add(ssxx);
			}
		}
		JSONArray json=JSONArray.fromObject(lists);
		PrintWriter out = response.getWriter();
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
