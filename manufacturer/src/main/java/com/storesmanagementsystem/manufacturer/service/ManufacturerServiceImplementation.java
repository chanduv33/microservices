package com.storesmanagementsystem.manufacturer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storesmanagementsystem.manufacturer.dao.ManufacturerDAO;
import com.storesmanagementsystem.manufacturer.dto.*;

@Service
public class ManufacturerServiceImplementation implements ManufacturerService {

	@Autowired
	private ManufacturerDAO dao;

	@Override
	public boolean setCostPrice(ProductInfoBean bean) {
		return dao.setCostPrice(bean);
	}


	@Override
	public boolean addProduct(UserInfoBean manufacturer) {
		return dao.addProduct(manufacturer);
	}

	@Override
	public List<ProductInfoBean> getAllProducts(int userId) {
		return dao.getAllProducts(userId);
	}

	@Override
	public boolean updateProduct(ProductInfoBean bean) {
		// TODO Auto-generated method stub
		return dao.updateProduct(bean);
	}



	@Override
	public List<OrderDetails> getPaymentDetails(int userId) {
		return dao.getPaymentDetails(userId);
	}


	@Override
	public boolean removeProduct(int productId) {
		return dao.removeProduct(productId);
	}

	
}
