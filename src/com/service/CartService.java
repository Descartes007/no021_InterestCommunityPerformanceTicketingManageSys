package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Cart;

@Service("cartService")
public interface CartService {
	// 插入数据 调用cartDAO里的insertCart配置
	public int insertCart(Cart cart);

	// 更新数据 调用cartDAO里的updateCart配置
	public int updateCart(Cart cart);

	// 删除数据 调用cartDAO里的deleteCart配置
	public int deleteCart(String cartid);

	// 查询全部数据 调用cartDAO里的getAllCart配置
	public List<Cart> getAllCart();

	// 按照Cart类里面的字段名称精确查询 调用cartDAO里的getCartByCond配置
	public List<Cart> getCartByCond(Cart cart);

	// 按照Cart类里面的字段名称模糊查询 调用cartDAO里的getCartByLike配置
	public List<Cart> getCartByLike(Cart cart);

	// 按主键查询表返回单一的Cart实例 调用cartDAO里的getCartById配置
	public Cart getCartById(String cartid);

}
