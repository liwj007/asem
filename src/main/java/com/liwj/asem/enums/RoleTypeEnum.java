package com.liwj.asem.enums;

import java.util.HashMap;
import java.util.Map;

public enum RoleTypeEnum {
    ADMIN(0, "管理员"),
    OTHER(1, "其他"),
    INSTRUCTOR(2, "辅导员"),
    CLASS_TEACHER(3, "班主任"),
    GRADE_ADVISER(4, "年级辅导员"),
    DUTY_ADVISER(5, "责任辅导员"),
    SPECIAL_ADVISER(6, "专项辅导员"),
    COLLEGE_USER(7, "学院用户"),
    SCHOOL_USER(8, "学校用户"),
    SCHOOL_ASSISTANT(9, "学生工作助理"),
    CLASS_COMMITTEE(10, "班委"),
    STUDENT(11, "学生");

    public final String desc;
    public final int code;
    // 构造方法
    private RoleTypeEnum(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    private static Map<Integer,RoleTypeEnum> map;
    static {
        RoleTypeEnum[] res = values();
        map = new HashMap<>(res.length);
        for(RoleTypeEnum item: res) {
            map.put(item.code, item);
        }
    }

    public static RoleTypeEnum getByCode(int code){
        return map.get(code);
    }

    public static String getNameByCode(int code){
        return map.get(code).desc;
    }
}
