package com.storesmanagementsystem.manufacturer.service;

import java.util.List;

import com.storesmanagementsystem.manufacturer.dto.*;


public interface ManufacturerService {
	//public boolean checkNameAvailability(String name) ;
	public boolean setCostPrice(ProductInfoBean bean);
	public List<OrderDetails> getPaymentDetails(int userId);
	//public ManufacturerInfoBean login(ManufacturerInfoBean bean);
	public boolean addProduct(UserInfoBean bean);
	public List<ProductInfoBean> getAllProducts(int userId);
	public boolean updateProduct(ProductInfoBean bean);
	public boolean removeProduct(int productId);
}
