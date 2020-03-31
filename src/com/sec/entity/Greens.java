package com.sec.entity;

public class Greens  implements Comparable<Greens>{
	private int Greens_ID;
	private String Greens_Name;
	private String Greens_Unit;
	private String Greens_Character;
	private String Greens_Preiod;
	private String Greens_Norms;
	private int Greens_Number;
	private float Greens_Price;
	private float Greens_Market_Price;
	private String Greens_Condition;
	private int Greens_Minnumber;
	private String Greens_Class;
	private int Greens_Price_Num;
	public int getGreens_Price_Num() {
		return Greens_Price_Num;
	}
	public void setGreens_Price_Num(int greens_Price_Num) {
		Greens_Price_Num = greens_Price_Num;
	}
	private int Greens_Grade;
	private String Greens_characteristics;
	private String Greens_tupian;
	public String getGreens_Like() {
		return Greens_Like;
	}
	public void setGreens_Like(String greens_Like) {
		Greens_Like = greens_Like;
	}
	private String Class_Name;
	private String Greens_Like;
	private int Greens_Stop;
	private String BigName;
	private int Greens_Sore;
	private String Greens_Date;
	public String getClass_Name() {
		return Class_Name;
	}
	public void setClass_Name(String class_Name) {
		Class_Name = class_Name;
	}
	public int getGreens_ID() {
		return Greens_ID;
	}
	public void setGreens_ID(int greens_ID) {
		Greens_ID = greens_ID;
	}
	public String getGreens_Name() {
		return Greens_Name;
	}
	public void setGreens_Name(String greens_Name) {
		Greens_Name = greens_Name;
	}
	public String getGreens_Unit() {
		return Greens_Unit;
	}
	public void setGreens_Unit(String greens_Unit) {
		Greens_Unit = greens_Unit;
	}
	public String getGreens_Character() {
		return Greens_Character;
	}
	public void setGreens_Character(String greens_Character) {
		Greens_Character = greens_Character;
	}
	public String getGreens_Preiod() {
		return Greens_Preiod;
	}
	public void setGreens_Preiod(String greens_Preiod) {
		Greens_Preiod = greens_Preiod;
	}
	public String getGreens_Norms() {
		return Greens_Norms;
	}
	public void setGreens_Norms(String greens_Norms) {
		Greens_Norms = greens_Norms;
	}
	public int getGreens_Number() {
		return Greens_Number;
	}
	public void setGreens_Number(int greens_Number) {
		Greens_Number = greens_Number;
	}
	public float getGreens_Price() {
		return Greens_Price;
	}
	public void setGreens_Price(float greens_Price) {
		Greens_Price = greens_Price;
	}
	public float getGreens_Market_Price() {
		return Greens_Market_Price;
	}
	public void setGreens_Market_Price(float greens_Market_Price) {
		Greens_Market_Price = greens_Market_Price;
	}
	public String getGreens_Condition() {
		return Greens_Condition;
	}
	public void setGreens_Condition(String greens_Condition) {
		Greens_Condition = greens_Condition;
	}
	public int getGreens_Minnumber() {
		return Greens_Minnumber;
	}
	public void setGreens_Minnumber(int greens_Minnumber) {
		Greens_Minnumber = greens_Minnumber;
	}
	public String getGreens_Class() {
		return Greens_Class;
	}
	public void setGreens_Class(String greens_Class) {
		Greens_Class = greens_Class;
	}
	public int getGreens_Grade() {
		return Greens_Grade;
	}
	public void setGreens_Grade(int greens_Grade) {
		Greens_Grade = greens_Grade;
	}
		public String getGreens_Recommend() {
		return Greens_Recommend;
	}
	public void setGreens_Recommend(String greens_Recommend) {
		Greens_Recommend = greens_Recommend;
	}
	public String getGreens_Remark() {
		return Greens_Remark;
	}
	public void setGreens_Remark(String greens_Remark) {
		Greens_Remark = greens_Remark;
	}
	private String Greens_Type_Name;

	public String getGreens_Type_Name() {
		return Greens_Type_Name;
	}
	public void setGreens_Type_Name(String greens_Type_Name) {
		Greens_Type_Name = greens_Type_Name;
	}
	
	public String getGreens_tupian() {
		return Greens_tupian;
	}
	public void setGreens_tupian(String greens_tupian) {
		Greens_tupian = greens_tupian;
	}
	public String getGreens_characteristics() {
		return Greens_characteristics;
	}
	public void setGreens_characteristics(String greens_characteristics) {
		Greens_characteristics = greens_characteristics;
	}
	private String Greens_Recommend;
	private String Greens_Remark;
	private String Greens_Time;
	
	public String getGreens_Time() {
		return Greens_Time;
	}
	public void setGreens_Time(String greens_Time) {
		Greens_Time = greens_Time;
	}
	public Greens(int Greens_ID,String Greens_Type_Name,String Greens_Name,String Greens_Unit,String Greens_Character,String Greens_Preiod,String Greens_Norms,
			int Greens_Number,float Greens_Price,float Greens_Market_Price,String Greens_Condition,int Greens_Minnumber,String Greens_Class,int Greens_Grade,String Greens_characteristics,String Greens_Recommend,String Greens_Remark,String Greens_Time) {
		this.Greens_ID = Greens_ID;
		this.Greens_Type_Name = Greens_Type_Name;
		this.Greens_Name = Greens_Name;
		this.Greens_Unit = Greens_Unit;
		this.Greens_Character = Greens_Character;
		this.Greens_Preiod = Greens_Preiod;
		this.Greens_Norms = Greens_Norms;
		this.Greens_Number = Greens_Number;
		this.Greens_Price = Greens_Price;
		this.Greens_Market_Price = Greens_Market_Price;
		this.Greens_Condition = Greens_Condition;
		this.Greens_Minnumber = Greens_Minnumber;
		this.Greens_Class = Greens_Class;
		this.Greens_Grade = Greens_Grade;
		this.Greens_characteristics = Greens_characteristics;
		this.Greens_Recommend = Greens_Recommend;
		this.Greens_Remark = Greens_Remark;
		this.Greens_Time = Greens_Time;
		
	}
	public Greens() {
		// TODO 自动生成的构造函数存根
	}
	public int getGreens_Stop() {
		return Greens_Stop;
	}
	public void setGreens_Stop(int greens_Stop) {
		Greens_Stop = greens_Stop;
	}
	public String getBigName() {
		return BigName;
	}
	public void setBigName(String bigName) {
		BigName = bigName;
	}
	public int getGreens_Sore() {
		return Greens_Sore;
	}
	public void setGreens_Sore(int greens_Sore) {
		Greens_Sore = greens_Sore;
	}
	public String getGreens_Date() {
		return Greens_Date;
	}
	public void setGreens_Date(String greens_Date) {
		Greens_Date = greens_Date;
	}
	@Override
	public String toString() {
		return "Greens [Greens_ID=" + Greens_ID + ", Greens_Name="
				+ Greens_Name + ", Greens_Unit=" + Greens_Unit
				+ ", Greens_Character=" + Greens_Character + ", Greens_Preiod="
				+ Greens_Preiod + ", Greens_Norms=" + Greens_Norms
				+ ", Greens_Number=" + Greens_Number + ", Greens_Price="
				+ Greens_Price + ", Greens_Market_Price=" + Greens_Market_Price
				+ ", Greens_Condition=" + Greens_Condition
				+ ", Greens_Minnumber=" + Greens_Minnumber + ", Greens_Class="
				+ Greens_Class + ", Greens_Price_Num=" + Greens_Price_Num
				+ ", Greens_Grade=" + Greens_Grade
				+ ", Greens_characteristics=" + Greens_characteristics
				+ ", Greens_tupian=" + Greens_tupian + ", Class_Name="
				+ Class_Name + ", Greens_Like=" + Greens_Like
				+ ", Greens_Stop=" + Greens_Stop + ", BigName=" + BigName
				+ ", Greens_Sore=" + Greens_Sore + ", Greens_Date="
				+ Greens_Date + ", Greens_Type_Name=" + Greens_Type_Name
				+ ", Greens_Recommend=" + Greens_Recommend + ", Greens_Remark="
				+ Greens_Remark + ", Greens_Time=" + Greens_Time + "]";
	}
	
	public int compareTo(Greens o) 
	     {
	         if(this.getGreens_Number()>o.getGreens_Number())
	         {
	             return -1;
	         }
	         else if(this.getGreens_Number()<o.getGreens_Number())
	         {
	             return 1;
         }
	         else
	         {
	             return 0;
	         }
	    }

}
