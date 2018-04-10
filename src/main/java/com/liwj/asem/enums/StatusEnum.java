package com.liwj.asem.enums;

import java.util.HashMap;
import java.util.Map;

public enum StatusEnum {
    NEW(0, "新建"),
    INVISIBLE(1,"已分配但不可见"),
    RELEASE(2, "下发至学院"),
    OPEN(3, "开放申请中"),
    CLOSE(5, "关闭");

    public final String desc;
    public final int code;
    // 构造方法
    private StatusEnum(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    private static Map<Integer,StatusEnum> map;
    static {
        StatusEnum[] res = values();
        map = new HashMap<>(res.length);
        for(StatusEnum item: res) {
            map.put(item.code, item);
        }
    }

    public static StatusEnum getByCode(int code){
        return map.get(code);
    }

    public static String getNameByCode(int code){
        return map.get(code).desc;
    }
}
