package com.storesmanagementsystem.manufacturer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.storesmanagementsystem.manufacturer.dto.OrderDetails;
import com.storesmanagementsystem.manufacturer.dto.ProductInfoBean;
import com.storesmanagementsystem.manufacturer.dto.ResponseClass;
import com.storesmanagementsystem.manufacturer.dto.UserInfoBean;
import com.storesmanagementsystem.manufacturer.service.ManufacturerService;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "Access-Control-Allow-Origin")
public class ManufacturerController {

	@Autowired
	private ManufacturerService service;

	@PostMapping(path = "/Product", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass addProduct(@RequestBody UserInfoBean bean) {
		ResponseClass resp = new ResponseClass();
		if (service.addProduct(bean)) {
			resp.setStatusCode(201);
			resp.setMessage("Success");
			resp.setDescription("Producted Added Successfully");
			resp.setUser(bean);
			return resp;
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Failed");
			resp.setDescription("Adding Product Failed");
			return resp;
		}
	}

	@PutMapping(path = "/Product/Cost", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass updateProductCost(@RequestBody ProductInfoBean bean) {
		ResponseClass resp = new ResponseClass();
		if (service.setCostPrice(bean)) {
			resp.setStatusCode(201);
			resp.setMessage("Success");
			resp.setDescription("Updation Successfull");
			return resp;
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Failed");
			resp.setDescription("Updation Product Failed");
			return resp;
		}
	}

	@GetMapping(path = "/Products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass getAllProducts(@RequestParam("userId") int userId) {
		ResponseClass resp = new ResponseClass();
		List<ProductInfoBean> prods = service.getAllProducts(userId);
		if (prods != null) {
			resp.setStatusCode(201);
			resp.setMessage("Success");
			resp.setDescription("Products Found");
			resp.setProducts(prods);
			return resp;
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Failed");
			resp.setDescription("Products NotFound");
			return resp;
		}
	}

	@PutMapping(path = "/Product", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass updateProduct(@RequestBody ProductInfoBean bean) {
		ResponseClass resp = new ResponseClass();
		if (service.updateProduct(bean)) {
			resp.setStatusCode(201);
			resp.setMessage("Success");
			resp.setDescription("Updation Successfull");
			return resp;
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Failed");
			resp.setDescription("Updation Product Failed");
			return resp;
		}
	}

	@GetMapping(path = "/Orders/Payments", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass getPayments(@RequestParam("userId") int userId) {
		ResponseClass resp = new ResponseClass();
		List<OrderDetails> orders = service.getPaymentDetails(userId);
		if (orders != null) {
			resp.setStatusCode(201);
			resp.setMessage("Success");
			resp.setDescription("Orders Found");
			resp.setOrders(orders);
			return resp;
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Failed");
			resp.setDescription("Orders Not Found");
			return resp;
		}
	}

	@DeleteMapping(path = "/Product", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass removeManufacturer(@RequestParam("productId") int productId) {
		ResponseClass resp = new ResponseClass();
		if (service.removeProduct(productId)) {
			resp.setStatusCode(201);
			resp.setMessage("Success");
			resp.setDescription("Product removed successfully");
			return resp;
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Failed");
			resp.setDescription("Product Not Found");
			return resp;
		}
	}

}
