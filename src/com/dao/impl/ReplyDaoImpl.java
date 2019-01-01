package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.inter.ReplyDao;
import com.entity.Reply;
import com.util.DButil;

public class ReplyDaoImpl implements ReplyDao{

	@Override
	public boolean publish(Reply reply) {
		// TODO Auto-generated method stub
		DButil.init();
		int result = DButil.addUpdDel("insert into reply(AuthorId,PostId,ReplyDate,ReplyTime,ReplyContent) " + "values('"
										+ reply.getAuthorId() + "','"
										+ reply.getPostId() + "','"
										+ reply.getReplyDate() + "','"
										+ reply.getReplyTime() + "','"
										+ reply.getReplyContent() + "')");
		DButil.closeConn();
		if(result<0)
			return false;
		return true;
	}

	@Override
	public Reply findReplyById(int replyId) {
		// TODO Auto-generated method stub
		DButil.init();
		ResultSet rs = DButil.selectSql("select * from reply where replyId = '" + replyId + "'");
		try {
			if(rs.next()) {
				Reply reply = new Reply(rs);
				DButil.closeConn();
				return reply;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
