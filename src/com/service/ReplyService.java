package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Reply;

@Service("replyService")
public interface ReplyService {
	// 插入数据 调用ReplyDAO里的insertReply配置
		public int insertReply(Reply reply);

		// 更新数据 调用ReplyDAO里的updateReply配置
		public int updateReply(Reply reply);

		// 删除数据 调用ReplyDAO里的deleteReply配置
		public int deleteReply(String replyid);

		// 查询全部数据 调用ReplyDAO里的getAllReply配置
		public List<Reply> getAllReply();

		// 按照Reply类里面的字段名称精确查询 调用replyDAO里的getReplyByCond配置
		public List<Reply> getReplyByCond(Reply reply);

		// 按照Reply类里面的字段名称模糊查询 调用replyDAO里的getReplyByLike配置
		public List<Reply> getReplyByLike(Reply reply);

		// 按主键查询表返回单一的Reply实例 调用replyDAO里的getReplyById配置
		public Reply getReplyById(String replyid);
	
}
