package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Concert;

@Service("concertService")
public interface ConcertService {
	// 插入数据 调用concertDAO里的insertConcert配置
	public int insertConcert(Concert concert);

	// 更新数据 调用concertDAO里的updateConcert配置
	public int updateConcert(Concert concert);

	// 删除数据 调用concertDAO里的deleteConcert配置
	public int deleteConcert(String concertid);

	// 查询全部数据 调用concertDAO里的getAllConcert配置
	public List<Concert> getAllConcert();

	public List<Concert> getConcertByCate(String cateid);

	public List<Concert> getConcertByHot();

	public List<Concert> getConcertByNews();

	// 按照Concert类里面的字段名称精确查询 调用concertDAO里的getConcertByCond配置
	public List<Concert> getConcertByCond(Concert concert);

	// 按照Concert类里面的字段名称模糊查询 调用concertDAO里的getConcertByLike配置
	public List<Concert> getConcertByLike(Concert concert);

	// 按主键查询表返回单一的Concert实例 调用concertDAO里的getConcertById配置
	public Concert getConcertById(String concertid);

}
