package cn.edu.hit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hit.dao.UlogDao;
import cn.edu.hit.dao.UserDao;
import cn.edu.hit.entity.Ulog;
import cn.edu.hit.entity.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("userid");  		 
		 if(userid==null)
		 {
			 response.sendRedirect("login.jsp");
		 }
		 String from = request.getParameter("from");
		 if(from.equals("add"))
		 {
		 String userid1 = request.getParameter("userid");
		 String pwd = request.getParameter("pwd");
		 String uname = request.getParameter("uname");
		 String gender = request.getParameter("gender");
		 int age = Integer.parseInt(request.getParameter("age"));
		 String address = request.getParameter("address");
		 UserDao dao = new UserDao();
		 UlogDao dao1 = new UlogDao();
		 dao1.add1(new Ulog(userid1,pwd));
		 dao.add(new  User(userid1,uname,age,gender,address));
		 response.sendRedirect("userlist.jsp");
	}
		 else if(from.equals("modify"))
		 {
			 String userid2 = request.getParameter("userid");
			 String uname = request.getParameter("uname");
			 int age = Integer.parseInt(request.getParameter("age"));
			 String gender = request.getParameter("gender");
			 String address = request.getParameter("address");
			 UserDao dao = new UserDao();
			 dao.modify(new User(userid2,uname,age,gender,address));
			 response.sendRedirect("userlist.jsp");
		 }
		 else if(from.equals("remove")){
			 String userid3 = request.getParameter("userid");
			 UserDao dao = new UserDao();
			 dao.remove(userid3);
			 response.sendRedirect("userlist.jsp");
		 }
		 else if(from.equals("modifypwd"))
		 {
			 String userid5 = request.getParameter("userid");
			 String pwd = request.getParameter("pwd");
			 UlogDao dao = new UlogDao();
			 dao.admodify(new Ulog(userid5,pwd));
			 response.sendRedirect("Manage.html");
		 }
		 else if(from.equals("usermodifypwd"))
		 {
			 String userid6 = request.getParameter("userid");
			 String pwd = request.getParameter("pwd");
			 UlogDao dao = new UlogDao();
			 dao.modify(new Ulog(userid6,pwd));
			 response.sendRedirect("goodslist.jsp");
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
