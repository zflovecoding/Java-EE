package cn.edu.hit.entity;

public class Ulog {
	
	private String userid;
	private String pwd;
	public Ulog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ulog(String userid, String pwd) {
		super();
		this.userid = userid;
		this.pwd = pwd;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
