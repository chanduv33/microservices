package com.storesmanagementsystem.manufacturer.dao;

import java.util.List;

import com.storesmanagementsystem.manufacturer.dto.*;
public interface ManufacturerDAO {
	public boolean setCostPrice(ProductInfoBean bean);
	public List<OrderDetails> getPaymentDetails(int userId);
	public boolean addProduct(UserInfoBean manufacturer);
	public List<ProductInfoBean> getAllProducts(int userId);
	public boolean updateProduct(ProductInfoBean bean);
	public boolean removeProduct(int productId);
}
