<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目单位信息编辑</title>
<jsp:include page="../common/commonjs.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	$("#submitBtn").click(function(){
		var orgID = $("#orgID").val().trim();
		var orgName = $("#orgName").val().trim();
		if(orgID=="" || orgName==""){
			alert("请完整填写信息");
			return;
		}
		
		var data = {
			orgID:orgID,
			orgName:orgName
		}
		
		$.postJson("/metaManagement/addOrgnization.do",data,function(jsonData){
			alert(jsonData.msg);
		});	
		
		
	})
})
</script>
</head>
<body>
<div>
	项目单位编号：<input id="orgID" type="text"/><br>
	项目单位名称：<input id="orgName" type="text"><br>
	<input id="submitBtn" type="button" size="23px" value="提交"/>
</div>
</body>
</html>