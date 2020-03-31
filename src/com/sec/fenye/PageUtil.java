package com.sec.fenye;

import java.util.ArrayList;
import java.util.List;

import com.sec.dao.IndentDao;
import com.sec.entity.Indent;

public class PageUtil {
	IndentDao dao = new IndentDao();
	/*������Ҫҳ�洫��*/
	private Integer pageSize=10;//ÿҳ��ʽ��������¼
	private Integer currentPage=1;//��ǰҳ��
	
	/*������Ҫ�����ݲ�ѯ*/
	private Integer allRowsAmount=0;//�ܼ�¼��
	private List<Indent> items = dao.findAll();//��¼����
	
	/*��Щ�����ɼ���ó�*/
	private Integer allPageAmount;//��ҳ��
	private Integer currentPageStartRow=1;//��ǰҳ��Ŀ�ʼ��
	private Integer currentPageEndRow;//��ǰҳ��Ľ�����
	private Integer firstPage=1;//��ҳ��ҳ��
	private Integer lastPage;//ĩҳ��ҳ��
	private Integer prevPage;//��һҳҳ��
	private Integer nextPage;//��һҳҳ��
	private Integer startPageNum;//������ʼҳ��
	private Integer endPageNum;//��������ҳ��
	private Integer maxPageAmount =10;//�����ʾ����ҳ
	public List<Integer> showPageNums =new ArrayList<Integer>();//Ҫ��ʾ��ҳ��
	
	public PageUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*���õ�ǰҳ*/
	public void setCurrentPage(int currentPage){
		if(currentPage <1){
			this.currentPage=1;
		}else{
			this.currentPage=currentPage;
		}
	}
	/*����ÿҳ��¼����Ĭ��10��*/
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/*�����ܼ�¼��*/
	public void setAllRowsAmount(int allRowsAmount) {
		this.allRowsAmount = allRowsAmount;
	}
	/*���÷�ҳ����*/
	public void setItems(List<Indent> items) {
		this.items = items;
	}
	/*���õ���ҳ����*/
	public void setMaxPageAmount(int maxPageAmount) {
		this.maxPageAmount = maxPageAmount;
	}
	
	public void calculatePage(){
		//������ҳ��
		if(this.allRowsAmount % this.pageSize ==0){
			this.allPageAmount=this.allRowsAmount/this.pageSize;
		}else{
			this.allPageAmount=this.allRowsAmount/this.pageSize+1;
		}
		//������ҳ
		this.firstPage=1;
		//����ĩҳ
		this.lastPage=this.allPageAmount;
		if(this.currentPage *pageSize <allRowsAmount){
			this.currentPageEndRow =this.currentPage*pageSize;
			this.currentPageStartRow =(this.currentPage-1)*pageSize+1;
		}else{
			this.currentPageEndRow =this.allRowsAmount;
			this.currentPageStartRow =(this.allPageAmount-1)*pageSize+1;
			if(this.currentPageStartRow <0){
				this.currentPageStartRow=0;
			}
		}
		//����ǰһҳ
		if(this.currentPage >1){
			this.prevPage=this.currentPage-1;
		}else{
			this.prevPage=this.currentPage;
		}
		//������һҳ
		if(this.currentPage <this.lastPage){
			this.nextPage=this.currentPage+1;
		}else{
			this.nextPage=this.lastPage;
		}
		//�������ֵ���ҳ
		startPageNum =Math.max(this.currentPage-maxPageAmount/2, firstPage);
		endPageNum =Math.min(startPageNum+maxPageAmount, lastPage);
		if(endPageNum-startPageNum <maxPageAmount){
			startPageNum =Math.max(endPageNum -maxPageAmount , 1);
		}
		for(int i=startPageNum ;i<=endPageNum;i++){
			showPageNums.add(i);
		}
	}
	
	//����get�����Ƕ����ṩ�ķ���������ȡ����ֵ
	public Integer getPageSize() {
		return pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public Integer getAllRowsAmount() {
		return allRowsAmount;
	}

	public List<?> getItems() {
		return items;
	}

	public Integer getAllPageAmount() {
		return allPageAmount;
	}

	public Integer getCurrentPageStartRow() {
		return currentPageStartRow;
	}

	public Integer getCurrentPageEndRow() {
		return currentPageEndRow;
	}

	public Integer getFirstPage() {
		return firstPage;
	}

	public Integer getLastPage() {
		return lastPage;
	}

	public Integer getPrevPage() {
		return prevPage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public Integer getStartPageNum() {
		return startPageNum;
	}

	public Integer getEndPageNum() {
		return endPageNum;
	}

	public Integer getMaxPageAmount() {
		return maxPageAmount;
	}

	public List<Integer> getShowPageNums() {
		return showPageNums;
	}

	@Override
	public String toString() {
		return "PageUtil [pageSize=" + pageSize + ", currentPage="
				+ currentPage + ", allRowsAmount=" + allRowsAmount + ", ÿҳ����items="
				+ items + ", allPageAmount=" + allPageAmount
				+ ", currentPageStartRow=" + currentPageStartRow
				+ ", currentPageEndRow=" + currentPageEndRow + ", firstPage="
				+ firstPage + ", lastPage=" + lastPage + ", prevPage="
				+ prevPage + ", nextPage=" + nextPage + ", startPageNum="
				+ startPageNum + ", endPageNum=" + endPageNum + ", maxPageAmount="
				+ maxPageAmount + ", ҳ��list=" + showPageNums + "]";
	}
	
	public static void main(String[] args) {
		List<String> items =new ArrayList<String>();
		for(int i=0;i<10;i++){
			items.add("str"+i);
		}
		PageUtil pageUtil =new PageUtil();
		pageUtil.setCurrentPage(1);
		//pageUtil.setItems(items);
		pageUtil.setAllRowsAmount(33);
		pageUtil.calculatePage();
		System.out.println(pageUtil);
	}
}
