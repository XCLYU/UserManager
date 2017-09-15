package com.user.util;

import java.io.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;





public class SqlHelper {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	//load arguement
	static String url;
	static String username;
	static String driver;
	static String password;
	
	static Properties properties=null;
	static InputStream inputStream=null;
	//load driver
	static {
		try {
			properties=new Properties();
	
			inputStream=SqlHelper.class.getClassLoader().
					getResourceAsStream("dbinfo.properties");
			properties.load(inputStream);
			url=properties.getProperty("url");
			username=properties.getProperty("username");
			driver=properties.getProperty("driver");
			password=properties.getProperty("password");

	

//			System.out.println("ok");
			Class.forName(driver);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			inputStream=null;
		}
	}
	//get connection


	public static Connection initConnection() {
		try {
			connection=DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}
	public static ResultSet executeQuery(String sql,String [] parameters) {
		try {
			connection=initConnection();
			preparedStatement=connection.prepareStatement(sql);
			if(parameters!=null) {
				for(int i=0;i<parameters.length;i++) {
					preparedStatement.setObject(i+1, parameters[i]);
				}
			}
			resultSet=preparedStatement.executeQuery();
			return resultSet;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	//update/delete/insert
	public static void executeUpdate(String sql,String []parameters) {
		try {
			connection=initConnection();
			preparedStatement=connection.prepareStatement(sql);
			if(parameters!=null) {
				for(int i=0;i<parameters.length;i++) {
					preparedStatement.setObject(i+1, parameters[i]);
				}
			}
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally {
			close(resultSet, preparedStatement, connection);
		}
		
	}
	public static void close(ResultSet resultSet,Statement preparedStatement,Connection connection) {
		if(resultSet!=null) {
			try {
				resultSet.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			resultSet=null;
		}
		if(preparedStatement!=null) {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			preparedStatement=null;
		}
		if(connection!=null) {
			try {
				connection.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			connection=null;
		}
	}
	public static PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}
	public static ResultSet getResultSet() {
		return resultSet;
	}
	public static Connection getConnection() {
		return connection;
	}

}
