<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/22
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>上元教务-个人信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="<c:url value="/image/web_image/shop_logo.ico"/> " type="image/x-icon" />
    <link rel="stylesheet" href="<c:url value="/layui/css/layui.css"/>">
    <link rel="stylesheet" href="<c:url value="/layui/css/admin.css"/>">
</head>
<input type="hidden" id="url" title="" value="${pageContext.request.contextPath}">
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <jsp:include page="test/public/menu.jsp"/>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="layui-card layadmin-header">
            <span class="layui-breadcrumb">
                <a href="">首页</a>
                <a href="">信息维护</a>
                <a><cite>个人信息</cite></a>
            </span>
        </div>
        <%--主体--%>
        <div class="layui-fluid">
            <div class="layui-card">

            </div>
        </div>
        <div style="padding: 15px;">

        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
    </div>
</div>
<script src="<c:url value="/layui/layui.all.js"/>"></script>
<script src="<c:url value="/js/info.js"/>"></script>
<script type="text/html" class="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    {{#  if(d.status == 1){ }}
    <a class="layui-btn layui-btn-xs" lay-event="check">审核</a>
    {{#  }else if(d.status == 2){ }}
    <a class="layui-btn layui-btn-xs layui-btn-disabled" lay-event="check">已审核</a>
    {{#  } }}
</script>

<script type="text/html" class="genderTpl">
    {{#  if(d.gender==1){ }}男
    {{#  } else if(d.gender==2) { }}女
    {{#  } else{}}保密
    {{#  } }}
</script>
</body>
</html>
