package cn.edu.hit.entity;


public class User {
 private String userid;
 private String uname;
 private String gender;
 private int age;
 private String address;
public  User() {
	//super();
}
public User( String userid,  String uname,int age, String gender, String address) {
	super();
	this.userid = userid;
	this.uname = uname;
	this.gender = gender;
	this.age = age;
	this.address = address;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

}
 
