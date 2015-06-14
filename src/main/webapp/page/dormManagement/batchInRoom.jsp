<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>入宿</title>
    <jsp:include page="../common/commonjs.jsp"></jsp:include>
</head>
<body>
<div style="text-align: center;">入宿</div>
<hr size="1" color="#DDDDDD">
<div>
    <div style="float: left;text-align: center; padding: 10px;">
        <label>选择入住人员 | </label>
        <input id="allSex" type="radio" onclick="flushTreeUnit(0)" name="sex" value="0">全部
        <input id="male" type="radio" onclick="flushTreeUnit(1)" name="sex" value="1">男
        <input id="female" type="radio" onclick="flushTreeUnit(2)" name="sex" value="2">女
        <ul id="treePeople" class="ztree"></ul>
        <div style="font-size: 14px">
            <font color="red">红色</font>表示未分配，<b>黑色</b>表示已分配
        </div>
    </div>
    <div style="float: left; text-align: center; padding: 10px;">
        <label>选择入住地点</label>
        <ul id="treeUnit" class="ztree"></ul>
        <div style="font-size: 14px">
            <font color="yellow"><b>黄色</b></font>表示满宿，<font color="green"><b>绿色</b></font>表示可入宿
        </div>
    </div>
</div>
</body>

<SCRIPT type="text/javascript">
    var peopleJsonData;
    var unitJsonData;
    var setting = {
        view: {
            fontCss: getFont,
            nameIsHTML: true
        },
        edit: {
            enable: true,
            showRemoveBtn: false,
            showRenameBtn: false
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            beforeDrag: beforeDrag,
            beforeDrop: beforeDrop
        }
    };

    var setting2 = {
        view: {
            fontCss: getFont2,
            nameIsHTML: true
        },
        edit: {
            enable: true,
            showRemoveBtn: false,
            showRenameBtn: false
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            beforeDrag: beforeDrag,
            beforeDrop: beforeDrop
        }
    };

    function getFont(treeId, node) {
        if(node.isAllocated!='-1' && node.isAllocated!='1'){
            node.font = {'color':'red'};
        }
        return node.font;
    }

    function getFont2(treeId, node) {
        if(node.unitType == '3') {
            if (node.restSize == 0) {
                node.font = {'background-color': 'yellow'};
            } else {
                node.font = {'background-color': 'green'};
            }
        }
        return node.font;
    }

    function beforeDrag(treeId, treeNodes) {
        if(treeId == "treeUnit") {
            return false;
        }
        for (var i=0,l=treeNodes.length; i<l; i++) {
            if (treeNodes[i].drag === false) {
                return false;
            }
        }
        return true;
    }

    /**
     * 递归获取要入宿的人员的ID和Name
     * 返回值是一个数组res
     * res[0] 所要入宿的人员的ID 形如：1,2,3,
     *
     */
    function getIDsNames(treeNodes) {
        var ids = "", names = "";
        var res = new Array();
        for (var i=0; i<treeNodes.length; i++) {
            if(treeNodes[i].check_Child_State == 0) {
                var t = getIDsNames(treeNodes[i].children);
                ids += t[0];
                names += t[1];
            }
            else {
                if(treeNodes[i].isAllocated == '1') {
                    if (confirm(treeNodes[i].name + "  已经入宿是否重新排宿？")) {
                        ids += "," + treeNodes[i].id ;
                        names += "," + treeNodes[i].name;
                    }
                } else {
                    ids += "," + treeNodes[i].id ;
                    names += "," + treeNodes[i].name;
                }
            }
        }
        res[0] = ids;
        res[1] = names;
        return res;
    }


    /**
     * 获取某个节点的所有叶子节点
     */
    function getAllChildren(treeNodes) {
        var objs = [], k=0;
        if(treeNodes.check_Child_State == 0) {
            for (var i=0; i<treeNodes.children.length; i++) {
                var t = getAllChildren(treeNodes.children[i]);
                objs =  objs.concat(t) ;
            }
        } else {
            objs[k++] = treeNodes;
        }
        return objs;
    }

    function beforeDrop(treeId, treeNodes, targetNode, moveType) {
        if(!targetNode.hasOwnProperty("treePath")) {
            return false;
        }
        var idsAndNames = getIDsNames(treeNodes);
        if(idsAndNames[0] == "") return false;
        var srcIDs = idsAndNames[0];
        srcIDs = srcIDs.substring(1);
        var names = idsAndNames[1];
        names = names.substring(1)
        var targetID = targetNode.id;
        var msg = "是否将 [" + names + "] 入宿到  " + targetNode.name;
        var jsonData = {
            peopleIDs : srcIDs,
            unitIDs : targetID
        }
        if (confirm(msg)) {
            //预分配房间
            var resJson = preDistribution(idsAndNames, targetNode);
            if(!resJson) {
                alert("房间不够用");
                return false;
            }
            var resDate = {
                peopleUnitIDs :  JSON.stringify(resJson)
            }

            $.postJson("/dormManagement/allocateUnit.do", resDate, function (jsonData) {
                if(jsonData.msg != '') {
                    alert(jsonData.msg);
                } else {
                    alert("入宿成功！");
                    flushPeopleTree();
                    flushUnitTree();
                }
            });
        }
        return false;
    }

    $(document).ready(function(){
        $("#allSex").attr("checked","checked");
        flushUnitTree();
        flushPeopleTree();
    });

    function flushUnitTree() {
        $.getJson("/metaManagement/getAllLocations.do", function (jsonData) {
            unitJsonData = jsonData.data;
            updateUnit(jsonData.data);
        });
    }

    function flushPeopleTree() {
        var allSex = $("#allSex")[0];
        var male = $("#male")[0];
        var female = $("#female")[0];
        var paraJson;
        if(allSex.checked) paraJson = {sex : allSex.value};
        if(male.checked) paraJson = {sex : male.value};
        if(female.checked) paraJson = {sex : female.value};
        $.postJson("/dormManagement/getAllStudentBySchool.do", paraJson, function (jsonData) {
            peopleJsonData = jsonData.data;
            $.fn.zTree.init($("#treePeople"), setting, jsonData.data);
        });
    }

    function updateUnit(data) {
        for(var i=0; i<data.length; i++) {
            if(data[i].unitType == '3') {
                var le = data[i].name.indexOf('(');
                data[i].name = le>0? data[i].name.substr(0, le):data[i].name;
                data[i].name += "("+data[i].restSize+")";
                if(data[i].restSize == '0') data[i].font = eval("({'background-color':'yellow', 'color':'black'})");
                else data[i].font = eval("({'background-color':'green', 'color':'black'})");
            }
        }
        $.fn.zTree.init($("#treeUnit"), setting2, data);
    }

    function flushTreeUnit(val) {
        var jsonData = {
            sex : val
        }
        $.postJson("/dormManagement/getAllStudentBySchool.do", jsonData, function (jsonData) {
            $.fn.zTree.init($("#treePeople"), setting, jsonData.data);
        });
    }
    function preDistribution(idsAndNames, targetNode) { //preDistribution(treeNodes, targetNode)
        var resJson = [], restep = 0;
        //判断房间是否够用
        //var idsAndNames = getIDsNames(treeNodes);
        var srcIDs = idsAndNames[0];
        srcIDs = srcIDs.substring(1);
        var peopleIDs = srcIDs.split(",");
        if(peopleIDs.length > targetNode.restSize) {
            return false;
        }
        var rooms = getAllChildren(targetNode);
        var roomstep = 0;
        for(var i=0; i<peopleIDs.length;) {
            var room = rooms[roomstep++];
            var roomJson = [], step = 0;
            while(room.restSize>0 && i<peopleIDs.length) {
                roomJson[step++] = peopleIDs[i++];
                //下面做节点颜色更新


                room.restSize--;
            }
            if(roomJson.length == 0) continue;
            roomJson[step++] = room.id;
            resJson[restep++] = roomJson;
        }
        return resJson;
    }
</SCRIPT>
