package com.liwj.asem.enums;

import java.util.HashMap;
import java.util.Map;

public enum UnitTypeEnum {
    SCHOOL(0, "学校"),
    COLLEGE(1, "学院");

    public final String desc;
    public final int code;

    // 构造方法
    private UnitTypeEnum(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    private static Map<Integer, UnitTypeEnum> map;

    static {
        UnitTypeEnum[] res = values();
        map = new HashMap<>(res.length);
        for (UnitTypeEnum item : res) {
            map.put(item.code, item);
        }
    }

    public static UnitTypeEnum getByCode(int code) {
        return map.get(code);
    }

    public static String getNameByCode(int code) {
        return map.get(code).desc;
    }
}
