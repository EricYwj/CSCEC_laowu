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
public class projStatusEnum extends StringEnum
{
    public static final String START_VALUE = "0";//alias=启动
    public static final String WORKING_VALUE = "1";//alias=在施
    public static final String STOP_VALUE = "4";//alias=停工
    public static final String BEFENDING_VALUE = "2";//alias=临验
    public static final String END_VALUE = "3";//alias=终验

    public static final projStatusEnum start = new projStatusEnum("start", START_VALUE);
    public static final projStatusEnum working = new projStatusEnum("working", WORKING_VALUE);
    public static final projStatusEnum stop = new projStatusEnum("stop", STOP_VALUE);
    public static final projStatusEnum befEnding = new projStatusEnum("befEnding", BEFENDING_VALUE);
    public static final projStatusEnum end = new projStatusEnum("end", END_VALUE);

    /**
     * construct function
     * @param String projStatusEnum
     */
    private projStatusEnum(String name, String projStatusEnum)
    {
        super(name, projStatusEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static projStatusEnum getEnum(String projStatusEnum)
    {
        return (projStatusEnum)getEnum(projStatusEnum.class, projStatusEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(projStatusEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(projStatusEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(projStatusEnum.class);
    }
}