package com.bd.action;

import com.bd.entity.BlogArticleEntity;
import com.opensymphony.xwork2.ActionSupport;

public class WriteBlogAction extends ActionSupport{
	
	BlogArticleEntity be; // 封装表单提交参数 这里是博文对象

	public BlogArticleEntity getBe() {
		return be;
	}

	public void setBe(BlogArticleEntity be) {
		this.be = be;
	}

	// 写博客
	public String doWriteBlog() {
		System.out.println("[WriteBlogAciton]-doWriteBlog");
		System.out.println(be.getTitle());
		System.out.println(be.getContent());
		return "index";
	}
}
