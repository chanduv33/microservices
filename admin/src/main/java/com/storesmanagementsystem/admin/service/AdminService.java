package com.storesmanagementsystem.admin.service;

import java.util.List;

import com.storesmanagementsystem.admin.dto.UserInfoBean;

public interface AdminService {
	public boolean updateManufacturerDetails(UserInfoBean manufacturer);
	public List<UserInfoBean> getAllManufacturersDetails();
	public boolean removeManufacturer(int userId);
}
