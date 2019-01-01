package com.dao.inter;

import com.entity.Reply;

public interface ReplyDao {
	
	public boolean publish(Reply reply);//发表回复
	public Reply findReplyById(int replyId);//根据id查找回复
}
