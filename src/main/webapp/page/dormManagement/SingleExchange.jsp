<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>单人互调</title>
<jsp:include page="../common/commonjs.jsp"></jsp:include>
<script type="text/javascript">

var peopleID,locationID;
var anotherPeopleID,anotherLocationID;


var setting = {
	view: {
		fontCss: getFont,
		nameIsHTML: true 
	},
	data: {
		simpleData: {
			enable: true
		}
	},
	callback: {
		onClick: onClick,
	}
};

var setting2 = {
		view: {
			fontCss: getFont,
			nameIsHTML: true  ,
			dblClickExpand: false
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			onClick: onClick2,
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
	
	peopleID = treeNode.id;
	locationID = treeNode.locationID;
	
	
	
}

function onClick2(e, treeId, treeNode) {
	var isAllocated = treeNode.isAllocated;
	if(isAllocated!='1'){
		alert("请选择已经入住的人员");
		return;
	}
	
	anotherPeopleID = treeNode.id;
	anotherLocationID = treeNode.locationID;
	
}

function flushTreeUnit(val) { 
    $.postJson("/dormManagement/getAllStudentBySchool.do", {sex:val}, function (jsonData) {
      $.fn.zTree.init($("#treePeople"), setting, jsonData.data);
    });
}

function flushTreeUnit2(val) { 
    $.postJson("/dormManagement/getAllStudentBySchool.do", {sex:val}, function (jsonData) {
      $.fn.zTree.init($("#treePeople2"), setting, jsonData.data);
    });
}

$(document).ready(function(){
	
	$("#allSex").attr("checked","checked");
	$.postJson("/dormManagement/getAllStudentBySchool.do",{sex:0},function(jsonData){
		$.fn.zTree.init($("#treePeople"), setting, jsonData.data);
	});
	
	$("#allSex2").attr("checked","checked");
	$.postJson("/dormManagement/getAllStudentBySchool.do",{sex:0},function(jsonData){
		$.fn.zTree.init($("#treePeople2"), setting2, jsonData.data);
	});
	
	
	$("#submitBtn").click(function(){
	
		var data = {
			peopleID:peopleID,	
			locationID:locationID,
			anotherPeopleID:anotherPeopleID,
			anotherLocationID:anotherLocationID
		};
		
		$.postJson("/dormManagement/peopleLocationExchange.do",data,function(jsonData){
			alert(jsonData.msg);
			$.postJson("/dormManagement/getAllStudentBySchool.do",{sex:0},function(jsonData){
				$.fn.zTree.init($("#treePeople"), setting, jsonData.data);
			});
			$.postJson("/dormManagement/getAllStudentBySchool.do",{sex:0},function(jsonData){
				$.fn.zTree.init($("#treePeople2"), setting2, jsonData.data);
			});
			peopleID = null;
			locationID = null;
			anotherPeopleID = null;
			anotherLocationID = null;
		});
	})
	
	
	
	
	
	
	
	
	
	
	
	
	
})

</script>
</head>
<body>
<div style="text-align: center;">单人互调</div>
<hr size="1" color="#DDDDDD">

<div style="float: left;text-align: center; padding: 10px;float: left;border-right-style: solid;border-right-width: 1px;border-right-color: #DDDDDD;">
 	<label>选择入住人员 | </label>
    <input id="allSex" type="radio" onclick="flushTreeUnit(0)" name="sex" value="0">全部
    <input type="radio" onclick="flushTreeUnit(1)" name="sex" value="1">男
    <input type="radio" onclick="flushTreeUnit(2)" name="sex" value="2">女
    <ul id="treePeople" class="ztree"></ul>
    <div>
    	红色表示未分配，黑色表示已分配
    </div>
</div>

<div style="float: left;text-align: center; padding: 10px;">
 	<label>选择入住人员 | </label>
    <input id="allSex2" type="radio" onclick="flushTreeUnit2(0)" name="sex2" value="0">全部
    <input type="radio" onclick="flushTreeUnit2(1)" name="sex2" value="1">男
    <input type="radio" onclick="flushTreeUnit2(2)" name="sex2" value="2">女
    <ul id="treePeople2" class="ztree"></ul>
    <div>
    	红色表示未分配，黑色表示已分配
    </div>
</div>
</br>
<div>
	<input id="submitBtn" type="button" value="提交" size="23px"/>
</div>


</body>
</html>