package com.subhash.service;

import java.util.List;

import com.subhash.model.Item;

public interface IItemService {

	Integer saveItem(Item item);

	Item getItem(Integer itemId);

	List<Item> gerAllItem();

}
