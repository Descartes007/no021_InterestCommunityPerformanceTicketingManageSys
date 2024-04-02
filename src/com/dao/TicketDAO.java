package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Ticket;

@Repository("ticketDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface TicketDAO {

	/**
	 * TicketDAO 接口 可以按名称直接调用ticket.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包ticket.xml里的insertTicket配置 返回值0(失败),1(成功)
	public int insertTicket(Ticket ticket);

	// 更新数据 调用entity包ticket.xml里的updateTicket配置 返回值0(失败),1(成功)
	public int updateTicket(Ticket ticket);

	// 删除数据 调用entity包ticket.xml里的deleteTicket配置 返回值0(失败),1(成功)
	public int deleteTicket(String ticketid);

	// 查询全部数据 调用entity包ticket.xml里的getAllTicket配置 返回List类型的数据
	public List<Ticket> getAllTicket();

	// 按照Ticket类里面的值精确查询 调用entity包ticket.xml里的getTicketByCond配置 返回List类型的数据
	public List<Ticket> getTicketByCond(Ticket ticket);

	// 按照Ticket类里面的值模糊查询 调用entity包ticket.xml里的getTicketByLike配置 返回List类型的数据
	public List<Ticket> getTicketByLike(Ticket ticket);

	// 按主键查询表返回单一的Ticket实例 调用entity包ticket.xml里的getTicketById配置
	public Ticket getTicketById(String ticketid);

}
