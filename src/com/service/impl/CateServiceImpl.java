package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.CateDAO;
import com.entity.Cate;
import com.service.CateService;

@Service("cateService")
public class CateServiceImpl implements CateService {
	@Autowired
	@Resource
	private CateDAO cateDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertCate(Cate cate) {
		return this.cateDAO.insertCate(cate);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateCate(Cate cate) {
		return this.cateDAO.updateCate(cate);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteCate(String cateid) {
		return this.cateDAO.deleteCate(cateid);
	}

	@Override // 继承接口的查询全部
	public List<Cate> getAllCate() {
		return this.cateDAO.getAllCate();
	}

	@Override // 继承接口的查询全部
	public List<Cate> getFrontCate() {
		return this.cateDAO.getFrontCate();
	}

	@Override // 继承接口的按条件精确查询
	public List<Cate> getCateByCond(Cate cate) {
		return this.cateDAO.getCateByCond(cate);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Cate> getCateByLike(Cate cate) {
		return this.cateDAO.getCateByLike(cate);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Cate getCateById(String cateid) {
		return this.cateDAO.getCateById(cateid);
	}

}
