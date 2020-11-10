package com.javayz.entity;

/**
 * @author by: Liyu
 * @ClassName: ResponseCode
 * @Description: TODO 通过返回体
 * @Date: 2020/11/9 15:52
 */
public enum ResponseCode {
    // 通用模块 1xxxx
    ILLEGAL_ARGUMENT(10000, "参数不合法"),
    REPETITIVE_OPERATION(10001, "请勿重复操作"),
    ;
    ResponseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private Integer code;
    private String msg;
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
