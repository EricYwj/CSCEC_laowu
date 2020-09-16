/**
 * output package name
 */
package com.kingdee.eas.zjlw.attendance.app;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class checkResultEnum extends StringEnum
{
    public static final String NORMAL_VALUE = "0";//alias=正常打卡
    public static final String ANORMAL_VALUE = "1";//alias=不正常打卡
    public static final String OTHER_VALUE = "9";//alias=其他情况

    public static final checkResultEnum NORMAL = new checkResultEnum("NORMAL", NORMAL_VALUE);
    public static final checkResultEnum ANORMAL = new checkResultEnum("ANORMAL", ANORMAL_VALUE);
    public static final checkResultEnum OTHER = new checkResultEnum("OTHER", OTHER_VALUE);

    /**
     * construct function
     * @param String checkResultEnum
     */
    private checkResultEnum(String name, String checkResultEnum)
    {
        super(name, checkResultEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static checkResultEnum getEnum(String checkResultEnum)
    {
        return (checkResultEnum)getEnum(checkResultEnum.class, checkResultEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(checkResultEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(checkResultEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(checkResultEnum.class);
    }
}