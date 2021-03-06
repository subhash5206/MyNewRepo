package com.hostbook.service;

import java.util.List;

import com.hostbook.model.User;

public interface IUserService {

	Integer saveUser(User user);

	void updateUser(User user);

	void deleteUser(Integer id);

	User getOneUser(Integer id);

	List<User> getAllUsers();

	boolean isUserExist(Integer id);

}
