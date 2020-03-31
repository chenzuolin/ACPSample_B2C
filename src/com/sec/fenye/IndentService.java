package com.sec.fenye;

import java.util.List;

import javax.servlet.http.HttpServlet;

import com.sec.dao.IndentDao;
import com.sec.entity.Indent;
import java.util.ArrayList;

public class IndentService  extends HttpServlet {



	/**
	 * 
	 */
	private static final long serialVersionUID = -9023895075614351696L;
	IndentDao dao = new IndentDao();
	public Page pageUsers(String currentPage) throws Exception {//查询全部订单
		// TODO 自动生成的方法存根
		
		int allRowsAmount = dao.getAllRowsAmount();//查询全部订单方法
		PageUtil pageUtil =new PageUtil();
		pageUtil.setAllRowsAmount(allRowsAmount);//24
		if(currentPage !=null){
			pageUtil.setCurrentPage(Integer.parseInt(currentPage));//1,2,3
		}
		pageUtil.calculatePage();
		int cc = pageUtil.getCurrentPage();
		System.out.println(cc);
		int aa = 10*cc-9;
		System.out.println(aa);
		int bb = 10*cc;
		System.out.println(bb);
		

		List<Indent> list =dao.getUserByCurrentPage(aa,bb);//从多少行到多少行查询方法
		Page page =new Page();
		page.setPrevPage(pageUtil.getPrevPage());
		page.setNextPage(pageUtil.getNextPage());
		page.setshowuser(list);
		page.setShowPageNums(pageUtil.getShowPageNums());
		page.setCurrentPage(pageUtil.getCurrentPage());
		return page;
	}
	
	public Page pageUsers1(String currentPage,int session) throws Exception {//确认收货订单
		// TODO 自动生成的方法存根
		
		
		
		List<Indent> list =dao.getUserByCurrentPage1(session);
		for(Indent indent : list){
			
		}
		System.out.println(list);
		List<Indent> lists = new ArrayList<Indent>();
		int a = list.size();
		System.out.println(a);
		int c = 10;
		int b = 0;
		if(a % 10 == 0) {
			b = a / 10;
		}else {
			b = a / 10 + 1 ;
		}
		if(currentPage == null) {
			 currentPage = "1";
		}
		if(10 * Integer.parseInt(currentPage) <= a) {
		for(int i = 10 * Integer.parseInt(currentPage) -10;i < 10 * Integer.parseInt(currentPage);i++) {
			Indent indent = new Indent();
			indent.setIndent_ID(list.get(i).getIndent_ID());
			indent.setIndent_Time(list.get(i).getIndent_Time());
			indent.setIndent_Status(list.get(i).getIndent_Status());
			lists.add(indent);
		}
		}else {
			for(int i = 10 * Integer.parseInt(currentPage) -10;i < a;i++) {
				Indent indent = new Indent();
				indent.setIndent_ID(list.get(i).getIndent_ID());
				indent.setIndent_Time(list.get(i).getIndent_Time());
				indent.setIndent_Status(list.get(i).getIndent_Status());
				lists.add(indent);
			}
		}
		PageUtil pageUtil =new PageUtil();
		pageUtil.setAllRowsAmount(a);//24
		pageUtil.setCurrentPage(Integer.parseInt(currentPage));
		pageUtil.calculatePage();
		
		Page page =new Page();
		page.setPrevPage(pageUtil.getPrevPage());
		page.setNextPage(pageUtil.getNextPage());
		page.setshowuser(lists);
		page.setShowPageNums(pageUtil.getShowPageNums());
		page.setCurrentPage(pageUtil.getCurrentPage());
		return page;
	

	}
	public Page pageUsers2(String currentPage,int session, String aa, String bb) throws Exception {//确认收货订单
		// TODO 自动生成的方法存根
		
		
		
		List<Indent> list =dao.getUserByCurrentPage2(aa,bb,session);
		System.out.println(list);
		List<Indent> lists = new ArrayList<Indent>();
		int a = list.size();
		System.out.println(a);
		int c = 10;
		int b = 0;
		if(a % 10 == 0) {
			b = a / 10;
		}else {
			b = a / 10 + 1 ;
		}
		if(currentPage == null) {
			 currentPage = "1";
		}
		if(10 * Integer.parseInt(currentPage) <= a) {
		for(int i = 10 * Integer.parseInt(currentPage) -10;i < 10 * Integer.parseInt(currentPage);i++) {
			Indent indent = new Indent();
			indent.setIndent_ID(list.get(i).getIndent_ID());
			indent.setIndent_Time(list.get(i).getIndent_Time());
			indent.setIndent_Status(list.get(i).getIndent_Status());
			lists.add(indent);
		}
		}else {
			for(int i = 10 * Integer.parseInt(currentPage) -10;i < a;i++) {
				Indent indent = new Indent();
				indent.setIndent_ID(list.get(i).getIndent_ID());
				indent.setIndent_Time(list.get(i).getIndent_Time());
				indent.setIndent_Status(list.get(i).getIndent_Status());
				lists.add(indent);
			}
		}
		PageUtil pageUtil =new PageUtil();
		pageUtil.setAllRowsAmount(a);//24
		pageUtil.setCurrentPage(Integer.parseInt(currentPage));
		pageUtil.calculatePage();
		
		Page page =new Page();
		page.setPrevPage(pageUtil.getPrevPage());
		page.setNextPage(pageUtil.getNextPage());
		page.setshowuser(lists);
		page.setShowPageNums(pageUtil.getShowPageNums());
		page.setCurrentPage(pageUtil.getCurrentPage());
		return page;
	

	}


	public Page pageUsers3(String currentPage,int session, String aa, String bb) throws Exception {//确认收货订单
		// TODO 自动生成的方法存根
		
		
		
		List<Indent> list =dao.getUserByCurrentPage3(aa,bb,session);
		System.out.println(list);
		List<Indent> lists = new ArrayList<Indent>();
		int a = list.size();
		System.out.println(a);
		int c = 10;
		int b = 0;
		if(a % 10 == 0) {
			b = a / 10;
		}else {
			b = a / 10 + 1 ;
		}
		if(currentPage == null) {
			 currentPage = "1";
		}
		if(10 * Integer.parseInt(currentPage) <= a) {
		for(int i = 10 * Integer.parseInt(currentPage) -10;i < 10 * Integer.parseInt(currentPage);i++) {
			Indent indent = new Indent();
			indent.setIndent_ID(list.get(i).getIndent_ID());
			indent.setIndent_Time(list.get(i).getIndent_Time());
			indent.setIndent_Status(list.get(i).getIndent_Status());
			lists.add(indent);
		}
		}else {
			for(int i = 10 * Integer.parseInt(currentPage) -10;i < a;i++) {
				Indent indent = new Indent();
				indent.setIndent_ID(list.get(i).getIndent_ID());
				indent.setIndent_Time(list.get(i).getIndent_Time());
				indent.setIndent_Status(list.get(i).getIndent_Status());
				lists.add(indent);
			}
		}
		PageUtil pageUtil =new PageUtil();
		pageUtil.setAllRowsAmount(a);//24
		pageUtil.setCurrentPage(Integer.parseInt(currentPage));
		pageUtil.calculatePage();
		
		Page page =new Page();
		page.setPrevPage(pageUtil.getPrevPage());
		page.setNextPage(pageUtil.getNextPage());
		page.setshowuser(lists);
		page.setShowPageNums(pageUtil.getShowPageNums());
		page.setCurrentPage(pageUtil.getCurrentPage());
		return page;
	

	}

	public Page pageUsers4(String currentPage,int session, String aa, String bb) throws Exception {//确认收货订单
		// TODO 自动生成的方法存根
		
		
		
		List<Indent> list =dao.getUserByCurrentPage4(aa,bb,session);
		System.out.println(list);
		List<Indent> lists = new ArrayList<Indent>();
		int a = list.size();
		System.out.println(a);
		int c = 10;
		int b = 0;
		if(a % 10 == 0) {
			b = a / 10;
		}else {
			b = a / 10 + 1 ;
		}
		if(currentPage == null) {
			 currentPage = "1";
		}
		if(10 * Integer.parseInt(currentPage) <= a) {
		for(int i = 10 * Integer.parseInt(currentPage) -10;i < 10 * Integer.parseInt(currentPage);i++) {
			Indent indent = new Indent();
			indent.setIndent_ID(list.get(i).getIndent_ID());
			indent.setIndent_Time(list.get(i).getIndent_Time());
			indent.setIndent_Status(list.get(i).getIndent_Status());
			lists.add(indent);
		}
		}else {
			for(int i = 10 * Integer.parseInt(currentPage) -10;i < a;i++) {
				Indent indent = new Indent();
				indent.setIndent_ID(list.get(i).getIndent_ID());
				indent.setIndent_Time(list.get(i).getIndent_Time());
				indent.setIndent_Status(list.get(i).getIndent_Status());
				lists.add(indent);
			}
		}
		PageUtil pageUtil =new PageUtil();
		pageUtil.setAllRowsAmount(a);//24
		pageUtil.setCurrentPage(Integer.parseInt(currentPage));
		pageUtil.calculatePage();
		
		Page page =new Page();
		page.setPrevPage(pageUtil.getPrevPage());
		page.setNextPage(pageUtil.getNextPage());
		page.setshowuser(lists);
		page.setShowPageNums(pageUtil.getShowPageNums());
		page.setCurrentPage(pageUtil.getCurrentPage());
		return page;
	

	}

	public Page pageUsers5(String currentPage,int session, String aa, String bb) throws Exception {//确认收货订单
		// TODO 自动生成的方法存根
		
		
		
		List<Indent> list =dao.getUserByCurrentPage5(aa,bb,session);
		System.out.println(list);
		List<Indent> lists = new ArrayList<Indent>();
		int a = list.size();
		System.out.println(a);
		int c = 10;
		int b = 0;
		if(a % 10 == 0) {
			b = a / 10;
		}else {
			b = a / 10 + 1 ;
		}
		if(currentPage == null) {
			 currentPage = "1";
		}
		if(10 * Integer.parseInt(currentPage) <= a) {
		for(int i = 10 * Integer.parseInt(currentPage) -10;i < 10 * Integer.parseInt(currentPage);i++) {
			Indent indent = new Indent();
			indent.setIndent_ID(list.get(i).getIndent_ID());
			indent.setIndent_Time(list.get(i).getIndent_Time());
			indent.setIndent_Status(list.get(i).getIndent_Status());
			lists.add(indent);
		}
		}else {
			for(int i = 10 * Integer.parseInt(currentPage) -10;i < a;i++) {
				Indent indent = new Indent();
				indent.setIndent_ID(list.get(i).getIndent_ID());
				indent.setIndent_Time(list.get(i).getIndent_Time());
				indent.setIndent_Status(list.get(i).getIndent_Status());
				lists.add(indent);
			}
		}
		PageUtil pageUtil =new PageUtil();
		pageUtil.setAllRowsAmount(a);//24
		pageUtil.setCurrentPage(Integer.parseInt(currentPage));
		pageUtil.calculatePage();
		
		Page page =new Page();
		page.setPrevPage(pageUtil.getPrevPage());
		page.setNextPage(pageUtil.getNextPage());
		page.setshowuser(lists);
		page.setShowPageNums(pageUtil.getShowPageNums());
		page.setCurrentPage(pageUtil.getCurrentPage());
		return page;
	

	}

	public Page pageUsers6(String currentPage,int session, String aa, String bb) throws Exception {//确认收货订单
		// TODO 自动生成的方法存根
		
		
		
		List<Indent> list =dao.getUserByCurrentPage6(aa,bb,session);
		System.out.println(list);
		List<Indent> lists = new ArrayList<Indent>();
		int a = list.size();
		System.out.println(a);
		int c = 10;
		int b = 0;
		if(a % 10 == 0) {
			b = a / 10;
		}else {
			b = a / 10 + 1 ;
		}
		if(currentPage == null) {
			 currentPage = "1";
		}
		if(10 * Integer.parseInt(currentPage) <= a) {
		for(int i = 10 * Integer.parseInt(currentPage) -10;i < 10 * Integer.parseInt(currentPage);i++) {
			Indent indent = new Indent();
			indent.setIndent_ID(list.get(i).getIndent_ID());
			indent.setIndent_Time(list.get(i).getIndent_Time());
			indent.setIndent_Status(list.get(i).getIndent_Status());
			lists.add(indent);
		}
		}else {
			for(int i = 10 * Integer.parseInt(currentPage) -10;i < a;i++) {
				Indent indent = new Indent();
				indent.setIndent_ID(list.get(i).getIndent_ID());
				indent.setIndent_Time(list.get(i).getIndent_Time());
				indent.setIndent_Status(list.get(i).getIndent_Status());
				lists.add(indent);
			}
		}
		PageUtil pageUtil =new PageUtil();
		pageUtil.setAllRowsAmount(a);//24
		pageUtil.setCurrentPage(Integer.parseInt(currentPage));
		pageUtil.calculatePage();
		
		Page page =new Page();
		page.setPrevPage(pageUtil.getPrevPage());
		page.setNextPage(pageUtil.getNextPage());
		page.setshowuser(lists);
		page.setShowPageNums(pageUtil.getShowPageNums());
		page.setCurrentPage(pageUtil.getCurrentPage());
		return page;
	

	}

	public Page pageUsers10(String currentPage,String aa, String bb) throws Exception {//确认收货订单
		// TODO 自动生成的方法存根
		
		
		
		List<Indent> list =dao.getUserByCurrentPage10(aa,bb);
		System.out.println(list);
		List<Indent> lists = new ArrayList<Indent>();
		int a = list.size();
		System.out.println(a);
		int c = 10;
		int b = 0;
		if(a % 10 == 0) {
			b = a / 10;
		}else {
			b = a / 10 + 1 ;
		}
		if(currentPage == null) {
			 currentPage = "1";
		}
		if(10 * Integer.parseInt(currentPage) <= a) {
		for(int i = 10 * Integer.parseInt(currentPage) -10;i < 10 * Integer.parseInt(currentPage);i++) {
			Indent indent = new Indent();
			indent.setIndent_ID(list.get(i).getIndent_ID());
			indent.setIndent_Time(list.get(i).getIndent_Time());
			indent.setIndent_Status(list.get(i).getIndent_Status());
			lists.add(indent);
		}
		}else {
			for(int i = 10 * Integer.parseInt(currentPage) -10;i < a;i++) {
				Indent indent = new Indent();
				indent.setIndent_ID(list.get(i).getIndent_ID());
				indent.setIndent_Time(list.get(i).getIndent_Time());
				indent.setIndent_Status(list.get(i).getIndent_Status());
				lists.add(indent);
			}
		}
		PageUtil pageUtil =new PageUtil();
		pageUtil.setAllRowsAmount(a);//24
		pageUtil.setCurrentPage(Integer.parseInt(currentPage));
		pageUtil.calculatePage();
		
		Page page =new Page();
		page.setPrevPage(pageUtil.getPrevPage());
		page.setNextPage(pageUtil.getNextPage());
		page.setshowuser(lists);
		page.setShowPageNums(pageUtil.getShowPageNums());
		page.setCurrentPage(pageUtil.getCurrentPage());
		return page;
	

	}

	public Page pageUsers11(String currentPage,String aa, String bb) throws Exception {//确认收货订单
		// TODO 自动生成的方法存根
		
		
		
		List<Indent> list =dao.getUserByCurrentPage11(aa,bb);
		System.out.println(list);
		List<Indent> lists = new ArrayList<Indent>();
		int a = list.size();
		System.out.println(a);
		int c = 10;
		int b = 0;
		if(a % 10 == 0) {
			b = a / 10;
		}else {
			b = a / 10 + 1 ;
		}
		if(currentPage == null) {
			 currentPage = "1";
		}
		if(10 * Integer.parseInt(currentPage) <= a) {
		for(int i = 10 * Integer.parseInt(currentPage) -10;i < 10 * Integer.parseInt(currentPage);i++) {
			Indent indent = new Indent();
			indent.setIndent_ID(list.get(i).getIndent_ID());
			indent.setIndent_Time(list.get(i).getIndent_Time());
			indent.setIndent_Status(list.get(i).getIndent_Status());
			lists.add(indent);
		}
		}else {
			for(int i = 10 * Integer.parseInt(currentPage) -10;i < a;i++) {
				Indent indent = new Indent();
				indent.setIndent_ID(list.get(i).getIndent_ID());
				indent.setIndent_Time(list.get(i).getIndent_Time());
				indent.setIndent_Status(list.get(i).getIndent_Status());
				lists.add(indent);
			}
		}
		PageUtil pageUtil =new PageUtil();
		pageUtil.setAllRowsAmount(a);//24
		pageUtil.setCurrentPage(Integer.parseInt(currentPage));
		pageUtil.calculatePage();
		
		Page page =new Page();
		page.setPrevPage(pageUtil.getPrevPage());
		page.setNextPage(pageUtil.getNextPage());
		page.setshowuser(lists);
		page.setShowPageNums(pageUtil.getShowPageNums());
		page.setCurrentPage(pageUtil.getCurrentPage());
		return page;
	

	}

	public Page pageUsers12(String currentPage,String aa, String bb) throws Exception {//确认收货订单
		// TODO 自动生成的方法存根
		
		
		
		List<Indent> list =dao.getUserByCurrentPage12(aa,bb);
		System.out.println(list);
		List<Indent> lists = new ArrayList<Indent>();
		int a = list.size();
		System.out.println(a);
		int c = 10;
		int b = 0;
		if(a % 10 == 0) {
			b = a / 10;
		}else {
			b = a / 10 + 1 ;
		}
		if(currentPage == null) {
			 currentPage = "1";
		}
		if(10 * Integer.parseInt(currentPage) <= a) {
		for(int i = 10 * Integer.parseInt(currentPage) -10;i < 10 * Integer.parseInt(currentPage);i++) {
			Indent indent = new Indent();
			indent.setIndent_ID(list.get(i).getIndent_ID());
			indent.setIndent_Time(list.get(i).getIndent_Time());
			indent.setIndent_Status(list.get(i).getIndent_Status());
			lists.add(indent);
		}
		}else {
			for(int i = 10 * Integer.parseInt(currentPage) -10;i < a;i++) {
				Indent indent = new Indent();
				indent.setIndent_ID(list.get(i).getIndent_ID());
				indent.setIndent_Time(list.get(i).getIndent_Time());
				indent.setIndent_Status(list.get(i).getIndent_Status());
				lists.add(indent);
			}
		}
		PageUtil pageUtil =new PageUtil();
		pageUtil.setAllRowsAmount(a);//24
		pageUtil.setCurrentPage(Integer.parseInt(currentPage));
		pageUtil.calculatePage();
		
		Page page =new Page();
		page.setPrevPage(pageUtil.getPrevPage());
		page.setNextPage(pageUtil.getNextPage());
		page.setshowuser(lists);
		page.setShowPageNums(pageUtil.getShowPageNums());
		page.setCurrentPage(pageUtil.getCurrentPage());
		return page;
	

	}

	public Page pageUsers13(String currentPage,String aa, String bb) throws Exception {//确认收货订单
		// TODO 自动生成的方法存根
		
		
		
		List<Indent> list =dao.getUserByCurrentPage13(aa,bb);
		System.out.println(list);
		List<Indent> lists = new ArrayList<Indent>();
		int a = list.size();
		System.out.println(a);
		int c = 10;
		int b = 0;
		if(a % 10 == 0) {
			b = a / 10;
		}else {
			b = a / 10 + 1 ;
		}
		if(currentPage == null) {
			 currentPage = "1";
		}
		if(10 * Integer.parseInt(currentPage) <= a) {
		for(int i = 10 * Integer.parseInt(currentPage) -10;i < 10 * Integer.parseInt(currentPage);i++) {
			Indent indent = new Indent();
			indent.setIndent_ID(list.get(i).getIndent_ID());
			indent.setIndent_Time(list.get(i).getIndent_Time());
			indent.setIndent_Status(list.get(i).getIndent_Status());
			lists.add(indent);
		}
		}else {
			for(int i = 10 * Integer.parseInt(currentPage) -10;i < a;i++) {
				Indent indent = new Indent();
				indent.setIndent_ID(list.get(i).getIndent_ID());
				indent.setIndent_Time(list.get(i).getIndent_Time());
				indent.setIndent_Status(list.get(i).getIndent_Status());
				lists.add(indent);
			}
		}
		PageUtil pageUtil =new PageUtil();
		pageUtil.setAllRowsAmount(a);//24
		pageUtil.setCurrentPage(Integer.parseInt(currentPage));
		pageUtil.calculatePage();
		
		Page page =new Page();
		page.setPrevPage(pageUtil.getPrevPage());
		page.setNextPage(pageUtil.getNextPage());
		page.setshowuser(lists);
		page.setShowPageNums(pageUtil.getShowPageNums());
		page.setCurrentPage(pageUtil.getCurrentPage());
		return page;
	

	}

		public Page pageUsers14(String currentPage,String aa, String bb) throws Exception {//确认收货订单
		// TODO 自动生成的方法存根
		
		
		
		List<Indent> list =dao.getUserByCurrentPage14(aa,bb);
		System.out.println(list);
		List<Indent> lists = new ArrayList<Indent>();
		int a = list.size();
		System.out.println(a);
		int c = 10;
		int b = 0;
		if(a % 10 == 0) {
			b = a / 10;
		}else {
			b = a / 10 + 1 ;
		}
		if(currentPage == null) {
			 currentPage = "1";
		}
		if(10 * Integer.parseInt(currentPage) <= a) {
		for(int i = 10 * Integer.parseInt(currentPage) -10;i < 10 * Integer.parseInt(currentPage);i++) {
			Indent indent = new Indent();
			indent.setIndent_ID(list.get(i).getIndent_ID());
			indent.setIndent_Time(list.get(i).getIndent_Time());
			indent.setIndent_Status(list.get(i).getIndent_Status());
			lists.add(indent);
		}
		}else {
			for(int i = 10 * Integer.parseInt(currentPage) -10;i < a;i++) {
				Indent indent = new Indent();
				indent.setIndent_ID(list.get(i).getIndent_ID());
				indent.setIndent_Time(list.get(i).getIndent_Time());
				indent.setIndent_Status(list.get(i).getIndent_Status());
				lists.add(indent);
			}
		}
		PageUtil pageUtil =new PageUtil();
		pageUtil.setAllRowsAmount(a);//24
		pageUtil.setCurrentPage(Integer.parseInt(currentPage));
		pageUtil.calculatePage();
		
		Page page =new Page();
		page.setPrevPage(pageUtil.getPrevPage());
		page.setNextPage(pageUtil.getNextPage());
		page.setshowuser(lists);
		page.setShowPageNums(pageUtil.getShowPageNums());
		page.setCurrentPage(pageUtil.getCurrentPage());
		return page;
	

	}

		public Page pageUsers20(String currentPage) throws Exception {//确认收货订单
		// TODO 自动生成的方法存根
		
		
		
		List<Indent> list =dao.getUserByCurrentPage15();
		System.out.println(list);
		List<Indent> lists = new ArrayList<Indent>();
		int a = list.size();
		System.out.println(a);
		int c = 10;
		int b = 0;
		if(a % 10 == 0) {
			b = a / 10;
		}else {
			b = a / 10 + 1 ;
		}
		if(currentPage == null) {
			 currentPage = "1";
		}
		if(10 * Integer.parseInt(currentPage) <= a) {
		for(int i = 10 * Integer.parseInt(currentPage) -10;i < 10 * Integer.parseInt(currentPage);i++) {
			Indent indent = new Indent();
			indent.setIndent_ID(list.get(i).getIndent_ID());
			indent.setIndent_Time(list.get(i).getIndent_Time());
			indent.setIndent_Status(list.get(i).getIndent_Status());
			lists.add(indent);
		}
		}else {
			for(int i = 10 * Integer.parseInt(currentPage) -10;i < a;i++) {
				Indent indent = new Indent();
				indent.setIndent_ID(list.get(i).getIndent_ID());
				indent.setIndent_Time(list.get(i).getIndent_Time());
				indent.setIndent_Status(list.get(i).getIndent_Status());
				lists.add(indent);
			}
		}
		PageUtil pageUtil =new PageUtil();
		pageUtil.setAllRowsAmount(a);//24
		pageUtil.setCurrentPage(Integer.parseInt(currentPage));
		pageUtil.calculatePage();
		
		Page page =new Page();
		page.setPrevPage(pageUtil.getPrevPage());
		page.setNextPage(pageUtil.getNextPage());
		page.setshowuser(lists);
		page.setShowPageNums(pageUtil.getShowPageNums());
		page.setCurrentPage(pageUtil.getCurrentPage());
		return page;
	

	}

		public Page pageUsers21(String currentPage) throws Exception {//确认收货订单
		// TODO 自动生成的方法存根
		
		
		
		List<Indent> list =dao.getUserByCurrentPage16();
		System.out.println(list);
		List<Indent> lists = new ArrayList<Indent>();
		int a = list.size();
		System.out.println(a);
		int c = 10;
		int b = 0;
		if(a % 10 == 0) {
			b = a / 10;
		}else {
			b = a / 10 + 1 ;
		}
		if(currentPage == null) {
			 currentPage = "1";
		}
		if(10 * Integer.parseInt(currentPage) <= a) {
		for(int i = 10 * Integer.parseInt(currentPage) -10;i < 10 * Integer.parseInt(currentPage);i++) {
			Indent indent = new Indent();
			indent.setIndent_ID(list.get(i).getIndent_ID());
			indent.setIndent_Time(list.get(i).getIndent_Time());
			indent.setIndent_Status(list.get(i).getIndent_Status());
			lists.add(indent);
		}
		}else {
			for(int i = 10 * Integer.parseInt(currentPage) -10;i < a;i++) {
				Indent indent = new Indent();
				indent.setIndent_ID(list.get(i).getIndent_ID());
				indent.setIndent_Time(list.get(i).getIndent_Time());
				indent.setIndent_Status(list.get(i).getIndent_Status());
				lists.add(indent);
			}
		}
		PageUtil pageUtil =new PageUtil();
		pageUtil.setAllRowsAmount(a);//24
		pageUtil.setCurrentPage(Integer.parseInt(currentPage));
		pageUtil.calculatePage();
		
		Page page =new Page();
		page.setPrevPage(pageUtil.getPrevPage());
		page.setNextPage(pageUtil.getNextPage());
		page.setshowuser(lists);
		page.setShowPageNums(pageUtil.getShowPageNums());
		page.setCurrentPage(pageUtil.getCurrentPage());
		return page;
	

	}
}
