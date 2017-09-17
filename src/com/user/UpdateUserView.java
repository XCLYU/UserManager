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
			request.setAttribute("err","�������û����������¼");
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		}
		//��ȡ�ӿ��������ݵ�User����
		User user=(User) request.getAttribute("user");
		//��ʾ
		out.println("<img src='images/sjtu2.png' /><hr/>");
		out.println("<a href='/UserManager/MainFrame'>����������</a>");
		out.println("<a href='/UserManager/Login'>�������µ�¼</a>");
		if(user==null) return;
		out.println("<h1>�޸��û�<h1>"+
		"<form action='/UserManager/UserProcServlet?type=update' method='post'>");
		out.println("<table border=1 bordercolor=green cellspacing=0 width=500px>");
		out.println("<tr><td>id</td><td><input type='text' name='id' readonly value='"+user.getId()+"'/></td></tr><tr><td>"
				+ "�û���</td><td>"+"<input type='text' name='username' value='"+user.getName()+"'/></td></tr><tr><td>"
				+ "�ʼ�</td><td><input type='text' name='email' value='"+user.getEmail()+"'/></td></tr><tr><td>"
				+ "����</td><td><input type='text' name='grade' value='"+user.getGrade()+"'/></td></tr><tr><td>"
				+ "����</td><td><input type='text' name='passwd' value='"+user.getPwd()+"'/></td></tr>"
				+"<tr><td><input type='submit' value='�޸��û�'></td> <td><input type='reset' value='������д'></td>"
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
