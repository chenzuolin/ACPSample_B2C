package com.sec.entity;

import java.util.List;

public class Page {
	private int totalPage;//��ҳ��	
	private int currentPage;//��ǰҳ��
	private List list;//װÿ�β�ѯ������
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}

}
