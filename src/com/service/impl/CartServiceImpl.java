package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.CartDAO;
import com.entity.Cart;
import com.service.CartService;

@Service("cartService")
public class CartServiceImpl implements CartService {
	@Autowired
	@Resource
	private CartDAO cartDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertCart(Cart cart) {
		return this.cartDAO.insertCart(cart);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateCart(Cart cart) {
		return this.cartDAO.updateCart(cart);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteCart(String cartid) {
		return this.cartDAO.deleteCart(cartid);
	}

	@Override // 继承接口的查询全部
	public List<Cart> getAllCart() {
		return this.cartDAO.getAllCart();
	}

	@Override // 继承接口的按条件精确查询
	public List<Cart> getCartByCond(Cart cart) {
		return this.cartDAO.getCartByCond(cart);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Cart> getCartByLike(Cart cart) {
		return this.cartDAO.getCartByLike(cart);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Cart getCartById(String cartid) {
		return this.cartDAO.getCartById(cartid);
	}

}
