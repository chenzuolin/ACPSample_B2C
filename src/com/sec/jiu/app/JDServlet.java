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
		IndentDao dao = new IndentDao();	//ʵ����������
		List<JD> lists=new ArrayList<JD>();
		List<Indent> list=dao.findAll();	//��ѯ�������������Ϣ  �����ظ�list
		System.out.println("list="+list);
		for(int i=0;i<list.size();i++) {	//�����������������Ϣ
			Indent indent=list.get(i);		//�õ��ĵ�i��ֵ ��ֵ��indent
			if(list.get(i).getIndent_Status().contains("�ּ���ϵȴ����Ա����")) { //��ѯ����״̬Ϊ �ּ���ϵȴ����Ա���� ����������
				WineshopDao dao1 = new WineshopDao();		//ʵ���� �Ƶ��
				List<Wineshop> list6=dao1.findUserByID(list.get(i).getWineshop_ID());  //�õ���i���Ƶ��� 
				for(Wineshop wineshop : list6) {
					String name = wineshop.getWineshop_Name();
					System.out.println("name="+name);
					int id= indent.getIndent_ID();		//�Ӷ�����õ��������
					String status = indent.getIndent_Status();		//�Ӷ�����õ�����״̬
							String address=indent.getWineshop_Address();		//�õ��Ƶ��ַ
							String TEL=indent.getWineshop_Telephone();			//�õ��Ƶ긺���˵�
							String Time=indent.getIndent_Time();				//�õ��µ�ʱ��
							JD jd=new JD();
							jd.setAa(id);	//�������
							jd.setBb(name);		//�Ƶ�����
							jd.setCc(status);		//����״̬
							jd.setFf(Time);			//�µ�ʱ��
							jd.setGg(address);	//�Ƶ��ַ
							jd.setHh(TEL);		//��ϵ�绰
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
