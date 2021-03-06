package com.hostbook.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hostbook.model.User;
import com.hostbook.repo.UserRepo;
import com.hostbook.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepo repo;

	@Transactional
	public Integer saveUser(User user) {
		return repo.save(user).getId();
	}

	@Transactional
	public void updateUser(User user) {
		repo.save(user);
	}

	@Transactional
	public void deleteUser(Integer id) {
		repo.deleteById(id);
	}

	@Transactional(readOnly = true)
	public User getOneUser(Integer id) {
		Optional<User> opt = repo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Transactional(readOnly = true)
	public List<User> getAllUsers() {
		List<User> list = repo.findAll();
		return list;
	}

	@Transactional(readOnly = true)
	public boolean isUserExist(Integer id) {
		Optional<User> opt = repo.findById(id);
		if (opt.isPresent()) {
			return true;
		}
		return false;
	}

}
