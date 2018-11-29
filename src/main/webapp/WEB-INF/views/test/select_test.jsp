<%--
  Created by IntelliJ IDEA.
  User: Kirito
  Date: 2018/10/3
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>上元学生教务系统</title>
    <link rel="shortcut icon" href="<c:url value="/image/web_image/shop_logo.ico"/> " type="image/x-icon" />
    <link rel="stylesheet" href="<c:url value="/layui/css/layui.css"/>">
    <link rel="stylesheet" href="<c:url value="/layui/css/admin.css"/>">
</head>
<input type="hidden" id="url" title="" value="${pageContext.request.contextPath}">
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <jsp:include page="public/menu.jsp"/>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="layui-card layadmin-header">
            <span class="layui-breadcrumb">
                <a href="">首页</a>
                <a><cite>测试列表</cite></a>
            </span>
        </div>
        <div class="layui-fluid">
            <div class="layui-card">
                <div class="layui-form layui-card-header layuiadmin-card-header-auto">
                    <div class="search-from">
                        搜索数据：
                        <div class="layui-inline">
                            <input class="layui-input" name="keyword" id="demoReload" autocomplete="off"
                                   placeholder="输入要查询的信息">
                        </div>
                        <button class="layui-btn" data-type="search">搜索</button>
                        <button class="layui-btn" data-type="show">显示全部</button>
                    </div>
                </div>
                <div class="layui-card-body">
                    <div>
                        <button class="layui-btn" data-type="delete">删除</button>
                        <button class="layui-btn" data-type="add">添加</button>
                    </div>
                    <table class="layui-table"
                           lay-data="{url:'<c:url value="/test/getTestList"/>', page:true, id:'test'}"
                           lay-filter="test">
                        <thead>
                        <tr>
                            <th lay-data="{field:'checkbox', type:'checkbox'}"></th>
                            <th lay-data="{field:'testId', sort: true}">ID</th>
                            <th lay-data="{field:'testName'}">用户名</th>
                            <th lay-data="{field:'testPhone'}">电话</th>
                            <th lay-data="{field:'testMail'}">邮箱</th>
                            <th lay-data="{field:'gender',templet: '.genderTpl', sort: true}">性别</th>
                            <th lay-data="{fixed:'right', toolbar: '.barDemo'}">操作</th>
                        </tr>
                        </thead>
                    </table>
                </div>
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
<script src="<c:url value="/js/test.js"/>"></script>
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