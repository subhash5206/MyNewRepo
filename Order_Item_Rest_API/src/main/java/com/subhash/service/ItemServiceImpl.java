package com.subhash.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.subhash.model.Item;
import com.subhash.repo.ItemRepo;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private ItemRepo itemRepo;

	@Transactional
	public Integer saveItem(Item item) {
		return itemRepo.save(item).getItemId();

	}

	@Transactional(readOnly = true)
	public Item getItem(Integer itemId) {
		Optional<Item> opt = itemRepo.findById(itemId);
		if (opt.isPresent())
			return opt.get();
		return null;
	}

	@Transactional(readOnly = true)
	public List<Item> gerAllItem() {
		return itemRepo.findAll();
	}

}
