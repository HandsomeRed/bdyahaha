package com.bd.action;

import com.bd.entity.BlogArticleEntity;
import com.opensymphony.xwork2.ActionSupport;

public class WriteBlogAction extends ActionSupport{
	
	BlogArticleEntity be; // ��װ���ύ���� �����ǲ��Ķ���

	public BlogArticleEntity getBe() {
		return be;
	}

	public void setBe(BlogArticleEntity be) {
		this.be = be;
	}

	// д����
	public String doWriteBlog() {
		System.out.println("[WriteBlogAciton]-doWriteBlog");
		System.out.println(be.getTitle());
		System.out.println(be.getContent());
		return "index";
	}
}
