package com.bd.action;

import java.util.List;
import java.util.Map;

import com.bd.entity.BlogClassifyEntity;
import com.bd.entity.UserEntity;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bd.entity.BlogArticleEntity;
import com.bd.service.BlogService;
import com.opensymphony.xwork2.ActionSupport;

public class BlogAction extends ActionSupport implements RequestAware,SessionAware{

    private BlogService blogService; // ��ע��

	private BlogClassifyEntity type; // ǰ̨����������ص���������
	private BlogArticleEntity ba; // ǰ̨����

    private UserEntity user; //�������˲�����ҳ��
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

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}


    // ������ҳ���� ����
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


    //�������˲�����ҳ
    public String doGetBlogMng() {
        if (user == null || user.getId() == 0) {
            return "fail";
        }
        List<BlogArticleEntity> publicArticles;
        publicArticles = blogService.getBlogMng(user);
        request.put("blogMng", publicArticles);
        return "success";
    }



	// ����ָ��article �ɹ�����success,ʧ�ܷ���fail
    public String doGetArticle() {
		ba = blogService.getArticle(ba);
		if (ba == null) return "fail";
		request.put("blogArticle", ba);
		return "success";
	}

    public String doGetMyArticles() {

        UserEntity user = (UserEntity) session.get(Key_Value.user);
        if (user == null) return "fail";
        List<BlogArticleEntity> myArticles;

        myArticles = blogService.getMyArticles(user, ba);
        if (myArticles == null) return "fail";
        request.put("myArticles", myArticles);
        return "success";
    }


}
