package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gexin.fastjson.JSON;
import com.sec.dao.WineshopDao;
import com.sumeng.page.fenye;

/**
 * Servlet implementation class ShouHuoServlet
 */
@WebServlet("/ShouHuoServlet")
public class ShouHuoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShouHuoServlet() {
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
		String currentPage = request.getParameter("currentPage");
		int size = Integer.parseInt(request.getParameter("size"));

		int currPage=1;
		if(currentPage!=null) {
			currPage = Integer.parseInt(currentPage);
			
		}
		WineshopDao dao = new WineshopDao();
		fenye p = dao.getSum2(currPage, size);
		System.out.println(p.toString());
		fenye page = dao.getSun2(currPage, p, size);
		System.out.println(page.toString());
		Object json = JSON.toJSON(page);
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
		doGet(request, response);
	}

}
