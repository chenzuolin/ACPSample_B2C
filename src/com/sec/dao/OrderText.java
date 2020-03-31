package com.sec.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import WeiXin.UUID;

import com.sec.entity.Order;
import com.sec.entity.Price;

public class OrderText {

	public static void main(String[] args) throws SQLException {
		// TODO 自动生成的方法存根
		OrderDao dao = new OrderDao();
		List<Order> list = dao.findAllDay(198);
		float bb = 0;
		for(Order order :list){
			//System.out.println(order.getGreens_Name());
			//System.out.println(order.getGreens_Price());
			//System.out.println(order.getNumber());
			float aa = 0;
			 aa = order.getGreens_Price()*order.getNumber();
			bb +=aa;
			//System.out.println(bb);
		}
		System.out.println(bb);
		
		
		

	}

}
