package com.entity;

public class Subforum {
	private int subforumId;
	private String subforumName;
	private String subforumInfo;
	private String subforumNotice;
	private int postTotalNum;
	
	public Subforum() {}
	public Subforum(int id, String name, String info, String notice, int num) {
		subforumId = id;
		subforumName = name;
		subforumInfo = info;
		subforumNotice = notice;
		postTotalNum = num;
	}
	public Subforum(String name, String info, String notice) {
		subforumName = name;
		subforumInfo = info;
		subforumNotice = notice;
	}
	public int getSubforumId() {
		return subforumId;
	}
	public void setSubforumId(int subforumId) {
		this.subforumId = subforumId;
	}
	public String getSubforumName() {
		return subforumName;
	}
	public void setSubforumName(String subforumName) {
		this.subforumName = subforumName;
	}
	public String getSubforumInfo() {
		return subforumInfo;
	}
	public void setSubforumInfo(String subforumInfo) {
		this.subforumInfo = subforumInfo;
	}
	public String getSubforumNotice() {
		return subforumNotice;
	}
	public void setSubforumNotice(String subforumNotice) {
		this.subforumNotice = subforumNotice;
	}
	public int getPostTotalNum() {
		return postTotalNum;
	}
	public void setPostTotalNum(int postTotalNum) {
		this.postTotalNum = postTotalNum;
	}
	

}
