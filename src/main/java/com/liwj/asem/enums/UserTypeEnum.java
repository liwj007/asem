package com.liwj.asem.enums;

import java.util.HashMap;
import java.util.Map;

public enum UserTypeEnum {
    NONE(-1, "无用户"),
    ADMIN(0, "管理员"),
    STUDENT(1, "学生用户"),
    SCHOOL_USER(3, "学校用户"),
    GRADE_INSTRUCTOR(4, "年级辅导员用户"),
    COLLEGE_USER(5, "学院用户"),
    SPECIAL_INSTRUCTOR(7, "专项辅导员用户");

    public final String desc;
    public final int code;

    // 构造方法
    private UserTypeEnum(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    private static Map<Integer, UserTypeEnum> map;

    static {
        UserTypeEnum[] res = values();
        map = new HashMap<>(res.length);
        for (UserTypeEnum item : res) {
            map.put(item.code, item);
        }
    }

    public static UserTypeEnum getByCode(int code) {
        return map.get(code);
    }

    public static String getNameByCode(int code) {
        return map.get(code).desc;
    }
}
