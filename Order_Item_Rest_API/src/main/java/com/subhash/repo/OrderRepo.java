package com.subhash.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subhash.model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
