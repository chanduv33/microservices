package com.storesmanagementsystem.dealer.dao;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.storesmanagementsystem.dealer.dto.DealerProductInfoBean;
import com.storesmanagementsystem.dealer.dto.OrderDetails;
import com.storesmanagementsystem.dealer.dto.ProductInfoBean;

public interface DealerDAO {
	public OrderDetails placeOrder(String userId, @RequestBody OrderDetails bean);

	public boolean setSellingPrice(DealerProductInfoBean dealer);

	public DealerProductInfoBean getProduct(int id);

	public OrderDetails getPaymentDeatils(int orderId);

	public boolean checkNameAvailability(String name);

	public List<DealerProductInfoBean> getAllProducts(int userId);

	public boolean setMinimumQuantity(DealerProductInfoBean dealer);

	public List<ProductInfoBean> getProducts();

	public boolean update(DealerProductInfoBean dealer);
}
