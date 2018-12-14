package com.bilibili.yl.enums;

public enum ResultEnum {
    // 成功状态码
    SUCCESS("参数为空", 10001),

    // 参数错误
    PARAMS_IS_NULL("参数为空", 10001),
    PARAMS_NOT_COMPLETE("参数不全", 10002),
    PARAMS_TYPE_ERROR("参数类型错误", 10003),
    PARAMS_IS_INVALID("参数无效", 10004),

    // 用户错误
    USER_NOT_EXIST("用户不存在", 20001),
    USER_NOT_LOGGED_IN("用户未登录", 20002),
    USER_ACCOUNT_ERROR("用户名或密码错误", 20003),
    USER_ACCOUNT_FORBIDDEN("用户账户已被禁用", 20004),
    USER_HAS_EXIST("用户已存在", 20005),

    // 业务错误
    BUSINESS_ERROR("系统业务出现问题", 30001),

    // 系统错误
    SYSTEM_INNER_ERROR("系统内部错误", 40001),

    // 数据错误
    DATA_NOT_FOUND("数据未找到", 50001),
    DATA_IS_WRONG("数据有误", 50002),
    DATA_ALREADY_EXISTED("数据已存在", 50003),

    // 接口错误
    INTERFACE_INNER_INVOKE_ERROR("系统内部接口调用异常", 60001),
    INTERFACE_OUTER_INVOKE_ERROR("系统外部接口调用异常", 60002),
    INTERFACE_FORBIDDEN("接口禁止访问", 60003),
    INTERFACE_ADDRESS_INVALID("接口地址无效", 60004),
    INTERFACE_REQUEST_TIMEOUT("接口请求超时", 60005),
    INTERFACE_EXCEED_LOAD("接口负载过高", 60006),

    // 权限不足
    PERMISSION_NO_ACCESS("没有访问权限", 70001);

    private String msg;
    private int code;

    ResultEnum(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
