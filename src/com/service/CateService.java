package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Cate;

@Service("cateService")
public interface CateService {
	// 插入数据 调用cateDAO里的insertCate配置
	public int insertCate(Cate cate);

	// 更新数据 调用cateDAO里的updateCate配置
	public int updateCate(Cate cate);

	// 删除数据 调用cateDAO里的deleteCate配置
	public int deleteCate(String cateid);

	// 查询全部数据 调用cateDAO里的getAllCate配置
	public List<Cate> getAllCate();

	public List<Cate> getFrontCate();

	// 按照Cate类里面的字段名称精确查询 调用cateDAO里的getCateByCond配置
	public List<Cate> getCateByCond(Cate cate);

	// 按照Cate类里面的字段名称模糊查询 调用cateDAO里的getCateByLike配置
	public List<Cate> getCateByLike(Cate cate);

	// 按主键查询表返回单一的Cate实例 调用cateDAO里的getCateById配置
	public Cate getCateById(String cateid);

}
