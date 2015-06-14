<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/commonjs.jsp"></jsp:include>

<script type="text/javascript">
$(function(){
	getRole();
	
	submitData();
	
})

function getRole(){
	$.getJson("/systemManagement/getAllRole.do",function(backData){
		$.each(backData.data,function(index,item){
			$("#roleSel").append("<option value='"+item.roleID+"'>"+item.roleName+"</option>");
		})
		
	});
}

function submitData(){
	
	$("#submitBtn").click(function(){
		checkData();
	})
	
	
	
	
}


function checkData(){
	var loginAccount = $("#loginAccount").val().trim();
	var loginPassword = $("#loginPassword").val().trim();
	var rePassword = $("#rePassword").val().trim();
	var orgID = $("#orgID").val().trim();
	var roleSel= $("#roleSel").val();
	
	if(loginAccount=="" || loginPassword=="" || rePassword=="" || orgID=="" || roleSel==""){
		alert("请填写完整信息");
		return false;
	}else{
		if(loginPassword!=rePassword){
			alert("两次密码不一致");
			return false;
		}else{
			
			var jsonData={
				loginAccount:loginAccount,	
				loginPassword:loginPassword,
				rePassword:rePassword,
				orgID:orgID,
				roleID:roleSel
			}
				
			$.postJson("/systemManagement/addLoginUser.do", jsonData, function (backData) {
		         alert(backData.msg);
		    });
			
			
			
			
			
			
		}
	}
	
}




</script>


</head>
<body>

账号:<input id="loginAccount" type="text"/><br>
密码:<input id="loginPassword" type="password"/><br>
再一次密码:<input id="rePassword" type="password"/><br>
单位编号:<input id="orgID" type="text"/><br>
角色:<select id="roleSel"></select><br>
<input id="submitBtn" type="button" value="提交"/>
</body>
</html>