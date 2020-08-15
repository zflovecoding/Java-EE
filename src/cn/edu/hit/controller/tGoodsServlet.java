package cn.edu.hit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hit.dao.tGoodsDao;
import cn.edu.hit.entity.tGoods;

/**
 * Servlet implementation class tGoodsServlet
 */
@WebServlet("/tGoodsServlet")
public class tGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tGoodsServlet() {
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
		if(from.equals("modify"))
		 {
			 String gname = request.getParameter("gname");
			 float unitprice = Float.parseFloat(request.getParameter("unitprice"));
			 int number = Integer.parseInt(request.getParameter("number"));
			 String type = request.getParameter("type");
             tGoodsDao dao = new tGoodsDao();
			 dao.add(new tGoods(gname,unitprice,number,type));
			 response.sendRedirect("adgoodslist.jsp");
		 }
		else if(from.equals("remove"))
		{
			String gname = request.getParameter("gname");
            tGoodsDao dao = new tGoodsDao();
			dao.remove(gname);
			response.sendRedirect("adgoodslist.jsp");
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
