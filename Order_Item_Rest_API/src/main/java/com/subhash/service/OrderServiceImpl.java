package com.subhash.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.subhash.model.Order;
import com.subhash.repo.OrderRepo;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderRepo orderRepo;

	@Transactional
	public Integer saveOrder(Order order) {
		return orderRepo.save(order).getOrderId();

	}

	@Transactional(readOnly = true)
	public Order getOrder(Integer orderId) {
		Optional<Order> opt = orderRepo.findById(orderId);
		if (opt.isPresent())
			return opt.get();
		return null;
	}

	@Transactional(readOnly = true)
	public List<Order> gerAllOrder() {
		return orderRepo.findAll();
	}

}
