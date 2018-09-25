<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script type="text/javascript" src="<%=path %>/styles/houtai/scripts/jquery/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="<%=path %>/styles/houtai/scripts/jquery/jquery.form.js"></script>
    <link href="<%=path %>/styles/houtai/style/authority/basic_layout.css" rel="stylesheet" type="text/css">
    <script type="application/javascript">

    </script>
</head>
<body>
HelloWorld
</body>
</html>