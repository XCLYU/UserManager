package com.user;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
		out.println("<h1>�û���¼<h1>");
		out.println("<form action='/UserManager/LoginProcServlet' method='post'>");
		out.println("�˻�id��<input type='text' name='id'/><br/>");
		out.println("���룺<input type='password' name='password'/><br/>");
		out.println("��֤�룺<input type='text' name='checkcode'/><img src='/UserManager/CreateCode'/><br/>");
		out.println("<input type='submit' value='��¼'/> <br/>");
		out.println("</form>");
		if(request.getAttribute("err")!=null) {
			out.println("<font color='red'>"+request.getAttribute("err").toString()+"</font>");
		}
		out.println("<h3>��ϵ��ʽ�� ���-��Ȼ�߿Ƽ���¥4¥ 62932901 ����-ͼ����Ϣ¥(��ͼ�������) 34206060</h3>");
	  
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		String filePath=this.getServletContext().getRealPath("recoder.txt");
		try {
			FileWriter fileWriter=new FileWriter(filePath);
			BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
			Integer num=(Integer) this.getServletConfig().getServletContext().getAttribute("visitcount");

			bufferedWriter.write(""+num);
		
			bufferedWriter.close();
			fileWriter.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		super.destroy();
	}


	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub

		String filePath=this.getServletContext().getRealPath("recoder.txt");

		FileReader fileReader=null;
		BufferedReader bufferedReader=null;
		try {		
			fileReader=new FileReader(filePath);
			bufferedReader=new BufferedReader(fileReader);
			String nums=bufferedReader.readLine();
			this.getServletConfig().getServletContext().setAttribute("visitcount", Integer.parseInt(nums));
			Integer num=(Integer) this.getServletConfig().getServletContext().getAttribute("visitcount");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				bufferedReader.close();
				fileReader.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}finally {
				bufferedReader=null;
				fileReader=null;
			}
			
		}
		super.init();
	}

}
