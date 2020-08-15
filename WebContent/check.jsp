 <%@ page language="java" import="cn.edu.hit.dao.*,java.util.*,cn.edu.hit.entity.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看销售额统计</title>
</head>
	<body>
	    <table width="687" border="1" align="center">
  <tr>
    <td width="160">用户账号</td>
    <td width="67">商品名称</td>
    <td width="104">商品单价</td>
    <td width="98">用户购买该商品数量</td>    
    <td width="128">销售额</td>
    <td>总计</td>
     
  </tr>
  <%
  OrderDao dao = new OrderDao();
  List<Order> orderList = dao.getOrders("select * from orderlist");
  String userid,gname;
  int number;
  float num,unitprice,numpro=0;
  for(int i=0;i<orderList.size();i++)
  {
     userid=orderList.get(i).getUserid();
	 gname=orderList.get(i).getGname();
	 unitprice=orderList.get(i).getUnitprice();
	 number=orderList.get(i).getMinusnumber();
	 num = orderList.get(i).getNum();
	 numpro+=num;
  %>
  <tr>
    <td><%=userid%></td>
    <td><%=gname%></td>
    <td><%=unitprice%></td>
    <td><%=number%></td>  
    <td><%=num%></td>
     
  </tr>
  <%
  }    //java语句，for的另一半大括号。
  %>
  <tr>
    <td><%=numpro%></td>
  </tr>
</table>   
	</body>
</html>