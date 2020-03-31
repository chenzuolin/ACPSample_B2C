package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gexin.fastjson.JSON;
import com.sec.dao.IndentDao;
import com.sumeng.page.Page;

/**
 * Servlet implementation class TimeIndentServlet1
 */
@WebServlet("/TimeIndentServlet1")
public class TimeIndentServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeIndentServlet1() {
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
		String Wineshop_Name =request.getParameter("Wineshop_Name");
		String Time1 = request.getParameter("Time1");
		String Time2 = request.getParameter("Time2");
//		String currentPage = "1";
//		
//		int size = 5;
//		String Wineshop_Name = "666";
//		String Time1 = "2019-05-04";
//		String Time2 = "2019-05-07";
		int currPage=1;
		if(currentPage!=null) {
			currPage = Integer.parseInt(currentPage);
			
		}
		IndentDao dao = new IndentDao();
		Page p = dao.getSum2(currPage, size,Wineshop_Name,Time1,Time2);
		System.out.println(p.toString());
		Page page = dao.getSun2(currPage, p, size,Wineshop_Name,Time1,Time2);
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
