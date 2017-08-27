package com.liwj.asem.enums;

import java.util.HashMap;
import java.util.Map;

public enum AllocationMethodEnum {
    COLLEGE(0, "按学院分配"),
    GRADE(1, "按年级分配");

    public final String desc;
    public final int code;

    // 构造方法
    private AllocationMethodEnum(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    private static Map<Integer, AllocationMethodEnum> map;

    static {
        AllocationMethodEnum[] res = values();
        map = new HashMap<>(res.length);
        for (AllocationMethodEnum item : res) {
            map.put(item.code, item);
        }
    }

    public static AllocationMethodEnum getByCode(int code) {
        return map.get(code);
    }

    public static String getNameByCode(int code) {
        return map.get(code).desc;
    }
}
