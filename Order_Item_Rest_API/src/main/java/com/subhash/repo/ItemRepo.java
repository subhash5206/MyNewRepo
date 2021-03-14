package com.subhash.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subhash.model.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
