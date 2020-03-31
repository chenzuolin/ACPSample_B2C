package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gexin.fastjson.JSON;
import com.sec.dao.XiaoJiDao;
import com.sumeng.page.Page;

/**
 * Servlet implementation class GreensNumberServlet1
 */
@WebServlet("/GreensNumberServlet1")
public class GreensNumberServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GreensNumberServlet1() {
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
		String Time1=request.getParameter("Time1");
		String Time2 = request.getParameter("Time2");
		String Greens_Name= request.getParameter("Greens_Name");
		String Greens_Type_Name = request.getParameter("Greens_Type_Name");
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
		XiaoJiDao dao = new XiaoJiDao();
		Page p = dao.getSum8(currPage, size,Time1,Time2,Greens_Name,Greens_Type_Name);
		System.out.println(p.toString());
		Page page = dao.getSun8(currPage, p, size,Time1,Time2,Greens_Name,Greens_Type_Name);
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
