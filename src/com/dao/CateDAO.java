package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Cate;

@Repository("cateDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface CateDAO {

	/**
	 * CateDAO 接口 可以按名称直接调用cate.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包cate.xml里的insertCate配置 返回值0(失败),1(成功)
	public int insertCate(Cate cate);

	// 更新数据 调用entity包cate.xml里的updateCate配置 返回值0(失败),1(成功)
	public int updateCate(Cate cate);

	// 删除数据 调用entity包cate.xml里的deleteCate配置 返回值0(失败),1(成功)
	public int deleteCate(String cateid);

	// 查询全部数据 调用entity包cate.xml里的getAllCate配置 返回List类型的数据
	public List<Cate> getAllCate();

	public List<Cate> getFrontCate();

	// 按照Cate类里面的值精确查询 调用entity包cate.xml里的getCateByCond配置 返回List类型的数据
	public List<Cate> getCateByCond(Cate cate);

	// 按照Cate类里面的值模糊查询 调用entity包cate.xml里的getCateByLike配置 返回List类型的数据
	public List<Cate> getCateByLike(Cate cate);

	// 按主键查询表返回单一的Cate实例 调用entity包cate.xml里的getCateById配置
	public Cate getCateById(String cateid);

}
