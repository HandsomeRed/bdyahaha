package com.bd.service.imply;

import java.util.List;

import com.bd.dao.UserDao;
import com.bd.entity.UserEntity;
import com.bd.service.UserService;

public class UserServiceImply implements UserService {

	UserDao userDao; // Ðè×¢Èë
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<UserEntity> login(UserEntity cond) {
		return userDao.search(cond);
	}

	@Override
	public int addUser(UserEntity cond) {
		return userDao.addUser(cond);
	}

}
