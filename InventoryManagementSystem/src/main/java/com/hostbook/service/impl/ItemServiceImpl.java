package com.hostbook.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hostbook.model.Item;
import com.hostbook.repo.ItemRepo;
import com.hostbook.service.IItemService;
@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private ItemRepo repo;

	@Transactional
	public Integer saveItem(Item item) {
		return repo.save(item).getId();
	}

	@Transactional
	public void updateItem(Item item) {
		repo.save(item);
	}

	@Transactional
	public void deleteItem(Integer id) {
		repo.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Item getOneItem(Integer id) {
		Optional<Item> opt = repo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Transactional(readOnly = true)
	public List<Item> getAllItems() {
		List<Item> list = repo.findAll();
		return list;
	}

	@Transactional(readOnly = true)
	public boolean isItemExist(Integer id) {
		Optional<Item> opt = repo.findById(id);
		if (opt.isPresent()) {
			return true;
		}
		return false;
	}

}
