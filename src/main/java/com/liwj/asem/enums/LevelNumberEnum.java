package com.liwj.asem.enums;

import java.util.HashMap;
import java.util.Map;

public enum LevelNumberEnum {
    SCHOOL(0, "学校"),
    COLLEGE(1, "学院"),
    GRADE(2, "年级");

    public final String desc;
    public final int code;

    // 构造方法
    private LevelNumberEnum(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    private static Map<Integer, LevelNumberEnum> map;

    static {
        LevelNumberEnum[] res = values();
        map = new HashMap<>(res.length);
        for (LevelNumberEnum item : res) {
            map.put(item.code, item);
        }
    }

    public static LevelNumberEnum getByCode(int code) {
        return map.get(code);
    }

    public static String getNameByCode(int code) {
        return map.get(code).desc;
    }
}
