package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.UsersDAO;
import com.entity.Users;
import com.service.UsersService;

@Service("usersService")
public class UsersServiceImpl implements UsersService {
	@Autowired
	@Resource
	private UsersDAO usersDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertUsers(Users users) {
		return this.usersDAO.insertUsers(users);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateUsers(Users users) {
		return this.usersDAO.updateUsers(users);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteUsers(String usersid) {
		return this.usersDAO.deleteUsers(usersid);
	}

	@Override // 继承接口的查询全部
	public List<Users> getAllUsers() {
		return this.usersDAO.getAllUsers();
	}

	@Override // 继承接口的按条件精确查询
	public List<Users> getUsersByCond(Users users) {
		return this.usersDAO.getUsersByCond(users);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Users> getUsersByLike(Users users) {
		return this.usersDAO.getUsersByLike(users);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Users getUsersById(String usersid) {
		return this.usersDAO.getUsersById(usersid);
	}

}
