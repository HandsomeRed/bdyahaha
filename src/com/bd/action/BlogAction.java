package com.bd.action;

import com.bd.entity.BlogArticleEntity;
import com.bd.entity.BlogClassifyEntity;
import com.bd.entity.UserEntity;
import com.bd.service.BlogService;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import tool.Key_Value;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class BlogAction extends ActionSupport implements RequestAware, SessionAware {

    private BlogService blogService; // 需注入

    private BlogClassifyEntity type; // 前台需给出欲加载的文章类型
    private BlogArticleEntity ba; // 前台传入


    private UserEntity user; //访问他人博客主页用
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


    // 加载主页内容 博客
    public String list() {

        List<BlogClassifyEntity> baList = blogService.getBlogClassify();
        List<BlogArticleEntity> selectArticle = blogService.getSelectBlogArticles(type);
        if (baList != null) {
            request.put("ArticleClassifyList", baList);
        }
        if (selectArticle != null) {
            request.put("selectArticlesList", selectArticle);
        }

        return "index";
    }


    //加载他人博客主页 | 加载个人博客管理页面的 博文List
    public String doGetBlogMng() {
        if (user == null || user.getId() == 0) {
            return "fail";
        }
        List<BlogArticleEntity> publicArticles;
        publicArticles = blogService.getBlogMng(user);
        request.put("someoneArticleList", publicArticles);

        UserEntity someone = new UserEntity();
        someone = blogService.getUser(user);
        request.put("author", someone);

        return "success";
    }


    // 加载指定article 成功返回success,失败返回fail
    public String doGetArticle() {
        ba = blogService.getArticle(ba);
        if (ba == null) return "fail";
        request.put("blogArticle", ba);
        return "success";
    }

    //自己blogMng
    public String doGetMyArticles() {

        UserEntity user = (UserEntity) session.get(Key_Value.user);
        if (user == null) return "fail";
        List<BlogArticleEntity> myArticles;
        myArticles = blogService.getMyArticles(user, ba);

        if (myArticles == null) return "fail";
        request.put("blogArticleList", myArticles);

        return "success";
    }

    public String doDeleteBlogArticle() {
        UserEntity user = (UserEntity) session.get(Key_Value.user);
        if (user == null) return "fail";

        return blogService.doDeleteBlogArticle(user, ba);
    }


}
