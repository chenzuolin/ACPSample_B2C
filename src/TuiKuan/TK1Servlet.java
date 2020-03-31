package TuiKuan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.IndentDao;
import com.sec.dao.TKDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Indent;
import com.sec.entity.TK;
import com.sec.entity.TimeIndent;

/**
 * Servlet implementation class TK1Servlet
 */
@WebServlet("/TK1Servlet")
public class TK1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TK1Servlet() {
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
		String Indent_Why = request.getParameter("Indent_Why");
		int Indent_ID = Integer.parseInt(request.getParameter("Indent_ID"));
		String username = request.getParameter("username");
		String Greens_Name = request.getParameter("Greens_Name");
		int Greens_Number = Integer.parseInt(request.getParameter("Greens_Number"));
		String Greens_Price = request.getParameter("Greens_Price");
		String TK_Type = request.getParameter("TK_Type");
		WineshopDao dao1 = new WineshopDao();
		int Wineshop_ID = dao1.findUserByID2(username);
		
		IndentDao dao = new IndentDao();
		String a = null;
		List<Indent> list = dao.findUserByID(Indent_ID);
		for(Indent indent : list) {
			a = indent.getIndent_Why();
			
		}
		String b = null;
		b=a+Indent_Why;
		
		IndentDao dao11 = new IndentDao();
		TimeIndent o = new TimeIndent();
		o.setIndent_Why(b);
		o.setRefund_Status("ÉêÇëÍË¿î");
		o.setIndent_ID(Indent_ID);
		
		dao11.update55(o);
		
		
		
		
		
		
		
		TKDao dao111 = new TKDao();
		TK t = new TK();
		t.setIndent_ID(Indent_ID);
		t.setWineshop_ID(Wineshop_ID);
		t.setGreens_Name(Greens_Name);
		t.setGreens_Number(Greens_Number);
		t.setGreens_Price(Greens_Price);
		t.setTK_Type(TK_Type);
		dao111.add(t);
		PrintWriter out = response.getWriter();
		out.print(1);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
