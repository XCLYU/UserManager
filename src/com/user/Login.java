package com.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html);charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.println("<img src='images/sjtu1.png' /><hr/>");
		out.println("<h1>用户登录<h1>");
		out.println("<form action='/UserManager/LoginProcServlet' method='post'>");
		out.println("账户id：<input type='text' name='id'/><br/>");
		out.println("密码：<input type='password' name='password'/><br/>");
		out.println("<input type='submit' value='登录'/> <br/>");
		out.println("</form>");
		out.println("<h3>联系方式： 徐汇-浩然高科技大楼4楼 62932901 闵行-图书信息楼(新图书馆西侧) 34206060</h3>");
	  
		if(request.getAttribute("err")!=null) {
			out.println("<font color='red'>"+request.getAttribute("err").toString()+"</font>");
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
