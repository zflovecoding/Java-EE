package cn.edu.hit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hit.dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		 LoginDao dao = new LoginDao();
		 boolean flag = dao.login(userid, pwd);
		 if(flag)
		 {
			 HttpSession session = request.getSession();
			 session.setAttribute("userid",userid);			 
			 Cookie c=new Cookie("userid",userid);
			 c.setMaxAge(60*60*24*7);
			 response.addCookie(c);
			 response.sendRedirect("goodslist.jsp");
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
