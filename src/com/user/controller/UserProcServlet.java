package com.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.UpdateUserView;
import com.user.domain.User;
import com.user.service.UsersService;

/**
 * Servlet implementation class DelProcServlet
 */
@WebServlet("/UserProcServlet")
public class UserProcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProcServlet() {
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
		String type=request.getParameter("type");
		
		UsersService usersService=new UsersService();
	
		if("delete".equals(type)) {
			String id=request.getParameter("id");
			if(usersService.delUser(id)) {
				request.setAttribute("info", "ɾ���ɹ�!");
				request.getRequestDispatcher("/Ok").forward(request, response);
			}
			else {
				request.setAttribute("info", "ɾ��ʧ��!");
				request.getRequestDispatcher("/Err").forward(request, response);
			}
		}else if("gotoUpdateView".equals(type)) {
			String id=request.getParameter("id");
			User user=usersService.getUserById(id);
		    request.setAttribute("user", user);
		    request.getRequestDispatcher("/UpdateUserView").forward(request, response);
		}else if("update".equals(type)) {
			String id=request.getParameter("id");
			String username=request.getParameter("username");
			String email=request.getParameter("email");
			String grade=request.getParameter("grade");
			String passwd=request.getParameter("passwd");
			User user=new User(Integer.parseInt(id),username,email,passwd,Integer.parseInt(grade));
			//�޸��û�
			if(usersService.updateUser(user)) {
				request.setAttribute("info", "�޸ĳɹ�!");
				request.getRequestDispatcher("/Ok").forward(request, response);
			}else {
				request.setAttribute("info", "�޸�ʧ��!");
				request.getRequestDispatcher("/Err").forward(request, response);
			}
		}else if("gotoAddUser".equals(type)) {
			request.getRequestDispatcher("/AddUserView").forward(request, response);
		}else if("addUser".equals(type)) {
			//�����û���Ϣ
			String id=request.getParameter("id");
			String username=request.getParameter("username");
			String email=request.getParameter("email");
			String grade=request.getParameter("grade");
			String passwd=request.getParameter("passwd");
			User user=new User(Integer.parseInt(id),username,email,passwd,Integer.parseInt(grade));
		
			//����û�
			if(usersService.addUser(user)) {
				request.setAttribute("info", "��ӳɹ�!");
				request.getRequestDispatcher("/Ok").forward(request, response);
			}else {
				request.setAttribute("info", "���ʧ��!");
				request.getRequestDispatcher("/Err").forward(request, response);
			}
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
