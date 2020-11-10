package com.javayz.entity;

/**
 * @author by: Liyu
 * @ClassName: Response
 * @Description: TODO  请求返回结果实体类
 * @Date: 2020/11/9 11:45
 */
public class Response {
    private int status;
    private String msg;
    private Object data;

    public Response() {
    }

    public Response(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
