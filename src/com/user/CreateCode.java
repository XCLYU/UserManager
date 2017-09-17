package com.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.GraphicAttribute;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class CreateCode
 */
@WebServlet("/CreateCode")
public class CreateCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCode() {
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
		
		//禁止缓存
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-Cache");
		response.setHeader("Pragma", "no-Cache");
		
		response.setHeader("Content-Type", "image/jpeg");
		BufferedImage image=new BufferedImage(60, 30, BufferedImage.TYPE_INT_RGB);
		Graphics graphics=image.getGraphics();
		//设置背景色
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, 60, 30);
		//写入的颜色和字体
		graphics.setColor(Color.RED);
		graphics.setFont(new Font(null, Font.BOLD, 20));
		//向图片上写数字
		String num=makeRandom();
		request.getSession().setAttribute("checkcode", num);
		graphics.drawString(num, 0, 20);
		//把写好的数据发送给浏览器
		ImageIO.write(image, "jpg", response.getOutputStream());
		
	}
	public String makeRandom() {
		Random random=new Random();
		String num=random.nextInt(9999)+"";
		StringBuffer stringBuffer=new StringBuffer();
		for(int i=0;i<4-num.length();i++) {
			stringBuffer.append("0");		
		}
		num=stringBuffer.toString()+num;
		return num;		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
