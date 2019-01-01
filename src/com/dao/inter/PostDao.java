package com.dao.inter;

import java.util.List;

import com.entity.Post;
import com.entity.Reply;

public interface PostDao {

	public boolean publish(Post post);//发表帖子
	public Post getPostById(int postId);//根据id查找帖子
	public List<Reply> getAllReply(int postId);//获取某帖子下的所有回复
	
}
