package com.liwj.asem.enums;

import java.util.HashMap;
import java.util.Map;

public enum ApplicationPrizeStatusEnum {
    NO(0, " 未提交"),
    SUBMIT(2, "审核中"),
    PASS(3, "审核通过"),
    REJECT(4, "审核不通过");

    public final String desc;
    public final int code;

    // 构造方法
    private ApplicationPrizeStatusEnum(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    private static Map<Integer, ApplicationPrizeStatusEnum> map;

    static {
        ApplicationPrizeStatusEnum[] res = values();
        map = new HashMap<>(res.length);
        for (ApplicationPrizeStatusEnum item : res) {
            map.put(item.code, item);
        }
    }

    public static ApplicationPrizeStatusEnum getByCode(int code) {
        return map.get(code);
    }

    public static String getNameByCode(int code) {
        return map.get(code).desc;
    }
}
