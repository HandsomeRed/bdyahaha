package com.bd.action;

import com.bd.entity.BlogArticleEntity;
import com.bd.entity.UserEntity;
import com.bd.service.WriteBlogService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class WriteBlogAction extends ActionSupport implements SessionAware {

	private BlogArticleEntity be; // ��װ���ύ���� �����ǲ��Ķ���
	private WriteBlogService wbs;
	private Map<String, Object> session;

	public BlogArticleEntity getBe() {
		return be;
	}

	public void setBe(BlogArticleEntity be) {
		this.be = be;
	}

	// д����
	public String doWriteBlog() {

		UserEntity user = (UserEntity) session.get(Key_Value.user);
		return wbs.addArticle(user, be) ? "success" : "fail";
	}

	@Override
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}


	public WriteBlogService getWbs() {
		return wbs;
	}

	public void setWbs(WriteBlogService wbs) {
		this.wbs = wbs;
	}
}
