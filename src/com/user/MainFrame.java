package com.user;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainFrame
 */
@WebServlet("/MainFrame")
public class MainFrame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainFrame() {
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
		
		out.println("<img src='images/sjtu2.png' /><hr/>");
		out.println("欢迎"+"xx"+"登录");		

		out.println("<h1>请选择您要进行的操作</h1>");
		out.println("<a href='/UserManager/ManageUsers'>管理用户</a>");
		out.println("<a href='/UserManager/UserProcServlet?type=gotoAddUser'>添加用户</a>");
		out.println("<a href='/UserManager/Login'>  </a>");
		out.println("<a href='/UserManager/Login'>返回重新登录</a>");
//		out.println("<form action='???' method='post'>");
//		out.println("username:<input type='text' name='username'/>");
//		out.println("password:<input type='password' name='pwd'/>");
//		out.println("<input type='submit' value='submit'/>");
//		out.println("</form>");

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
