package com.dao.inter;

import com.entity.User;

import java.util.List;

import com.entity.Post;
import com.entity.Reply;

public interface UserDao {
	
	public boolean register(User user); //注册
	public User login(String username, String password); //登陆
	public User getUserById(int id);//通过UserId找到用户实例
	public List<User> getAllUserFromPostList(List<Post> postList);
	public List<User> getAllUserFromReplyList(List<Reply> replyList);
}
