package com.liwj.asem.enums;

import java.util.HashMap;
import java.util.Map;

public enum UserTypeEnum {
    ADMIN(0, "管理员"),
    SCHOOL_USER(1, "学校用户"),
    COLLEGE_USER(2, "学院用户"),
    INSTRUCTOR(3, "辅导员用户"),
    STUDENT(4, "学生用户");

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
