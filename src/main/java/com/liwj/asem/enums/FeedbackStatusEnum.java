package com.liwj.asem.enums;

import java.util.HashMap;
import java.util.Map;

public enum FeedbackStatusEnum {
    NEW(0, "申请中"),
    PASS(1, "通过"),
    REJECT(2, "不通过");

    public final String desc;
    public final int code;

    // 构造方法
    private FeedbackStatusEnum(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    private static Map<Integer, FeedbackStatusEnum> map;

    static {
        FeedbackStatusEnum[] res = values();
        map = new HashMap<>(res.length);
        for (FeedbackStatusEnum item : res) {
            map.put(item.code, item);
        }
    }

    public static FeedbackStatusEnum getByCode(int code) {
        return map.get(code);
    }

    public static String getNameByCode(int code) {
        return map.get(code).desc;
    }
}
