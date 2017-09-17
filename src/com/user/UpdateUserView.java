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
@WebServlet("/UpdateUserView")
public class UpdateUserView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserView() {
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
	    User theuser=(User) request.getSession().getAttribute("user");
		if(theuser==null) {
			request.setAttribute("err","请输入用户名和密码登录");
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		}
		//获取从控制器传递的User对象
		User user=(User) request.getAttribute("user");
		//显示
		out.println("<img src='images/sjtu2.png' /><hr/>");
		out.println("<a href='/UserManager/MainFrame'>返回主界面</a>");
		out.println("<a href='/UserManager/Login'>返回重新登录</a>");
		if(user==null) return;
		out.println("<h1>修改用户<h1>"+
		"<form action='/UserManager/UserProcServlet?type=update' method='post'>");
		out.println("<table border=1 bordercolor=green cellspacing=0 width=500px>");
		out.println("<tr><td>id</td><td><input type='text' name='id' readonly value='"+user.getId()+"'/></td></tr><tr><td>"
				+ "用户名</td><td>"+"<input type='text' name='username' value='"+user.getName()+"'/></td></tr><tr><td>"
				+ "邮件</td><td><input type='text' name='email' value='"+user.getEmail()+"'/></td></tr><tr><td>"
				+ "级别</td><td><input type='text' name='grade' value='"+user.getGrade()+"'/></td></tr><tr><td>"
				+ "密码</td><td><input type='text' name='passwd' value='"+user.getPwd()+"'/></td></tr>"
				+"<tr><td><input type='submit' value='修改用户'></td> <td><input type='reset' value='重新填写'></td>"
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
