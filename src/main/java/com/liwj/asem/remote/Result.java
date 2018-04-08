package com.liwj.asem.remote;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public class Result {
    public boolean status;
    public int code;
    public List<JSONObject> data;
    public String message;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<JSONObject> getData() {
        return data;
    }

    public void setData(List<JSONObject> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
