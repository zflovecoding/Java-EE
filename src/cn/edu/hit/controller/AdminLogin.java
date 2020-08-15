package cn.edu.hit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hit.dao.AdminDao;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String userid = request.getParameter("userid");
		 String pwd = request.getParameter("pwd");
		 AdminDao dao = new AdminDao();
		 boolean flag = dao.login(userid, pwd);
		 if(flag)
		 {
			 HttpSession session = request.getSession();
			 session.setAttribute("userid",userid);			 
			 Cookie c=new Cookie("userid",userid);
			 c.setMaxAge(60*60*24*7);
			 response.addCookie(c);
			 response.sendRedirect("Manage.html");
		 }
		 else
		 {
			 response.getWriter().print("Error!");
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
