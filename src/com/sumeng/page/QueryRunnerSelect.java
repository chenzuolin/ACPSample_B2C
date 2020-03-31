package com.sumeng.page;

public class QueryRunnerSelect {
	private String wineshopName;
	private String indentType;
	private int minPrice;
	private int maxPrice;
	private String startTime;
	private String endTime;
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getWineshopName() {
		return wineshopName;
	}
	public void setWineshopName(String wineshopName) {
		this.wineshopName = wineshopName;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	public int getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getIndentType() {
		return indentType;
	}
	public void setIndentType(String indentType) {
		this.indentType = indentType;
	}
	@Override
	public String toString() {
		return "QueryRunnerSelect [wineshopName=" + wineshopName + ", indentType=" + indentType + ", minPrice="
				+ minPrice + ", maxPrice=" + maxPrice + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	
}
