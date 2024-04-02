package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Article;
import com.entity.Reply;

@Repository("replyDAO") // Repository标签定义数据库连接的访问 Spring中直接

public interface ReplyDao {
	/**
	 * ReplyDAO 接口 可以按名称直接调用reply.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包reply.xml里的inserReply配置 返回值0(失败),1(成功)
	public int insertReply(Reply reply);

	// 更新数据 调用entity包reply.xml里的updateReply配置 返回值0(失败),1(成功)
	public int updateReply(Reply reply);

	// 删除数据 调用entity包reply.xml里的deleteReply配置 返回值0(失败),1(成功)
	public int deleteReply(String replyid);

	// 查询全部数据 调用entity包reply.xml里的getAllReply配置 返回List类型的数据
	public List<Reply> getAllReply();

	// 按照Reply类里面的值精确查询 调用entity包reply.xml里的getReplyByCond配置 返回List类型的数据
	public List<Reply> getReplyByCond(Reply reply);

	// 按照Reply类里面的值模糊查询 调用entity包reply.xml里的getReplyByLike配置 返回List类型的数据
	public List<Reply> getReplyByLike(Reply reply);

	// 按主键查询表返回单一的Reply实例 调用entity包article.xml里的getReplyById配置
	public Reply getReplyById(String replyid);

	

}
