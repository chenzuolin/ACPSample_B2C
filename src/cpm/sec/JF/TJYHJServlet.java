package cpm.sec.JF;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.CouponDao;
import com.sec.entity.Coupon;

/**
 * Servlet implementation class TJYHJServlet
 */
@WebServlet("/TJYHJServlet")
public class TJYHJServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TJYHJServlet() {
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
		int aa = Integer.parseInt(request.getParameter("Point"));
		int bb = Integer.parseInt(request.getParameter("num"));
		CouponDao dao = new CouponDao();
		Coupon c = new Coupon();
		c.setCoupon_Point(aa);
		c.setCoupon_num(bb);
		c.setCoupon_Type("优惠券");
		dao.add(c);
		PrintWriter out = response.getWriter();
		out.print("<script langage='javascript'>alert('添加成功！！');window.location.href='TJYHJ.jsp'</script>");
	}

}
