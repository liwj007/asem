package com.liwj.asem.enums;

import java.util.HashMap;
import java.util.Map;

public enum UserRightEnum {
    ADMIN(0, "管理员"),
    SCHOOL(1, "学校用户"),
    STUDENT(2, "学生用户"),
    SPECIAL_INSTRUCTOR(3, "专项辅导员"),
    GRADE_INSTRUCTOR(4, "年级辅导员"),
    GRADE_STUDENT(5, "年级学生助理"),
    COLLEGE_STUDENT(6, "学院学生助理");

    public final String desc;
    public final int code;
    // 构造方法
    private UserRightEnum( int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    private static Map<Integer,UserRightEnum> map;
    static {
        UserRightEnum[] res = values();
        map = new HashMap<>(res.length);
        for(UserRightEnum item: res) {
            map.put(item.code, item);
        }
    }

    public static UserRightEnum getByCode(int code){
        return map.get(code);
    }

    public static String getNameByCode(int code){
        return map.get(code).desc;
    }
}
