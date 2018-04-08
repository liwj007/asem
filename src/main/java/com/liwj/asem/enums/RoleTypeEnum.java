package com.liwj.asem.enums;

import java.util.HashMap;
import java.util.Map;

public enum RoleTypeEnum {
    ADMIN(0, "管理员"),
    GRADE(1, "年级"),
    COLLEGE(3, "学院"),
    SCHOOL(4, "学校"),
    STUDENT(5, "学生");

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
