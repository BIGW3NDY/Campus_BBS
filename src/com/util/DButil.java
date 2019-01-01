package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButil {
	static String url = "jdbc:mysql://localhost:3306/forum?useSSL=true";
	static String username = "root";
	static String password = "1967";
	static Connection conn = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	
	public static void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection)DriverManager.getConnection(url, username, password);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL数据库连接失败");
			e.printStackTrace();
		}
	}
	
	public static int addUpdDel(String sql) {
		int flag = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sql数据库更新失败");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static ResultSet selectSql(String sql) {
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
		} catch(SQLException e) {
			System.out.println("sql数据库查询失败");
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void closeConn() {
		try {
			conn.close();
		}catch(SQLException e) {
			System.out.println("sql数据库关闭失败");
			e.printStackTrace();
		}
	}
}
