package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.inter.UserDao;
import com.entity.Post;
import com.entity.Reply;
import com.entity.User;
import com.util.DButil;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		DButil.init();
		int result = DButil.addUpdDel("insert into user(UserName,UserPassword,UserSex,UserCollege,UserClass) " + "values('"
										+ user.getUserName() + "','"
										+ user.getUserPassword() + "','"
										+ user.getUserSex() + "','"
										+ user.getUserCollege() + "','"
										+ user.getUserClass() + "',0)");  
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		DButil.init();
		ResultSet rs = DButil.selectSql("select * from user where UserName='"+username+"'and UserPassword='"+ password + "'");
		try {
			while(rs.next()) {
				System.out.println(rs.getString("UserName") + " " + username);
				System.out.println(rs.getString("UserPassword") + " " + password);
				if(rs.getString("UserName").equals(username)&&rs.getString("UserPassword").equals(password)) {
					User user = new User(rs);
//					User user = new User(rs.getInt("UserId"), rs.getString("UserName"), rs.getString("UserPassword"),
//										rs.getString("UserSex"), rs.getString("UserCollege"), rs.getString("UserClass"));
					DButil.closeConn();
					return user;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DButil.closeConn();
		return null;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		DButil.init();
		ResultSet rs = DButil.selectSql("select * from user where UserId = '" + id + "'");
		try {
			if(rs.next()) {
				User user = new User(rs);
				DButil.closeConn();
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DButil.closeConn();
		return null;
	}

	@Override
	public List<User> getAllUserFromPostList(List<Post> postList) {
		// TODO Auto-generated method stub
		if(postList == null)
			return null;
		
		List<User> hostList = new ArrayList<User>();
		for(int i=0;i<postList.size();i++) {
			Post post = postList.get(i);
			int hostId = post.getHostId();
			System.out.println("hostId: " + hostId);
			User user = this.getUserById(hostId);
			hostList.add(user);
		}
		
		return hostList;
	}

	@Override
	public List<User> getAllUserFromReplyList(List<Reply> replyList) {
		// TODO Auto-generated method stub
		if(replyList==null)
			return null;
		List<User> authorList = new ArrayList<User>();
		for(int i=0;i<replyList.size();i++) {
			Reply reply = replyList.get(i);
			int authorId = reply.getAuthorId();
			User user = this.getUserById(authorId);
			authorList.add(user);
		}
		
		return authorList;
	}

}
