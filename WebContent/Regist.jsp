<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册页面</title>
<script type="text/javascript" src = "js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/public.css">
<link rel="stylesheet" type="text/css" href="css/regist.css">

</head>
<body>
<div class="frame">

	<div class="leftFrame"><!--图片-->
    	<img src="images/gg.jpg">
	</div>
 	<div class="regist"><!--登录-->
    	<div class="form">
    		<form action="doRegist" id="form">
    		<div class="tab"><!--注册tab-->
    			<!--  <input type="button" onclick="Change(this)" id="tab_1" class="tab_1" value="账号注册">
    			<input type="button" onclick="Change(this)" id="tab_2" class="tab_2" value="邮箱注册">-->
        		<div onclick="Change(this)" id="tab_1" class="tab_1">账号注册</div>
        		<div onclick="Change(this)" id="tab_2" class="tab_2">邮箱注册</div>
	       	</div>
            <div class="clears"></div>
	       	<div class="accountTab">
            	<div class="account">
            		<input type="text" onblur="checkUser(this)" name="ue.email" placeholder="邮箱" id="email" class="accInput" style="display: none;">
                	<input type="text" onblur="checkUser(this)" name="ue.account" placeholder="账号 6~13位" id="account" class="accInput"><span id="upormpt"></span>
                </div>
            </div>
            <div class="passwordTab">
            	<div class="password">
                	<input type="password" name="ue.password" placeholder="密码 6~18位" id="password" class="pwdInput">
                </div>
            </div>
            <div class="passwordTab">
            	<div class="password">
                	<input type="password"placeholder="确认密码  6~18位" id="confirmPassword" class="pwdInput">
                </div>
            </div>
            <div class="forgetpwd"><a href="">忘记密码</a></div>
            <div class="error" id="error"><!--失败提示--></div>
            <div class="clears"></div>
            <div class="loginButton">
            	<input type="button" onclick="Submit()" class="btn" value="注册">
            	<!--  <button class="btn" onclick="Submit()">注册</button>-->
            </div>
    		</form>
        	
        </div>
    	
    </div>

</div>
</body>
<script type="text/javascript">
//改变邮箱/账户注册方式
function Change(t){
	var account = document.getElementById("account");
	var email = document.getElementById("email");
	console.log(t.id)
	if(t.id == "tab_1"){
		email.setAttribute("style","display: none")
		account.setAttribute("style","display: block")
	}else if(t.id =="tab_2"){
		account.setAttribute("style","display: none")
		email.setAttribute("style","display: block")
	}
}
//检测邮箱/账户是否可用
function checkUser(t){
	var myReg = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/;
	
	var upormpt = document.getElementById("upormpt");
	//var account = document.getElementById("account").value;
	if(t.id == "account"){//检测账户是否可用
		if(t.value.length<6 || t.value.length>13){
			upormpt.innerHTML = "☒  用户名在6~13位";
			upormpt.setAttribute("style","color:red;");
		}else{
			$.post("doCheck",{"ue.account":t.value},function(data){
				
					if(data == "success" && t.value != ""){
						upormpt.innerHTML = "☑  该账户可用";
						upormpt.setAttribute("style","color:green;");
					}else if(data == "fail"){
						upormpt.innerHTML = "☒  该账户已被注册";
						upormpt.setAttribute("style","color:red;");
					}
			});
		}
			
	}else if(t.id == "email"){//检测邮箱是否可用
		if(myReg.test(t.value)){
			console.log(t.value)
			$.post("doCheck",{"ue.email":t.value},function(data){
				
				if(data == "success" && t.value != ""){
					upormpt.innerHTML = "☑  该邮箱可用！";
					upormpt.setAttribute("style","color:green;");
				}else if(data == "fail"){
					upormpt.innerHTML = "☒  该邮箱已被注册！";
					upormpt.setAttribute("style","color:red;");
				}
			});
		}else{
			upormpt.innerHTML = "☒  邮箱格式错误！";
			upormpt.setAttribute("style","color:red;");
		}
		
	}
	
	
}
//提交表单
function Submit(){
	var form = document.getElementById("form");
	var error = document.getElementById("error");
	var pass = document.getElementById("password").value;
	var repass = document.getElementById("confirmPassword").value;
	var account = document.getElementById("account");
	if(pass != repass){
		error.innerHTML="☒ 两次密码输入不一样";
	}else if(pass.length<6 || pass.length>18){
		error.innerHTML="☒ 密码必须在6~18位";
	}else{
		form.submit();
	}
}
</script>
</html>