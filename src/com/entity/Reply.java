package com.entity;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class Reply {
	private int replyId;
	private int authorId;
	private int postId;
	private Date replyDate;
	private Time replyTime;
	private String replyContent;
	
	public Reply() {}
	public Reply(int replyid, int authorid, int postid, Date date, Time time, String content) {
		replyId = replyid;
		authorId = authorid;
		postId = postid;
		replyDate = date;
		replyTime = time;
		replyContent = content;
	}
	public Reply(int authorid, int postid, Date date, Time time, String content) {
		authorId = authorid;
		postId = postid;
		replyDate = date;
		replyTime = time;
		replyContent = content;
	}
	public Reply(ResultSet rs) throws SQLException {
		replyId = rs.getInt("ReplyId");
		authorId = rs.getInt("AuthorId");
		postId = rs.getInt("PostId");
		replyDate = rs.getDate("ReplyDate");
		replyTime = rs.getTime("ReplyTime");
		replyContent = rs.getString("ReplyContent");
	}
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}

	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public Time getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Time replyTime) {
		this.replyTime = replyTime;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	
	
	
}
