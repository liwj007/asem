package com.liwj.asem.enums;

import java.util.HashMap;
import java.util.Map;

public enum FeedbackTypeEnum {
    APPLY(0, "申请"),
    BACK(1, "退回");

    public final String desc;
    public final int code;

    // 构造方法
    private FeedbackTypeEnum(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    private static Map<Integer, FeedbackTypeEnum> map;

    static {
        FeedbackTypeEnum[] res = values();
        map = new HashMap<>(res.length);
        for (FeedbackTypeEnum item : res) {
            map.put(item.code, item);
        }
    }

    public static FeedbackTypeEnum getByCode(int code) {
        return map.get(code);
    }

    public static String getNameByCode(int code) {
        return map.get(code).desc;
    }
}
