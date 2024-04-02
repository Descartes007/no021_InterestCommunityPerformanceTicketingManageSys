package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ConcertDAO;
import com.entity.Concert;
import com.service.ConcertService;

@Service("concertService")
public class ConcertServiceImpl implements ConcertService {
	@Autowired
	@Resource
	private ConcertDAO concertDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertConcert(Concert concert) {
		return this.concertDAO.insertConcert(concert);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateConcert(Concert concert) {
		return this.concertDAO.updateConcert(concert);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteConcert(String concertid) {
		return this.concertDAO.deleteConcert(concertid);
	}

	@Override // 继承接口的查询全部
	public List<Concert> getAllConcert() {
		return this.concertDAO.getAllConcert();
	}

	@Override // 继承接口的查询全部
	public List<Concert> getConcertByHot() {
		return this.concertDAO.getConcertByHot();
	}

	@Override // 继承接口的查询全部
	public List<Concert> getConcertByNews() {
		return this.concertDAO.getConcertByNews();
	}

	@Override // 继承接口的查询全部
	public List<Concert> getConcertByCate(String cateid) {
		return this.concertDAO.getConcertByCate(cateid);
	}

	@Override // 继承接口的按条件精确查询
	public List<Concert> getConcertByCond(Concert concert) {
		return this.concertDAO.getConcertByCond(concert);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Concert> getConcertByLike(Concert concert) {
		return this.concertDAO.getConcertByLike(concert);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Concert getConcertById(String concertid) {
		return this.concertDAO.getConcertById(concertid);
	}

}
