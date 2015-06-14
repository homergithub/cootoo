<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%    
String path = request.getContextPath();       
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";       
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/commonjs.jsp"></jsp:include>
<script type="text/javascript">
function downloadFile(){
	$("#iframe").attr("src","<%=basePath%>metaManagement/downloadModel.do?fileName=card.xlsx");
}

function downloadFile2(){
	$("#iframe").attr("src","<%=basePath%>metaManagement/downloadModel.do?fileName=managerCard.xlsx");
}

function showLoading(){
	$("#dataImport").append("<image id='loading' width='25px' height='25px' src='<%=basePath%>ui/common/images/loading.jpg' style='vertical-align:middle;'/>")
}

function showLoading2(){
	$("#dataImport2").append("<image id='loading' width='25px' height='25px' src='<%=basePath%>ui/common/images/loading.jpg' style='vertical-align:middle;'/>")
}
function hideLoading(){
	$("#dataImport").find("#loading").remove();
}

function hideLoading2(){
	$("#dataImport2").find("#loading").remove();
}

$(function(){

            $("#dataImport").ajaxForm({
                dataType:'json',
                beforeSend: function() {
                 showLoading();
                },
                success: function(data) {
                    hideLoading();
					$("#file").val("");
                    alert(data.msg);
					
                }
            });

 			$("#dataImport2").ajaxForm({
	                dataType:'json',
	                beforeSend: function() {
	                 showLoading2();
	                },
	                success: function(data) {
	                    hideLoading2();
						$("#file2").val("");
	                    alert(data.msg);
						
	                }
	            });
		       
})

</script>
</head>
<body>
<h5>门卡信息导入</h5>
<form id="dataImport" action="<%=basePath%>metaManagement/cardImport.do" method="post" enctype="multipart/form-data">
请选择要上传的文件<input id="file" type="file" name="file" size="50">
<input type="submit" value="提交">
</form>
	<hr size="1" color="#DDDDDD">
<h5>管理门卡信息导入</h5>
<form id="dataImport2" action="<%=basePath%>metaManagement/addManagerCard.do" method="post" enctype="multipart/form-data">
请选择要上传的文件<input id="file2" type="file" name="file2" size="50">
<input type="submit" value="提交">
</form>



<div style="position: absolute;bottom:10px;left: 0;width: 100%;margin-left:16%">
<a onclick="downloadFile();return false;" style="cursor: pointer">门卡附件下载</a><img width="30px" height="30px" alt="模版" src="<%=basePath%>ui/common/images/excel.jpeg">
</div>

<div style="position: absolute;bottom:10px;left: 0;width: 100%;margin-left:30%">
<a onclick="downloadFile2();return false;" style="cursor: pointer">管理门卡附件下载</a><img width="30px" height="30px" alt="模版" src="<%=basePath%>ui/common/images/excel.jpeg">
</div>
<iframe id="iframe" style="display: none" src=""></iframe>


</body>
</html>