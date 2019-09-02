package com.bd.action;

import java.util.List;
import java.util.Map;

import com.bd.entity.BlogClassifyEntity;
import com.bd.entity.BlogMngEntity;
import com.bd.entity.UserEntity;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bd.entity.BlogArticleEntity;
import com.bd.service.BlogService;
import com.opensymphony.xwork2.ActionSupport;

public class BlogAction extends ActionSupport implements RequestAware,SessionAware{

    private BlogService blogService; // 需注入

	private BlogClassifyEntity type; // 前台需给出欲加载的文章类型
	private BlogArticleEntity ba; // 前台传入

	private Map<String, Object> request;
	private Map<String, Object> session;


    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }


	public void setType(BlogClassifyEntity type) {
		this.type = type;
	}


	public BlogArticleEntity getBa() {
		return ba;
	}

	public void setBa(BlogArticleEntity ba) {
		this.ba = ba;
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

		List<BlogClassifyEntity> baList = blogService.getBlogClassify();
		List<BlogArticleEntity> selectArticle = blogService.getSelectBlogArticles(type);
        if (baList != null) {
			request.put("ArticleClassifyList", baList);
		}
        if (selectArticle != null) {
			request.put("selectArticlesList",selectArticle);
		}

		return "index";
	}


	// 加载指定article 成功返回success,失败返回fail
    public String doGetArticle() {
		ba = blogService.getArticle(ba);
		if (ba == null) return "fail";
		request.put("blogArticle", ba);
		return "success";
	}

    public String doGetMyArticles() {

        UserEntity user = (UserEntity) session.get(Key_Value.user);
        if (user == null) return "fail";
        List<BlogArticleEntity> myArticles = null;


        // 将user blogmng 封装 到ba.
        BlogMngEntity blogmng = new BlogMngEntity();
        blogmng.setUser(user);
        if (ba == null) ba = new BlogArticleEntity();

        if (ba.getStatus() == null || ba.getStatus().equals("all")) ba.setStatus(null);
        ba.setBlogMng(blogmng);

        myArticles = blogService.getMyArticles(ba);
        if (myArticles == null) return "fail";
        request.put("myArticles", myArticles);

        System.out.println(myArticles.size());
        for (BlogArticleEntity article : myArticles) {
            System.out.println(article.getId());
        }

//		System.out.println("date:   "+ba.getReleaseTime());

        return "success";
    }


}
