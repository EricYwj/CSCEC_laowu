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
public class hadlStaEnum extends StringEnum
{
    public static final String NORMAL_VALUE = "0";//alias=正常办理
    public static final String STOP_VALUE = "1";//alias=暂停办理
    public static final String CANCEL_VALUE = "2";//alias=永久停办

    public static final hadlStaEnum NORMAL = new hadlStaEnum("NORMAL", NORMAL_VALUE);
    public static final hadlStaEnum STOP = new hadlStaEnum("STOP", STOP_VALUE);
    public static final hadlStaEnum CANCEL = new hadlStaEnum("CANCEL", CANCEL_VALUE);

    /**
     * construct function
     * @param String hadlStaEnum
     */
    private hadlStaEnum(String name, String hadlStaEnum)
    {
        super(name, hadlStaEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static hadlStaEnum getEnum(String hadlStaEnum)
    {
        return (hadlStaEnum)getEnum(hadlStaEnum.class, hadlStaEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(hadlStaEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(hadlStaEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(hadlStaEnum.class);
    }
}