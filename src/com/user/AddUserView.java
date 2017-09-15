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
		//��ȡ�ӿ��������ݵ�User����
		User user=(User) request.getAttribute("user");
		//��ʾ
		out.println("<img src='images/sjtu2.png' /><hr/>");
		out.println("<a href='/UserManager/MainFrame'>����������</a>");
		out.println("<a href='/UserManager/Login'>�������µ�¼</a>");

		out.println("<h1>����û�<h1>"+
		"<form action='/UserManager/UserProcServlet?type=addUser' method='post'>");
		out.println("<table border=1 bordercolor=green cellspacing=0 width=500px>");
		out.println("<tr><td>�û�id</td><td>"+"<input type='text' name='id'/></td></tr><tr><td>"
				+ "�û���</td><td>"+"<input type='text' name='username'/></td></tr><tr><td>"
				+ "�ʼ�</td><td><input type='text' name='email' /></td></tr><tr><td>"
				+ "����</td><td><input type='text' name='grade' /></td></tr><tr><td>"
				+ "����</td><td><input type='text' name='passwd'/></td></tr>"
				+"<tr><td><input type='submit' value='����û�'></td> <td><input type='reset' value='������д'></td>"
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
