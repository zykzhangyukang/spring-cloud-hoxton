package com.coderman.common.vo;


import java.util.HashMap;
import java.util.Map;


public class JsonData {

    public static final int SUCCESS_CODE=0;  //响应成功
    public static final int ERROR_CODE=-1;   //响应失败
    public static final int PARAM_ERROR=400; //参数错误
    public static final int INTERNAL_SERVER_ERROR=500; //服务器异常
    public static final int TOKEN_ILLEGAL=10001; //令牌不合法 (过期,非法)

    private int code;

    private String msg;

    private Object data;

    public JsonData(int code) {
        this.code = code;
    }

    public JsonData() {
    }

    public JsonData(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static JsonData success(Object object, String msg) {
        JsonData jsonData = new JsonData(SUCCESS_CODE);
        jsonData.data = object;
        jsonData.msg = msg;
        return jsonData;
    }

    public static JsonData success(Object object) {
        JsonData jsonData = new JsonData(SUCCESS_CODE);
        jsonData.data = object;
        return jsonData;
    }

    public static JsonData success() {
        return new JsonData(SUCCESS_CODE);
    }

    public static JsonData fail(String msg) {
        JsonData jsonData = new JsonData(ERROR_CODE);
        jsonData.msg = msg;
        return jsonData;
    }

    public static JsonData fail(int code,String msg) {
        JsonData jsonData = new JsonData(code);
        jsonData.msg = msg;
        return jsonData;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }

    public static int getSuccessCode() {
        return SUCCESS_CODE;
    }

    public static int getErrorCode() {
        return ERROR_CODE;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonData{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
