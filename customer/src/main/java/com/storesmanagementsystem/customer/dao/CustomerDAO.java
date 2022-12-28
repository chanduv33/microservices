package com.storesmanagementsystem.customer.dao;

import java.util.List;

import com.storesmanagementsystem.customer.dto.*;


public interface CustomerDAO {
	public OrderDetails buyProduct(OrderDetails cameOrder, String userId);
	public OrderDetails getOrderDetails(int id);
	public boolean checkEmailAvailability(String email);
	public void autoBuy(int minimumQty,DealerProductInfoBean prodcut);
	public List<DealerProductInfoBean> getProds();
}
