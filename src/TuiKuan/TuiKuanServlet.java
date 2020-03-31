package TuiKuan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.IndentDao;
import com.sec.entity.Indent;
import com.sec.entity.TimeIndent;

/**
 * Servlet implementation class TuiKuanServlet
 */
@WebServlet("/TuiKuanServlet")
public class TuiKuanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TuiKuanServlet() {
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
		
		int Indent_ID = Integer.parseInt(request.getParameter("Indent_ID"));//用户发起退款原因
		
		String Indent_Why = request.getParameter("Indent_Why");
		
		IndentDao dao = new IndentDao();
		TimeIndent o = new TimeIndent();
		o.setIndent_Why(Indent_Why);
		o.setRefund_Status("申请退款");
		o.setIndent_ID(Indent_ID);
		
		dao.update55(o);
		
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
