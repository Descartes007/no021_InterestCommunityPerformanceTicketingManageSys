package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.OrdersDAO;
import com.dao.ReplyDao;
import com.entity.Reply;
import com.service.OrdersService;
import com.service.ReplyService;

@Service("replyService")

public class ReplyServiceImpl implements ReplyService{
	@Autowired
	@Resource
	private ReplyDao replyDAO;
	
	@Override
	public int insertReply(Reply reply) {
		// TODO Auto-generated method stub
		return this.replyDAO.insertReply(reply);
	}

	@Override
	public int updateReply(Reply reply) {
		// TODO Auto-generated method stub
		return this.replyDAO.updateReply(reply);
	}

	@Override
	public int deleteReply(String replyid) {
		// TODO Auto-generated method stub
		return this.replyDAO.deleteReply(replyid);
	}

	@Override
	public List<Reply> getAllReply() {
		// TODO Auto-generated method stub
		return this.replyDAO.getAllReply();
	}

	@Override
	public List<Reply> getReplyByCond(Reply reply) {
		// TODO Auto-generated method stub
		return this.replyDAO.getReplyByCond(reply);
	}

	@Override
	public List<Reply> getReplyByLike(Reply reply) {
		// TODO Auto-generated method stub
		return this.replyDAO.getReplyByLike(reply);
	}

	@Override
	public Reply getReplyById(String replyid) {
		// TODO Auto-generated method stub
		return this.replyDAO.getReplyById(replyid);
	}
	

}
