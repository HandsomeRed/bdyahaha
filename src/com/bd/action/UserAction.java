package com.bd.action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bd.entity.UserEntity;
import com.bd.service.UserService;
import org.apache.struts2.interceptor.SessionAware;

public class UserAction extends ActionSupport implements SessionAware {

    private UserEntity ue; // 用于封装登录表单参数
    private UserService userService; // 需注入
    private Map<String, Object> session; // session

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
        ue = userService.login(ue);
        if (ue != null) {
            // 登录成功 跳转至 index.jsp,同时将user 信息储存于session.
            session.put("userInfor", ue);
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
	public String doCheck() throws Exception{
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
		return "test";
	}

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
    }
}
