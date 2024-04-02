package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Ticket;

@Service("ticketService")
public interface TicketService {
	// 插入数据 调用ticketDAO里的insertTicket配置
	public int insertTicket(Ticket ticket);

	// 更新数据 调用ticketDAO里的updateTicket配置
	public int updateTicket(Ticket ticket);

	// 删除数据 调用ticketDAO里的deleteTicket配置
	public int deleteTicket(String ticketid);

	// 查询全部数据 调用ticketDAO里的getAllTicket配置
	public List<Ticket> getAllTicket();

	// 按照Ticket类里面的字段名称精确查询 调用ticketDAO里的getTicketByCond配置
	public List<Ticket> getTicketByCond(Ticket ticket);

	// 按照Ticket类里面的字段名称模糊查询 调用ticketDAO里的getTicketByLike配置
	public List<Ticket> getTicketByLike(Ticket ticket);

	// 按主键查询表返回单一的Ticket实例 调用ticketDAO里的getTicketById配置
	public Ticket getTicketById(String ticketid);

}
