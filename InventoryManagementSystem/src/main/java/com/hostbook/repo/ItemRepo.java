package com.hostbook.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hostbook.model.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {


}
