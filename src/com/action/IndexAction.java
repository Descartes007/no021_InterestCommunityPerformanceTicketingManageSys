package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Article;
import com.entity.Cart;
import com.entity.Cate;
import com.entity.Concert;
import com.entity.Orders;
import com.entity.Reply;
import com.entity.Ticket;
import com.entity.Users;
import com.service.ArticleService;
import com.service.CartService;
import com.service.CateService;
import com.service.ConcertService;
import com.service.OrdersService;
import com.service.ReplyService;
import com.service.TicketService;
import com.service.UsersService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping("/index")
public class IndexAction extends BaseAction {

	@Autowired
	@Resource
	private UsersService usersService;
	@Autowired
	@Resource
	private ArticleService articleService;
	@Autowired
	@Resource
	private CateService cateService;
	@Autowired
	@Resource
	private ConcertService concertService;
	@Autowired
	@Resource
	private TicketService ticketService;
	@Autowired
	@Resource
	private CartService cartService;
	@Autowired
	@Resource
	private OrdersService ordersService;
	@Autowired
	@Resource
	private ReplyService replyService;
	

	// 公共方法 提供公共查询数据
	private void front() {
		this.getRequest().setAttribute("title", "演出系统");
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		List<Concert> hotList = this.concertService.getConcertByHot();
		this.getRequest().setAttribute("hotList", hotList);
	}

	// 首页显示
	@RequestMapping("index.action")
	public String index() {
		this.front();
		List<Cate> cateList = this.cateService.getFrontCate();
		List<Cate> frontList = new ArrayList<Cate>();
		for (Cate cate : cateList) {
			List<Concert> goodsList = this.concertService.getConcertByCate(cate.getCateid());
			cate.setConcertList(goodsList);
			frontList.add(cate);
		}
		this.getRequest().setAttribute("frontList", frontList);
		return "users/index";
	}

	// 公告
	@RequestMapping("article.action")
	public String article(String number) {
		this.front();
		List<Article> tempList = this.articleService.getAllArticle();
		PageHelper.getIndexPage(tempList, "article", "article", null, 10, number, this.getRequest());
		return "users/article";
	}

	// 阅读公告
	@RequestMapping("read.action")
	public String read(String id) {
		this.front();
		Article article = this.articleService.getArticleById(id);
		article.setHits("" + (Integer.parseInt(article.getHits()) + 1));
		this.articleService.updateArticle(article);
		this.getRequest().setAttribute("article", article);
		return "users/read";
	}

	// 准备登录
	@RequestMapping("preLogin.action")
	public String prelogin() {
		this.front();
		return "users/login";
	}

	// 用户登录
	@RequestMapping("login.action")
	public String login() {
		this.front();
		String username = this.getRequest().getParameter("username");
		String password = this.getRequest().getParameter("password");
		Users u = new Users();
		u.setUsername(username);
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			this.getSession().setAttribute("message", "用户名不存在");
			return "redirect:/index/preLogin.action";
		} else {
			Users users = usersList.get(0);
			if (password.equals(users.getPassword())) {
				this.getSession().setAttribute("userid", users.getUsersid());
				this.getSession().setAttribute("username", users.getUsername());
				this.getSession().setAttribute("users", users);
				return "redirect:/index/index.action";
			} else {
				this.getSession().setAttribute("message", "密码错误");
				return "redirect:/index/preLogin.action";
			}
		}
	}

	// 准备注册
	@RequestMapping("preReg.action")
	public String preReg() {
		this.front();
		return "users/register";
	}

	// 用户注册
	@RequestMapping("register.action")
	public String register(Users users) {
		this.front();
		Users u = new Users();
		u.setUsername(users.getUsername());
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			users.setRegdate(VeDate.getStringDateShort());
			this.usersService.insertUsers(users);
		} else {
			this.getSession().setAttribute("message", "用户名已存在");
			return "redirect:/index/preReg.action";
		}

		return "redirect:/index/preLogin.action";
	}

	// 退出登录
	@RequestMapping("exit.action")
	public String exit() {
		this.front();
		this.getSession().removeAttribute("userid");
		this.getSession().removeAttribute("username");
		this.getSession().removeAttribute("users");
		return "index";
	}

	// 准备修改密码
	@RequestMapping("prePwd.action")
	public String prePwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/editpwd";
	}

	// 修改密码
	@RequestMapping("editpwd.action")
	public String editpwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		String password = this.getRequest().getParameter("password");
		String repassword = this.getRequest().getParameter("repassword");
		Users users = this.usersService.getUsersById(userid);
		if (password.equals(users.getPassword())) {
			users.setPassword(repassword);
			this.usersService.updateUsers(users);
		} else {
			this.getSession().setAttribute("message", "旧密码错误");
			return "redirect:/index/prePwd.action";
		}
		return "redirect:/index/prePwd.action";
	}

	@RequestMapping("usercenter.action")
	public String usercenter() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/usercenter";
	}

	@RequestMapping("userinfo.action")
	public String userinfo() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		this.getSession().setAttribute("users", this.usersService.getUsersById(userid));
		return "users/userinfo";
	}

	@RequestMapping("personal.action")
	public String personal(Users users) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.usersService.updateUsers(users);
		return "redirect:/index/userinfo.action";
	}

	// 添加演唱会到购物车
	@RequestMapping("addcart.action")
	public String addcart() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Cart cart = new Cart();
		cart.setAddtime(VeDate.getStringDateShort());
		cart.setConcertid(getRequest().getParameter("concertid"));
		cart.setTicketid(this.getRequest().getParameter("ticketid"));
		cart.setNum(getRequest().getParameter("num"));
		Ticket ticket = this.ticketService.getTicketById(cart.getTicketid());
		cart.setPrice(ticket.getPrice());
		cart.setUsersid(userid);
		this.cartService.insertCart(cart);
		return "redirect:/index/cart.action";
	}

	// 查看购物车
	@RequestMapping("cart.action")
	public String cart() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Cart cart = new Cart();
		cart.setUsersid(userid);
		List<Cart> cartList = this.cartService.getCartByCond(cart);
		this.getRequest().setAttribute("cartList", cartList);
		return "users/cart";
	}

	// 删除购物车中的演唱会
	@RequestMapping("deletecart.action")
	public String deletecart(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.cartService.deleteCart(id);
		return "redirect:/index/cart.action";
	}

	// 准备结算
	@RequestMapping("preCheckout.action")
	public String preCheckout() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Cart cart = new Cart();
		cart.setUsersid(userid);
		List<Cart> cartList = this.cartService.getCartByCond(cart);
		if (cartList.size() == 0) {
			this.getRequest().setAttribute("message", "请选购商品");
			return "redirect:/index/cart.action";
		}
		return "users/checkout";
	}

	// 结算
	@RequestMapping("checkout.action")
	public String checkout() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Cart cart1 = new Cart();
		cart1.setUsersid(userid);
		List<Cart> cartList = this.cartService.getCartByCond(cart1);
		if (cartList.size() == 0) {
			this.getRequest().setAttribute("message", "请选购商品");
			return "redirect:/index/cart.action";
		} else {
			for (Cart cart : cartList) {
				String ordercode = "PD" + VeDate.getRandom();
				double total = Double.parseDouble(cart.getPrice()) * Double.parseDouble(cart.getNum());
				Orders orders = new Orders();
				orders.setConcertid(cart.getConcertid());
				orders.setTicketid(cart.getTicketid());
				orders.setOrdercode(ordercode);
				orders.setStatus("未付款");
				orders.setUsersid(userid);
				orders.setPrice(cart.getPrice());
				orders.setNum(cart.getNum());
				orders.setTotal("" + VeDate.getStringDouble(total));
				this.ordersService.insertOrders(orders);
				this.cartService.deleteCart(cart.getCartid());
			}

		}
		return "redirect:/index/showOrders.action";
	}

	// 查看订购
	@RequestMapping("showOrders.action")
	public String showOrders(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Orders orders = new Orders();
		orders.setUsersid(userid);
		List<Orders> tempList = this.ordersService.getOrdersByCond(orders);
		PageHelper.getIndexPage(tempList, "orders", "showOrders", null, 10, number, this.getRequest());
		return "users/orderlist";
	}

	// 准备付款
	@RequestMapping("prePay.action")
	public String prePay(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.getRequest().setAttribute("id", id);
		Orders orders = this.ordersService.getOrdersById(id);
		this.getRequest().setAttribute("orders", orders);
		return "users/pay";
	}

	// 付款
	@RequestMapping("pay.action")
	public String pay(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(this.getRequest().getParameter("id"));
		orders.setStatus("已付款");
		this.ordersService.updateOrders(orders);
		Concert concert = this.concertService.getConcertById(orders.getConcertid());
		concert.setSellnum("" + (Integer.parseInt(concert.getSellnum()) + Integer.parseInt(orders.getNum())));
		this.concertService.updateConcert(concert);
		Ticket ticket = this.ticketService.getTicketById(orders.getTicketid());
		int sellnum = Integer.parseInt(ticket.getSellnum()) + Integer.parseInt(orders.getNum());
		int balance = Integer.parseInt(ticket.getStorage()) - sellnum;
		ticket.setBalance("" + balance);
		ticket.setSellnum("" + sellnum);
		this.ticketService.updateTicket(ticket);
		return "redirect:/index/showOrders.action";
	}

	// 确认收货
	@RequestMapping("over.action")
	public String over(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(this.getRequest().getParameter("id"));
		orders.setStatus("完成");
		this.ordersService.updateOrders(orders);
		return "redirect:/index/showOrders.action";
	}

	// 取消订单
	@RequestMapping("cancel.action")
	public String cancel(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(this.getRequest().getParameter("id"));
		orders.setStatus("已取消");
		this.ordersService.updateOrders(orders);
		return "redirect:/index/showOrders.action";
	}

	// 按分类查询
	@RequestMapping("cate.action")
	public String cate(String id, String number) {
		this.front();
		Concert concert = new Concert();
		concert.setCateid(id);
		List<Concert> tempList = this.concertService.getConcertByCond(concert);
		PageHelper.getIndexPage(tempList, "concert", "cate", id, 12, number, this.getRequest());
		return "users/list";
	}

	// 推荐演唱会
	@RequestMapping("recommend.action")
	public String recommend(String number) {
		this.front();
		Concert concert = new Concert();
		concert.setRecommend("是");
		List<Concert> tempList = this.concertService.getConcertByCond(concert);
		PageHelper.getIndexPage(tempList, "concert", "recommend", null, 12, number, this.getRequest());
		return "users/list";
	}

	// 全部演唱会
	@RequestMapping("all.action")
	public String all(String number) {
		this.front();
		List<Concert> tempList = this.concertService.getAllConcert();
		PageHelper.getIndexPage(tempList, "concert", "all", null, 12, number, this.getRequest());
		return "users/list";
	}

	// 查询商品
	@RequestMapping("query.action")
	public String query(String name) {
		this.front();
		Concert concert = new Concert();
		concert.setTitle(name);
		List<Concert> concertList = this.concertService.getConcertByLike(concert);
		this.getRequest().setAttribute("concertList", concertList);
		return "users/list";
	}

	// 商品详情
	@RequestMapping("detail.action")
	public String detail(String id) {
		this.front();
		Concert concert = this.concertService.getConcertById(id);
		concert.setHits("" + (Integer.parseInt(concert.getHits()) + 1));
		this.concertService.updateConcert(concert);
		this.getRequest().setAttribute("concert", concert);
		Ticket ticket = new Ticket();
		ticket.setConcertid(id);
		List<Ticket> ticketList = this.ticketService.getTicketByCond(ticket);
		this.getRequest().setAttribute("ticketList", ticketList);
		return "users/detail";
	}
	// 预退票
	@RequestMapping("preCancel.action")
	public String preCancel(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.getRequest().setAttribute("id", id);
		Orders orders = this.ordersService.getOrdersById(id);
		this.getRequest().setAttribute("orders", orders);
		return "users/cancel";
	}
	//预转让
	@RequestMapping("preTransfer.action")
	public String preTransfer(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.getRequest().setAttribute("id", id);
		Orders orders = this.ordersService.getOrdersById(id);
		this.getRequest().setAttribute("orders", orders);
		return "users/transfer";
	}
	//转让
		@RequestMapping("transfer.action")
		public String tansfer(String id) {
			this.front();
			if (this.getSession().getAttribute("userid") == null) {
				return "redirect:/index/preLogin.action";
			}
			Orders orders = this.ordersService.getOrdersById(this.getRequest().getParameter("id"));
			//另一用户新增订单
			Orders order = new Orders();
			String concertid =orders.getConcertid();
			String ticketid =orders.getTicketid();
			String ordercode =orders.getOrdercode();
			String num =orders.getNum();
			String reuserid = this.getRequest().getParameter("reuserid");
			String re_amount = this.getRequest().getParameter("re_amount");
			order.setOrdersid("O" + VeDate.getRandom());
			order.setConcertid(concertid);
			order.setTicketid(ticketid);
			order.setOrdercode(ordercode);
			order.setStatus("未付款");
			order.setUsersid(reuserid);
			order.setPrice(re_amount);
			order.setNum(num);
			order.setTotal(num);
			this.ordersService.insertOrders(order);
			orders.setStatus("已转让");
			this.ordersService.updateOrders(orders);
			return "redirect:/index/showOrders.action";
		}
		// 查看论坛
		@RequestMapping("conmment.action")
		public String comment(String number) {
			this.front();
			List<Reply> tempList = this.replyService.getAllReply();
			PageHelper.getIndexPage(tempList, "reply", "reply", null, 10, number, this.getRequest());
			return "users/read";
		}
		//预添加评论
		@RequestMapping("preAddComment.action")
		public String preAddComment(String id) {
			this.front();
			if (this.getSession().getAttribute("userid") == null) {
				return "redirect:/index/preLogin.action";
			}
			this.getRequest().setAttribute("id", id);   
			Article article = this.articleService.getArticleById(id);
			return "users/comment";
		}

		//添加评论
		@RequestMapping("AddComment.action")
		public String AddComment(String id) {
			this.front();
			if (this.getSession().getAttribute("userid") == null) {
				return "redirect:/index/preLogin.action";
			}
			Article article = this.articleService.getArticleById(this.getRequest().getParameter("id"));
			String userid = (String) this.getSession().getAttribute("userid");
			//new一个reply对象
			Reply reply = new Reply();
			reply.setReplyid("R"+ VeDate.getRandom());
			reply.setUsername(this.getRequest().getParameter("username"));
			reply.setUsersid((String) this.getSession().getAttribute("userid"));
			reply.setArticleid(this.getRequest().getParameter("articleid"));
			reply.setReply( this.getRequest().getParameter("reply"));
			this.replyService.insertReply(reply);
			return "users/read";
		}

}
