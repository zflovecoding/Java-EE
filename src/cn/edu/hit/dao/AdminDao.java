package cn.edu.hit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.hit.utils.DbUtils;

public class AdminDao {
    public boolean login(String userid,String pwd)
    {
    	boolean flag = false;
    	int count = 0;
    	DbUtils du = new DbUtils();
        ResultSet rs = du.executeQuery("select count(*) from admin where userid = '"+userid+"'and pwd = '"+pwd+"'");       	
        try {
			rs.next();
			count = rs.getInt(1);  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return count>0?true:false;
    }
}
