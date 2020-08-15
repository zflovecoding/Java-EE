package cn.edu.hit.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.hit.entity.Goods;
import cn.edu.hit.utils.DbUtils;
public class GoodsDao {
		public void add(Goods s)   //½ø»õ
		{
		    	  String gname = s.getGname(); 
		    	  float unitprice = s.getUnitprice();
		    	  int number = s.getNumber();
		          String sql = "update goods set number = "+number+" where gname = '"+gname+"'" ;		          
		          DbUtils du = new  DbUtils();
		          du.executeUpdate(sql);
		          du.close();
		}
		public List<Goods> getGoods(String sql){
	    	  DbUtils du = new  DbUtils();
	          ResultSet rs = du.executeQuery(sql);
	          List<Goods> goodsList = new ArrayList<>();
	          String gname = null;
	    	  float unitprice = 0 ;
	    	  int number =  0;
	    	  try {
				while(rs.next()) {
		              gname= rs.getString(1);
		              unitprice = rs.getFloat(2);
		              number = rs.getInt(3);
  		              goodsList.add(new  Goods(gname,unitprice,number));
				  }
				du.close();
				return goodsList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	          
	      }
		public Goods getByGname(String gname) {
	    	  DbUtils du = new  DbUtils();
	    	  float  unitprice = 0;
	          int number = 0;
	    	  
	    	  String sql = "select * from  goods where gname = '" + gname + "'"; 
	          ResultSet rs = du.executeQuery(sql);
	          
	    	  try {
				 if(rs.next()) {				 				   
		             unitprice= rs.getFloat(2);
		              number = rs.getInt(3);
		              
				  }
				 
				du.close();
			    return  new Goods(gname,unitprice,number);
				 
	    	  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	      }
}
