<%@ page language="java" import="cn.edu.hit.dao.*,java.util.*,cn.edu.hit.entity.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单查询</title>
</head>
<body>
    <%
    	String userid = request.getParameter("userid");
        String gname = request.getParameter("gname");
	    GoodsDao  dao = new GoodsDao();
        Goods g = dao.getByGname(gname); 
        OrderDao dao1 = new OrderDao();
        Mix m = new Mix(userid,gname); //为了确保某人某物
        Order o = dao1.getByMix(m);
	    float unitprice = g.getUnitprice();	    
	    int minusnumber = o.getMinusnumber(); 
	    float num = o.getNum();
    %>
    <form action="GoodsServlet" method="post">
    <div align="center">
      <table border="1">
        <tr>
          <td>用户ID</td>
 	        <td><input type="text" name="userid" value = "<%=userid%>"readonly/></td>
     	  </tr>
        <tr>
        <tr>
          <td>商品名称</td>
 	        <td><input type="text" name="gname" value = "<%=gname%>"readonly/></td>
     	  </tr>
        <tr>
          <td>商品单价</td>
 	        <td><input type="text" name="unitprice" value = "<%=unitprice%>"readonly/></td>
     	</tr>
          <tr>
          <td>已购买该商品数量</td>
 	        <td><input type="text" name="minusnumber" value = "<%=minusnumber%>"readonly/></td>
     	  </tr>   
     	  <tr>
          <td>花费总金额</td>
 	        <td><input type="text" name="num" value = "<%=num%>"readonly/></td>
     	  </tr>    
     	  
        </table>
       
       
      </div>
</form>
</body>
</html>