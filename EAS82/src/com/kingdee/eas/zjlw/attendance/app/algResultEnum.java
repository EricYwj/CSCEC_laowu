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
public class algResultEnum extends StringEnum
{
    public static final String NORMAL_VALUE = "0";//alias=Õý³£
    public static final String DISAPP_VALUE = "1";//alias=È±ÇÚ

    public static final algResultEnum NORMAL = new algResultEnum("NORMAL", NORMAL_VALUE);
    public static final algResultEnum DISAPP = new algResultEnum("DISAPP", DISAPP_VALUE);

    /**
     * construct function
     * @param String algResultEnum
     */
    private algResultEnum(String name, String algResultEnum)
    {
        super(name, algResultEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static algResultEnum getEnum(String algResultEnum)
    {
        return (algResultEnum)getEnum(algResultEnum.class, algResultEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(algResultEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(algResultEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(algResultEnum.class);
    }
}