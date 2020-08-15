package cn.edu.hit.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.hit.entity.User;
import cn.edu.hit.utils.DbUtils;
public class UserDao {
      public void add(User s) {
    	  String userid = s.getUserid();
    	  String uname = s.getUname();
    	  String gender = s.getGender();
    	  int age = s.getAge();
    	  String address = s.getAddress() ;
          String sql = "insert into  userinfo values('"+userid+"','"+uname +"',"+age+",'"+gender+"','"+address+"')";
          DbUtils du = new  DbUtils();
          du.executeUpdate(sql);
          du.close();
      }
      public void remove(String userid) {
    	  String sql = " delete from userinfo where userid = '"+ userid+ "'";
    	  String sql1 = " delete from userlogin where userid = '"+ userid+ "'";
          DbUtils du = new  DbUtils();
          du.executeUpdate(sql);
          du.executeUpdate(sql1);
          du.close();
      }
      public void modify(User s) {
    	  String userid = s.getUserid();
    	  String uname = s.getUname();
    	  int age = s.getAge();
    	  String gender = s.getGender();
    	  String  address = s.getAddress();
          String sql =  "update  userinfo set uname= '" +uname +"', age = " + age +",gender = '"+gender +"',address = '"+address+"' where userid ='"+userid+ "'";   
          DbUtils du = new  DbUtils();
          du.executeUpdate(sql);
          du.close();
      }
      public List<User> getUsers(String sql){
    	  DbUtils du = new  DbUtils();
          ResultSet rs = du.executeQuery(sql);
          List<User> userList = new ArrayList<>();
          String userid = null;
    	  String uname =  null;
    	  String gender =  null;
    	  int age =  0;
    	  String address =  null;
    	  try {
			while(rs.next()) {
				  
				  userid = rs.getString(1);
	              uname= rs.getString(2);
	              age = rs.getInt(3);
	              gender= rs.getString(4); 
	              address = rs.getString(5);
	              userList.add(new  User(userid,uname, age ,gender,address));
			  }
			du.close();
			return userList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
          
      }
      public User getByUserid(String userid) {
    	  DbUtils du = new  DbUtils();
    	  String sql = "select * from  userinfo where userid = '" + userid + "'"; 
          ResultSet rs = du.executeQuery(sql);
          String uname =  null;
    	  String gender =  null;
    	  int age =  0,flag=0;
    	  String  address =  null;
    	  try {
			 if(rs.next()) {				 				   
	              uname= rs.getString(2);
	              age = rs.getInt(3);
	              address = rs.getString(5);
	              gender= rs.getString(4); 	
	              flag=1;
			  }
			 
			du.close();
			
			if(flag == 1) {
				return  new User(userid,uname,age,gender,address);
			}
			else {
				return null;
			}
    	  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
      }
}
