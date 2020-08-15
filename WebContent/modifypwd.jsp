<%@ page language="java" import="cn.edu.hit.dao.*,java.util.*,cn.edu.hit.entity.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	 String userid = (String)session.getAttribute("userid");
     if(userid==null)
     {
    	 response.sendRedirect("adminlogin.jsp");
    	 return;
     }
%>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>修改密码</title>
	</head>
	<body>
	<%
	String userid0 = request.getParameter("userid");
	UlogDao  dao = new UlogDao();
	Ulog user = dao.getByUserid1(userid0);
	String pwd = user.getPwd();
	%>
	<form action="UserServlet" method="post">
	         <table border="1" align="center">
	          	<tr>
	          	   <td width="39" height="30">账号</td>
	          	   <td width="175"><input type="text" name="userid" value = "<%=userid%>"readonly/></td>
	          	</tr>
	          	<tr>
	          	   <td height="33">新密码</td>
	          	   <td><input type="password" name="pwd"  /></td>
	          	</tr>
	          	<tr>
	          		<td height="34"></td>
	          		<td><input type="submit" value="修改"  onclick="return confirm('确定要修改吗？')"/></td>
	          	</tr>
   	  </table>
	         <input type = "hidden" name = "from" value= "modifypwd" />
    </form>
	</body>
</html>