//JavaScript代码区域
layui.use(['element', 'table'], function () {
    var element = layui.element, table = layui.table, $ = layui.$, url = $('#url').val(), active = {
        //搜索
        search: function () {
            table.reload('test', {
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    keyword: $('#demoReload').val()
                }
            });
        },
        //全部显示
        show: function () {
            table.reload('test', {
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    keyword: ''
                }
            });
        },
        //批量删除
        delete: function () {
            var checkStatus = table.checkStatus('test'), data = checkStatus.data, deList = [];
            data.forEach(function (n, i) {
                deList.push(n.testId);
            });
            if (deList.length === 0) layer.msg('未选中数据'); else {
                layer.prompt({
                    formType: 1, //输入框类型，支持0（文本）默认1（密码）2（多行文本）
                    value: '', //初始时的值，默认空字符
                    title: '敏感操作，请验证口令', //标题
                    maxlength: 15 //可输入文本的最大长度，默认500
                }, function (value, index, elem) {
                    $.ajax({
                        type: 'POST',
                        url: url + '/test/deleteTest',
                        dataType: 'JSON',
                        data: {listForId: deList},
                        success: function (data) {
                            layer.msg(data.msg);
                            table.reload('test');
                        }
                    });
                    layer.close(index);
                });
            }
        },
        //添加
        add: function () {
            layer.msg("添加");
        }
    };

    //绑定按钮事件
    $('.layui-btn').each(function () {
        $(this).on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        })
    });

    //监听工具条
    table.on('tool(test)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象

        if (layEvent === 'detail') { //查看
            layer.open({
                type: 2,
                title: data.testName + '详情',
                content: url + '/test/select',
                scrollbar: false,
                area: ['900px', '600px'],
                resize: false
            });
        } else if (layEvent === 'del') { //删除
            layer.prompt({
                formType: 1, //输入框类型，支持0（文本）默认1（密码）2（多行文本）
                value: '', //初始时的值，默认空字符
                title: '敏感操作，请验证口令', //标题
                maxlength: 15 //可输入文本的最大长度，默认500
            }, function (value, index, elem) {
                var deList = [];
                deList.push(data.testId);
                if (deList.length > 0) {
                    $.ajax({
                        type: 'POST',
                        url: url + '/test/deleteTest',
                        dataType: 'JSON',
                        data: {listForId: deList},
                        success: function (data) {
                            layer.msg(data.msg);
                            table.reload('test');
                        }
                    });
                } else layer.msg('系统错误，请刷新重试');
                layer.close(index);
            });
        } else if (layEvent === 'edit') { //编辑
            //do something
            //同步更新缓存对应的值
            obj.update({
                testId: '123'
                , testName: 'xxx'
            });
        }
    });
});