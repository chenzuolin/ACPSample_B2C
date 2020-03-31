package com.sec.fenye;

import java.util.ArrayList;
import java.util.List;

import com.sec.entity.Indent;

public class Page {
	private Integer currentPage;
	private Integer prevPage;
	private Integer nextPage;
	private List<Indent> showuser =new ArrayList<Indent>();
	public List<Indent> getshowuser() {
		return showuser;
	}
	public void setshowuser(List<Indent> showuser) {
		this.showuser = showuser;
	}
	private List<Integer> showPageNums = new ArrayList<Integer>();
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(Integer prevPage) {
		this.prevPage = prevPage;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	
	public List<Integer> getShowPageNums() {
		return showPageNums;
	}
	public void setShowPageNums(List<Integer> showPageNums) {
		this.showPageNums = showPageNums;
	}
	
}
