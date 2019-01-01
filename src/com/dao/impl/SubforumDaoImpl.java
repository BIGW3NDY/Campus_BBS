package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.inter.SubforumDao;
import com.entity.Post;
import com.entity.Subforum;
import com.util.DButil;

public class SubforumDaoImpl implements SubforumDao {

	@Override
	public boolean create(Subforum subforum) {
		// TODO Auto-generated method stub
		DButil.init();
		int result = DButil.addUpdDel("insert into subforum(SubforumName,SubforumInfo,SubforumNotice,PostTotalNum) " + "values('"
				+ subforum.getSubforumName()+ "','"
				+ subforum.getSubforumInfo() + "','"
				+ subforum.getSubforumNotice() + "','"
				+ subforum.getPostTotalNum() + "')");
		DButil.closeConn();
		if(result > 0)
			return false;
		else
			return true;
	}

	@Override
	public List<Post> getAllPost(Subforum subforum) {
		// TODO Auto-generated method stub
		DButil.init();
		List<Post> list = new ArrayList<Post>();
		ResultSet rs = DButil.selectSql("select * from Post where SubforumId = '" + subforum.getSubforumId() +"'");
		try {
			while(rs.next()) {
				Post post = new Post(rs.getInt("PostId"),rs.getString("PostTitle"),rs.getDate("PostDate"),rs.getTime("PostTime"),
									rs.getInt("HostId"),rs.getString("PostBody"),rs.getInt("SubforumId"));
				list.add(post);
			}
			DButil.closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Subforum> getAllSubforum() {
		// TODO Auto-generated method stub
		List<Subforum> list = new ArrayList<Subforum>();
		DButil.init();
		ResultSet rs = DButil.selectSql("select * from Subforum");
		try {
			while(rs.next()) {
				Subforum subforum = new Subforum(rs.getInt("SubforumId"),rs.getString("SubforumName"),rs.getString("SubforumInfo"),rs.getString("SubforumNotice"),rs.getInt("PostTotalNum"));
				list.add(subforum);
				System.out.println(subforum.getSubforumName() + "loaded");
			}
			DButil.closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	@Override
	public Subforum getSubforumById(int id) {
		// TODO Auto-generated method stub
		DButil.init();
		ResultSet rs = DButil.selectSql("select * from subforum where SubforumId = '" + id + "'");
		try {
			if(rs.next()) {
				Subforum subforum = new Subforum(rs.getInt("SubforumId"),rs.getString("SubforumName"),rs.getString("SubforumInfo"),rs.getString("SubforumNotice"),rs.getInt("PostTotalNum"));
				return subforum;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
