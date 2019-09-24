package com.bd.action;

import com.bd.entity.BlogArticleEntity;
import com.bd.entity.UserEntity;
import com.bd.service.WriteBlogService;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import tool.Key_Value;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.Map;

public class WriteBlogAction extends ActionSupport implements SessionAware {

	private BlogArticleEntity be; // 封装表单提交参数 这里是博文对象
	private WriteBlogService wbs;
	private Map<String, Object> session;
	private File upload;
	private String uploadFileName;
	public BlogArticleEntity getBe() {
		return be;
	}

	public void setBe(BlogArticleEntity be) {
		this.be = be;
	}

	// 写博客
	public String doWriteBlog() {

		UserEntity user = (UserEntity) session.get(Key_Value.user);
		return wbs.addArticle(user, be) ? "success" : "fail";
	}

	// 加载写博客页面
	public String doLoginWriteBlog() {
		return "success";
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

	public Map<String, Object> getSession() {
		return session;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String doUploadPicture() throws Exception {

		ServletOutputStream outPut = ServletActionContext.getResponse().getOutputStream();
		JSONObject json = new JSONObject();
		uploadFileName = new Date().getTime() + uploadFileName.substring(uploadFileName.lastIndexOf("."));
		String relativePath = wbs.savePicture(upload, uploadFileName);

		json.put("uploaded", true);
		json.put("url", "../" + Key_Value.relativePicturePath + "/" + uploadFileName);
		System.out.println(upload.getName());
		System.out.println(json.toString());
		outPut.print(json.toString());
		outPut.flush();
		outPut.close();
		return "success";
	}
}
