package com.hostbook.service;

import java.util.List;

import com.hostbook.model.Item;

public interface IItemService {

	Integer saveItem(Item item);

	void updateItem(Item item);

	void deleteItem(Integer id);

	Item getOneItem(Integer id);

	List<Item> getAllItems();

	boolean isItemExist(Integer id);

}
