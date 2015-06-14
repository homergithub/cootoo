<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>建筑信息编辑</title>
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
	
		var parentObj = $("#parentID");
		parentObj.val(treeNode.name);
	}

	function showMenu() {
		$.getJson("/metaManagement/getAllLocations.do",callback);
		var parentObj = $("#parentID");
		var parentOffset = $("#parentID").offset();
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

	function callback(jsonData){
		$.fn.zTree.init($("#treeDemo"), setting, jsonData.data);
	}
	
	function refresh(){
	    $("input").val(""); 
	    $("#buildingType").val("0");
	    $("#sex").val("-1");
	}
	
	
	
	
	$(document).ready(function(){
		
		
		$.getJson("/metaManagement/getAllLocations.do",callback);
		function callback(jsonData){
			$.fn.zTree.init($("#treeDemo2"), setting, jsonData.data);
		}
		
		
		$("#submitBtn").click(function(){

			var locationID = $("#locationID").val().trim();
			if(locationID == ""){
				alert("必须填写编号！");
				 return;
			}
			
			var unitName = $("#unitName").val().trim();
			if(unitName == ""){
				alert("必须填写名称！");
				return;
			}
			
			
						
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		    var nodes = null;
		    if(zTree!=null){
				nodes = zTree.getSelectedNodes();
		    }
			var parentNode = "";	
			if(nodes == null || nodes.length == 0){
				parentNode = "";
			}else{
				parentNode = nodes[0].id;
			}
						
			var data = {
				locationID:$("#locationID").val().trim(),
				unitName:$("#unitName").val().trim(),
				parentID:parentNode,
				unitType:$("#buildingType").val().trim(),
				People:$("#people").val().trim(),
				sex:$("#sex").val().trim()
			}
								
			$.postJson("/metaManagement/addUnitLocation.do",data,function(jsonData){
				alert(jsonData.msg);
				
				refresh();
				refresh2();
				
			});
				
			nodes = null;
			
			
		})
		
		
	});

</script>
<script type="text/javascript">

var setting2 = {
		
		edit: {
			enable: true,
			showRemoveBtn: true
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			onClick:onClick2,
			beforeRemove:beforeRemove
			
		}
	};

	function onClick2(e, treeId, treeNode) {
		
		var data = {
			locationID:treeNode.id
		}
		
		if(treeNode.pId==null){
			$.postJson("/metaManagement/getUnitLocationByLocationParent.do",data,function(jsonData){
				
				$("#locationID2").val(jsonData.data.locationID);
				$("#unitName2").val(jsonData.data.unitName);
				$("#parentID2").val("");
				$("#parentHid").val("");
				$("#people2").val(jsonData.data.unitSize);
			    $("#buildingType2").val(jsonData.data.unitType);
			    if(jsonData.data.sex==null){
			        $("#sex2").val("-1");
			    }else{
			    	 $("#sex2").val(jsonData.data.sex);
			    }
			   			
			});
		}else{
			$.postJson("/metaManagement/getUnitLocationByLocationID.do",data,function(jsonData){
				
				$("#locationID2").val(jsonData.data.locationID);
				$("#unitName2").val(jsonData.data.unitName);
				$("#parentID2").val(jsonData.data.bUnitName);
				$("#parentHid").val(jsonData.data.parentNode);
				$("#people2").val(jsonData.data.unitSize);
			    $("#buildingType2").val(jsonData.data.unitType);
			    if(jsonData.data.sex==null){
			        $("#sex2").val("-1");
			    }else{
			    	 $("#sex2").val(jsonData.data.sex);
			    }
			   			
			});
		}
		
	
			
	}


	function beforeRemove(treeId, treeNodes){
		
		if (!confirm("确认要删除？")) {
            return false;
        }
		
		getNodesID(treeNodes);
		
		var data = {locationID:temp};
		$.postJson("/metaManagement/removeUnitLocation.do",data,function(jsonData){
			alert(jsonData.msg);	
		});
		temp = null;
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
	
	function refresh2(){
		$.getJson("/metaManagement/getAllLocations.do",callback2);
	}
	
	function callback2(jsonData){
		$.fn.zTree.init($("#treeDemo2"), setting2, jsonData.data);
	} 
	
	 $(document).ready(function(){
		$.getJson("/metaManagement/getAllLocations.do",callback2);
		
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
	
		var parentObj = $("#parentID2");
		var parentHid = $("#parentHid");
		parentObj.val(treeNode.name);
		parentHid.val(treeNode.id);
		
	}

	function showMenu2() {
		$.getJson("/metaManagement/getAllLocations.do",callback3);
		var parentObj = $("#parentID2");
		var parentOffset = $("#parentID2").offset();
		$("#menuContent3").css({left:parentOffset.left + "px", top:parentOffset.top + parentObj.outerHeight() + "px"}).slideDown("fast");
		$("body").bind("mousedown", onBodyDown3);
	}
	function hideMenu3() {
		$("#menuContent3").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown3);
		
	}
	function onBodyDown3(event) {
		if (!(event.target.id == "menuBtn2" || event.target.id == "menuContent3" || $(event.target).parents("#menuContent3").length>0)) {
			hideMenu3();
		}
	}

	function callback3(jsonData){
		$.fn.zTree.init($("#treeDemo3"), setting3, jsonData.data);
	}
	
	function refresh3(){
		$("#locationID2").val("");
		$("#unitName2").val("");
		$("#parentID2").val("");
		$("#people2").val("");
	    $("#buildingType2").val("0");
	    $("#sex2").val("-1");
	    $.getJson("/metaManagement/getAllLocations.do",callback2);
	    
	}
	
	
	
	
	$(document).ready(function(){
		
		$("#submitBtn2").click(function(){
							
			var zTree = $.fn.zTree.getZTreeObj("treeDemo3");
		    var nodes = null;
		    if(zTree!=null){
				nodes = zTree.getSelectedNodes();
		    }
			var parentNode = "";	
			if(nodes == null || nodes.length == 0){
				parentNode = "";
			}else{
				parentNode = nodes[0].id;
			}
			
			
			var tempSex = null;
			if($("#sex2").val().trim()!='-1'){
				tempSex = $("#sex2").val().trim();
			}
			
			var data = {
				locationID:$("#locationID2").val().trim(),
				unitName:$("#unitName2").val().trim(),
				parentID:$("#parentHid").val(),
				unitType:$("#buildingType2").val().trim(),
				unitSize:$("#people2").val().trim(),
				sex:tempSex
			}
								
			$.postJson("/metaManagement/updateUnitLocation.do",data,function(jsonData){
				alert(jsonData.msg);
			
				refresh3();
				
			});
				
			nodes = null;
			
			
		})
		
		
	});

</script>
</head>
<body>
	<div style="text-align: center;">建筑物信息录入</div>
	<hr size="1" color="#DDDDDD">
	<div>
		<table cellspacing="20">
			<tr><td>建筑物编号:</td><td><input id="locationID" type="text" size="23px"/></td></tr>
		    <tr><td>建筑物名称:</td><td><input id="unitName" type="text" size="23px"/></td></tr>
			<tr><td>上一级名称:</td><td><input id="parentID" type="text" size="23px" readonly="readonly"/><a id="menuBtn" href="#" onclick="showMenu(); return false;">选择</a><b>如果是一级单位，忽略此项</b></td></tr>
		    <tr><td>建筑类型:&nbsp;&nbsp;&nbsp;</td><td><select id="buildingType">
			<option value='0' selected="selected">区域</option>
			<option value='1'>楼栋</option>
			<option value='2'>楼层</option>
			<option value='3'>房间</option>
			</select></td></tr>
			<tr><td>可容纳人数:</td><td><input id="people" type="text" size="23px"/></td></tr>
			<tr><td>入住性别:&nbsp;&nbsp;&nbsp;</td><td><select id="sex" name="sex"><option value='-1'>请选择</option><option value='0'>混合</option><option value='1'>男</option><option value='2'>女</option></select></td></tr>
		    <tr><td colspan="2"><input id="submitBtn" type="button" value="提交" style="height: 40px;width: 70px"/></td></tr>
		</table>
	</div>
	<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
	<ul id="treeDemo" class="ztree" style="margin-top:0; width:160px;"></ul>
	</div>
	
	
	<div style="text-align: center;">建筑物信息修改</div>
	<hr size="1" color="#DDDDDD">
	
	<div class="zTreeDemoBackground left" style="float: left; width:20%; padding-left: 10px;">
		<ul id="treeDemo2" class="ztree" style="margin-top: 0px;"></ul>
	</div>
	
	<div>
		<table cellspacing="20">
			<tr><td>建筑物编号:</td><td><input id="locationID2" type="text" size="23px"/></td></tr>
		    <tr><td>建筑物名称:</td><td><input id="unitName2" type="text" size="23px"/></td></tr>
		    
			<tr><td>上一级名称:</td><td><input id="parentID2" type="text" size="23px" readonly="readonly"/>
			<input id="parentHid" type="hidden"/>
			 
			<a id="menuBtn2" href="#" onclick="showMenu2(); return false;">选择</a></td></tr>
		    <tr><td>建筑类型:&nbsp;&nbsp;&nbsp;</td><td><select id="buildingType2">
			<option value='0' selected="selected">区域</option>
			<option value='1'>楼栋</option>
			<option value='2'>楼层</option>
			<option value='3'>房间</option>
			</select></td></tr>
			<tr><td>可容纳人数:</td><td><input id="people2" type="text" size="23px"/></td></tr>
			<tr><td>入住性别:&nbsp;&nbsp;&nbsp;</td><td><select id="sex2" name="sex"><option value='-1' selected="selected">请选择</option><option value='0'>混合</option><option value='1'>男</option><option value='2'>女</option></select></td></tr>
		    <tr><td colspan="2"><input id="submitBtn2" type="button" value="提交" style="height: 40px;width: 70px"/></td></tr>
		</table>
	</div>
	<div id="menuContent3" class="menuContent" style="display:none; position: absolute;">
	<ul id="treeDemo3" class="ztree" style="margin-top:0; width:160px;"></ul>
	</div>
	
	
	
	
	
	
	
	
</body>
</html>