/**
 * output package name
 */
package com.kingdee.eas.fi.cas;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class projStatus extends StringEnum
{
    public static final String S_VALUE = "0";//alias=∆Ù∂Ø
    public static final String A_VALUE = "1";//alias=‘⁄ ©
    public static final String B_VALUE = "2";//alias=¡ŸºÏ
    public static final String C_VALUE = "3";//alias=÷’ºÏ

    public static final projStatus s = new projStatus("s", S_VALUE);
    public static final projStatus a = new projStatus("a", A_VALUE);
    public static final projStatus b = new projStatus("b", B_VALUE);
    public static final projStatus c = new projStatus("c", C_VALUE);

    /**
     * construct function
     * @param String projStatus
     */
    private projStatus(String name, String projStatus)
    {
        super(name, projStatus);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static projStatus getEnum(String projStatus)
    {
        return (projStatus)getEnum(projStatus.class, projStatus);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(projStatus.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(projStatus.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(projStatus.class);
    }
}