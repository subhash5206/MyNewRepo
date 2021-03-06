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

import com.hostbook.model.User;
import com.hostbook.service.IItemService;
import com.hostbook.service.IUserService;

/*	 Go to postman then , try all the below url's , 
 *   to check all the operations 
 * 		
 * 		localost:8080/user/save
		localhost:8080/user/fetch
		localhost:8080/user/delete/1
		localhost:8080/user/update/2
*/
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;

//	Creating New Users Account
	@PostMapping("/save")
	public ResponseEntity<String> createUser(@RequestBody User user) {
		service.saveUser(user);
		Integer id = user.getId();
		ResponseEntity<String> response = new ResponseEntity<String>("New User Account Created with  '" + id + "'  ",
				HttpStatus.ACCEPTED);
		return response;
	}

	// User Accound Modification
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody User user) {

		User update = service.getOneUser(id);
		update.setId(user.getId());
		update.setUserSalutation(user.getUserSalutation());
		update.setUserFirstName(user.getUserFirstName());
		update.setUserLastName(user.getUserLastName());
		update.setUserGender(user.getUserGender());
		update.setUserMobile(user.getUserMobile());
		update.setUserEmail(user.getUserEmail());
		update.setUserAddress(user.getUserAddress());
		update.setUserRole(user.getUserRole());
		update.setUserStatus(user.getUserStatus());

		service.updateUser(user);
		ResponseEntity<String> response = new ResponseEntity<String>(
				"User Account Data Modified with ID  '" + id + "' ", HttpStatus.ACCEPTED);

		return response;
	}

	// Fetching the all records available in the records
	@GetMapping("/fetch")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> user = service.getAllUsers();
		ResponseEntity<List<User>> response = new ResponseEntity<List<User>>(user, HttpStatus.FOUND);
		return response;
	}

	// Deleting the records i.e. already saved in the database
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> DeleteUserById(@PathVariable Integer id) {
		service.deleteUser(id);
		ResponseEntity<String> response = new ResponseEntity<String>("Data '" + id + "'Deleted", HttpStatus.FOUND);
		return response;
	}

}
