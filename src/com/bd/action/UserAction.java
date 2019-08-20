package com.bd.action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

import com.bd.entity.UserEntity;
import com.bd.service.UserService;

public class UserAction extends ActionSupport {
	
	UserEntity ue; // ���ڷ�װ��¼������
	UserService userService; // ��ע��

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public UserEntity getUe() {
		return ue;
	}

	public void setUe(UserEntity ue) {
		this.ue = ue;
	}
	
	// ��¼
	public String doLogin() throws Exception {
		List<UserEntity> ueList = userService.login(ue);
		if(ueList.size() > 0) {
			// ��¼�ɹ� index.jsp
			return "index";
		}else {
			// ��¼ʧ�� login.jsp
			return "login";
		}
	}
	
	// ע��
	public String doRegist() throws Exception {
		int result = 0;
		result = userService.addUser(ue);
		System.out.println(result);
		if(result != 0) {
			System.out.println("ע��ɹ�");
			return "login";
		}else {
			System.out.println("ע��ʧ��");
			return "regist";
		}
	}
	
}
