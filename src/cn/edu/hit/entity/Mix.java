package cn.edu.hit.entity;

public class Mix {
  public Mix(String userid, String gname) {
		super();
		this.userid = userid;
		this.gname = gname;
	}
public Mix() {
		super();
		// TODO Auto-generated constructor stub
	}
private String userid;
  private String gname;
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
  
}
