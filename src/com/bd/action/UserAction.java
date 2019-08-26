package com.bd.action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bd.entity.UserEntity;
import com.bd.service.UserService;

public class UserAction extends ActionSupport {
	
	UserEntity ue; // 用于封装登录表单参数
	UserService userService; // 需注入

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public UserEntity getUe() {
		return ue;
	}

	public void setUe(UserEntity ue) {
		this.ue = ue;
	}
	
	// 登录
	public String doLogin() throws Exception {
		List<UserEntity> ueList = userService.login(ue);
		if(ueList.size() > 0) {
			// 登录成功 index.jsp
			return "index";
		}else {
			// 登录失败 login.jsp
			return "login";
		}
	}
	
	// 注册
	public String doRegist() throws Exception {
		int result = 0;
		result = userService.addUser(ue);
		System.out.println(result);
		if(result != 0) {
			System.out.println("注册成功");
			return "login";
		}else {
			System.out.println("注册失败");
			return "regist";
		}
		
	}
	//检测用户名
	public void doCheck() throws Exception{
		HttpServletResponse response=ServletActionContext.getResponse();  
        //以下代码从JSON.java中拷过来的  
        response.setContentType("text/html");  
        PrintWriter out;  
        out = response.getWriter();  
		if(userService.checkUser(ue)) {
			System.out.println("账户可用");
			out.print(SUCCESS);
		}else {
			System.out.println("账户不可用");
			out.print("fail");
		}
	}
	
}
