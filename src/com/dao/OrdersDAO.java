package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Orders;

@Repository("ordersDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface OrdersDAO {

	/**
	 * OrdersDAO 接口 可以按名称直接调用orders.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包orders.xml里的insertOrders配置 返回值0(失败),1(成功)
	public int insertOrders(Orders orders);

	// 更新数据 调用entity包orders.xml里的updateOrders配置 返回值0(失败),1(成功)
	public int updateOrders(Orders orders);

	// 删除数据 调用entity包orders.xml里的deleteOrders配置 返回值0(失败),1(成功)
	public int deleteOrders(String ordersid);

	// 查询全部数据 调用entity包orders.xml里的getAllOrders配置 返回List类型的数据
	public List<Orders> getAllOrders();

	// 按照Orders类里面的值精确查询 调用entity包orders.xml里的getOrdersByCond配置 返回List类型的数据
	public List<Orders> getOrdersByCond(Orders orders);

	// 按照Orders类里面的值模糊查询 调用entity包orders.xml里的getOrdersByLike配置 返回List类型的数据
	public List<Orders> getOrdersByLike(Orders orders);

	// 按主键查询表返回单一的Orders实例 调用entity包orders.xml里的getOrdersById配置
	public Orders getOrdersById(String ordersid);

}
