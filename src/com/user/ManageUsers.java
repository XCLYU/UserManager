package com.user;

import com.user.domain.*;
import com.user.service.UsersService;
import com.user.util.SqlHelper;

import jdk.internal.cmm.SystemResourcePressureImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManageUsers
 */
@WebServlet("/ManageUsers")
public class ManageUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html);charset=utf-8");response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		//javascript
		out.println("<script type= 'text/javascript' language='javascript'>"
				+ "function turnToPage(){"
				+ "var page=document.getElementById('page');"	
				+ "window.open('/UserManager/ManageUsers?page='+page.value,'_self');}"
				+ "function confirmDel(){return window.confirm('are you sure to delete?');}"
				+"</script>");
		
		//�����ҳ�������
		int page=1;
		if(request.getParameter("page")!=null) page=Integer.parseInt(request.getParameter("page"));
		int pageSize=3;
		int pageCount=1;
		int rowCount=1;
		
		UsersService usersService=new UsersService();
		pageCount=usersService.getPageCount(pageSize);
		
		out.println("<img src='images/sjtu2.png' /><hr/>");
		out.println("��ӭ"+"xx"+"��¼");	
		out.println("<a href='/UserManager/MainFrame'>����������</a>");
		out.println("<a href='/UserManager/Login'>�������µ�¼</a>");
		out.println("<table border=1 bordercolor=green cellspacing=0 width=500px>");
		out.println("<tr><th>id</th><th>�û���</th><th>�ʼ�</th><th>����</th></tr>");
		
		//�õ���ҳ��users
		ArrayList<User> arrayList=usersService.getUsersByPage(page,pageSize);
		for(User user:arrayList) {
			out.println("<tr><td>"+user.getId()+
					"</td>"+"<td>"+user.getName()+
					"</td><td>"+user.getEmail()+
					"</td><td>"+user.getGrade()+
					"</td><td><a onClick='return confirmDel();' href='/UserManager/UserProcServlet?type=delete&id="+user.getId()+"'>ɾ��</a></td>"
					+"<td><a href='/UserManager/UserProcServlet?type=gotoUpdateView&id="+user.getId()+"'>�޸��û�</a></td></tr>");
		}
		
		out.println("</table>");
		for(int i=1;i<=pageCount;i++) {
			out.println("<a href='/UserManager/ManageUsers?page="+i+"'><"+i+"></a>");
		}
		out.println("��ת�� <input type='text' id='page' name='page'/> "
				+ "<input type='button' onClick='turnToPage()' value='��'/>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
