   <%@ page language="java" import="cn.edu.hit.dao.*,java.util.*,cn.edu.hit.entity.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>进货</title>
</head>
<body>
        <div align="center">
    <%
	String gname = request.getParameter("gname");
	GoodsDao  dao = new GoodsDao();  
	Goods g = dao.getByGname(gname);    
	float unitprice = g.getUnitprice();
	int number = g.getNumber();
	int addnumber = 0;
	%>
        </div>
        <form action="GoodsServlet" method="post">
	         <div align="center">
	           <table border="1">
	             <tr>
	               <td>商品名称</td>
          	        <td><input type="text" name="gname" value = "<%=gname%>"readonly/></td>
	          	  </tr>
	             <tr>
	               <td>商品售出时单价</td>
          	        <td><input type="text" name="unitprice" value = "<%=unitprice%>"readonly/></td>
	          	  </tr>
	             <tr> 
	               <td>商品现有数量</td>
          	        <td><input type="text" name="number" value = "<%=number%>"readonly/></td>
	          	  </tr>
	             <tr>
	               <td>进货量</td>
          	        <td><input type="text" name="addnumber" /></td>
	          	  </tr>
	             
	             <tr>
	               <td></td>
          		     <td><input type="submit" value="进货"  onclick="return confirm('确定要进这些货物吗？')"/></td>
	          	  </tr>
	             </table>
	           <input type = "hidden" name = "from" value= "addgoods" />
	            
               </div>
        </form>
</body>
</html>