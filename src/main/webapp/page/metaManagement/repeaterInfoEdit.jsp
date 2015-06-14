<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中继器信息编辑</title>
<jsp:include page="../common/commonjs.jsp"></jsp:include>
<style type="text/css">
td{
text-align: left;
}
</style>
<script type="text/javascript">

var setting = {
		view: {
			dblClickExpand: false
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			onClick: onClick
		}
	};
	
	function onClick(e, treeId, treeNode) {
		
		if(treeNode.unitType!="2"){
			alert("请选择具体楼层");			
			return false;
		}
		var locationObj = $("#repeaterLocation");
		locationObj.val(treeNode.name);
	}

	function showMenu() {
		$.getJson("/metaManagement/getAllLocations.do",callback);
		var locationObj = $("#repeaterLocation");
		var locationOffset = $("#repeaterLocation").offset();
		$("#menuContent").css({left:locationOffset.left + "px", top:locationOffset.top + locationObj.outerHeight() + "px"}).slideDown("fast");
		$("body").bind("mousedown", onBodyDown);
	}
	function hideMenu() {
		$("#menuContent").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
		
	}
	function onBodyDown(event) {
		if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
			hideMenu();
		}
	}

	function callback(jsonData){
		$.fn.zTree.init($("#treeDemo"), setting, jsonData.data);
	}
	
	function refresh(){
		$("#repeaterMacID").val("");
		$("#repeaterName").val("");
		$("#repeaterIp").val("");
		$("#repeaterLocation").val("");
		$.getJson("/metaManagement/getAllRepeaters.do?v="+new Date().getTime(),callback2);
		
	}
	
	$(document).ready(function(){
			
		$.getJson("/metaManagement/getAllLocations.do",callback);
		function callback(jsonData){
			$.fn.zTree.init($("#treeDemo2"), setting, jsonData.data);
		}	
		$("#submitBtn").click(function(){
			
			var repeaterID = $("#repeaterMacID").val().trim();
			var repeaterName = $("#repeaterName").val().trim();
			var repeaterIP = $("#repeaterIp").val().trim();
			var locationID = $("#repeaterLocation").val().trim();
			
			if(repeaterID ==""|| repeaterName =="" || repeaterIP == ""|| locationID == ""){
				alert("填写完整信息");
				return;
			}
			
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		    var nodes = null;
		    if(zTree!=null){
				nodes = zTree.getSelectedNodes();
		    }
		    var location = "";	
			if(!(nodes == null || nodes.length == 0)){
				
				location = nodes[0].id;
			}
			var data = {
				repeaterID : repeaterID,	
				repeaterName : repeaterName,
				repeaterIP : repeaterIP,
				locationID : location
			}
			
			$.postJson("/metaManagement/addRepeater.do",data,function(jsonData){
				alert(jsonData.msg);			
				refresh();				
			});			
		})

		
		
		
	});
	
</script>
<script type="text/javascript">

var setting2 = {
		view: {
			dblClickExpand: false
		},
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
			onClick: onClick2,
			beforeRemove:beforeRemove
		}
	};

	function onClick2(e, treeId, treeNode) {
		if(treeNode.unitType != '-1'){
			return false;
		}
		var data = {
			repeaterID : treeNode.id
		}
			
		$.postJson("/metaManagement/getRepeater.do",data,function(jsonData){
			$("#repeaterMacID2").val(jsonData.data.repeaterID);		
			$("#repeaterName2").val(jsonData.data.repeaterName);
			$("#repeaterIp2").val(jsonData.data.repeaterIP);
			$("#repeaterLocation2").val(jsonData.data.unitName);	
			$("#hidLocationID").val(jsonData.data.locationID);
		});
	}
	
	
	
	function beforeRemove(treeId, treeNodes){
		
		if(treeNodes.unitType != '-1'){
			alert("只能删除中继器");
			return false;
		}
		
		if (!confirm("确认要删除？")) {
            return false;
        }		
		
		
		var data = {repeaterID:treeNodes.id};
		$.postJson("/metaManagement/removeRepeater.do",data,function(jsonData){
			alert(jsonData.msg);	
		});
			
	}

	function callback2(jsonData){
		$.fn.zTree.init($("#treeDemo2"), setting2, jsonData.data);
	} 
	
	function refresh2(){
		$.getJson("/metaManagement/getAllRepeaters.do?v="+new Date().getTime(),callback2);
		$("#repeaterMacID2").val("");		
		$("#repeaterName2").val("");
		$("#repeaterIp2").val("");
		$("#repeaterLocation2").val("");
	}
	
	 $(document).ready(function(){
		$.getJson("/metaManagement/getAllRepeaters.do?v="+new Date().getTime(),callback2);
		
		
		//以下代码执行更新操作
		$("#submitBtn2").click(function(){
			var repeaterID = $("#repeaterMacID2").val().trim();
			var repeaterName = $("#repeaterName2").val().trim();
			var repeaterIP = $("#repeaterIp2").val().trim();
			var locationID = $("#hidLocationID").val().trim();
			
			/* var zTree = $.fn.zTree.getZTreeObj("treeDemo3");
		    var nodes = null;
		    if(zTree!=null){
				nodes = zTree.getSelectedNodes();
		    }
		    var location = "";	
			if(!(nodes == null || nodes.length == 0)){
				
				location = nodes[0].id;
			} */
			var data = {
				repeaterID : repeaterID,	
				repeaterName : repeaterName,
				repeaterIP : repeaterIP,
				locationID : locationID
			}
			
			$.postJson("/metaManagement/updateRepeater.do",data,function(jsonData){
				alert(jsonData.msg);	
				refresh2();
			});	
		
		})
	}); 
</script>
<script type="text/javascript">
var setting3 = {
		view: {
			dblClickExpand: false
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			onClick: onClick3
		}
	};
	
	function onClick3(e, treeId, treeNode) {
		
		if(treeNode.unitType!="2"){
			alert("请选择具体楼层");			
			return false;
		}
		var locationObj = $("#repeaterLocation2");
		locationObj.val(treeNode.name);
		$("#hidLocationID").val(treeNode.id);
	}

	function showMenu2() {
		$.getJson("/metaManagement/getAllRepeaters.do",callback3);
		var locationObj = $("#repeaterLocation2");
		var locationOffset = $("#repeaterLocation2").offset();
		$("#menuContent3").css({left:locationOffset.left + "px", top:locationOffset.top + locationObj.outerHeight() + "px"}).slideDown("fast");
		$("body").bind("mousedown", onBodyDown2);
	}
	function hideMenu2() {
		$("#menuContent3").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown2);
		
	}
	function onBodyDown2(event) {
		if (!(event.target.id == "menuBtn2" || event.target.id == "menuContent3" || $(event.target).parents("#menuContent3").length>0)) {
			hideMenu2();
		}
	}

	function callback3(jsonData){
		$.fn.zTree.init($("#treeDemo3"), setting3, jsonData.data);
	}
	
	
	
	
	
</script>
</head>
<body>
	<div style="text-align: center;">中继器信息录入</div>
	<hr size="1" color="#DDDDDD">
	<div>
		<table cellspacing="20px">
			<tr><td>中继器MAC_ID:</td><td><input id="repeaterMacID" type="text" size="23px"/></td></tr>
			<tr><td>中继器名称:</td><td><input id="repeaterName" type="text" size="23px"/></td></tr>
			<tr><td>中继器IP:</td><td><input id="repeaterIp" type="text" size="23px"/></td></tr>
			<tr><td>所属位置:</td><td><input id="repeaterLocation" type="text" size="23px"/><a id="menuBtn" href="#" onclick="showMenu(); return false;">选择</a></td></tr>
			<tr><td colspan="2"><input id="submitBtn" type="button" value="提交" style="height: 40px;width: 70px"/></td></tr>
		</table>
	</div>
	<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
		<ul id="treeDemo" class="ztree" style="margin-top:0; width:160px;"></ul>
	</div>

	<div style="text-align: center;">中继器信息修改</div>
	<hr size="1" color="#DDDDDD">
	
	<div class="zTreeDemoBackground left" style="float: left; width:20%; padding-left: 10px;">
		<ul id="treeDemo2" class="ztree" style="margin-top: 0px;"></ul>
	</div>

	<div style="float: left;">
		<table cellspacing="20px">
			<tr><td>中继器MAC_ID:</td><td><input id="repeaterMacID2" type="text" size="23px" readonly="readonly"/></td></tr>
			<tr><td>中继器名称:</td><td><input id="repeaterName2" type="text" size="23px"/></td></tr>
			<tr><td>中继器IP:</td><td><input id="repeaterIp2" type="text" size="23px"/></td></tr>
			<tr><td>所属位置:</td><td><input id="repeaterLocation2" type="text" size="23px"/><a id="menuBtn2" href="#" onclick="showMenu2(); return false;">选择</a></td></tr>
			<input id="hidLocationID" type="hidden"/>
			<tr><td colspan="2"><input id="submitBtn2" type="button" value="提交" style="height: 40px;width: 70px"/></td></tr>
		</table>
	</div>
	<div id="menuContent3" class="menuContent" style="display:none; position: absolute;">
		<ul id="treeDemo3" class="ztree" style="margin-top:0; width:160px;"></ul>
	</div>
</body>
</html>