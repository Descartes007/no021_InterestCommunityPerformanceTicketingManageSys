package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.AdminDAO;
import com.entity.Admin;
import com.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	@Resource
	private AdminDAO adminDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertAdmin(Admin admin) {
		return this.adminDAO.insertAdmin(admin);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateAdmin(Admin admin) {
		return this.adminDAO.updateAdmin(admin);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteAdmin(String adminid) {
		return this.adminDAO.deleteAdmin(adminid);
	}

	@Override // 继承接口的查询全部
	public List<Admin> getAllAdmin() {
		return this.adminDAO.getAllAdmin();
	}

	@Override // 继承接口的按条件精确查询
	public List<Admin> getAdminByCond(Admin admin) {
		return this.adminDAO.getAdminByCond(admin);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Admin> getAdminByLike(Admin admin) {
		return this.adminDAO.getAdminByLike(admin);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Admin getAdminById(String adminid) {
		return this.adminDAO.getAdminById(adminid);
	}

}
