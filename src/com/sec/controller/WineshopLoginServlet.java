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
                //根据网卡获取本机配置的IP地址
                InetAddress inetAddress = null;
                try {
                    inetAddress = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inetAddress.getHostAddress();
            }
        }
        
        //对于通过多个代理的情况，第一个IP为客户端真实的IP地址，多个IP按照','分割
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
				String userName=request.getParameter("userName");//获取登录名称
				String password = request.getParameter("password");//获取登录密码
				String ip = getIpAddress(request);
				String ip_name = request.getParameter("ip_name");//获取登录设备名称
				Date data = new Date();//创建时间对象
		        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");//设置时间格式
		        SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMdd");//设置时间格式
		        String time = df.format(data);//转换时间
		        String time1 = df1.format(data);//转换时间
		        int n = random();//生成随机数
		        Log log = new Log();//实列化Log
		        String log_Id = n + time1;//得到前面四位数
				WineshopDao dao1 = new WineshopDao();//实列化酒店方法
				Greens_JobberDao dao = new Greens_JobberDao();//实列化菜商方法
				UserDao dao2=new UserDao();//实列化服务方法
				
				CGDao da = new CGDao();
				int lp = da.checkCGs(userName, password);
				int flag = dao1.checkWineshop(userName, password);//酒店验证
				int b = dao.checkGreen_Jobber(userName, password);//菜商验证
				int  w=dao2.checkUser(userName, password);//管理员验证
				HttpSession session = request.getSession();//创建session
				PrintWriter out = response.getWriter();//创建输出流
				LogDao dao3 = new LogDao();//实列化LogDao
					if(lp != 0){
					session.setAttribute("GHS", lp);//flag保存到session
					log.setLog_Id(log_Id);
					log.setLog_Time(time);
					log.setLog_Name(userName);
					log.setLog_Ip(ip);
					log.setLog_Ip_Name(ip_name);
					log.setLog_Type("客户端登录");
					log.setLog_Content("供货商登录");
					dao3.add(log);
					response.sendRedirect("GHSLogin.jsp");//到酒店首页
					
				}else if(flag != 0){//登录到酒店
					session.setAttribute("id", flag);//flag保存到session
					log.setLog_Id(log_Id);
					log.setLog_Time(time);
					log.setLog_Name(userName);
					log.setLog_Ip(ip);
					log.setLog_Ip_Name(ip_name);
					log.setLog_Type("客户端登录");
					log.setLog_Content("酒店登录");
					dao3.add(log);
					response.sendRedirect("./wineshop/jiudianshouye.jsp");//到酒店首页
				}else if(b != 0) {//登录到菜商
					session.setAttribute("id", b);//b保存到session
					log.setLog_Id(log_Id);
					log.setLog_Time(time);
					log.setLog_Name(userName);
					log.setLog_Ip(ip);
					log.setLog_Ip_Name(ip_name);
					log.setLog_Type("客户端登录");
					log.setLog_Content("菜商登录");
					dao3.add(log);
					response.sendRedirect("Greensindex.jsp");//登录到菜商首页
				}else if(w != 0) {//登录到服务中心
						session.setAttribute("w", w);//w保存到session
						MenuDao menu = new MenuDao();
						List<MenuPath> menuPath = menu.getPath(w);
						session.setAttribute("path", menuPath);
						log.setLog_Id(log_Id);
						log.setLog_Time(time);
						log.setLog_Name(userName);
						log.setLog_Ip(ip);
						log.setLog_Ip_Name(ip_name);
						log.setLog_Type("内部登录");
						log.setLog_Content("管理员登录");
						dao3.add(log);
						response.sendRedirect("./admin/adminIndex.jsp");//登录到服务中心首页
				}else{
						out.print("<script langage='javascript'>alert('用户名或密码错误！！');window.location.href='login1.jsp'</script>");
					}
			}

	}
