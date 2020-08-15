 <%@ page language="java" import="cn.edu.hit.dao.*,java.util.*,cn.edu.hit.entity.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改商品信息</title>
</head>
<body>
	<%
	String gname = request.getParameter("gname");
	tGoodsDao  dao = new tGoodsDao();
	tGoods user = dao.getByGname(gname);
	float unitprice = user.getUnitprice();
	int number = user.getNumber();
	String type = user.getType();
	%>
	    <form action="tGoodsServlet" method="post">
	         <table border="1">
	          	<tr>
	          	   <td>商品名称</td>
	          	   <td><input type="text" name="gname" value = "<%=gname%>"readonly/></td>
	          	</tr>
	          	<tr>
	          	   <td>商品销售单价</td>
	          	   <td><input type="text" name="unitprice" value = "<%=unitprice%>"/></td>
	          	</tr>
	          	<tr>
	          	   <td>商品数量</td>
	          	   <td><input type="text" name="number" value ="<%=number%>"readonly/></td>
	          	</tr>
       	
	          	<tr>
	          	   <td>商品类别</td>
	          	   <td><input type="text" name="type" value ="<%=type%>"/></td>
	          	</tr>
	          	 
	          	<tr>
	          		<td></td>
	          		<td><input type="submit" value="修改"  onclick="return confirm('确定要进行修改吗？')"/></td>
	          	</tr>
	         </table>
	         <input type = "hidden" name = "from" value= "modify" />
	    </form>
</body>
</html>