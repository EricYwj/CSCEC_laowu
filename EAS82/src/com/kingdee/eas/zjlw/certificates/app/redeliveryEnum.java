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
public class redeliveryEnum extends StringEnum
{
    public static final String CHECK_VALUE = "10";//alias=Ö§Æ±
    public static final String TRANSFERS_VALUE = "20";//alias=×ªÕÊ

    public static final redeliveryEnum CHECK = new redeliveryEnum("CHECK", CHECK_VALUE);
    public static final redeliveryEnum TRANSFERS = new redeliveryEnum("TRANSFERS", TRANSFERS_VALUE);

    /**
     * construct function
     * @param String redeliveryEnum
     */
    private redeliveryEnum(String name, String redeliveryEnum)
    {
        super(name, redeliveryEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static redeliveryEnum getEnum(String redeliveryEnum)
    {
        return (redeliveryEnum)getEnum(redeliveryEnum.class, redeliveryEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(redeliveryEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(redeliveryEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(redeliveryEnum.class);
    }
}