package com.liwj.asem.data;


import com.liwj.asem.utils.PropertiesUtil;

/**
 * Created by liwj0 on 2017/7/14.
 */
public class CommonVariable {

    public static Long tokenOutPeriod = Long.parseLong(PropertiesUtil.getStringByKey("tokenOutPeriod"));

}
