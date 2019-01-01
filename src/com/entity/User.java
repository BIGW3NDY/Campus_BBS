package com.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
	private int UserId;
	private String UserName;
	private String UserPassword;
	private String UserSex;
	private String UserCollege;
	private String UserClass;
	private int IsAdmin;
	
	public User() {}
	public User(int id, String name, String pwd, String sex, String college, String Class, int isAdmin) {
		UserId = id;
		UserName = name;
		UserPassword = pwd;
		UserSex = sex;
		UserCollege = college;
		UserClass = Class;
		IsAdmin = isAdmin;
	}
	public User(String name, String pwd, String sex, String college, String Class, int isAdmin) {
		UserName = name;
		UserPassword = pwd;
		UserSex = sex;
		UserCollege = college;
		UserClass = Class;
		IsAdmin = isAdmin;
	}
	public User(ResultSet rs) throws SQLException {
		UserId = rs.getInt("UserId");
		UserName = rs.getString("UserName");
		UserPassword = rs.getString("UserPassword");
		UserSex = rs.getString("UserSex");
		UserCollege = rs.getString("UserCollege");
		UserClass = rs.getString("UserClass");
		IsAdmin = rs.getInt("IsAdmin");
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	public String getUserSex() {
		return UserSex;
	}
	public void setUserSex(String userSex) {
		UserSex = userSex;
	}
	public String getUserCollege() {
		return UserCollege;
	}
	public void setUserCollege(String userCollege) {
		UserCollege = userCollege;
	}
	public String getUserClass() {
		return UserClass;
	}
	public void setUserClass(String userClass) {
		UserClass = userClass;
	}
	public int getIsAdmin() {
		return IsAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		IsAdmin = isAdmin;
	}
	
}
