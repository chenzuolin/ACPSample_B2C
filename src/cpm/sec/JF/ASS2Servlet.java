package cpm.sec.JF;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.sec.dao.CouponDao;
import com.sec.entity.Coupon;

/**
 * Servlet implementation class ASS2Servlet
 */
@WebServlet("/ASS2Servlet")
public class ASS2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ASS2Servlet() {
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
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html,gbk");
   		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
   		//该类用于实现文件的上传于下载操作
        SmartUpload     su=new  SmartUpload();
        //获取JspFactory对象
        JspFactory      jf=JspFactory.getDefaultFactory();
        //获取PageContext对象
        PageContext   pageContext=jf.getPageContext(this, request, response, "", true, 8192, true); 
        
        //实现initialize方法，需要pageContext对象
        su.initialize(pageContext);
        try {
			su.upload(); //读取文件数据，完成一些准备工作
			
			//文件保存的目录
			su.save("D://Program Files (x86)//webapps//app//SHOP");
			
        } catch (SmartUploadException e) {
			e.printStackTrace();
        }    
        Files      files=su.getFiles();   //获取全部的上传文件
        File        fe=files.getFile(0);  //获取第一个文件   注意：File不是io包里面的，
        String     fileName=fe.getFileName();
        Request t=su.getRequest();
        int aa = Integer.parseInt(t.getParameter("Coupon_Point"));//消耗积分
        String bb = t.getParameter("Coupon_Mode");//商品名称
        String cc = t.getParameter("Coupon_Type");//商品类型
        CouponDao dao = new CouponDao();
        Coupon c = new Coupon();
        c.setCoupon_Point(aa);
        c.setCoupon_Type(cc);
        c.setCoupon_Mode(bb);
        c.setCoupon_Tupian(fileName);
        dao.adds(c);
        response.sendRedirect("AS2.jsp");    
        
	}

}
