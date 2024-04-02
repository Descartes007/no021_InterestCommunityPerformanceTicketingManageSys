package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Article;
import com.entity.Concert;
import com.entity.Orders;
import com.entity.Reply;
import com.entity.Ticket;
import com.entity.Users;
import com.service.ArticleService;
import com.service.OrdersService;
import com.service.ReplyService;
import com.service.UsersService;
import com.util.PageHelper;

//定义为控制器
@Controller
//设置路径
@RequestMapping(value = "/reply", produces = "text/plain;charset=utf-8")

public class ReplyAction  extends BaseAction {
	// 注入Service 由于标签的存在 所以不需要getter setter
		@Autowired
		@Resource
		private ReplyService replyService;
		@Autowired
		@Resource
		private UsersService usersService;
		@Autowired
		@Resource
		private ArticleService articleService;
		
		//准备添加数据
		@RequestMapping("createReply.action")
		public String createReply() {
			List<Users> usersList = this.usersService.getAllUsers();
			this.getRequest().setAttribute("usersList", usersList);
			List<Article> articleList = this.articleService.getAllArticle();
			this.getRequest().setAttribute("articleList", articleList);
			return "admin/addreply";
		}
		
		// 添加数据
		@RequestMapping("addReply.action")
		public String addReply(Reply reply) {
			this.replyService.insertReply(reply);
			return "redirect:/reply/createReply.action";
		}
		
		// 通过主键删除数据
		@RequestMapping("deleteReply.action")
		public String deleteReply(String id) {
			this.replyService.deleteReply(id);
			return "redirect:/reply/getAllReply.action";
		}
		
		// 批量删除数据
		@RequestMapping("deleteReplyByIds.action")
		public String deleteReplyByIds() {
			String[] ids = this.getRequest().getParameterValues("replyid");
			for (String replyid : ids) {
				this.replyService.deleteReply(replyid);
			}
			return "redirect:/reply/getAllReply.action";
		}
		
		// 更新数据
		@RequestMapping("updateOReply.action")
		public String updateReply(Reply reply) {
			this.replyService.updateReply(reply);
			return "redirect:/reply/getAllReply.action";
		}
		
		// 显示全部数据
		@RequestMapping("getAllReply.action")
		public String getAllReply(String number) {
			List<Reply> replyList = this.replyService.getAllReply();
			PageHelper.getPage(replyList, "reply", null, null, 10, number, this.getRequest(), null);
			return "admin/listreply";
		}
		
		// 按条件查询数据 (模糊查询)
		@RequestMapping("queryReplyByCond.action")
		public String queryReplyByCond(String cond, String name, String number) {
			Reply reply = new Reply();
			if (cond != null) {
				if ("usersid".equals(cond)) {
					reply.setUsersid(name);
				}
				if ("articleid".equals(cond)) {
					reply.setArticleid(name);
				}
				if ("username".equals(cond)) {
					reply.setUsername(name);
				}
				if ("addtime".equals(cond)) {
					reply.setAddtime(name);
				}
				if ("title".equals(cond)) {
					reply.setTitle(name);
				}
				if ("reply".equals(cond)) {
					reply.setReply(name);
				}
			}

			List<String> nameList = new ArrayList<String>();
			List<String> valueList = new ArrayList<String>();
			nameList.add(cond);
			valueList.add(name);
			PageHelper.getPage(this.replyService.getReplyByLike(reply), "reply", nameList, valueList, 10, number, this.getRequest(), "query");
			name = null;
			cond = null;
			return "admin/queryreply";
		}
		
		// 按主键查询数据
		@RequestMapping("getReplyById.action")
		public String getReplyById(String id) {
			Reply reply = this.replyService.getReplyById(id);
			this.getRequest().setAttribute("reply", reply);
			List<Users> usersList = this.usersService.getAllUsers();
			this.getRequest().setAttribute("usersList", usersList);
			List<Article> articleList = this.articleService.getAllArticle();
			this.getRequest().setAttribute("articleList", articleList);
			return "admin/editreply";
		}
		public ReplyService getReplyService() {
			return replyService;
		}

		public void setReplyService(ReplyService replyService) {
			this.replyService = replyService;
		}
}
