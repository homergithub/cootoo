<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../page/common/commonjs.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	$("#clickable").mouseenter(function(){
		$(this).css("background-color","#AAAAAA").css("cursor","pointer");
	})
	$("#clickable").mouseout(function(){
		$(this).css("background-color","#ffffff");
	})
	$("#clickable").click(function(){
		window.location.href="depart.jsp";
	})
})
</script>
</head>
<body>

<shiro:hasRole name="admin">
<div id="clickable" style="height:500px;width:500px;text-align:center;border-width: 1px;border-style: dashed;position:absolute; padding:10px;
    -moz-border-radius: 15px;
    -webkit-border-radius: 15px;
    border-radius:15px;">
<span style="margin-right:100px;position:absolute;">编辑</span>
</div>
</shiro:hasRole>

</body>
</html>