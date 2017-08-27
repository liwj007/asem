package com.liwj.asem.enums;

import java.util.HashMap;
import java.util.Map;

public enum ApplicationStepStatusEnum {
    GRADE(0, " 待年级审核"),
    COLLEGE(1, "待学院审核"),
    SCHOOL(2, "待学校审核"),
    PASS(3, "审核通过"),
    REJECT(4, "审核不通过");

    public final String desc;
    public final int code;

    // 构造方法
    private ApplicationStepStatusEnum(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    private static Map<Integer, ApplicationStepStatusEnum> map;

    static {
        ApplicationStepStatusEnum[] res = values();
        map = new HashMap<>(res.length);
        for (ApplicationStepStatusEnum item : res) {
            map.put(item.code, item);
        }
    }

    public static ApplicationStepStatusEnum getByCode(int code) {
        return map.get(code);
    }

    public static String getNameByCode(int code) {
        return map.get(code).desc;
    }
}
