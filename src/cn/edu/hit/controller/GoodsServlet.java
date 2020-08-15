package cn.edu.hit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hit.dao.GoodsDao;
import cn.edu.hit.dao.OrderDao;
import cn.edu.hit.entity.Goods;
import cn.edu.hit.entity.Order;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/GoodsServlet")
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String from = request.getParameter("from");
		String from1 = request.getParameter("from1");
		
		 if(from.equals("addgoods"))
		 {
		 String gname = request.getParameter("gname");
		 float unitprice = Float.parseFloat(request.getParameter("unitprice"));
		 int number = Integer.parseInt(request.getParameter("number"));
		 int addnumber =  Integer.parseInt(request.getParameter("addnumber"));
		 int num = number + addnumber;
		 GoodsDao dao = new GoodsDao();
		 dao.add(new Goods(gname,unitprice,num));
		 response.sendRedirect("adgoodslist.jsp");
	     }
		 else if(from.equals("buygoods"))
		 {
			 String gname = request.getParameter("gname");
			 float unitprice = Float.parseFloat(request.getParameter("unitprice"));
			 int number = Integer.parseInt(request.getParameter("number"));
			 int minusnumber =  Integer.parseInt(request.getParameter("minusnumber"));
			 int num = number - minusnumber;
			 GoodsDao dao = new GoodsDao();
			 dao.add(new Goods(gname,unitprice,num));
			 response.sendRedirect("goodslist.jsp");
		 }
		 if(from1.equals("order"))
		 {
			 
			 String userid = request.getParameter("userid");
			 
			 String gname = request.getParameter("gname");
			 float unitprice = Float.parseFloat(request.getParameter("unitprice"));
			 int minusnumber =  Integer.parseInt(request.getParameter("minusnumber"));
			 OrderDao dao = new OrderDao();
			 float numplus = unitprice*minusnumber;
			 dao.add(new Order(userid,gname,unitprice,minusnumber,numplus));	
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
