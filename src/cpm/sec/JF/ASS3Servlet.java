package cpm.sec.JF;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.GiveDao;
import com.sec.dao.RedDao;
import com.sec.entity.Give;
import com.sec.entity.Red;

/**
 * Servlet implementation class ASS3Servlet
 */
@WebServlet("/ASS3Servlet")
public class ASS3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ASS3Servlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html,UTF-8");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		int aa = Integer.parseInt(request.getParameter("Wineshop_ID"));
		int bb = Integer.parseInt(request.getParameter("Give_Money"));
		int cc = Integer.parseInt(request.getParameter("Give_Num"));
		String dd = request.getParameter("Give_Time");
		String ff = request.getParameter("Give_FZ");
		RedDao dao = new RedDao();
		Red a = new Red();
		a.setWineshop_ID(aa);
		a.setRed_Type("赠送券");
		a.setGive_Time(dd);
		a.setGive_Money(bb);
		a.setGive_Num(cc);
		a.setGive_Shijian(df.format(new Date()));
		a.setGive_FZ(ff);
		dao.adds(a);
		GiveDao daos = new GiveDao();
		Give g = new Give();
		g.setWineshop_ID(aa);
		g.setGive_Time(dd);
		g.setGive_Money(bb);
		g.setGive_Num(cc);
		g.setGive_Shijian(df.format(new Date()));
		g.setGive_FZ(ff);
		daos.add(g);
		request.getRequestDispatcher("ZS.jsp").forward(request, response);
		
	}

}
