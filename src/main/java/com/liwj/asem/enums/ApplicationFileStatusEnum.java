package com.liwj.asem.enums;

import java.util.HashMap;
import java.util.Map;

public enum ApplicationFileStatusEnum {
    NO(0, " 未提交"),
    SUBMIT(1, "审核中"),
    PASS(2, "审核通过"),
    REJECT(3, "审核不通过");

    public final String desc;
    public final int code;

    // 构造方法
    private ApplicationFileStatusEnum(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    private static Map<Integer, ApplicationFileStatusEnum> map;

    static {
        ApplicationFileStatusEnum[] res = values();
        map = new HashMap<>(res.length);
        for (ApplicationFileStatusEnum item : res) {
            map.put(item.code, item);
        }
    }

    public static ApplicationFileStatusEnum getByCode(int code) {
        return map.get(code);
    }

    public static String getNameByCode(int code) {
        return map.get(code).desc;
    }
}
