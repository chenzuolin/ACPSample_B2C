package com.sumeng.page;

import java.util.List;

public class fenye {
	private int code;
	private int count;
	private int totalPage;//总页数	
	private int currentPage;//当前页数
	private List data;//装每次查询的数据
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Page [code=" + code + ", count=" + count + ", totalPage=" + totalPage + ", currentPage=" + currentPage
				+ ", data=" + data + "]";
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
	

}
