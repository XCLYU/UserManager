package com.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.domain.User;

/**
 * Servlet implementation class UpdateUserView
 */
@WebServlet("/AddUserView")
public class AddUserView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserView() {
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
		//获取从控制器传递的User对象
		User user=(User) request.getAttribute("user");
		//显示
		out.println("<img src='images/sjtu2.png' /><hr/>");
		out.println("<a href='/UserManager/MainFrame'>返回主界面</a>");
		out.println("<a href='/UserManager/Login'>返回重新登录</a>");

		out.println("<h1>添加用户<h1>"+
		"<form action='/UserManager/UserProcServlet?type=addUser' method='post'>");
		out.println("<table border=1 bordercolor=green cellspacing=0 width=500px>");
		out.println("<tr><td>用户id</td><td>"+"<input type='text' name='id'/></td></tr><tr><td>"
				+ "用户名</td><td>"+"<input type='text' name='username'/></td></tr><tr><td>"
				+ "邮件</td><td><input type='text' name='email' /></td></tr><tr><td>"
				+ "级别</td><td><input type='text' name='grade' /></td></tr><tr><td>"
				+ "密码</td><td><input type='text' name='passwd'/></td></tr>"
				+"<tr><td><input type='submit' value='添加用户'></td> <td><input type='reset' value='重新填写'></td>"
				+ "</form>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
