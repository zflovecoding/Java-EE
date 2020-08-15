  <%@ page language="java" import="cn.edu.hit.dao.*,java.util.*,cn.edu.hit.entity.*"  contentType="text/html; charset= UTF-8"  pageEncoding="UTF-8"%>
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
<title>用户信息</title>
</head>
<body>

<table width="687" border="1" align="center">
  <tr>
    <td width="160">账号</td>
    <td width="67">姓名</td>
    <td width="104">年龄</td>
    <td width="98">性别</td>    
    <td width="128">地址</td>
    <td width="41">修改</td>
    <td width="43">删除</td>
  </tr>
  <%
  UserDao dao = new UserDao();
  List<User> userList = dao.getUsers("select * from userinfo");
  String userid1,uname,gender,address;
  int age;
  for(int i=0;i<userList.size();i++)
  {
     userid1=userList.get(i).getUserid();
	 uname=userList.get(i).getUname();
	 gender=userList.get(i).getGender();
	 age=userList.get(i).getAge();
	 address=userList.get(i).getAddress();
  %>
  <tr>
    <td><%=userid1%></td>
    <td><%=uname%></td>
    <td><%=age%></td>
    <td><%=gender%></td>  
    <td><%=address%></td>
    <td><a href="modify.jsp?userid=<%=userid1%>">修改</a></td>
    <td><a href="UserServlet?from=remove&userid=<%=userid1%>"  onclick="return confirm('确定要删除吗？')">删除</a></td>
  </tr>
  <%
  }    //java语句，for的另一半大括号。
  %>
</table>
</body>
</html>