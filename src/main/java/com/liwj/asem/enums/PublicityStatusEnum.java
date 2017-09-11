package com.liwj.asem.enums;

import java.util.HashMap;
import java.util.Map;

public enum PublicityStatusEnum {
    OPEN(0, "开放"),
    CANCEL(1, "取消"),
    CLOSE(2,"关闭");

    public final String desc;
    public final int code;
    // 构造方法
    private PublicityStatusEnum(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    private static Map<Integer,PublicityStatusEnum> map;
    static {
        PublicityStatusEnum[] res = values();
        map = new HashMap<>(res.length);
        for(PublicityStatusEnum item: res) {
            map.put(item.code, item);
        }
    }

    public static PublicityStatusEnum getByCode(int code){
        return map.get(code);
    }

    public static String getNameByCode(int code){
        return map.get(code).desc;
    }
}
