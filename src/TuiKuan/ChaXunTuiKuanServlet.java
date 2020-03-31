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

/**
 * Servlet implementation class ChaXunTuiKuanServlet
 */
@WebServlet("/ChaXunTuiKuanServlet")
public class ChaXunTuiKuanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChaXunTuiKuanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charset=utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		IndentDao dao = new IndentDao();
		Indent indent = new Indent();
		indent.setIndent_TuiKuan("已确认退款完毕");
		indent.setIndent_ID(id);
		dao.update88(indent);
		PrintWriter out = response.getWriter();
		out.print("<script language='javascript'>alert('已确认退款完毕')      ;window.location.href='./admin/caiwu/ChaKanTuiKuan.jsp'</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
