<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%    
String path = request.getContextPath();       
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";       
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>建筑信息录入</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>ui/zTree/css/zTreeStyle/zTreeStyle.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>ui/zTree/css/demo.css">
<jsp:include page="/page/common/commonjs.jsp"></jsp:include>
<SCRIPT type="text/javascript">
		
		var setting = {
			edit: {
				enable: true,
				showRemoveBtn: true,
				showRenameBtn: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeDrag: beforeDrag,
				beforeDrop: beforeDrop,
				beforeRemove:beforeRemove
			}
		};


		function beforeDrag(treeId, treeNodes) {
			for (var i=0,l=treeNodes.length; i<l; i++) {
				if (treeNodes[i].drag === false) {
					return false;
				}
			}
			return true;
		}
		function beforeDrop(treeId, treeNodes, targetNode, moveType) {
			
			return targetNode ? targetNode.drop !== false : true;
		}
		
		function beforeRemove(treeId, treeNodes){
			
			if (!confirm("确认要删除？")) {
	            return false;
	        }
			temp = "";
			if(treeNodes.isParent){
				var childNodes = treeNodes.children;
				for (var i=0, l=childNodes.length; i<l; i++) {
					temp += childNodes[i].id + ",";
				}
				temp += treeNodes.id;
				if (temp.length > 0 ) v = temp.substring(0, temp.length);
			}else{
				temp = treeNodes.id;
			}
			
	
			var data = {locationID:temp};
			$.postJson("/metaManagement/removeUnitLocation.do",data,function(jsonData){
				alert(jsonData.msg);	
			},false);
				
		}
		
		function callback(jsonData){
			$.fn.zTree.init($("#treeDemo"), setting, jsonData.data);
		}
		
		$(document).ready(function(){
			$.getJson("/metaManagement/getAllLocations.do",callback);
			
		});
		
	</SCRIPT>

</head>

<body>






<div class="zTreeDemoBackground left">
		<ul id="treeDemo" class="ztree"></ul>
	</div>
</body>
</html>
