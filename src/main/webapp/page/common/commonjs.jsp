
<%    
String path = request.getContextPath();       
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";      
%> 
<link rel="stylesheet" type="text/css" href="<%=basePath%>ui/zTree/css/zTreeStyle/zTreeStyle.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>ui/zTree/css/demo.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>ui/common/css/menu.css">

<script type="text/javascript" src="<%=basePath%>ui/common/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>ui/common/js/common.js"></script>
<script type="text/javascript" src="<%=basePath%>ui/common/js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>ui/common/js/jquery.md5.js"></script>

<script type="text/javascript" src="<%=basePath%>ui/zTree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="<%=basePath%>ui/zTree/js/jquery.ztree.exedit-3.5.js"></script>
<script type="text/javascript" src="<%=basePath%>ui/zTree/js/jquery.ztree.excheck-3.5.js"></script>

