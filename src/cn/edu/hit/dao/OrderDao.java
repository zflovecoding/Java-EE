package cn.edu.hit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.hit.entity.Mix;
import cn.edu.hit.entity.Order;
import cn.edu.hit.entity.User;
import cn.edu.hit.utils.DbUtils;

public class OrderDao {
	  public void add(Order s) 
	  {
  	  String userid = s.getUserid();
  	  String gname = s.getGname();
  	  float unitprice = s.getUnitprice();
  	  int number = s.getMinusnumber();
  	  float num = s.getNum();
  	  String sql = "insert into orderlist(userid,gname,unitprice,number,num) values('"+userid+"','"+gname +"',"+unitprice+","+number+","+num+")";
  	   
      DbUtils du = new  DbUtils();
      du.executeUpdate(sql);
      du.close();
    }
	public Order getByUserid(String userid) {
  	  DbUtils du = new  DbUtils();
  	  String sql = "select * from  orderlist where userid = '" + userid + "'"; 
      ResultSet rs = du.executeQuery(sql);
      String gname =  null;
  	  float unitprice = 0;
  	  int number =  0;
  	  float num = 0;
  	  try {
			 if(rs.next()) {				 				   
	              gname= rs.getString(2);
	              unitprice= rs.getFloat(3);
	              number = rs.getInt(4);
	              num = rs.getFloat(5);
			  }			 
			du.close();					 
		    return  new Order(userid,gname,unitprice,number,num);
			} 
  	        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public Order getByMix(Mix m) {
	  	  DbUtils du = new  DbUtils();
	  	  String sql = "select * from  orderlist where userid = '" +m.getUserid() + "'and gname = '"+m.getGname()+"'"; 
	      ResultSet rs = du.executeQuery(sql);
	      String gname =  null;
	  	  float unitprice = 0;
	  	  int number =  0;
	  	  float num = 0;
	  	  try {
				 if(rs.next()) {				 				   
		              gname= rs.getString(2);
		              unitprice= rs.getFloat(3);
		              number = rs.getInt(4);
		              num = rs.getFloat(5);
				  }			 
				du.close();					 
			    return  new Order(m.getUserid(),m.getGname(),unitprice,number,num);
				} 
	  	        catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
	public List<Order> getOrders(String sql){
  	  DbUtils du = new  DbUtils();
      ResultSet rs = du.executeQuery(sql);
      List<Order> orderList = new ArrayList<>();
      String userid = null;
  	  String gname =  null;
  	  float unitprice =  0;
  	  int number =  0;
  	  float num = 0;
  	  try {
			while(rs.next()) {
				  
				  userid = rs.getString(1);
	              gname= rs.getString(2);
	              unitprice = rs.getFloat(3);
	              number= rs.getInt(4); 
	              num = rs.getFloat(5);
	              orderList.add(new  Order(userid,gname, unitprice ,number,num));
			  }
			du.close();
			return orderList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
        
    }
}
