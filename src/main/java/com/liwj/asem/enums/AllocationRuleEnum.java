package com.liwj.asem.enums;

import java.util.HashMap;
import java.util.Map;

public enum AllocationRuleEnum {
    PERCENT(0, "按群体人数比例分配"),
    AVG(1, "平均分配");

    public final String desc;
    public final int code;

    // 构造方法
    private AllocationRuleEnum(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    private static Map<Integer, AllocationRuleEnum> map;

    static {
        AllocationRuleEnum[] res = values();
        map = new HashMap<>(res.length);
        for (AllocationRuleEnum item : res) {
            map.put(item.code, item);
        }
    }

    public static AllocationRuleEnum getByCode(int code) {
        return map.get(code);
    }

    public static String getNameByCode(int code) {
        return map.get(code).desc;
    }
}
