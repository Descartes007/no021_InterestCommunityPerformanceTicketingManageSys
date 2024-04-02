package com.action;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Ticket;
import com.service.TicketService;
import com.entity.Concert;
import com.service.ConcertService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/ticket", produces = "text/plain;charset=utf-8")
public class TicketAction extends BaseAction {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private TicketService ticketService;
	@Autowired
	@Resource
	private ConcertService concertService;

	// 准备添加数据
	@RequestMapping("createTicket.action")
	public String createTicket() {
		List<Concert> concertList = this.concertService.getAllConcert();
		this.getRequest().setAttribute("concertList", concertList);
		return "admin/addticket";
	}

	// 添加数据
	@RequestMapping("addTicket.action")
	public String addTicket(Ticket ticket) {
		ticket.setSellnum("0");
		ticket.setBalance("0");
		this.ticketService.insertTicket(ticket);
		return "redirect:/ticket/createTicket.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteTicket.action")
	public String deleteTicket(String id) {
		this.ticketService.deleteTicket(id);
		return "redirect:/ticket/getAllTicket.action";
	}

	// 批量删除数据
	@RequestMapping("deleteTicketByIds.action")
	public String deleteTicketByIds() {
		String[] ids = this.getRequest().getParameterValues("ticketid");
		for (String ticketid : ids) {
			this.ticketService.deleteTicket(ticketid);
		}
		return "redirect:/ticket/getAllTicket.action";
	}

	// 更新数据
	@RequestMapping("updateTicket.action")
	public String updateTicket(Ticket ticket) {
		this.ticketService.updateTicket(ticket);
		return "redirect:/ticket/getAllTicket.action";
	}

	// 显示全部数据
	@RequestMapping("getAllTicket.action")
	public String getAllTicket(String number) {
		List<Ticket> ticketList = this.ticketService.getAllTicket();
		PageHelper.getPage(ticketList, "ticket", null, null, 10, number, this.getRequest(), null);
		return "admin/listticket";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryTicketByCond.action")
	public String queryTicketByCond(String cond, String name, String number) {
		Ticket ticket = new Ticket();
		if (cond != null) {
			if ("concertid".equals(cond)) {
				ticket.setConcertid(name);
			}
			if ("areaname".equals(cond)) {
				ticket.setAreaname(name);
			}
			if ("price".equals(cond)) {
				ticket.setPrice(name);
			}
			if ("storage".equals(cond)) {
				ticket.setStorage(name);
			}
			if ("sellnum".equals(cond)) {
				ticket.setSellnum(name);
			}
			if ("balance".equals(cond)) {
				ticket.setBalance(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.ticketService.getTicketByLike(ticket), "ticket", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryticket";
	}

	// 按主键查询数据
	@RequestMapping("getTicketById.action")
	public String getTicketById(String id) {
		Ticket ticket = this.ticketService.getTicketById(id);
		this.getRequest().setAttribute("ticket", ticket);
		List<Concert> concertList = this.concertService.getAllConcert();
		this.getRequest().setAttribute("concertList", concertList);
		return "admin/editticket";
	}

	public TicketService getTicketService() {
		return ticketService;
	}

	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

}
