<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%    
String path = request.getContextPath();       
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";      
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>你访问的页面不存在或被删除</title>
<meta http-equiv=content-type content="text/html; charset=utf-8">
<meta http-equiv=refresh content=3;url=<%=basePath%>login.html>
<style type=text/css>
.font14 {
	font-size: 14px
}
.font12 {
	font-size: 12px
}
.font12 a{
	font-size: 12px; color: #cc0000; text-decoration:none;
}

</style>

</head>
<body>
<table height=500 cellspacing=0 cellpadding=0 width=500 align=center background='<%=basePath %>ui/common/images/404.gif' border=0 style="background-repeat: no-repeat;">
  <tbody>
  <tr>
    <td height=330>　</td></tr>
  <tr>
    <td valign=top>
      <div class=font14 align=center>
      <strong>你访问的页面
      <font color=#0099ff>不存在</font>或被
      <font color=#ff0000>删除！<br></font>
      </strong><span class=font12>
      <font color=#666666>3秒后自动返回</font></span>
      </div>
      </td></tr></tbody></table>
      
</body>
</html>