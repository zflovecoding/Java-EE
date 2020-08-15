   <%@ page language="java" import="cn.edu.hit.dao.*,java.util.*,cn.edu.hit.entity.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	 String userid = (String)session.getAttribute("userid");
     if(userid==null)
     {
    	 response.sendRedirect("login.jsp");
    	 return;
     }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品</title>
</head>
<body>
<a href="usermodifypwd.jsp">修改密码</a>
<table width="251" border="1" align="center">
  <tr>
    <td width="68" height="43">商品名称</td>
    <td width="44">单价</td>
    <td width="55">剩余数量</td>
    <td width="56"> 购买</td>
  </tr>

  <%
  GoodsDao dao = new GoodsDao();
  List<Goods> goodsList = dao.getGoods("select * from  goods");
  String gname;
  float unitprice;
  int number;
  
  for(int i=0;i<goodsList.size();i++)
  {
      
	 gname=goodsList.get(i).getGname();
	 unitprice = goodsList.get(i).getUnitprice(); 
	 number=goodsList.get(i).getNumber();
	  
  %>
  <tr>     
    <td><%=gname%></td>
    <td><%=unitprice%></td>
    <td><%=number%></td>
    <td><a href="buy.jsp?gname=<%=gname%>&userid=<%=userid%>">购买</a></td> 
    <td><a href="order.jsp?userid=<%=userid%>&gname=<%=gname%>">订单查询</a></td>
  </tr>
  <%
  }  //java语句，for的另一半大括号。 
  %>
  </table>    

</body>
</html>