package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.OrdersDAO;
import com.entity.Orders;
import com.service.OrdersService;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	@Resource
	private OrdersDAO ordersDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertOrders(Orders orders) {
		return this.ordersDAO.insertOrders(orders);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateOrders(Orders orders) {
		return this.ordersDAO.updateOrders(orders);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteOrders(String ordersid) {
		return this.ordersDAO.deleteOrders(ordersid);
	}

	@Override // 继承接口的查询全部
	public List<Orders> getAllOrders() {
		return this.ordersDAO.getAllOrders();
	}

	@Override // 继承接口的按条件精确查询
	public List<Orders> getOrdersByCond(Orders orders) {
		return this.ordersDAO.getOrdersByCond(orders);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Orders> getOrdersByLike(Orders orders) {
		return this.ordersDAO.getOrdersByLike(orders);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Orders getOrdersById(String ordersid) {
		return this.ordersDAO.getOrdersById(ordersid);
	}

}
