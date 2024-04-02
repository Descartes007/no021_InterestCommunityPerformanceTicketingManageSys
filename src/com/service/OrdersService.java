package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Orders;

@Service("ordersService")
public interface OrdersService {
	// 插入数据 调用ordersDAO里的insertOrders配置
	public int insertOrders(Orders orders);

	// 更新数据 调用ordersDAO里的updateOrders配置
	public int updateOrders(Orders orders);

	// 删除数据 调用ordersDAO里的deleteOrders配置
	public int deleteOrders(String ordersid);

	// 查询全部数据 调用ordersDAO里的getAllOrders配置
	public List<Orders> getAllOrders();

	// 按照Orders类里面的字段名称精确查询 调用ordersDAO里的getOrdersByCond配置
	public List<Orders> getOrdersByCond(Orders orders);

	// 按照Orders类里面的字段名称模糊查询 调用ordersDAO里的getOrdersByLike配置
	public List<Orders> getOrdersByLike(Orders orders);

	// 按主键查询表返回单一的Orders实例 调用ordersDAO里的getOrdersById配置
	public Orders getOrdersById(String ordersid);

}
