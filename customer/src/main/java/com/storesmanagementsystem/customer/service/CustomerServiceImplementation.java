package com.storesmanagementsystem.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storesmanagementsystem.customer.dao.CustomerDAO;
import com.storesmanagementsystem.customer.dto.DealerProductInfoBean;
import com.storesmanagementsystem.customer.dto.OrderDetails;

@Service
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	private CustomerDAO dao;

	@Override
	public OrderDetails buyProduct(OrderDetails cameOrder, String userId) {
		return dao.buyProduct(cameOrder, userId);
	}

	@Override
	public OrderDetails getOrderDetails(int id) {
		return dao.getOrderDetails(id);
	}

	@Override
	public boolean checkEmailAvailability(String email) {
		return dao.checkEmailAvailability(email);
	}

	@Override
	public List<DealerProductInfoBean> getProds() {
		return dao.getProds();
	}
}
