<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kirito
  Date: 2018/10/3
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-header">
    <div class="layui-logo">上元学生教务系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
        <li class="layui-nav-item"><a href="">控制台</a></li>
        <li class="layui-nav-item"><a href="">商品管理</a></li>
        <li class="layui-nav-item"><a href="">用户</a></li>
        <li class="layui-nav-item">
            <a href="javascript:;">其它系统</a>
            <dl class="layui-nav-child">
                <dd><a href="">邮件管理</a></dd>
                <dd><a href="">消息管理</a></dd>
                <dd><a href="">授权管理</a></dd>
            </dl>
        </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a href="javascript:;">
                <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                贤心
            </a>
            <dl class="layui-nav-child">
                <dd><a href="<c:url value="/user/info"/>">基本资料</a></dd>
                <dd><a href="">安全设置</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="">退了</a></li>
    </ul>
</div>

<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree" lay-filter="test">
            <li class="layui-nav-item">
                <a class="" href="javascript:;">信息维护</a>
                <dl class="layui-nav-child">
                    <dd><a href="<c:url value="/user/info"/>">个人信息</a></dd>
                    <dd><a href="<c:url value="/user/pass"/>">密码修改</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">异动管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="">转专业申请</a></dd>
                    <dd><a href="">休学申请</a></dd>
                    <dd><a href="">退学申请</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">课程管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="">必修课</a></dd>
                    <dd><a href="">选修课</a></dd>
                    <dd><a href="">选课信息</a></dd>
                    <dd><a href="">重修管理</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">信息查询</a>
                <dl class="layui-nav-child">
                    <dd><a href="">课表</a></dd>
                    <dd><a href="">成绩查询</a></dd>
                    <dd><a href="">课程设计</a></dd>
                    <dd><a href="">毕业设计</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">考试管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="">考试安排表</a></dd>
                    <dd><a href="">申请补考</a></dd>
                    <dd><a href="">申请缓考</a></dd>
                    <dd><a href="">审批</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">等级考试</a>
                <dl class="layui-nav-child">
                    <dd><a href="">班级管理</a></dd>
                    <dd><a href="">学科管理</a></dd>
                    <dd><a href="">账户管理</a></dd>
                    <dd><a href="">登陆日志</a></dd>
                </dl>
            </li>
            <%--<li class="layui-nav-item"><a href="">发布商品</a></li>--%>
            <li class="layui-nav-item">
                <a href="<c:url value="/test/select"/>">测试列表</a>
            </li>
        </ul>
    </div>
</div>
