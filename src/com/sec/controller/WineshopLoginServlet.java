package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sec.dao.CGDao;
import com.sec.dao.Greens_JobberDao;
import com.sec.dao.LogDao;
import com.sec.dao.UserDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Log;
import com.sumeng.service.MenuPath;
import com.sumeng.web.MenuDao;


@WebServlet("/WineshopLoginServlet")
public class WineshopLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WineshopLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	 public static int random() {
	        Random random = new Random(System.currentTimeMillis());
	        int number = 0;
	        boolean ok = true;
	        do {
	            ok = true;
	            number = random.nextInt(9000) + 1000;
	            int[] digits = {
	                number / 1000 % 10,
	                number / 100 % 10,
	                number / 10 % 10,
	                number % 10
	            };
	            for (int i = 0; i < 4 && ok; i++) {
	                for (int j = i + 1; j < 4; j++) {
	                    if (digits[i] == digits[j]) {
	                        ok = false;
	                        break;
	                    }
	                }
	            }
	             
	        } while (!ok);
	 
	        return number;
	    }
	 public static String getIpAddress(HttpServletRequest request){
         
         String ipAddress = request.getHeader("x-forwarded-for");
         
         if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
             ipAddress = request.getHeader("Proxy-Client-IP");
         }
         if (ipAddress == null || ipAddress.length() == 0 || "unknow".equalsIgnoreCase(ipAddress)) {
             ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            
            if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
                //����������ȡ�������õ�IP��ַ
                InetAddress inetAddress = null;
                try {
                    inetAddress = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inetAddress.getHostAddress();
            }
        }
        
        //����ͨ�����������������һ��IPΪ�ͻ�����ʵ��IP��ַ�����IP����','�ָ�
        if(null != ipAddress && ipAddress.length() > 15){
            //"***.***.***.***".length() = 15
            if(ipAddress.indexOf(",") > 0){
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        
        return ipAddress;
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				String userName=request.getParameter("userName");//��ȡ��¼����
				String password = request.getParameter("password");//��ȡ��¼����
				String ip = getIpAddress(request);
				String ip_name = request.getParameter("ip_name");//��ȡ��¼�豸����
				Date data = new Date();//����ʱ�����
		        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");//����ʱ���ʽ
		        SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMdd");//����ʱ���ʽ
		        String time = df.format(data);//ת��ʱ��
		        String time1 = df1.format(data);//ת��ʱ��
		        int n = random();//���������
		        Log log = new Log();//ʵ�л�Log
		        String log_Id = n + time1;//�õ�ǰ����λ��
				WineshopDao dao1 = new WineshopDao();//ʵ�л��Ƶ귽��
				Greens_JobberDao dao = new Greens_JobberDao();//ʵ�л����̷���
				UserDao dao2=new UserDao();//ʵ�л����񷽷�
				
				CGDao da = new CGDao();
				int lp = da.checkCGs(userName, password);
				int flag = dao1.checkWineshop(userName, password);//�Ƶ���֤
				int b = dao.checkGreen_Jobber(userName, password);//������֤
				int  w=dao2.checkUser(userName, password);//����Ա��֤
				HttpSession session = request.getSession();//����session
				PrintWriter out = response.getWriter();//���������
				LogDao dao3 = new LogDao();//ʵ�л�LogDao
					if(lp != 0){
					session.setAttribute("GHS", lp);//flag���浽session
					log.setLog_Id(log_Id);
					log.setLog_Time(time);
					log.setLog_Name(userName);
					log.setLog_Ip(ip);
					log.setLog_Ip_Name(ip_name);
					log.setLog_Type("�ͻ��˵�¼");
					log.setLog_Content("�����̵�¼");
					dao3.add(log);
					response.sendRedirect("GHSLogin.jsp");//���Ƶ���ҳ
					
				}else if(flag != 0){//��¼���Ƶ�
					session.setAttribute("id", flag);//flag���浽session
					log.setLog_Id(log_Id);
					log.setLog_Time(time);
					log.setLog_Name(userName);
					log.setLog_Ip(ip);
					log.setLog_Ip_Name(ip_name);
					log.setLog_Type("�ͻ��˵�¼");
					log.setLog_Content("�Ƶ��¼");
					dao3.add(log);
					response.sendRedirect("./wineshop/jiudianshouye.jsp");//���Ƶ���ҳ
				}else if(b != 0) {//��¼������
					session.setAttribute("id", b);//b���浽session
					log.setLog_Id(log_Id);
					log.setLog_Time(time);
					log.setLog_Name(userName);
					log.setLog_Ip(ip);
					log.setLog_Ip_Name(ip_name);
					log.setLog_Type("�ͻ��˵�¼");
					log.setLog_Content("���̵�¼");
					dao3.add(log);
					response.sendRedirect("Greensindex.jsp");//��¼��������ҳ
				}else if(w != 0) {//��¼����������
						session.setAttribute("w", w);//w���浽session
						MenuDao menu = new MenuDao();
						List<MenuPath> menuPath = menu.getPath(w);
						session.setAttribute("path", menuPath);
						log.setLog_Id(log_Id);
						log.setLog_Time(time);
						log.setLog_Name(userName);
						log.setLog_Ip(ip);
						log.setLog_Ip_Name(ip_name);
						log.setLog_Type("�ڲ���¼");
						log.setLog_Content("����Ա��¼");
						dao3.add(log);
						response.sendRedirect("./admin/adminIndex.jsp");//��¼������������ҳ
				}else{
						out.print("<script langage='javascript'>alert('�û�����������󣡣�');window.location.href='login1.jsp'</script>");
					}
			}

	}
