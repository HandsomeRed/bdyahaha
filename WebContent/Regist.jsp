<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册页面</title>
</head>
<body>
<s:form action="doRegist" method="post" name="frm">
	<table width="300" align="center" style="text-align:center;">					
		<s:textfield name="ue.account" label="账号" />
		<s:textfield name="ue.password" label="密码"  />
		<s:textfield name="ue.name" label="昵称" />
		<s:textfield name="ue.address" label="家庭住址" />
		<s:textfield name="ue.email" label="电子邮箱"  />
		<s:submit value="%{getText('submit')}" align="center"></s:submit>
	</table>
</s:form>
</body>
</html>