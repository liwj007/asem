package com.liwj.asem.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liwj0 on 2017/7/19.
 */
public enum ErrorInfo {
    NO_RIGHT(10000, "您暂时没有权限进行相关操作"),
    TOKEN_EXP(10001, "TOKEN过期，请从电子科技大学智慧校园平台重新登录"),
    NO_LOGIN(10002, "该账号未登录，请从电子科技大学智慧校园平台重新登录"),
    PARAMS_ERROR(10003, "输入数据错误"),
    ERROR_USER_LOGIN(20001,"错误的用户名和密码"),
    CAN_NOT_DELETE_OR_UPDATE(30001,"该奖学金已经分配名额或评定时间，无法编辑或删除" );

    public final String desc;
    public final int code;
    // 构造方法
    private ErrorInfo(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    private static Map<Integer,ErrorInfo> map;
    static {
        ErrorInfo[] res = values();
        map = new HashMap<>(res.length);
        for(ErrorInfo tmp: res) {
            map.put(tmp.code, tmp);
        }
    }

    public static ErrorInfo getByCode(int code){
        return map.get(code);
    }

    public static String getMsgByCode(int code){
        return map.get(code).desc;
    }
}
