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
		<title>修改用户信息</title>
	</head>
	<body>
	<%
	String userid1 = request.getParameter("userid");
	UserDao  dao = new UserDao();
	User user = dao.getByUserid(userid1);
	String uname = user.getUname();
	int age = user.getAge();
	String gender = user.getGender();
	String address = user.getAddress();	
	%>
	    <form action="UserServlet" method="post">
	         <table border="1">
	          	<tr>
	          	   <td>账号</td>
	          	   <td><input type="text" name="userid" value = "<%=userid1%>"readonly/></td>
	          	</tr>
	          	<tr>
	          	   <td>姓名</td>
	          	   <td><input type="text" name="uname" value = "<%=uname%>"/></td>
	          	</tr>
	          	<tr>
	          	   <td>年龄</td>
	          	   <td><input type="text" name="age" value ="<%=age%>"/></td>
	          	</tr>
	          	<tr>
	          	   <td>性别</td>
	          	   <td>
	          	      <input name="gender" type="radio" value="male"
	          	      <%if(gender.equals("male")) 
	          	    	  out.print("checked=\"checked\""); %>/>male
	          	      <input name="gender" type="radio" value="female"
	          	      <%if(gender.equals("female")) 
	          	    	  out.print("checked=\"checked\""); %>/>female
	          	    </td>
	          	</tr>
	          	
	          	<tr>
	          	   <td>地址</td>
	          	   <td><input type="text" name="address" value ="<%=address%>"/></td>
	          	</tr>
	          	 
	          	<tr>
	          		<td></td>
	          		<td><input type="submit" value="提交"/></td>
	          	</tr>
	         </table>
	         <input type = "hidden" name = "from" value= "modify" />
	    </form>
	</body>
</html>