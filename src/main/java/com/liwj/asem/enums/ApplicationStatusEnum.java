package com.liwj.asem.enums;

import java.util.HashMap;
import java.util.Map;

public enum ApplicationStatusEnum {
    NO(0, " 未提交"),
    SUBMIT(1, "已提交"),
//    RESUBMIT(2, "重新提交"),
    PASS(3, "通过"),
    REJECT(4, "被驳回");

    public final String desc;
    public final int code;

    // 构造方法
    private ApplicationStatusEnum(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    private static Map<Integer, ApplicationStatusEnum> map;

    static {
        ApplicationStatusEnum[] res = values();
        map = new HashMap<>(res.length);
        for (ApplicationStatusEnum item : res) {
            map.put(item.code, item);
        }
    }

    public static ApplicationStatusEnum getByCode(int code) {
        return map.get(code);
    }

    public static String getNameByCode(int code) {
        return map.get(code).desc;
    }
}
