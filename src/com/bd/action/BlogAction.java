package com.bd.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bd.entity.BlogArticleEntity;
import com.bd.service.BlogService;
import com.opensymphony.xwork2.ActionSupport;

public class BlogAction extends ActionSupport implements RequestAware,SessionAware{

	BlogService blogService; // 需注入
	
	Map<String,Object> request;
	Map<String,Object> session;
	
	
	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	// 加载主页内容 博客
	public String list(){
		
		List<BlogArticleEntity> baList = blogService.getAllBlogArticle();
		if(baList.size()>0) {
			request.put("baList", baList);
		}
		
		
		return "index";
	}
	

}
