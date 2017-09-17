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
import javax.servlet.http.HttpSession;

import com.user.domain.User;

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
		
		//ȡ��
		User user=(User) request.getSession().getAttribute("user");
		if(user==null) {
			request.setAttribute("err","�������û����������¼");
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		}
		
		out.println("<img src='images/sjtu2.png' /><hr/>");
		out.println("��ӭ"+user.getName()+"��¼");	
		out.println("���ǵ�"+this.getServletConfig().getServletContext().getAttribute("visitcount")+"λ�ÿ�");	
		out.println("<h1>��ѡ����Ҫ���еĲ���</h1>");
		out.println("<a href='/UserManager/ManageUsers'>�����û�</a>");
		out.println("<a href='/UserManager/UserProcServlet?type=gotoAddUser'>����û�</a>");
		out.println("<a href='/UserManager/Login'>  </a>");
		out.println("<a href='/UserManager/Login'>�������µ�¼</a>");
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
