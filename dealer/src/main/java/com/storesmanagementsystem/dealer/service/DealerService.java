package com.storesmanagementsystem.dealer.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.storesmanagementsystem.dealer.dto.DealerProductInfoBean;
import com.storesmanagementsystem.dealer.dto.OrderDetails;
import com.storesmanagementsystem.dealer.dto.ProductInfoBean;

public interface DealerService {
	public OrderDetails placeOrder(String userId, @RequestBody OrderDetails bean);

	public boolean setSellingPrice(DealerProductInfoBean dealer);

	public DealerProductInfoBean getProduct(int id);

	public OrderDetails getPaymentDeatils(int orderId);

	public List<DealerProductInfoBean> getAllProducts(int userId);

	// public boolean checkNameAvailability(String name) ;
	public boolean setMinimumQuantity(DealerProductInfoBean dealer);

	public List<ProductInfoBean> getProducts();

	public boolean update(DealerProductInfoBean dealer);
}
