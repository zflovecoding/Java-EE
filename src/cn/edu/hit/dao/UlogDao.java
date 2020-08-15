package cn.edu.hit.dao;//用作账号和密码使用

import java.sql.ResultSet;
import java.sql.SQLException;
import cn.edu.hit.entity.Ulog;
import cn.edu.hit.utils.DbUtils;

public class UlogDao {
	public void add1(Ulog s) 
	{
	    	  String userid = s.getUserid();
	    	  String pwd = s.getPwd();
	          String sql = "insert into  userlogin values('"+userid+"','"+ pwd +"')";
	          DbUtils du = new  DbUtils();
	          du.executeUpdate(sql);
	          du.close();
	}
	public void modify(Ulog s) {
  	  String userid = s.getUserid();
  	  String pwd = s.getPwd();
  	  String sql =  "update  userlogin set pwd= '" +pwd +"' where userid ='"+userid+ "'";   
      DbUtils du = new  DbUtils();
      du.executeUpdate(sql);
      du.close();
    }
	public void admodify(Ulog s) {
	  	  String userid = s.getUserid();
	  	  String pwd = s.getPwd();
	  	  String sql =  "update  admin set pwd= '" +pwd +"' where userid ='"+userid+ "'";   
	      DbUtils du = new  DbUtils();
	      du.executeUpdate(sql);
	      du.close();
	    }
	public Ulog getByUserid(String userid) {
  	  DbUtils du = new  DbUtils();
  	  String pwd =  null;
  	  String sql = "select * from userlogin where userid = '" + userid + "'"; 
      ResultSet rs = du.executeQuery(sql);
     
  	  int flag=0;
  	  try {
			 if(rs.next()) {				 				   
	              pwd= rs.getString(2);
	              flag=1;
			  }			 
			du.close();		
			 
				return  new Ulog(userid,pwd);
			
			 
  	  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
  	public Ulog getByUserid1(String userid) {
    	  DbUtils du = new  DbUtils();
    	  String pwd =  null;
    	  String sql = "select * from admin where userid = '" + userid + "'"; 
          ResultSet rs = du.executeQuery(sql);
          int flag=0;
    	  try {
  			 if(rs.next()) {				 				   
  	              pwd= rs.getString(2);
  	              flag=1;
  			  }			 
  			du.close();		
  			 
  				return  new Ulog(userid,pwd);
  			
  			 
    	  } catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  			return null;
  		}
}
}


