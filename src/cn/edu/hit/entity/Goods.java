package cn.edu.hit.entity;

public class Goods {
	private String gname;
	private float unitprice;
	private int number;
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
public Goods(String gname, float unitprice, int number) {
		super();
		this.gname = gname;
		this.unitprice = unitprice;
		this.number = number;
	}
public String getGname() {
	return gname;
}
public void setGname(String gname) {
	this.gname = gname;
}
public float getUnitprice() {
	return unitprice;
}
public void setUnitprice(float unitprice) {
	this.unitprice = unitprice;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
  
   
}
