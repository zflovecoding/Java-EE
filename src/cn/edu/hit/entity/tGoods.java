package cn.edu.hit.entity;

public class tGoods {
	private String gname;
	private float unitprice;
	private int number;
	private String type;
	public tGoods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public tGoods(String gname, float unitprice, int number, String type) {
		super();
		this.gname = gname;
		this.unitprice = unitprice;
		this.number = number;
		this.type = type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
