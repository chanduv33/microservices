package com.storesmanagementsystem.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.storesmanagementsystem.customer.dto.DealerProductInfoBean;
import com.storesmanagementsystem.customer.dto.OrderDetails;
import com.storesmanagementsystem.customer.dto.ResponseClass;
import com.storesmanagementsystem.customer.service.CustomerService;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "Access-Control-Allow-Origin")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@PostMapping(path = "/Customer/buyProduct", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass buyProduct(@RequestParam("userId") String userId, @RequestBody OrderDetails bean) {
		ResponseClass resp = new ResponseClass();
		OrderDetails order = service.buyProduct(bean, userId);
		if (order != null) {
			resp.setStatusCode(201);
			resp.setMessage("Success");
			resp.setDescription("Order Placed Successfully");
			resp.setOrder(order);
//			service.autoBuy();
			return resp;
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Failed");
			resp.setDescription("Placing Order Unsuccessfull");
			return resp;
		}
	}

	@GetMapping(path = "/Order", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass getOrder(@RequestParam("orderId") int orderId) {
		ResponseClass resp = new ResponseClass();
		OrderDetails order = service.getOrderDetails(orderId);
		if (order != null) {
			resp.setStatusCode(201);
			resp.setMessage("Success");
			resp.setDescription("Order Found");
			resp.setOrder(order);
			return resp;
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Failed");
			resp.setDescription("Order Not Found");
			return resp;
		}
	}

	@GetMapping(path = "/Products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass getManufacturersProducts() {
		ResponseClass resp = new ResponseClass();
		List<DealerProductInfoBean> products = service.getProds();
		if (products != null) {
			resp.setStatusCode(201);
			resp.setMessage("Success");
			resp.setDescription("Products Found");
			resp.setDealerProds(products);
			return resp;
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Failed");
			resp.setDescription("Products Not Found");
			return resp;
		}
	}

}
