package com.liwj.asem.enums;

import java.util.HashMap;
import java.util.Map;

public enum ScholarshipTypeEnum {
    SCHOOL(0, "校级及以上"),
    COLLEGE(1, "院级");

    public final String desc;
    public final int code;
    // 构造方法
    private ScholarshipTypeEnum(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    private static Map<Integer,ScholarshipTypeEnum> map;
    static {
        ScholarshipTypeEnum[] res = values();
        map = new HashMap<>(res.length);
        for(ScholarshipTypeEnum item: res) {
            map.put(item.code, item);
        }
    }

    public static ScholarshipTypeEnum getByCode(int code){
        return map.get(code);
    }

    public static String getNameByCode(int code){
        return map.get(code).desc;
    }
}
