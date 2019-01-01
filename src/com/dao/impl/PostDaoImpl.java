package com.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.dao.inter.PostDao;
import com.entity.Post;
import com.entity.Reply;
import com.util.DButil;

public class PostDaoImpl implements PostDao{

	@Override
	public boolean publish(Post post) {
		// TODO Auto-generated method stub
		DButil.init();
		int result = DButil.addUpdDel("insert into post(PostId,PostTitle,PostDate,PostTime,HostId,PostBody,SubforumId) " + "values('"
										+ post.getPostId() + "','"
										+ post.getPostTitle() + "','"
										+ post.getPostDate() + "','"
										+ post.getPostTime() + "','"
										+ post.getHostId() + "','"
										+ post.getPostBody() + "','"
										+ post.getSubforumId() + "')");
		DButil.closeConn();
		if(result<0)
			return false;
		return true;
	}

	@Override
	public Post getPostById(int postId) {
		// TODO Auto-generated method stub
		DButil.init();
		ResultSet rs = DButil.selectSql("select * from post where PostId = '" + postId + "'");
		try {
			if(rs.next()) {
				Post post = new Post(rs);
				DButil.closeConn();
				return post;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DButil.closeConn();
		return null;
	}

	@Override
	public List<Reply> getAllReply(int postId) {
		// TODO Auto-generated method stub
		List<Reply> list = new ArrayList<Reply>();
		
		DButil.init();
		ResultSet rs = DButil.selectSql("select * from reply where PostId = '" + postId + "'");
		try {
			while(rs.next()) {
				Reply reply = new Reply(rs);
				list.add(reply);
				System.out.println("reply" + reply.getReplyId() + "is loaded" );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DButil.closeConn();
		return list;
	}

}
