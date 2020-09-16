/**
 * output package name
 */
package com.kingdee.eas.zjlw.certificates.app;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class logoutTypeEnum extends StringEnum
{
    public static final String ANTIOVER_VALUE = "0";//alias=反签到期注销或人员不来
    public static final String VISAOVER_VALUE = "1";//alias=签证到期或人员不来
    public static final String VISASTOP_VALUE = "2";//alias=签证停办
    public static final String IMMISTOP_VALUE = "3";//alias=入境停办
    public static final String PASSPNOGET_VALUE = "4";//alias=护照发放停办

    public static final logoutTypeEnum ANTIOVER = new logoutTypeEnum("ANTIOVER", ANTIOVER_VALUE);
    public static final logoutTypeEnum VISAOVER = new logoutTypeEnum("VISAOVER", VISAOVER_VALUE);
    public static final logoutTypeEnum VISASTOP = new logoutTypeEnum("VISASTOP", VISASTOP_VALUE);
    public static final logoutTypeEnum IMMISTOP = new logoutTypeEnum("IMMISTOP", IMMISTOP_VALUE);
    public static final logoutTypeEnum PASSPNOGET = new logoutTypeEnum("PASSPNOGET", PASSPNOGET_VALUE);

    /**
     * construct function
     * @param String logoutTypeEnum
     */
    private logoutTypeEnum(String name, String logoutTypeEnum)
    {
        super(name, logoutTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static logoutTypeEnum getEnum(String logoutTypeEnum)
    {
        return (logoutTypeEnum)getEnum(logoutTypeEnum.class, logoutTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(logoutTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(logoutTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(logoutTypeEnum.class);
    }
}