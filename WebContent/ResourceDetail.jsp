<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/public.css">
<link rel="stylesheet" type="text/css" href="css/ResourceDetail.css">
</head>

<body>

<div class="navigation"> <!--导航-->
	<div class="navigatLeft">
    	<ul>
        	<li><a href="list" title="首页图片"><img src="images/ico.jpg"/></a></li>
            <li><a href="list" title="首页" style="margin-left:0px">首页</a></li>
            <li><a href="" title="博客">博客</a></li>
            <li><a href="" title="下载">下载</a></li>
            <li><a href="" title="APP">APP</a></li>
            <li><a href="" title="专题">专题</a></li>
            <li><a href="" title="招聘">招聘</a></li>
            <li><a href="" title="课程">课程</a></li>
            <li><a href="" title="GitHub">GitHub</a></li>
            <li>
            	<div class="navigatLeftSearch">
                	<input type="text" class="inputSearch" name="search" id="search" placeholder="搜索"/>
                    <a href="">
                    	<img  src="images/search.jpg" class="icoSearch"/>
                    </a>
                </div>
            </li>
            <li class="writeBlog">
            	<a href="WriteBlog.jsp" title="writeBlog">
                	<img src="images/write_blog.jpg"/>
                    <span>写博客</span>
                </a>
            </li>
            <li class="message">
            	<a href="" title="message">
                	<img src="images/message.jpg" />
                    <span>消息</span>
                </a>
            </li>
            <s:if test="#session.saveUserInformationTOSession==null">
            	<li class="login_regist">
            		<a href="Login.jsp" title="login">登陆</a>
             	   <span></span>
             	   <a href="Regist.jsp" title="regist">注册</a>
            	</li>
            </s:if>
            <s:else>
            	<li class="loginedUser">
            		<div class="loginedUserBox">
                    	<a href="" class="loginedUserBoxA"><img class="loginedUserBoxAImg" src="images/defaultPic.jpg"></a>
                    </div>
            	</li>
            	<li>
            		<a href="doGetMyArticles">博客管理</a>
            	</li>
            	<li>
            		<a href="doGetMyResources">资源管理</a>
            	</li>
            </s:else>
        </ul>
    </div>
</div>
<div class="clears"></div>
<div class="news_nav">
	<div class="container">
    	<div class="nav_bar">
        	<a href="">下载首页</a>
            <a href="">精品推荐</a>
            <a href="">我的资源</a>
            <a href="">上传资源赚积分</a>
            <a href="">已下载</a>
            <a href="">我的收藏</a>
            <a href="">参与活动送会员</a>
            <span class="hot_text">hot</span>
        </div>
        <div class="search_download">
        	<a href=""  class="help">☹下载帮助</a>
        </div>
    </div>
    <div class="clears"></div>
</div>
<s:iterator id="rsc" value="#request.resource">
<div class="meeting_main">
	<div class="container libd_dl_bread">
    	<div class="row">
        	<div col-md-12>
            	<a href="">下载</a> > 
                <a href="">${rsc.resourceClassifySmall.name}</a> > 
                <!--<a href="">Java</a> >--> 
                <a href="">${rsc.name }</a>
            </div>
        </div>
    </div>
    <div class="clears"></div>
    <div class="download_l left">
    	<div class="download_top">
        	<div class="download_top_wrap">
            	<div class="download_top_t">
                	<div class="download_dl">
                    	<dt>
                        	<img src="images/img_rar.png">
                        </dt>
                        <dd>
                        	<h3>
                            	<span>${rsc.name }</span>
                                <span class="starts"><em>评分：</em>
                                <i aria-hidden="true" class="fa fa-star yellow">★</i>
                                <i aria-hidden="true" class="fa fa-star yellow">★</i>
                                <i aria-hidden="true" class="fa fa-star yellow">★</i>
                                <i aria-hidden="true" class="fa fa-star yellow">★</i>
                                <i aria-hidden="true" class="fa fa-star">★</i>
                                </span>
                            </h3>
                            
                            <div class="download_b">
                            	<div class="pre_description">${rsc.introduction }</div>
                                <div class="dl_b">
                                	<label>
                                    	<a href="" class="tag">${rsc.resourceKeyword.name }</a>
                                    </label>
                                    <strong class="size_box">
                                    	<span>${rsc.releaseTime }上传</span>
                                        <span>大小：<em>2.22MB</em></span><!-- 此为静态 -->
                                    </strong>
                                </div>
                            </div>
                        </dd>
                    </div>
                </div>
            </div>
            <div class="clears"></div>
	        <div class="dl_download dl_pdf">
	        	<div class=" dl_download_box dl_download_l">
	            	<label>
	                	所需：<em>3</em>积分/C币
	                </label>
	                <a class="open_vip">
	                	<img src="images/VIP.png">
	                    <span>高贡献用户免积分下载</span>
	                </a>
	    			<!--  
	                <a class="student">
	                	<span>学生认证会员7折</span>
	                </a>
	                -->
	                <a class="">立即下载</a>
	            </div>
	            <div class=" dl_download_box_r right">
	            	<div class=" dl_func right libd_share_btn" id="libd-share-btn">分享</div>
	                <a class="dl_func" style="width:75px;">
	                	<i class="fa fa-star">★</i>
	                    <span>收藏</span><em>(3)</em><!-- 此为静态 -->
	                    
	                </a>
	                <a class="dl_func" style="color:red; width:50px;">
	                	
	                    <span style="color:#F00;">！举报</span><!-- 此为静态 -->
	                </a>
	            </div>
	            <div class="clears"></div>
	        	
	        </div>
        </div>
        </s:iterator>
        <!-- 评论暂时没做 静态演示 -->
        <div class="comment_t">
        	<div class="dl_comm" id="comment">
            	<h3 class="comment_t">
                	<strong>评论</strong>
                    <span>共2条</span>
                </h3>
                <div class="comm_t">
                	<div class="comm_list">
                    	<div class="comm_list_t">
                        	<div class="comm_list_t_l left">
                            	<a>
                                	<img src="images/defaultPic.jpg" class="comm_avatar">
                                </a>
                                <a class="dl_user">
                                	<b>wuming2222</b>:
                                </a>
                                <span class="comm_con">挺不错，收获不少</span>
                            </div>
                            <div class="comm_list_t_r right">
                            	<label>
                                <i aria-hidden="true" class="fa fa-star yellow">★</i>
                                <i aria-hidden="true" class="fa fa-star yellow">★</i>
                                <i aria-hidden="true" class="fa fa-star yellow">★</i>
                                <i aria-hidden="true" class="fa fa-star yellow">★</i>
                                <i aria-hidden="true" class="fa fa-star yellow">★</i>
                                </label>
                                <span>2017-10-19</span>
                            </div>
                            <div class="clears"></div>
                            
                        </div>
                    </div>
                    <div class="comm_list">
                    	<div class="comm_list_t">
                        	<div class="comm_list_t_l left">
                            	<a>
                                	<img src="images/defaultPic.jpg" class="comm_avatar">
                                </a>
                                <a class="dl_user">
                                	<b>wuming2222</b>:
                                </a>
                                <span class="comm_con">挺不错，收获不少</span>
                            </div>
                            <div class="comm_list_t_r right">
                            	<label>
                                <i aria-hidden="true" class="fa fa-star yellow">★</i>
                                <i aria-hidden="true" class="fa fa-star yellow">★</i>
                                <i aria-hidden="true" class="fa fa-star yellow">★</i>
                                <i aria-hidden="true" class="fa fa-star yellow">★</i>
                                <i aria-hidden="true" class="fa fa-star yellow">★</i>
                                </label>
                                <span>2017-10-19</span>
                            </div>
                            <div class="clears"></div>
                            <div class="comm_b">
                            	<div class="comm_b_l left">
                                	<a>
                                    	<img src="images/defaultPic.jpg">
                                    </a>
                                </div>
                                <div class="comm_b_r">
                                	<div class="comm_b_t" style="display:none;">
                                    	<ul class="comment_stars">
                                        	<li class="tit">评分:</li>
                                            <li class="starts">
                                            	<i aria-hidden="true" class="fa fa-star yellow">★</i>
                                <i aria-hidden="true" class="fa fa-star yellow">★</i>
                                <i aria-hidden="true" class="fa fa-star yellow">★</i>
                                <i aria-hidden="true" class="fa fa-star yellow">★</i>
                                <i aria-hidden="true" class="fa fa-star yellow">★</i>
                                            </li>
                                        </ul>
                                        <div class=" dl_comm_tip">一个资源可评论一次，不少于5个字</div>
                                    </div>
                                    <div class="comm_b_b">
                                    	<textarea class="comm_text" placeholder="不少于5个字"></textarea><button class="comm_btn" style="display:none;">发表</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="download_r right">
    	<div class="dl_right_fixed">
        	<div class="mod_personal">
            	<div class="personal_wrap">
                	<dt>
                    	<a>
                        	<img class="head" src="images/defaultPic.jpg">
                        </a>
                        <span class="vip"></span>
                    </dt>
                    <dd>
                    	<a class="name">${rsc.resourceMng.user.name }</a>
                        <p>
                        	<span>
                            	<img src="images/grade.png">
                            </span>
                        </p>
                        <div class="mod_person_r">
                        	<p>
                            	<span class="attention_btn">
                                	<span class="text">关注</span>
                                </span>
                            </p>
                            <div class="check_all">
                            	<a class="check_all_btn">查看TA的资源</a><!-- 此为静态 -->
                            </div>
                        </div>
                    </dd>
                </div>
            </div>
            <div class="dl_left_box">
            	<h3 class="dl_new_tit">
                	<span class="line">|</span>
                    <span class="txt">热点文章</span>
                </h3>
                <div class="dl_company">
                	<ul class="hot_arti_list">
                    	<li>
                        	<h4>
                            	<a class="article_t">利用VS创建一个游戏（9）愤怒的小鸟(代码+注释)</a>
                            </h4>
                            <div class="hot_arti_b">
                            	<label>阅读数<i>1032</i></label>
                                <span>2018-06-07</span><em>hao51129</em>
                            </div>
                        </li>
                        <li>
                        	<h4>
                            	<a class="article_t">利用VS创建一个游戏（9）愤怒的小鸟(代码+注释)</a>
                            </h4>
                            <div class="hot_arti_b">
                            	<label>阅读数&nbsp;<i>1032</i></label>
                                <span>2018-06-07</span><em>hao51129</em>
                            </div>
                        </li>
                        <li>
                        	<h4>
                            	<a class="article_t">利用VS创建一个游戏（9）愤怒的小鸟(代码+注释)</a>
                            </h4>
                            <div class="hot_arti_b">
                            	<label>阅读数<i>1032</i></label>
                                <span>2018-06-07</span>
                                <em>hao51129</em>
                            </div>
                        </li>
                        <li>
                        	<h4>
                            	<a class="article_t">利用VS创建一个游戏（9）愤怒的小鸟(代码+注释)</a>
                            </h4>
                            <div class="hot_arti_b">
                            	<label>阅读数<i>1032</i></label>
                                <span>2018-06-07</span><em>hao51129</em>
                            </div>
                        </li>
                        <li>
                        	<h4>
                            	<a class="article_t">利用VS创建一个游戏（9）愤怒的小鸟(代码+注释)</a>
                            </h4>
                            <div class="hot_arti_b">
                            	<label>阅读数<i>1032</i></label>
                                <span>2018-06-07</span><em>hao51129</em>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <div class=" dl_wrap">
            	<h4 class=" dl_common_t">
                	<span>公告</span>
                </h4>
                <div class="dl_notice">
                	<ul class="resource_c_list">
                    	<li>
                        	<i class="fa">▶</i><a>下载频道用户反馈专区</a>
                            
                        </li>
                        <li>
                        	<i class="fa">▶</i><a>下载频道用户反馈专区</a>
                            
                        </li>
                        <li>
                        	<i class="fa">▶</i><a>下载频道用户反馈专区</a>
                            
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
