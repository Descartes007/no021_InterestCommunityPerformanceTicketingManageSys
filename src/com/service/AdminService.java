package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Admin;

@Service("adminService")
public interface AdminService {
	// 插入数据 调用adminDAO里的insertAdmin配置
	public int insertAdmin(Admin admin);

	// 更新数据 调用adminDAO里的updateAdmin配置
	public int updateAdmin(Admin admin);

	// 删除数据 调用adminDAO里的deleteAdmin配置
	public int deleteAdmin(String adminid);

	// 查询全部数据 调用adminDAO里的getAllAdmin配置
	public List<Admin> getAllAdmin();

	// 按照Admin类里面的字段名称精确查询 调用adminDAO里的getAdminByCond配置
	public List<Admin> getAdminByCond(Admin admin);

	// 按照Admin类里面的字段名称模糊查询 调用adminDAO里的getAdminByLike配置
	public List<Admin> getAdminByLike(Admin admin);

	// 按主键查询表返回单一的Admin实例 调用adminDAO里的getAdminById配置
	public Admin getAdminById(String adminid);

}
