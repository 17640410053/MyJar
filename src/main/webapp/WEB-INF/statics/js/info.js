layui.use(['element'], function () {
    var element = layui.element, $ = layui.$, url = $('#url').val(), active = {};

    $('.layui-side-scroll .layui-nav-item:eq(0)').addClass('layui-nav-itemed');
    $('.layui-side-scroll .layui-nav-item:eq(0) dd:eq(0)').addClass('layui-this');
});