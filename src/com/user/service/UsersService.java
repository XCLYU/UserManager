package com.user.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.crypto.provider.RSACipher;
import com.user.domain.User;
import com.user.util.SqlHelper;



public class UsersService {
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	//添加用户
	public boolean addUser(User user) {
		boolean b=true;
		String sql="insert into users values(?,?,?,?,?)";
		String parameters[]={user.getId()+"",user.getName(),user.getEmail(),user.getGrade()+"",user.getPwd()};
		try {
			SqlHelper.executeUpdate(sql, parameters);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			b=false;
		}
		
		return b;
	}
	
	//修改用户
	public boolean updateUser(User user) {
		boolean b=true;
		String sql="update users set username=?, email=?,grade=?,passwd=? where id=?";
		String parameters[]= {user.getName(),user.getEmail(),
				user.getGrade()+"",user.getPwd(),user.getId()+""};
		try {
			SqlHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			b=false;
		}
		return b;
		
		
	}
	
	//delete user
	public boolean delUser(String id) {
		boolean b=true;
		String sql="delete from users where id=?";
		String parameters[]= {id};
		try {
			SqlHelper.executeUpdate(sql,parameters);
		} catch (Exception e) {
			b=false;
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return b;
	}
	
	//get pageCount
	public int getPageCount(int pageSize) {
		int rowCount=0;
		String sql="select count(*) from users";
		ResultSet resultSet=SqlHelper.executeQuery(sql, null);
		try {
			resultSet.next();
			rowCount=resultSet.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SqlHelper.close(SqlHelper.getResultSet(),SqlHelper.getPreparedStatement(),
					SqlHelper.getConnection());
		}
		return (rowCount-1)/(pageSize)+1;		
	}
	
	
	//get user by id
	public User getUserById(String id) {
		String sql="select * from users where id=?";
		User user=new User();
		String parameters[]= {id};
		ResultSet resultSet=SqlHelper.executeQuery(sql, parameters);
		try {
			if(resultSet.next()) {
				//二次封装
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setEmail(resultSet.getString(3));
				user.setGrade(resultSet.getInt(4));
				user.setPwd(resultSet.getString(5));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SqlHelper.close(SqlHelper.getResultSet(),
					SqlHelper.getPreparedStatement(),
					SqlHelper.getConnection());
		}
		return user;
	}
	
	//get users by page
	//把resultSet-> users object -> ArrayList
	public ArrayList<User> getUsersByPage(int page,int pageSize) {
		ArrayList<User> arrayList=new ArrayList<>();
		String sql="select * from users order by id limit "+(page-1)*pageSize+","+pageSize;				
		ResultSet resultSet=SqlHelper.executeQuery(sql, null);
		try {
			while(resultSet.next()) {
				User user=new User();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setEmail(resultSet.getString(3));
				user.setPwd(resultSet.getString(4));
				user.setGrade(resultSet.getInt(5));
				arrayList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SqlHelper.close(SqlHelper.getResultSet(),
					SqlHelper.getPreparedStatement(),
					SqlHelper.getConnection());
		}
		return arrayList;
	}
	
	public boolean checkUser(User user) {
		boolean b=false;
		//use sqlhelper
		String sql="select * from users where id=? and passwd=?";
		String parameters[]= {user.getId()+"",user.getPwd()};
		ResultSet resultSet=SqlHelper.executeQuery(sql, parameters);
		try {
			if(resultSet.next()) {
				b=true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			SqlHelper.close(resultSet,preparedStatement,connection);
		}
		return b;
	}

}
