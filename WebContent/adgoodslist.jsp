 <%@ page language="java" import="cn.edu.hit.dao.*,java.util.*,cn.edu.hit.entity.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品</title>
</head>
<body>
<table width="346" border="1" align="center">
  <tr>
    <td width="65" height="42">商品名称</td>
    <td width="33">单价</td>
    <td width="65">剩余数量</td>
    <td width="65">商品种类</td>
    <td width="44">进货</td>
    <td width="105" height="42">修改商品信息</td>
    <td width="44">下架</td>
  </tr>
    
  <%
  tGoodsDao dao = new tGoodsDao();
  List<tGoods> goodsList = dao.gettGoods("select * from  goods");
  String gname;
  float unitprice;
  int number;
  String type;
  for(int i=0;i<goodsList.size();i++)
  {
      
	 gname=goodsList.get(i).getGname();
	 unitprice = goodsList.get(i).getUnitprice(); 
	 number=goodsList.get(i).getNumber();
	 type = goodsList.get(i).getType(); 
  %>
  <tr>     
    <td height="32"><%=gname%></td>
    <td><%=unitprice%></td>
    <td><%=number%></td>
    <td><%=type%></td>
    <td><a href="addgoods.jsp?gname=<%=gname%>">进货</a></td>
    <td><a href="goodsmodify.jsp?gname=<%=gname%>">修改</a></td>
    <td><a href="tGoodsServlet?from=remove&gname=<%=gname%>"  onclick="return confirm('确定要下架该商品吗？')">下架</a></td>
  </tr>
  <%
  }    //java语句，for的另一半大括号。
  %>
</table> 
<a href="check.jsp">查看销售额</a>
<a href="type.html">商品分类管理</a>
</body>
</html>