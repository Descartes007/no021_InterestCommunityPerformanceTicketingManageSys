package com.action;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Users;
import com.service.UsersService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/users", produces = "text/plain;charset=utf-8")
public class UsersAction extends BaseAction {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private UsersService usersService;

	// 准备添加数据
	@RequestMapping("createUsers.action")
	public String createUsers() {
		return "admin/addusers";
	}

	// 添加数据
	@RequestMapping("addUsers.action")
	public String addUsers(Users users) {
		this.usersService.insertUsers(users);
		return "redirect:/users/createUsers.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteUsers.action")
	public String deleteUsers(String id) {
		this.usersService.deleteUsers(id);
		return "redirect:/users/getAllUsers.action";
	}

	// 批量删除数据
	@RequestMapping("deleteUsersByIds.action")
	public String deleteUsersByIds() {
		String[] ids = this.getRequest().getParameterValues("usersid");
		for (String usersid : ids) {
			this.usersService.deleteUsers(usersid);
		}
		return "redirect:/users/getAllUsers.action";
	}

	// 更新数据
	@RequestMapping("updateUsers.action")
	public String updateUsers(Users users) {
		this.usersService.updateUsers(users);
		return "redirect:/users/getAllUsers.action";
	}

	// 显示全部数据
	@RequestMapping("getAllUsers.action")
	public String getAllUsers(String number) {
		List<Users> usersList = this.usersService.getAllUsers();
		PageHelper.getPage(usersList, "users", null, null, 10, number, this.getRequest(), null);
		return "admin/listusers";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryUsersByCond.action")
	public String queryUsersByCond(String cond, String name, String number) {
		Users users = new Users();
		if (cond != null) {
			if ("username".equals(cond)) {
				users.setUsername(name);
			}
			if ("password".equals(cond)) {
				users.setPassword(name);
			}
			if ("realname".equals(cond)) {
				users.setRealname(name);
			}
			if ("sex".equals(cond)) {
				users.setSex(name);
			}
			if ("birthday".equals(cond)) {
				users.setBirthday(name);
			}
			if ("contact".equals(cond)) {
				users.setContact(name);
			}
			if ("address".equals(cond)) {
				users.setAddress(name);
			}
			if ("regdate".equals(cond)) {
				users.setRegdate(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.usersService.getUsersByLike(users), "users", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryusers";
	}

	// 按主键查询数据
	@RequestMapping("getUsersById.action")
	public String getUsersById(String id) {
		Users users = this.usersService.getUsersById(id);
		this.getRequest().setAttribute("users", users);
		return "admin/editusers";
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

}
