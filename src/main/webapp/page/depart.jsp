<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%    
String path = request.getContextPath();       
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
div{

}
div .sch{

}
</style>

<jsp:include page="../page/common/commonjs.jsp"></jsp:include>

<script type="text/javascript">
$(function(){
	$("div").css("margin-left","4px").css("margin-top","3px").css("cursor","pointer");
	
	$("div").on("mouseenter",".sch",function() {
		$(this).css("background-color","#AAAAAA");
	});
	
	$("div").on("mouseout", ".sch",function() {
		$(this).css("background-color","#ffffff");
	});
	
	$("#add").click(function(){
		$("<div class='sch' style='margin-top:3px;margin-left:4px;border-radius:15px;height:100px;width:100px;text-align: center;border-width: 1px;border-style: solid;float: left;overflow: scroll;'>编辑<hr></div>").appendTo($("#sch"));
		
	})
})
</script>


</head>

<body style="margin: 0px;padding: 0px">

<div id="sch" style="width: 100%">

<div class="sch" style="border-radius:15px;height:100px;width:100px;text-align: center;border-width: 1px;border-style: solid;float: left;overflow: scroll;">
编辑
<hr>
</div>



</div>




<div id="add" style="border-radius:15px;height:100px;width:100px;text-align: center;border-width: 1px;border-style:dashed;float: left;overflow: scroll;vertical-align: middle;line-height:100px;">
<span style="font-size: 70px;color: #aaaaaa">+</span>
</div>

</body>
</html>