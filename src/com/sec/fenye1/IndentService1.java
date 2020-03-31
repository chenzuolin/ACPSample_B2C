package com.sec.fenye1;

import java.util.List;

import javax.servlet.http.HttpServlet;

import com.sec.dao.GreensDao;
import com.sec.entity.Greens;

import java.util.ArrayList;

public class IndentService1  extends HttpServlet {



	/**
	 * 
	 */
	private static final long serialVersionUID = -9023895075614351696L;
	GreensDao dao = new GreensDao();
	public Page1 pageUsers(String currentPage) throws Exception {//查询全部订单
		// TODO 自动生成的方法存根
		
		int allRowsAmount = dao.getAllRowsAmount();//查询全部订单方法
		PageUtil1 pageUtil =new PageUtil1();
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
		

		List<Greens> list =dao.getUserByCurrentPage(aa,bb);//从多少行到多少行查询方法
		Page1 page =new Page1();
		page.setPrevPage(pageUtil.getPrevPage());
		page.setNextPage(pageUtil.getNextPage());
		page.setshowuser(list);
		page.setShowPageNums(pageUtil.getShowPageNums());
		page.setCurrentPage(pageUtil.getCurrentPage());
		return page;
	}
	
	public Page1 pageUsers1(String currentPage) throws Exception {//确认收货订单
		// TODO 自动生成的方法存根
		
		
		
		List<Greens> list =dao.getUserByCurrentPage1();
		System.out.println(list);
		List<Greens> lists = new ArrayList<Greens>();
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
			Greens greens = new Greens();
			greens.setGreens_ID(list.get(i).getGreens_ID());
			greens.setGreens_Name(list.get(i).getGreens_Name());
			greens.setGreens_Unit(list.get(i).getGreens_Unit());
			greens.setGreens_Price(list.get(i).getGreens_Price());
			greens.setGreens_Market_Price(list.get(i).getGreens_Market_Price());
			greens.setGreens_Class(list.get(i).getGreens_Class());
			greens.setGreens_Preiod(list.get(i).getGreens_Preiod());
			greens.setGreens_Character(list.get(i).getGreens_Character());
			greens.setGreens_Condition(list.get(i).getGreens_Condition());
			greens.setGreens_Minnumber(list.get(i).getGreens_Minnumber());
			greens.setGreens_Norms(list.get(i).getGreens_Norms());
			greens.setGreens_Number(list.get(i).getGreens_Number());
			greens.setGreens_characteristics(list.get(i).getGreens_characteristics());
			greens.setGreens_Grade(list.get(i).getGreens_Grade());
			greens.setGreens_Recommend(list.get(i).getGreens_Recommend());
			greens.setGreens_Remark(list.get(i).getGreens_Remark());
			lists.add(greens);
			
			
		}
		}else {
			for(int i = 10 * Integer.parseInt(currentPage) -10;i < a;i++) {
				Greens greens = new Greens();
				greens.setGreens_ID(list.get(i).getGreens_ID());
				greens.setGreens_Name(list.get(i).getGreens_Name());
				greens.setGreens_Unit(list.get(i).getGreens_Unit());
				greens.setGreens_Price(list.get(i).getGreens_Price());
				greens.setGreens_Market_Price(list.get(i).getGreens_Market_Price());
				greens.setGreens_Class(list.get(i).getGreens_Class());
				greens.setGreens_Preiod(list.get(i).getGreens_Preiod());
				greens.setGreens_Character(list.get(i).getGreens_Character());
				greens.setGreens_Condition(list.get(i).getGreens_Condition());
				greens.setGreens_Minnumber(list.get(i).getGreens_Minnumber());
				greens.setGreens_Norms(list.get(i).getGreens_Norms());
				greens.setGreens_Number(list.get(i).getGreens_Number());
				greens.setGreens_characteristics(list.get(i).getGreens_characteristics());
				greens.setGreens_Grade(list.get(i).getGreens_Grade());
				greens.setGreens_Recommend(list.get(i).getGreens_Recommend());
				greens.setGreens_Remark(list.get(i).getGreens_Remark());
				lists.add(greens);
			}
		}
		PageUtil1 pageUtil =new PageUtil1();
		pageUtil.setAllRowsAmount(a);//24
		pageUtil.setCurrentPage(Integer.parseInt(currentPage));
		pageUtil.calculatePage();
		
		Page1 page =new Page1();
		page.setPrevPage(pageUtil.getPrevPage());
		page.setNextPage(pageUtil.getNextPage());
		page.setshowuser(lists);
		page.setShowPageNums(pageUtil.getShowPageNums());
		page.setCurrentPage(pageUtil.getCurrentPage());
		return page;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	public Page1 pageUsers2(String currentPage,String jjj) throws Exception {//确认收货订单
		// TODO 自动生成的方法存根
		
		
		List<Greens> list =dao.getUserByCurrentPage2(jjj);
		//System.out.println(list);
		List<Greens> lists = new ArrayList<Greens>();
		int a = list.size();
		//System.out.println(a);
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
			Greens greens = new Greens();
			greens.setGreens_ID(list.get(i).getGreens_ID());
			System.out.println(list.get(i).getGreens_Name());
			greens.setGreens_Name(list.get(i).getGreens_Name());
			greens.setGreens_Unit(list.get(i).getGreens_Unit());
			greens.setGreens_Price(list.get(i).getGreens_Price());
			greens.setGreens_Market_Price(list.get(i).getGreens_Market_Price());
			greens.setGreens_Class(list.get(i).getGreens_Class());
			greens.setGreens_Preiod(list.get(i).getGreens_Preiod());
			greens.setGreens_Character(list.get(i).getGreens_Character());
			greens.setGreens_Condition(list.get(i).getGreens_Condition());
			greens.setGreens_Minnumber(list.get(i).getGreens_Minnumber());
			greens.setGreens_Norms(list.get(i).getGreens_Norms());
			greens.setGreens_Number(list.get(i).getGreens_Number());
			greens.setGreens_characteristics(list.get(i).getGreens_characteristics());
			greens.setGreens_Grade(list.get(i).getGreens_Grade());
			greens.setGreens_Recommend(list.get(i).getGreens_Recommend());
			greens.setGreens_Remark(list.get(i).getGreens_Remark());
			lists.add(greens);
		}
		}else {
			for(int i = 10 * Integer.parseInt(currentPage) -10;i < a;i++) {
				Greens greens = new Greens();
				greens.setGreens_ID(list.get(i).getGreens_ID());
				greens.setGreens_Name(list.get(i).getGreens_Name());
				greens.setGreens_Unit(list.get(i).getGreens_Unit());
				greens.setGreens_Price(list.get(i).getGreens_Price());
				greens.setGreens_Market_Price(list.get(i).getGreens_Market_Price());
				greens.setGreens_Class(list.get(i).getGreens_Class());
				greens.setGreens_Preiod(list.get(i).getGreens_Preiod());
				greens.setGreens_Character(list.get(i).getGreens_Character());
				greens.setGreens_Condition(list.get(i).getGreens_Condition());
				greens.setGreens_Minnumber(list.get(i).getGreens_Minnumber());
				greens.setGreens_Norms(list.get(i).getGreens_Norms());
				greens.setGreens_Number(list.get(i).getGreens_Number());
				greens.setGreens_characteristics(list.get(i).getGreens_characteristics());
				greens.setGreens_Grade(list.get(i).getGreens_Grade());
				greens.setGreens_Recommend(list.get(i).getGreens_Recommend());
				greens.setGreens_Remark(list.get(i).getGreens_Remark());
				lists.add(greens);
			}
		}
		PageUtil1 pageUtil =new PageUtil1();
		pageUtil.setAllRowsAmount(a);//24
		pageUtil.setCurrentPage(Integer.parseInt(currentPage));
		pageUtil.calculatePage();
		
		Page1 page =new Page1();
		page.setPrevPage(pageUtil.getPrevPage());
		page.setNextPage(pageUtil.getNextPage());
		page.setshowuser(lists);
		page.setShowPageNums(pageUtil.getShowPageNums());
		page.setCurrentPage(pageUtil.getCurrentPage());
		return page;
	

	}


	public Page1 pageUsers3(String currentPage,String ggg) throws Exception {//确认收货订单
		// TODO 自动生成的方法存根
		
		List<Greens> list =dao.getUserByCurrentPage3(ggg);
		//System.out.println(list);
		List<Greens> lists = new ArrayList<Greens>();
		int a = list.size();
		//System.out.println(a);
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
			Greens greens = new Greens();
			greens.setGreens_ID(list.get(i).getGreens_ID());
			System.out.println(list.get(i).getGreens_Name());
			greens.setGreens_Name(list.get(i).getGreens_Name());
			greens.setGreens_Unit(list.get(i).getGreens_Unit());
			greens.setGreens_Price(list.get(i).getGreens_Price());
			greens.setGreens_Market_Price(list.get(i).getGreens_Market_Price());
			greens.setGreens_Class(list.get(i).getGreens_Class());
			greens.setGreens_Preiod(list.get(i).getGreens_Preiod());
			greens.setGreens_Character(list.get(i).getGreens_Character());
			greens.setGreens_Condition(list.get(i).getGreens_Condition());
			greens.setGreens_Minnumber(list.get(i).getGreens_Minnumber());
			greens.setGreens_Norms(list.get(i).getGreens_Norms());
			greens.setGreens_Number(list.get(i).getGreens_Number());
			greens.setGreens_characteristics(list.get(i).getGreens_characteristics());
			greens.setGreens_Grade(list.get(i).getGreens_Grade());
			greens.setGreens_Recommend(list.get(i).getGreens_Recommend());
			greens.setGreens_Remark(list.get(i).getGreens_Remark());
			lists.add(greens);
		}
		}else {
			for(int i = 10 * Integer.parseInt(currentPage) -10;i < a;i++) {
				Greens greens = new Greens();
				greens.setGreens_ID(list.get(i).getGreens_ID());
				greens.setGreens_Name(list.get(i).getGreens_Name());
				greens.setGreens_Unit(list.get(i).getGreens_Unit());
				greens.setGreens_Price(list.get(i).getGreens_Price());
				greens.setGreens_Market_Price(list.get(i).getGreens_Market_Price());
				greens.setGreens_Class(list.get(i).getGreens_Class());
				greens.setGreens_Preiod(list.get(i).getGreens_Preiod());
				greens.setGreens_Character(list.get(i).getGreens_Character());
				greens.setGreens_Condition(list.get(i).getGreens_Condition());
				greens.setGreens_Minnumber(list.get(i).getGreens_Minnumber());
				greens.setGreens_Norms(list.get(i).getGreens_Norms());
				greens.setGreens_Number(list.get(i).getGreens_Number());
				greens.setGreens_characteristics(list.get(i).getGreens_characteristics());
				greens.setGreens_Grade(list.get(i).getGreens_Grade());
				greens.setGreens_Recommend(list.get(i).getGreens_Recommend());
				greens.setGreens_Remark(list.get(i).getGreens_Remark());
				lists.add(greens);
			}
		}
		PageUtil1 pageUtil =new PageUtil1();
		pageUtil.setAllRowsAmount(a);//24
		pageUtil.setCurrentPage(Integer.parseInt(currentPage));
		pageUtil.calculatePage();
		
		Page1 page =new Page1();
		page.setPrevPage(pageUtil.getPrevPage());
		page.setNextPage(pageUtil.getNextPage());
		page.setshowuser(lists);
		page.setShowPageNums(pageUtil.getShowPageNums());
		page.setCurrentPage(pageUtil.getCurrentPage());
		return page;
	

	}

	

	
}
