package com.liwj.asem.enums;

import java.util.HashMap;
import java.util.Map;

public enum StatusEnum {
    NEW(0, "新建"),
    RELEASE(1, "下发至学院"),
    UNREADY(2,"已分配但不可见"),
    OPEN(3, "开放申请中"),
    CHECK(4, "审核中"),
    CLOSE(5, "关闭"),
    DELETE(6, "删除");

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
