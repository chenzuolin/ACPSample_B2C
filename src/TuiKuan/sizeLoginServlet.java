package TuiKuan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.sizeDao;

/**
 * Servlet implementation class sizeLoginServlet
 */
@WebServlet("/sizeLoginServlet")
public class sizeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sizeLoginServlet() {
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
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		String size_Name = request.getParameter("userName");
		String size_Password = request.getParameter("password");
		
		sizeDao dao = new sizeDao();
		int a =  dao.checkWineshop(size_Name, size_Password);
		System.out.println(a+"aa");
		if(a==0) {
			PrintWriter out = response.getWriter();
			out.print(0);
			out.flush();
			out.close();
		}else {
			switch (a) {
			case 1:
				PrintWriter out = response.getWriter();
				out.print(1);
				out.flush();
				out.close();
				break;
			case 2:
				PrintWriter out1 = response.getWriter();
				out1.print(2);
				out1.flush();
				out1.close();
				break;
			case 3:
				PrintWriter out11 = response.getWriter();
				out11.print(3);
				out11.flush();
				out11.close();
				break;
			case 4:
				PrintWriter out111 = response.getWriter();
				out111.print(4);
				out111.flush();
				out111.close();
				break;
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
