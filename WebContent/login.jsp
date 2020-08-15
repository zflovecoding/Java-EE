<%@ page language="java" import="cn.edu.hit.dao.*,java.util.*,cn.edu.hit.entity.*"  contentType="text/html; charset= UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="text/html; charset=UTF-8" />
<title>登录/注册</title>
</head>
<body>
<a href  ="add.html">新用户注册</a>
<%
Cookie[] cookies = request.getCookies();
String userid = "";
for(int i=0;i<cookies.length;i++)
{
	if(cookies != null)		
	{
		Cookie c = cookies[i];
		if(c.getName().equals("userid"))
		{
			userid = c.getValue(); 
		}
	}
}
%>
<form name="form1" method="post" action="LoginServlet">
   <div align="center">
     <table width="351" border="1">
       <tr>
         <td width="107">用户ID</td>
        <td width="228"><label>
          <input name="userid" type="text" id="userid" value="<%=userid%>">
         </label></td>
      </tr>
       <tr>
         <td height="24">密码
         <label></label></td>
        <td><label>
          <input name="pwd" type="password" id="pwd">
         </label></td>
      </tr>
       <tr>
         <td>&nbsp;</td>
        <td><label>
          <input type="submit" name="Submit" value="登录">
          <input type="checkbox" name="checkbox" value="checkbox">
        记住我</label></td>
      </tr>
      </table>
   </div>
</form>
</body>
</html>
