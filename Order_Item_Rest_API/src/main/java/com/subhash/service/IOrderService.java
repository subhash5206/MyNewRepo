package com.subhash.service;

import java.util.List;

import com.subhash.model.Order;

public interface IOrderService {

	Integer saveOrder(Order order);

	Order getOrder(Integer orderId);

	List<Order> gerAllOrder();

}
