package com.liwj.asem.enums;

import java.util.HashMap;
import java.util.Map;

public enum LevelTypeEnum {
    AVG(0, "均等"),
    MULTI(1, "有多个等级");

    public final String desc;
    public final int code;

    // 构造方法
    private LevelTypeEnum(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    private static Map<Integer, LevelTypeEnum> map;

    static {
        LevelTypeEnum[] res = values();
        map = new HashMap<>(res.length);
        for (LevelTypeEnum item : res) {
            map.put(item.code, item);
        }
    }

    public static LevelTypeEnum getByCode(int code) {
        return map.get(code);
    }

    public static String getNameByCode(int code) {
        return map.get(code).desc;
    }
}
