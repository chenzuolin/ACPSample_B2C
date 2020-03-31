package com.sec.TouSu;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.TouSuDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.TouSu;

/**
 * Servlet implementation class JiuDianTouSuServlet
 */
@WebServlet("/JiuDianTouSuServlet")
public class JiuDianTouSuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JiuDianTouSuServlet() {
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
		Date data = new Date();//创建时间对象
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");//设置时间格式
        String time = df.format(data);//转换时间
		String Wineshop_UserName = request.getParameter("Wineshop_UserName");
		String TouSu_Type = request.getParameter("TouSu_Type");
		String TouSu_Text = request.getParameter("TouSu_Text");
		WineshopDao dao = new WineshopDao();
		int Wineshop_ID = dao.findUserByID2(Wineshop_UserName);
		TouSu tousu = new TouSu();
		TouSuDao dao1 = new TouSuDao();
		tousu.setWineshop_ID(Wineshop_ID);
		tousu.setTouSu_Type(TouSu_Type);
		tousu.setTouSu_Text(TouSu_Text);
		tousu.setTouSu_Time(time);
		dao1.add(tousu);
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
