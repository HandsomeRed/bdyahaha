package com.bd.dao;

import java.util.List;

import com.bd.entity.UserEntity;

public interface UserDao {
	// 查找用户(登录)
	public List<UserEntity> search(UserEntity cond);
	
	// 添加用户(注册)
	public int addUser(UserEntity cond);
}
