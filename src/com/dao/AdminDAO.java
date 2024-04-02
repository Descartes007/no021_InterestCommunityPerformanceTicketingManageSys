package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Admin;

@Repository("adminDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface AdminDAO {

	/**
	 * AdminDAO 接口 可以按名称直接调用admin.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包admin.xml里的insertAdmin配置 返回值0(失败),1(成功)
	public int insertAdmin(Admin admin);

	// 更新数据 调用entity包admin.xml里的updateAdmin配置 返回值0(失败),1(成功)
	public int updateAdmin(Admin admin);

	// 删除数据 调用entity包admin.xml里的deleteAdmin配置 返回值0(失败),1(成功)
	public int deleteAdmin(String adminid);

	// 查询全部数据 调用entity包admin.xml里的getAllAdmin配置 返回List类型的数据
	public List<Admin> getAllAdmin();

	// 按照Admin类里面的值精确查询 调用entity包admin.xml里的getAdminByCond配置 返回List类型的数据
	public List<Admin> getAdminByCond(Admin admin);

	// 按照Admin类里面的值模糊查询 调用entity包admin.xml里的getAdminByLike配置 返回List类型的数据
	public List<Admin> getAdminByLike(Admin admin);

	// 按主键查询表返回单一的Admin实例 调用entity包admin.xml里的getAdminById配置
	public Admin getAdminById(String adminid);

}
