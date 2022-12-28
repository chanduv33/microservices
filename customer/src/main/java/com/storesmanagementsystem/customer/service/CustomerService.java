package com.storesmanagementsystem.customer.service;

import java.util.List;

import com.storesmanagementsystem.customer.dto.DealerProductInfoBean;
import com.storesmanagementsystem.customer.dto.OrderDetails;
import com.storesmanagementsystem.customer.dto.UserInfoBean;

public interface CustomerService {
	public OrderDetails buyProduct(OrderDetails cameOrder, String userId);
	public OrderDetails getOrderDetails(int id);
	public boolean checkEmailAvailability(String email);
	public List<DealerProductInfoBean> getProds();
}
