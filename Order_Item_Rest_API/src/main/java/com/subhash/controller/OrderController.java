package com.subhash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subhash.model.Order;
import com.subhash.service.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private IOrderService orderService;

	@PostMapping("/create")
	public ResponseEntity<String> createOrder(@RequestBody Order order) {
		orderService.saveOrder(order);
		ResponseEntity<String> response = new ResponseEntity<String>("Order Created", HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable Integer orderId) {
		Order orderList = orderService.getOrder(orderId);
		ResponseEntity<Order> response = new ResponseEntity<Order>(orderList, HttpStatus.FOUND);
		return response;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Order>> getAllOrder() {
		List<Order> orderList = orderService.gerAllOrder();
		ResponseEntity<List<Order>> response = new ResponseEntity<List<Order>>(orderList, HttpStatus.FOUND);
		return response;
	}

}
