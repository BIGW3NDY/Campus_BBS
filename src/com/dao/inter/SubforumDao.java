package com.dao.inter;

import java.util.List;

import com.entity.Post;
import com.entity.Subforum;

public interface SubforumDao {
	public boolean create(Subforum subforum);//创建一个新的论坛板块
	public List<Post> getAllPost(Subforum subforum);
	public List<Subforum> getAllSubforum();
	public Subforum getSubforumById(int id);
}
