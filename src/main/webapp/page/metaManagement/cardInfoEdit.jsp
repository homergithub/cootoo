<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>门锁信息录入</title>
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
    <div>
        <table cellspacing="20px">
            <tr><td>门卡MAC_ID:</td><td><input id="cardMacID" type="text" size="23px"/></td></tr>
            <tr><td>门卡名称:</td><td><input id="cardName" type="text" size="23px"/></td></tr>
            <tr><td>是否有效:</td><td><select id="cardIsLive"><option value='1'>可用</option><option value='0'>禁用</option></select></td></tr>
            <tr><td>门卡类型:</td><td>
                <select id="cardTypeID"/>
                </select>
            </td></tr>
            <tr><td colspan="2"><input id="submitBtn" type="button" value="提交" style="height: 40px;width: 70px"/></td></tr>
        </table>
    </div>

    <div style="text-align: center;">门卡信息修改</div>
    <hr size="1" color="#DDDDDD">

    <div style="float: left; width: 50%; padding: 10px; border-right: 1px solid #989797;">
        门卡类型:
        <select id="cardTypeID_search"/></select> &nbsp;&nbsp;&nbsp;&nbsp;
        门卡名称:
        <input id="cardName_search" type="text" />
        <input id="submitBtn_search" type="button" value="查询" style=""/>
        <br><br>
        <table id="list" style="width: 100%; text-align: center;">
            <tr><td>门卡MAC_ID</td><td>门卡名称</td><td>激活时间</td><td>操作</td></tr>
        </table>
    </div>

    <div style="float: left;">
       <%-- <table style="float:left; height:360px;
                    border-color:#888383;
                    border-left-style:solid;
                    border-width:1px;
                    margin-left: 20px">
            <tr><td valign="top"></td></tr>
        </table>--%>
        <table cellspacing="20px">
            <tr><td>门卡MAC_ID:</td><td><input id="cardMacID_" type="text" size="23px"/></td></tr>
            <tr><td>门卡名称:</td><td><input id="cardName_" type="text" size="23px"/></td></tr>
            <tr><td>是否有效:</td><td><select id="cardIsLive_"><option value='1'>可用</option><option value='0'>禁用</option></select></td></tr>
            <tr><td>门卡类型:</td><td>
                <select id="cardTypeID_"/>
                </select>
            </td></tr>
            <tr><td colspan="2"><input id="submitBtn_" type="button" value="提交" style="height: 40px;width: 70px"/></td></tr>
        </table>
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
            onClick: onClick2
        }
    };

    function onClick2() {}

    $(document).ready(function(){
        loadCardType();

        $("#submitBtn").click(function(){
            addCard();
        });

        $("#submitBtn_").click(function(){
            updateCard();
        });

        $("#submitBtn_search").click(function(){
            flushCardList();
        });
    });

    function addCard() {
        var data = getPara('');
        $.postJson("/metaManagement/addCard.do",data,function(jsonData){
            alert(jsonData.msg);
            flushCardList();
        });
    }

    function updateCard() {
        var data = getPara('_');
        $.postJson("/metaManagement/updateCard.do",data,function(jsonData){
            alert(jsonData.msg);
            flushCardList();
        });
    }

    function delCard(cardMacID) {
        if(confirm("确认删除？")) {
            $.postJson("/metaManagement/deleteCard.do", {cardMacID: cardMacID}, function (jsonData) {
                alert(jsonData.msg);
                flushCardList();
            });
        }
    }

    function editCard(card) {
        $("#cardMacID_").val(card.cardMacID);
        $("#cardName_").val(card.cardName);
        $("#cardIsLive_").val(card.cardIsLive);
        $("#cardTypeID_").val(card.cardTypeID);
    }

    function loadCardType() {
        $.getJson("/metaManagement/getCardType.do", function(jsonData) {
            $("#cardTypeID_search").append("<option value='0'>所有</option>");
            for(var i=0; i<jsonData.data.length; i++) {
                $("#cardTypeID").append("<option value='"+jsonData.data[i].cardTypeID+"'>"+jsonData.data[i].cardTypeName+"</option>");
                $("#cardTypeID_").append("<option value='"+jsonData.data[i].cardTypeID+"'>"+jsonData.data[i].cardTypeName+"</option>");
                $("#cardTypeID_search").append("<option value='"+jsonData.data[i].cardTypeID+"'>"+jsonData.data[i].cardTypeName+"</option>");
            }
        });
    }

    function getLocalTime(nS) {
        return new Date(parseInt(nS)).toLocaleString().replace(/:\d{1,2}$/,' ');
    }

    function flushCardList() {
        var cardName = $("#cardName_search").val().trim();
        var cardTypeID = $("#cardTypeID_search").val().trim();
        var data = {
            cardName : cardName,
            cardTypeID : cardTypeID
        }
        $.postJson("/metaManagement/getAllCardByOrgID.do",data,function(jsonData){
            $(".del").remove();
            for(var i=0; i<jsonData.data.length; i++) {
                var innerStr = "<tr class='del'>";
                innerStr += "<td>" + jsonData.data[i].cardMacID + "</td>";
                innerStr += "<td>" + jsonData.data[i].cardName + "</td>";
                innerStr += "<td>" + getLocalTime(jsonData.data[i].cardRegisterTime) + "</td>"
                innerStr += "<td><a href='javascript:void(0)'  onclick='editCard("+JSON.stringify(jsonData.data[i])+")'>编辑</a>&nbsp;&nbsp;" +
                        "<a href='javascript:void(0)' onclick=delCard('"+jsonData.data[i].cardMacID+"')>删除</a></td>"
                innerStr += "</tr>"
                $("#list").append(innerStr);
            }
        });
    }

    function getPara(val) {
        var cardMacID = $("#cardMacID"+val).val().trim();
        var cardName = $("#cardName"+val).val().trim();
        var cardIsLive = $("#cardIsLive"+val).val().trim();
        var cardTypeID = $("#cardTypeID"+val).val().trim();

        if(cardMacID ==""|| cardName =="" || cardIsLive == ""|| cardTypeID == ""){
            alert("填写完整信息");
            return;
        }

        var data = {
            cardMacID : cardMacID,
            cardName : cardName,
            cardIsLive : cardIsLive,
            cardTypeID : cardTypeID
        }
        return data;
    }

</script>
</body>
</html>