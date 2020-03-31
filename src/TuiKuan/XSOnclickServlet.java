package TuiKuan;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.sizeDao;
import com.sec.entity.TimeIndent;

/**
 * Servlet implementation class XSOnclickServlet
 */
@WebServlet("/XSOnclickServlet")
public class XSOnclickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XSOnclickServlet() {
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
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		int Indent_ID = Integer.parseInt(request.getParameter("Indent_ID"));
		float Indent_TKprice = Float.parseFloat(request.getParameter("Indent_TKprice"));
		sizeDao dao = new sizeDao();
		TimeIndent t = new TimeIndent();
		t.setRefund_Status("正在审核");
		t.setRefund_Time(df.format(new Date()));
		t.setIndent_TKprice(Indent_TKprice);
		t.setIndent_ID(Indent_ID);
		dao.update3(t);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
