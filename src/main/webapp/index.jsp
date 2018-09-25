<%--
  Created by IntelliJ IDEA.
  User: Eunice
  Date: 2018/9/18
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>index</title>
    <script type="application/javascript" src="<%=basePath %>js/jquery-1.10.2.min.js"></script>
</head>
<body>
    <input type="button" value="toTestRedPoint", onclick="toTestRedPoint()">
</body>

<script type="application/javascript">
    function toTestRedPoint() {
        location.href = "<%=basePath %>test/toTestRedPoint";
    }
</script>
</html>