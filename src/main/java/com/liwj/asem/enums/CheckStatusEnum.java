package com.liwj.asem.enums;

import java.util.HashMap;
import java.util.Map;

public enum CheckStatusEnum {
    NEW(0, "新建"),
    PASS(1, "通过"),
    REJECT(2, "不通过");

    public final String desc;
    public final int code;

    // 构造方法
    private CheckStatusEnum(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    private static Map<Integer, CheckStatusEnum> map;

    static {
        CheckStatusEnum[] res = values();
        map = new HashMap<>(res.length);
        for (CheckStatusEnum item : res) {
            map.put(item.code, item);
        }
    }

    public static CheckStatusEnum getByCode(int code) {
        return map.get(code);
    }

    public static String getNameByCode(int code) {
        return map.get(code).desc;
    }
}
