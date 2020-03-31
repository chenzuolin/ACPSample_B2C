package TuiKuan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.sizeDao;
import com.sec.entity.TimeIndent;

/**
 * Servlet implementation class LaoZhaoOnclickServlet
 */
@WebServlet("/LaoZhaoOnclickServlet")
public class LaoZhaoOnclickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LaoZhaoOnclickServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		int Indent_ID = Integer.parseInt(request.getParameter("Indent_ID"));
		sizeDao dao = new sizeDao();
		TimeIndent t = new TimeIndent();
		t.setRefund_Status("…Û∫ÀÕÍ±œ");
		t.setIndent_ID(Indent_ID);
		dao.update2(t);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
