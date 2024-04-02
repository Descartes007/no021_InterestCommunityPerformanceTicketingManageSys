package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.TicketDAO;
import com.entity.Ticket;
import com.service.TicketService;

@Service("ticketService")
public class TicketServiceImpl implements TicketService {
	@Autowired
	@Resource
	private TicketDAO ticketDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertTicket(Ticket ticket) {
		return this.ticketDAO.insertTicket(ticket);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateTicket(Ticket ticket) {
		return this.ticketDAO.updateTicket(ticket);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteTicket(String ticketid) {
		return this.ticketDAO.deleteTicket(ticketid);
	}

	@Override // 继承接口的查询全部
	public List<Ticket> getAllTicket() {
		return this.ticketDAO.getAllTicket();
	}

	@Override // 继承接口的按条件精确查询
	public List<Ticket> getTicketByCond(Ticket ticket) {
		return this.ticketDAO.getTicketByCond(ticket);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Ticket> getTicketByLike(Ticket ticket) {
		return this.ticketDAO.getTicketByLike(ticket);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Ticket getTicketById(String ticketid) {
		return this.ticketDAO.getTicketById(ticketid);
	}

}
