<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>门锁信息编辑</title>
<style type="text/css">
td{
text-align: left;
}
</style>
<jsp:include page="../common/commonjs.jsp"></jsp:include>

</head>
<body>
	<div style="text-align: center;">门锁信息录入</div>
	<hr size="1" color="#DDDDDD">
	<div id="lockInsert">
		<table cellspacing="20px">
			<tr><td>门锁MAC_ID:</td><td><input id="lockMacID" type="text" size="23px"/></td></tr>
			<tr><td>门锁名称:</td><td><input id="lockName" type="text" size="23px"/></td></tr>
			<tr><td>是否有效:</td><td><select id="isLive"><option value='1'>可用</option><option value='0'>禁用</option></select></td></tr>
			<tr><td>所属位置:</td><td><input id="lockLocation" type="text" size="23px"/><a id="menuBtn" href="#" onclick="showMenu(''); return false;">选择</a></td></tr>
			<tr><td>所属中继器:</td><td><input id="lockRepeater" type="text" size="23px"/><a id="menuBtn2" href="#" onclick="showMenu2(''); return false;">选择</a></td></tr>
			<tr><td colspan="2"><input id="submitBtn" type="button" value="提交" style="height: 40px;width: 70px"/></td></tr>
		</table>
	</div>
	<!-- 用于显示位置 -->
	<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
		<ul id="treeDemo" class="ztree" style="margin-top:0; width:160px;"></ul>
	</div>
	<!-- 用于显示中继器 -->
	<div id="menuContent2" class="menuContent" style="display:none; position: absolute;">
		<ul id="treeDemo2" class="ztree" style="margin-top:0; width:160px;"></ul>
	</div>


    <div style="text-align: center;">门锁信息修改</div>
    <hr size="1" color="#DDDDDD">
    <div>
        <div class="zTreeDemoBackground left" style="float: left; width:20%; padding-left: 10px;">
            <ul id="lockTree" class="ztree" style="margin-top: 0px;"></ul>
        </div>

        <div id="lockEdit" style="width:80%;">
            <table cellspacing="20px">
                <tr><td>门锁MAC_ID:</td><td><input id="lockMacID_" type="text" size="23px"/></td></tr>
                <tr><td>门锁名称:</td><td><input id="lockName_" type="text" size="23px"/></td></tr>
                <tr><td>是否有效:</td><td><select id="isLive_"><option value='1'>可用</option><option value='0'>禁用</option></select></td></tr>
                <tr><td>所属位置:</td><td><input id="lockLocation_" type="text" size="23px"/><a id="menuBtn_" href="#" onclick="showMenu('_'); return false;">选择</a></td></tr>
                <tr><td>所属中继器:</td><td><input id="lockRepeater_" type="text" size="23px"/><a id="menuBtn2_" href="#" onclick="showMenu2('_'); return false;">选择</a></td></tr>
                <input id="hidLocationID_" type="hidden"/>
                <tr><td colspan="2"><input id="submitBtn_" type="button" value="提交" style="height: 40px;width: 70px"/></td></tr>
            </table>
            <!-- 用于显示位置 -->
            <div id="menuContent_" class="menuContent" style="display:none; position: absolute;">
                <ul id="treeDemo_" class="ztree" style="margin-top:0; width:160px;"></ul>
            </div>
            <!-- 用于显示中继器 -->
            <div id="menuContent2_" class="menuContent" style="display:none; position: absolute;">
                <ul id="treeDemo2_" class="ztree" style="margin-top:0; width:160px;"></ul>
            </div>
        </div>
    </div>
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
    if(treeId == 'treeDemo2') {
        $("#lockRepeater").val(treeNode.name);
        if (treeNode.unitType != '0') {
            alert("请选择中继器");
            return;
        }
    } else {
        if (treeNode.unitType != '3') {
            alert("请选择房间");
            return;
        }
        var parentObj = $("#lockLocation");
        parentObj.val(treeNode.name);
    }
}

function showMenu(val) {
    $.getJson("/metaManagement/getAllLocations.do",callback);
    var parentObj = $("#lockLocation"+val);
    var parentOffset = $("#lockLocation"+val).offset();
    $("#menuContent"+val).css({left:parentOffset.left + "px", top:parentOffset.top + parentObj.outerHeight() + "px"}).slideDown("fast");
    if(val != '_') {
        $("#lockInsert").bind("mousedown", onBodyDown);
    } else {
        $("#lockEdit").bind("mousedown", onBodyDown_);
    }
}
function hideMenu() {
    $("#menuContent").fadeOut("fast");
    $("#menuContent_").fadeOut("fast");
    $("body").unbind("mousedown", onBodyDown);

}
function onBodyDown(event) {
    if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
        hideMenu();
    }
}
function onBodyDown_(event) {
    if (!(event.target.id == "menuBtn_" || event.target.id == "menuContent_" || $(event.target).parents("#menuContent_").length>0)) {
        hideMenu();
    }
}

function callback(jsonData){
    $.fn.zTree.init($("#treeDemo"), setting, jsonData.data);
    $.fn.zTree.init($("#treeDemo_"), setting2, jsonData.data);
}

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

var setting3 = {
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

function beforeRemove(treeId, treeNodes){
    if(treeNodes.unitType != '-1'){
        alert("只能删除门锁");
        return false;
    }
    if (!confirm("确认要删除？")) {
        return false;
    }
    var data = {lockMacID:treeNodes.id};
    $.postJson("/metaManagement/deleteLock.do",data,function(jsonData){
        alert(jsonData.msg);
    });
}

function onClick2(e, treeId, treeNode) {
    if(treeId == 'lockTree') {
        if (treeNode.unitType == '-1') {
            $.postJson("/metaManagement/getLock.do", {lockMacID: treeNode.id}, function (jsonData) {
                var data = jsonData.data;
                $("#lockMacID_").val(data.lockMacID);
                $("#lockName_").val(data.lockName);
                $("#isLive_").val(data.isLive);
                $("#lockLocation_").val(data.unitName);
                var lTree = $.fn.zTree.getZTreeObj("treeDemo_");
                lTree.selectNode(lTree.getNodeByParam("id", data.locationID,null));
                $("#lockRepeater_").val(data.repeaterName);
                var rTree = $.fn.zTree.getZTreeObj("treeDemo2_");
                rTree.selectNode(rTree.getNodeByParam("id", data.repeaterID,null));
            });
        } else if (treeNode.unitType == '0') {
            //点击的是中继器
        }
    } else if(treeId == 'treeDemo2_') {
        $("#lockRepeater_").val(treeNode.name);
        if (treeNode.unitType != '0') {
            alert("请选择中继器");
            return;
        }
    } else {
        if (treeNode.unitType != '3') {
            alert("请选择房间");
            return;
        }
        $("#lockLocation_").val(treeNode.name);
    }
}

function showMenu2(val) {
    //$.getJson("/metaManagement/getAllRepeaters.do",callback2);
    if($("#lockLocation"+val).val().trim()==""){
        alert("请先选择所属位置");
        return;
    }
    var zTree = $.fn.zTree.getZTreeObj("treeDemo"+val);
    var nodes = null;
    if(zTree!=null){
        nodes = zTree.getSelectedNodes();
        nodes = nodes[0].getParentNode();
    }
    var location = "";
    if(!(nodes == null || nodes.length == 0)){

        location = nodes.id;
    }

    var data = {
        locationID:location
    }

    $.postJson("/metaManagement/getRepeaterByLocation.do",data,callback2);

    var parentObj = $("#lockRepeater"+val);
    var parentOffset = $("#lockRepeater"+val).offset();
    $("#menuContent2"+val).css({left:parentOffset.left + "px", top:parentOffset.top + parentObj.outerHeight() + "px"}).slideDown("fast");
    $("body").bind("mousedown", onBodyDown2);
}
function hideMenu2() {
    $("#menuContent2").fadeOut("fast");
    $("#menuContent2_").fadeOut("fast");
    $("body").unbind("mousedown", onBodyDown2);

}
function onBodyDown2(event) {
    if (!(event.target.id == "menuBtn2" || event.target.id == "menuContent2" || $(event.target).parents("#menuContent2").length>0)) {
        hideMenu2();
    }
}

function callback2(jsonData){
    $.fn.zTree.init($("#treeDemo2"), setting, jsonData.data);
    $.fn.zTree.init($("#treeDemo2_"), setting2, jsonData.data);
}

function callback3(jsonData){
    $.fn.zTree.init($("#lockTree"), setting3, jsonData.data);
}

function refresh(){
    $.getJson("/metaManagement/getAllLock.do",callback3);
}

$(document).ready(function(){
    $.getJson("/metaManagement/getAllLocations.do",callback);

    $.getJson("/metaManagement/getAllRepeaters.do",callback2);

    $.getJson("/metaManagement/getAllLock.do",callback3);

    $("#submitBtn").click(function(){
        var data = getPara('');
        if(data == false) return;
        $.postJson("/metaManagement/addLock.do",data,function(jsonData){
            alert(jsonData.msg);
            refresh();
        });
    });

    $("#submitBtn_").click(function(){
        var data = getPara('_');
        if(data == false) return;
        $.postJson("/metaManagement/updateLock.do",data,function(jsonData){
            alert(jsonData.msg);
            refresh();
        });
    });
});

function getPara(val) {
    var lockMacID = $("#lockMacID"+val).val().trim();
    var lockName = $("#lockName"+val).val().trim();
    var isLive = $("#isLive"+val).val().trim();
    var lockLocation = $("#lockLocation"+val).val().trim();
    var lockRepeater = $("#lockRepeater"+val).val().trim();

    if(lockMacID ==""|| lockName =="" || isLive == ""|| lockLocation == "" || lockRepeater==""){
        alert("填写完整信息");
        return false;
    }

    var zTree = $.fn.zTree.getZTreeObj("treeDemo"+val);
    var nodes = null;
    if(zTree!=null){
        nodes = zTree.getSelectedNodes();
    }
    var location = "";
    if(!(nodes == null || nodes.length == 0)){

        location = nodes[0].id;
    }

    var zTree2 = $.fn.zTree.getZTreeObj("treeDemo2"+val);
    var nodes2 = null;
    if(zTree2!=null){
        nodes2 = zTree2.getSelectedNodes();
    }
    var repeaterLocation = "";
    if(!(nodes2 == null || nodes2.length == 0)){

        repeaterLocation = nodes2[0].id;
    }
    var data = {
        lockMacID : lockMacID,
        lockName : lockName,
        isLive : isLive,
        locationID : location,
        repeaterID : repeaterLocation
    }
    return data;
}
</script>
</body>
</html>