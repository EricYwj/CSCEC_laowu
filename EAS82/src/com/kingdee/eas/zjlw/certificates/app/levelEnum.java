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
public class levelEnum extends StringEnum
{
    public static final String ONE_VALUE = "0";//alias=Ò»¼¶

    public static final levelEnum one = new levelEnum("one", ONE_VALUE);

    /**
     * construct function
     * @param String levelEnum
     */
    private levelEnum(String name, String levelEnum)
    {
        super(name, levelEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static levelEnum getEnum(String levelEnum)
    {
        return (levelEnum)getEnum(levelEnum.class, levelEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(levelEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(levelEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(levelEnum.class);
    }
}