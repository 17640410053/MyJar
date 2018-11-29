<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/22
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>上元教务系统 - 登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="<c:url value="/image/web_image/shop_logo.ico"/> " type="image/x-icon"/>
    <link rel="stylesheet" href="<c:url value="/layui/css/layui.css"/>">
    <link rel="stylesheet" href="<c:url value="/layui/css/admin.css"/>">
</head>
<input type="hidden" id="url" title="" value="${pageContext.request.contextPath}">
<body class="layui-bg-gray layui-layout-body">
<div class="card-size">
    <div class="layui-card">
        <div class="layui-card-header">用户登录</div>
        <div class="layui-card-body">
            <form class="layui-form" action="<c:url value="/user/info"/>">
                <div class="layui-form-item">
                    <label class="layui-form-label">学号</label>
                    <div class="layui-input-inline">
                        <input type="text" name="title" required lay-verify="required" placeholder="请输入用户名"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="password" required lay-verify="required" placeholder="请输入密码"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">复选框</label>
                    <div class="layui-input-block">
                        <input type="checkbox" name="keep_login" title="7天免登录">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">登录</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="<c:url value="/layui/layui.all.js"/>"></script>
<script>
    //Demo
    layui.use('form', function () {
        var form = layui.form;
        //监听提交
        form.on('submit(formDemo)', function (data) {
            layer.msg(JSON.stringify(data.field));
        });
    });
</script>
</body>
</html>