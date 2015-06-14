<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.cootoo.systemmanagement.domain.User"%>  
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<%    
String path = request.getContextPath();       
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="Shortcut Icon" href="<%=basePath%>ui/common/images/logo.png" type="image/x-icon">
<title>咕咚网络</title>
<style>
	#content {
		margin-left: 200px;
	}
</style>
<jsp:include page="../page/common/commonjs.jsp"></jsp:include>
<script type="text/javascript">

function addMenu(){
	$.getJson("/systemManagement/getUserRoleFunctions.do",callback);
}

function callback(jsonData){
	
	$.each(jsonData.data.modules,function(index,item){
		$("#menu").append("<div class='div2'><div class='"+item.style+"'> </div>"+item.moduleName+"</div>");
		$("#menu").append("<div class='div3'><ul id='"+item.moduleID+"'></ul></div>");
		$.each(item.functions,function(index2,item2){
			$("#"+item.moduleID).append("<li target="+item2.functionURL+">"+item2.functionName+"</li>");
		})
	})
	$(".div2").click(function(){ 
		$(this).next("div").slideToggle("slow").siblings(".div3:visible").slideUp("slow");
	});
			
	$("li").click(function(){
		var url = $(this).attr("target");
		$.get("<%=basePath%>"+url,function(data){
			$("#content").html(data);
		});
	})
}

$(document).ready(function(){	
	addMenu();	
	var ss = "${sessionScope.login.loginAccount}${sessionScope.login.roleName}";
	if(ss!=null && ss!=""){
		ss="["+ss+"]";
	}
	$("#menu").append(ss);
});

</script>
</head>
<body>
<div id="left" class="left">
<div id="menu" class="div1">
<div class="left_top">
	<img src="<%=basePath%>ui/common/images/bbb_01.jpg">
	<img src="<%=basePath%>ui/common/images/bbb_02.jpg">
	<img src="<%=basePath%>ui/common/images/bbb_03.jpg">
	<img src="<%=basePath%>ui/common/images/bbb_04.jpg"> 
</div>
</div>
</div>

<div id="content"></div>

</body>
</html>