package com.user.controller;

import java.io.IOException;
import java.lang.invoke.CallSite;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.domain.User;
import com.user.service.UsersService;



/**
 * Servlet implementation class LoginProcServlet
 */
@WebServlet("/LoginProcServlet")
public class LoginProcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginProcServlet() {
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
		//接收用户提交的用户名和密码
		String id=request.getParameter("id");
		String password=request.getParameter("password");
	
	    //创建Userservice 验证数据
		UsersService uService=new UsersService();
		User user=new User();
		user.setId(Integer.parseInt(id));
		user.setPwd(password);
		if(uService.checkUser(user)) {
			request.getRequestDispatcher("/MainFrame").forward(request, response);
		}
		else {
			request.setAttribute("err", "用户id或密码有误");
			request.getRequestDispatcher("/Login").forward(request, response);
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
