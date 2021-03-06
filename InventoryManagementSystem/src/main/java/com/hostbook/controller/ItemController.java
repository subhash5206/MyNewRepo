package com.hostbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostbook.model.Item;
import com.hostbook.service.impl.ItemServiceImpl;

/*	 Go to postman then , try all the below url's , 
 *   to check all the operations 
 * 		
 * 		localhost:8080/Item/save
		localhost:8080/Item/fetch
		localhost:8080/Item/delete/1
		localhost:8080/Item/update/2
*/
@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemServiceImpl service;

//	Creating New Items Account
	@PostMapping("/save")
	public ResponseEntity<String> createItem(@RequestBody Item item) {
		service.saveItem(item);
		Integer id = item.getId();
		ResponseEntity<String> response = new ResponseEntity<String>("New Item Added with  '" + id + "'  ",
				HttpStatus.ACCEPTED);
		return response;
	}

	// Item  Modification
	// Examples to do modification in operation 
	// localhost:8080/item/update/4
	/*
	 * { "id":"4", "itemName":"laptop", "itemImage":"abcdef.jpg",
	 * "itemCategory":"electronity", "itemQuantity":"5", "itemUnit":"46",
	 * "itemUnitPrice":"4546953.353", "itemStatus":"dispatched" }
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateItem(@PathVariable Integer id, @RequestBody Item item) {

		Item update = service.getOneItem(id);
		update.setId(item.getId());
		update.setItemName(item.getItemName());
		update.setItemImage(item.getItemImage());
		update.setItemCategory(item.getItemCategory());
		update.setItemQuantity(item.getItemQuantity());
		update.setItemUnit(item.getItemUnit());
		update.setItemUnitPrice(item.getItemUnitPrice());
		update.setItemStatus(item.getItemStatus());
		service.updateItem(item);
		ResponseEntity<String> response = new ResponseEntity<String>(
				"Item Account Data Modified with ID  '" + id + "' ", HttpStatus.ACCEPTED);

		return response;
	}

	// Fetching the all records available in the records
	@GetMapping("/fetch")
	public ResponseEntity<List<Item>> getAllItem() {
		List<Item> item = service.getAllItems();
		ResponseEntity<List<Item>> response = new ResponseEntity<List<Item>>(item, HttpStatus.FOUND);
		return response;
	}

	// Deleting the records i.e. already saved in the database
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> DeleteItemById(@PathVariable Integer id) {
		service.deleteItem(id);
		ResponseEntity<String> response = new ResponseEntity<String>("Item '" + id + "'Deleted", HttpStatus.FOUND);
		return response;
	}

}
