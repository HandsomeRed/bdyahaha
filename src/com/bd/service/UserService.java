package com.bd.service;

import java.util.List;

import com.bd.entity.UserEntity;

public interface UserService {
	
	// �����û�(��¼)
	public List<UserEntity> login(UserEntity cond);
	
	// ����û�(ע��)
	public int addUser(UserEntity cond);
}
