package cpm.sec.JF;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.CouponDao;
import com.sec.dao.PointDao;
import com.sec.dao.RedDao;
import com.sec.dao.ShopDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Coupon;
import com.sec.entity.Point;
import com.sec.entity.Red;
import com.sec.entity.Shop;

/**
 * Servlet implementation class AS3Servlet
 */
@WebServlet("/AS3Servlet")
public class AS3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AS3Servlet() {
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
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String aa = request.getParameter("name");
		int bb = Integer.parseInt(request.getParameter("aa"));
		int dd = Integer.parseInt(request.getParameter("bb"));
		WineshopDao dao = new WineshopDao();
		int cc = dao.findUserByID2(aa);
		PointDao da = new PointDao();
		List<Point> list = da.findNumber(cc);
		int ee = 0;
		for(Point p : list){
			ee = p.getPoint_num();
		}
		if(ee>=dd){
		int ff = ee-dd;
		Point pp = new Point();
		pp.setPoint_num(ff);
		pp.setWineshop_ID(cc);
		da.update(pp);
		CouponDao daod = new CouponDao();
		List<Coupon> lis = daod.findNumber(bb);
		int fd = 0;
		for(Coupon c : lis){
			
			if(c.getCoupon_Type().contains("优惠券")){
			fd = c.getCoupon_num();
		RedDao daos = new RedDao();
		Red r = new Red();
		r.setWineshop_ID(cc);
		r.setCoupon_ID(bb);
		r.setRed_Type("优惠券");
		r.setCoupon_Num(fd);
		r.setGive_Money(0);
		daos.add(r);
		PrintWriter out = response.getWriter();
		out.print(1);
		out.flush();
		out.close();
			}else{
				String lo = c.getCoupon_Mode();
				ShopDao das = new ShopDao();
				Shop s = new Shop();
				s.setShop_Name(lo);
				s.setWineshop_ID(cc);
				s.setShop_Time(df.format(new Date()));
				s.setShop_Status("未配送");
				das.add(s);
				PrintWriter out = response.getWriter();
				out.print(2);
				out.flush();
				out.close();
			}
		}
		
		}else{
			PrintWriter out = response.getWriter();
			out.print(0);
			out.flush();
			out.close();
		}
	}

}
