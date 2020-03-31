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
   		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
   		//��������ʵ���ļ����ϴ������ز���
        SmartUpload     su=new  SmartUpload();
        //��ȡJspFactory����
        JspFactory      jf=JspFactory.getDefaultFactory();
        //��ȡPageContext����
        PageContext   pageContext=jf.getPageContext(this, request, response, "", true, 8192, true); 
        
        //ʵ��initialize��������ҪpageContext����
        su.initialize(pageContext);
        try {
			su.upload(); //��ȡ�ļ����ݣ����һЩ׼������
			
			//�ļ������Ŀ¼
			su.save("D://Program Files (x86)//webapps//app//SHOP");
			
        } catch (SmartUploadException e) {
			e.printStackTrace();
        }    
        Files      files=su.getFiles();   //��ȡȫ�����ϴ��ļ�
        File        fe=files.getFile(0);  //��ȡ��һ���ļ�   ע�⣺File����io������ģ�
        String     fileName=fe.getFileName();
        Request t=su.getRequest();
        int aa = Integer.parseInt(t.getParameter("Coupon_Point"));//���Ļ���
        String bb = t.getParameter("Coupon_Mode");//��Ʒ����
        String cc = t.getParameter("Coupon_Type");//��Ʒ����
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
