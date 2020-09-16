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
public class BelongAreaEnum extends StringEnum
{
    public static final String EAST_VALUE = "0";//alias=东部
    public static final String MID_VALUE = "1";//alias=中部
    public static final String WEST_VALUE = "2";//alias=西部

    public static final BelongAreaEnum EAST = new BelongAreaEnum("EAST", EAST_VALUE);
    public static final BelongAreaEnum MID = new BelongAreaEnum("MID", MID_VALUE);
    public static final BelongAreaEnum WEST = new BelongAreaEnum("WEST", WEST_VALUE);

    /**
     * construct function
     * @param String belongAreaEnum
     */
    private BelongAreaEnum(String name, String belongAreaEnum)
    {
        super(name, belongAreaEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static BelongAreaEnum getEnum(String belongAreaEnum)
    {
        return (BelongAreaEnum)getEnum(BelongAreaEnum.class, belongAreaEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(BelongAreaEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(BelongAreaEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(BelongAreaEnum.class);
    }
}