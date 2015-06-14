<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>智能门锁管理系统</title>
<jsp:include page="../common/commonjs.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	$("#loginBtn").click(function(){
		var userAccount = $("#userAccount").val().trim();
		var userPassword = $("#userPassword").val().trim();
		
		if(userAccount==""||userPassword==""){
			alert("账号或密码为空");
			return;
		}
		
		var jsonData = {
			userAccount:userAccount,
			userPassword:userPassword
		}
		
		$.postJson("/logon/login.do", jsonData, function (backData) {

	           if(backData.code=="1"){
	        	   window.location.href=backData.url;
	           }else{
	        		document.getElementById("tip").innerHTML=backData.msg;          		
	           }
	    });
		
	})

})

</script>
</head>
<body>

<div  style="text-align: center;margin-top: 20%">
账号：<input id="userAccount" type="text"/><br>
密码：<input id="userPassword" type="password"/><br>
<span id="tip" style="color: red"></span>
<input id="loginBtn" type="submit" value="登录" size="23px"/>


</div>
</body>
</html>