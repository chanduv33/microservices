package com.storesmanagementsystem.dealer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.storesmanagementsystem.dealer.dto.DealerProductInfoBean;
import com.storesmanagementsystem.dealer.dto.OrderDetails;
import com.storesmanagementsystem.dealer.dto.ProductInfoBean;
import com.storesmanagementsystem.dealer.dto.ResponseClass;
import com.storesmanagementsystem.dealer.service.DealerService;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "Access-Control-Allow-Origin")
public class DealerController {

	@Autowired
	private DealerService service;

	@PostMapping(path = "/Order", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass placeOrder(@RequestParam("userId") String userId, @RequestBody OrderDetails bean) {
		ResponseClass resp = new ResponseClass();
		OrderDetails order = service.placeOrder(userId, bean);
		if (order != null) {
			resp.setStatusCode(201);
			resp.setMessage("Success");
			resp.setDescription("Order Placed Successfully");
			resp.setOrder(order);
			return resp;
		} else {
			resp.setStatusCode(401);
			resp.setMessage("/Failed");
			resp.setDescription("Placing Order Unsuccessfull");
			return resp;
		}
	}

	@PostMapping(path = "/Product/Price", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass setSellingPrice(@RequestBody DealerProductInfoBean bean) {
		ResponseClass resp = new ResponseClass();
		if (service.setSellingPrice(bean)) {
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
		List<DealerProductInfoBean> prods = service.getAllProducts(userId);
		if (prods != null) {
			resp.setStatusCode(201);
			resp.setMessage("Success");
			resp.setDescription("Products Found");
			resp.setDealerProds(prods);
			return resp;
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Failed");
			resp.setDescription("Products Not Found");
			return resp;
		}
	}

	@GetMapping(path = "/Product", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass getProduct(@RequestParam("dealersProductId") int dealersProductId) {
		ResponseClass resp = new ResponseClass();
		DealerProductInfoBean prod = service.getProduct(dealersProductId);
		if (prod != null) {
			resp.setStatusCode(201);
			resp.setMessage("Success");
			resp.setDescription("Product Found");
			resp.setDealerProd(prod);
			return resp;
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Failed");
			resp.setDescription("Product Not Found");
			return resp;
		}
	}

	@GetMapping(path = "/Order", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass getOrder(@RequestParam("orderId") int orderId) {
		ResponseClass resp = new ResponseClass();
		OrderDetails order = service.getPaymentDeatils(orderId);
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

	@PostMapping(path = "/Product/Price/Min", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass setMinimumQuantity(@RequestBody DealerProductInfoBean bean) {
		ResponseClass resp = new ResponseClass();
		if (service.setMinimumQuantity(bean)) {
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

	@GetMapping(path = "/Products/getMansProds", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass getManufacturersProducts() {
		ResponseClass resp = new ResponseClass();
		List<ProductInfoBean> products = service.getProducts();
		if (products != null) {
			resp.setStatusCode(201);
			resp.setMessage("Success");
			resp.setDescription("Products Found");
			resp.setProducts(products);
			return resp;
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Failed");
			resp.setDescription("Products Not Found");
			return resp;
		}
	}

	@PutMapping(path = "/Product", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass updateDealerProduct(@RequestBody DealerProductInfoBean bean) {
		ResponseClass resp = new ResponseClass();
		if (service.update(bean)) {
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

}
