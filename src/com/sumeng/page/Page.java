package com.sumeng.page;

import java.util.List;

public class Page {
	private int code = 0;
	private int count;
	private int totalPage;//��ҳ��	
	private int currentPage;//��ǰҳ��
	private List data;//װÿ�β�ѯ������
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
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
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Page [code=" + code + ", count=" + count + ", totalPage="
				+ totalPage + ", currentPage=" + currentPage + ", data=" + data
				+ "]";
	}
	

}
