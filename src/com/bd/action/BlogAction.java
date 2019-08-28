package com.bd.action;

import java.util.List;
import java.util.Map;

import com.bd.entity.BlogClassifyEntity;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bd.entity.BlogArticleEntity;
import com.bd.service.BlogService;
import com.opensymphony.xwork2.ActionSupport;

public class BlogAction extends ActionSupport implements RequestAware,SessionAware{



    BlogService blogService; // ��ע��



	BlogClassifyEntity type; // ǰ̨����������ص���������
	Map<String,Object> request;
	Map<String,Object> session;


    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }


	public void setType(BlogClassifyEntity type) {
		this.type = type;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	// ������ҳ���� ����
	public String list(){

//    	test
//    	BlogClassifyEntity type = new BlogClassifyEntity();
//    	type.setName("one");
		
		List<BlogClassifyEntity> baList = blogService.getBlogClassify();
		List<BlogArticleEntity> selectArticle = blogService.getSelectBlogArticles(type);
		for (BlogClassifyEntity b: baList) {
			System.out.println(b.getName());
		}

		for (BlogArticleEntity ba : selectArticle){
			System.out.println(ba.getId());
		}


		if(baList.size()>0) {
			request.put("ArticleClassifyList", baList);
		}
		if (selectArticle.size()>0){
			request.put("selectArticlesList",selectArticle);
		}

		return "index";
	}


}
