package cpm.sec.JF;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.PointDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Point;

/**
 * Servlet implementation class AS2Servlet
 */
@WebServlet("/AS2Servlet")
public class AS2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AS2Servlet() {
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
		String aa = request.getParameter("username");
		WineshopDao dao = new WineshopDao();
		int bb = dao.findUserByID2(aa);
		PointDao daos = new PointDao();
		List<Point> list = daos.findNumber(bb);
		for(Point p : list){
			int cc = p.getPoint_num();
			PrintWriter out = response.getWriter();
			out.print(cc);
			out.flush();
			out.close();
		}
	}

}
