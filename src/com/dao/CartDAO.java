package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Cart;

@Repository("cartDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface CartDAO {

	/**
	 * CartDAO 接口 可以按名称直接调用cart.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包cart.xml里的insertCart配置 返回值0(失败),1(成功)
	public int insertCart(Cart cart);

	// 更新数据 调用entity包cart.xml里的updateCart配置 返回值0(失败),1(成功)
	public int updateCart(Cart cart);

	// 删除数据 调用entity包cart.xml里的deleteCart配置 返回值0(失败),1(成功)
	public int deleteCart(String cartid);

	// 查询全部数据 调用entity包cart.xml里的getAllCart配置 返回List类型的数据
	public List<Cart> getAllCart();

	// 按照Cart类里面的值精确查询 调用entity包cart.xml里的getCartByCond配置 返回List类型的数据
	public List<Cart> getCartByCond(Cart cart);

	// 按照Cart类里面的值模糊查询 调用entity包cart.xml里的getCartByLike配置 返回List类型的数据
	public List<Cart> getCartByLike(Cart cart);

	// 按主键查询表返回单一的Cart实例 调用entity包cart.xml里的getCartById配置
	public Cart getCartById(String cartid);

}
