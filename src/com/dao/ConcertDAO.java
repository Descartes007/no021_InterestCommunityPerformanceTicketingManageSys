package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Concert;

@Repository("concertDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface ConcertDAO {

	/**
	 * ConcertDAO 接口 可以按名称直接调用concert.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包concert.xml里的insertConcert配置 返回值0(失败),1(成功)
	public int insertConcert(Concert concert);

	// 更新数据 调用entity包concert.xml里的updateConcert配置 返回值0(失败),1(成功)
	public int updateConcert(Concert concert);

	// 删除数据 调用entity包concert.xml里的deleteConcert配置 返回值0(失败),1(成功)
	public int deleteConcert(String concertid);

	// 查询全部数据 调用entity包concert.xml里的getAllConcert配置 返回List类型的数据
	public List<Concert> getAllConcert();

	public List<Concert> getConcertByCate(String cateid);

	public List<Concert> getConcertByHot();
	
	public List<Concert> getConcertByNews();

	// 按照Concert类里面的值精确查询 调用entity包concert.xml里的getConcertByCond配置 返回List类型的数据
	public List<Concert> getConcertByCond(Concert concert);

	// 按照Concert类里面的值模糊查询 调用entity包concert.xml里的getConcertByLike配置 返回List类型的数据
	public List<Concert> getConcertByLike(Concert concert);

	// 按主键查询表返回单一的Concert实例 调用entity包concert.xml里的getConcertById配置
	public Concert getConcertById(String concertid);

}
