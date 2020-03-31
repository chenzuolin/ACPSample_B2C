package com.sumeng.service;

public class WineShopAllIndent {

	private int Indent_ID;
	private String Indent_Time;
	private String Indent_Status;
	private String Indent_Type;
	private String Indent_PayID;
	private String Indent_remark;
	private String total;
	public int getIndent_ID() {
		return Indent_ID;
	}
	public void setIndent_ID(int indent_ID) {
		Indent_ID = indent_ID;
	}
	public String getIndent_Time() {
		return Indent_Time;
	}
	public void setIndent_Time(String indent_Time) {
		Indent_Time = indent_Time;
	}
	public String getIndent_Status() {
		return Indent_Status;
	}
	public void setIndent_Status(String indent_Status) {
		Indent_Status = indent_Status;
	}
	public String getIndent_Type() {
		return Indent_Type;
	}
	public void setIndent_Type(String indent_Type) {
		Indent_Type = indent_Type;
	}
	public String getIndent_PayID() {
		return Indent_PayID;
	}
	public void setIndent_PayID(String indent_PayID) {
		Indent_PayID = indent_PayID;
	}
	public String getIndent_remark() {
		return Indent_remark;
	}
	public void setIndent_remark(String indent_remark) {
		Indent_remark = indent_remark;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "WineShopAllIndent [Indent_ID=" + Indent_ID + ", Indent_Time="
				+ Indent_Time + ", Indent_Status=" + Indent_Status
				+ ", Indent_Type=" + Indent_Type + ", Indent_PayID="
				+ Indent_PayID + ", Indent_remark=" + Indent_remark
				+ ", total=" + total + "]";
	}
}
