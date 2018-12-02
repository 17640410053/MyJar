package com.bilibili.yl.entity;

/**
 * 通用返回集
 * <p>
 * code : 状态码
 * <p>
 * msg : 返回信息
 * <p>
 * count : 返回的记录数
 * <p>
 * data : [{},{}] 泛型T，返回的数据，如果没有返回null
 */
public class ResultEntity<T> {
    private Integer code;
    private String msg;
    private Long count;
    private T data;

    public ResultEntity() {
    }

    public ResultEntity(Integer code) {
        this.code = code;
    }

    public ResultEntity(Integer code, String msg) {
        this(code);
        this.msg = msg;
    }

    public ResultEntity(Integer code, String msg, Long count) {
        this(code, msg);
        this.count = count;
    }

    public ResultEntity(Integer code, String msg, Long count, T data) {
        this(code, msg, count);
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
