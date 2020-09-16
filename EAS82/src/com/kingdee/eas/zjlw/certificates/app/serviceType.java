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
public class serviceType extends StringEnum
{
    public static final String STOPTYPE_VALUE = "0";//alias=停办
    public static final String UPDATETYPE_VALUE = "1";//alias=更新
    public static final String CHANGETYPE_VALUE = "2";//alias=调转

    public static final serviceType STOPTYPE = new serviceType("STOPTYPE", STOPTYPE_VALUE);
    public static final serviceType UPDATETYPE = new serviceType("UPDATETYPE", UPDATETYPE_VALUE);
    public static final serviceType CHANGETYPE = new serviceType("CHANGETYPE", CHANGETYPE_VALUE);

    /**
     * construct function
     * @param String serviceType
     */
    private serviceType(String name, String serviceType)
    {
        super(name, serviceType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static serviceType getEnum(String serviceType)
    {
        return (serviceType)getEnum(serviceType.class, serviceType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(serviceType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(serviceType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(serviceType.class);
    }
}