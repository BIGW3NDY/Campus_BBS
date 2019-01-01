package com.entity;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class Post {
	private int postId;
	private String postTitle;
	private Date postDate;
	private Time postTime;
	private int hostId;
	private int subforumId;
	private String postBody;
	
	public Post() {};
	public Post(int id, String title, Date date, Time time,  int host, String body, int subforum) {
		postId = id;
		postTitle = title;
		postDate = date;
		postTime = time;
		hostId = host;
		postBody = body;
		subforumId = subforum;
	}
	
	public Post(String title,int host, String body, int subforum) {
		postTitle = title;
		postDate = new Date(System.currentTimeMillis());
		postTime = new Time(System.currentTimeMillis());
		hostId = host;
		postBody = body;
		subforumId = subforum;
	}
	
	public Post(ResultSet rs) throws SQLException {
		postId = rs.getInt("PostId");
		postTitle = rs.getString("PostTitle");
		postDate = rs.getDate("PostDate");
		postTime = rs.getTime("PostTime");
		hostId = rs.getInt("HostId");
		postBody = rs.getString("PostBody");
		subforumId = rs.getInt("SubforumId");
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public Time getPostTime() {
		return postTime;
	}
	public void setPostTime(Time postTime) {
		this.postTime = postTime;
	}
	public int getHostId() {
		return hostId;
	}
	public void setHostId(int hostId) {
		this.hostId = hostId;
	}
	public int getSubforumId() {
		return subforumId;
	}
	public void setSubforumId(int subforumId) {
		this.subforumId = subforumId;
	}
	public String getPostBody() {
		return postBody;
	}
	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}
	

}
