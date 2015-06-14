<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出宿</title>
<jsp:include page="../common/commonjs.jsp"></jsp:include>
<script type="text/javascript">
var setting = {
	view: {
		fontCss: getFont,
		nameIsHTML: true  ,
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
		onClick: onClick,
		beforeRemove:beforeRemove
	}
};

function getFont(treeId, node) {
	if(node.isAllocated!='-1' && node.isAllocated!='1'){
		node.font = {'color':'red'};
	}
    return node.font;
}

function onClick(e, treeId, treeNode) {
	var isAllocated = treeNode.isAllocated;
	if(isAllocated!='1'){
		alert("请选择已经入住的人员");
		return;
	}
	
	var peopleID = treeNode.id;
	$.postJson("/dormManagement/getPeopleUnitLocation.do", {peopleID:peopleID},function (jsonData) {
	      $("#location").val(jsonData.data.unitName);
	      $("#oldLocation").val(jsonData.data.locationID);
	      $("#peopleID").val(jsonData.data.peopleID);
	});
	
}

function beforeRemove(treeId, treeNodes){
	
	var isAllocated = treeNodes.isAllocated;
	var type = treeNodes.type;
	/* if(type=='-1'){
		alert("请选择人员");
		return false;
	} */
	
	/* if(isAllocated!='1'){
		alert("请选择已经入住的人员");
		return false;
	} */
	
	if (!confirm("确认要将此人出宿？")) {
        return false;
    }
	
	getNodesID(treeNodes);
	
	var locationID = treeNodes.locationID;
	var data = {peopleID:temp,locationID:locationID};
	$.postJson("/dormManagement/removePeopleFromUnitLocation.do",data,function(jsonData){
		alert(jsonData.msg);	
		$.postJson("/dormManagement/getAllStudentBySchool.do", {sex:'0'}, function (jsonData) {
		      $.fn.zTree.init($("#treePeople"), setting, jsonData.data);
		});
	});
	temp = null;
	return false;	
}

var temp = "";
function getNodesID(treeNodes) {
	
	temp += treeNodes.id+",";
    if(treeNodes.children!=null && treeNodes.children.length!=0){
    	for (var count in treeNodes.children) {
    		getNodesID(treeNodes.children[count]);
		}
    }else{
    	temp = temp.substring(0,temp.lastIndexOf(","));
    }
}

function flushTreeUnit(val) { 
    $.postJson("/dormManagement/getAllStudentBySchool.do", {sex:val}, function (jsonData) {
      $.fn.zTree.init($("#treePeople"), setting, jsonData.data);
    });
}

$(document).ready(function(){
	$("#allSex").attr("checked","checked");
	$.postJson("/dormManagement/getAllStudentBySchool.do",{sex:0},function(jsonData){
		$.fn.zTree.init($("#treePeople"), setting, jsonData.data);
	});
})

</script>

<script type="text/javascript">
var setting2 = {
	view: {
		dblClickExpand: false
	},
	data: {
		simpleData: {
			enable: true
		}
	},
	callback: {
		onClick: onClick2
	}
};
function onClick2(e, treeId, treeNode) {
	var unitType = treeNode.unitType;
	if(unitType!="3"){
		alert("请选择房间");
		return;
	}
	var locationID = treeNode.id;
	var unitName = treeNode.name;
	$("#location").val(unitName);
	$("#newLocation").val(locationID);
	
}

function showMenu() {
	$.getJson("/metaManagement/getAllLocations.do",function(jsonData){
		$.fn.zTree.init($("#treeLocation"), setting2, jsonData.data);
	});
	var parentObj = $("#location");
	var parentOffset = $("#location").offset();
	$("#menuContent").css({left:parentOffset.left + "px", top:parentOffset.top + parentObj.outerHeight() + "px"}).slideDown("fast");
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
$(document).ready(function(){
	$.getJson("/metaManagement/getAllLocations.do",function(jsonData){
		$.fn.zTree.init($("#treeLocation"), setting2, jsonData.data);
	});
	
	$("#locationBtn").click(function(){
		var peopleID = $("#peopleID").val();
		var oldLocation = $("#oldLocation").val();
		var newLocation = $("#newLocation").val();
		
		$.postJson("/dormManagement/updatePeopleUnitLocation.do",{peopleID:peopleID,oldLocation:oldLocation,newLocation:newLocation},function(jsonData){
			alert(jsonData.msg);
			$("#location").val("");
			$.postJson("/dormManagement/getAllStudentBySchool.do", {sex:'0'}, function (jsonData) {
			      $.fn.zTree.init($("#treePeople"), setting, jsonData.data);
			});
		});
		
		
		
	})
	
})
</script>




</head>
<body>
<div style="text-align: center;">出宿</div>
<hr size="1" color="#DDDDDD">

<div style="float: left;text-align: center; padding: 10px;float: left">
 	<label>选择入住人员 | </label>
    <input id="allSex" type="radio" onclick="flushTreeUnit(0)" name="sex" value="0">全部
    <input type="radio" onclick="flushTreeUnit(1)" name="sex" value="1">男
    <input type="radio" onclick="flushTreeUnit(2)" name="sex" value="2">女
    <ul id="treePeople" class="ztree"></ul>
    <div id="tip">
    	红色表示未分配，黑色表示已分配
    </div>
</div>
<div style="margin-top: 50px">
	房间<input id="location" type="text" size="23px"/>
	<a id="menuBtn" href="#" onclick="showMenu(); return false;">选择</a>
	<input id="peopleID" type="hidden"/>
	<input id="oldLocation" type="hidden"/>
	<input id="newLocation" type="hidden"/>
	<input id="locationBtn" type="button" value="提交"/>
</div>
<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
	<ul id="treeLocation" class="ztree" style="margin-top:0; width:160px;"></ul>
</div>


















</body>
</html>