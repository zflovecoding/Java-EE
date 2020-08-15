package cn.edu.hit.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 
import cn.edu.hit.entity.tGoods;
import cn.edu.hit.utils.DbUtils;
public class tGoodsDao {
	public void add(tGoods s)   //½ø»õ
	{
	    	  String gname = s.getGname(); 
	    	  float unitprice = s.getUnitprice();
	    	  int number = s.getNumber();
	    	  String type = s.getType();
	          String sql = "update goods set number = "+number+" ,unitprice = '"+unitprice+"',type= '"+type+"' where gname = '"+gname+"'" ;		          
	          DbUtils du = new  DbUtils();
	          du.executeUpdate(sql);
	          du.close();
	}
	public List<tGoods> gettGoods(String sql){
    	  DbUtils du = new  DbUtils();
          ResultSet rs = du.executeQuery(sql);
          List<tGoods> goodsList = new ArrayList<>();
          String gname = null;
    	  float unitprice = 0 ;
    	  int number =  0;
    	  String type = null;
    	  try {
			while(rs.next()) {
	              gname= rs.getString(1);
	              unitprice = rs.getFloat(2);
	              number = rs.getInt(3);
	              type = rs.getNString(4);
		          goodsList.add(new  tGoods(gname,unitprice,number,type));
			  }
			du.close();
			return goodsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
          
      }
	public tGoods getByGname(String gname) {
    	  DbUtils du = new  DbUtils();
    	  float  unitprice = 0;
          int number = 0;
    	  String type =null;
    	  String sql = "select * from  goods where gname = '" + gname + "'"; 
          ResultSet rs = du.executeQuery(sql);
    	  try {
			 if(rs.next()) {				 				   
	             unitprice= rs.getFloat(2);
	              number = rs.getInt(3);
	              type =  rs.getString(4);
			  }
			 
			du.close();
		    return  new tGoods(gname,unitprice,number,type);
			 
    	  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
      }
	public void remove(String gname) {
  	  String sql = " delete from goods where gname = '"+gname+ "'";
      DbUtils du = new  DbUtils();
      du.executeUpdate(sql);
      du.close();
    }
}
