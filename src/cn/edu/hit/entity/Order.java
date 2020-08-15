package cn.edu.hit.entity;

public class Order {
	private String userid;
	private String gname;
	private float unitprice;
	private int minusnumber;
	private float num;
	public Order(String userid, String gname, float unitprice, int minusnumber, float num) {
		super();
		this.userid = userid;
		this.gname = gname;
		this.unitprice = unitprice;
		this.minusnumber = minusnumber;
		this.num = num;
	}
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public int getMinusnumber() {
		return minusnumber;
	}
	public void setMinusnumber(int minusnumber) {
		this.minusnumber = minusnumber;
	}
	public float getNum() {
		return num;
	}
	public void setNum(float num) {
		this.num = num;
	}
 
 
}
