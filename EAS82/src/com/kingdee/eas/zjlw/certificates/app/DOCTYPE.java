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
public class DOCTYPE extends StringEnum
{
    public static final String EMPTY_VALUE = "3";//alias=
    public static final String TEMPORARY_VALUE = "0";//alias=¡Ÿ ±
    public static final String FORMAL_VALUE = "1";//alias=’˝ Ω

    public static final DOCTYPE EMPTY = new DOCTYPE("EMPTY", EMPTY_VALUE);
    public static final DOCTYPE TEMPORARY = new DOCTYPE("TEMPORARY", TEMPORARY_VALUE);
    public static final DOCTYPE FORMAL = new DOCTYPE("FORMAL", FORMAL_VALUE);

    /**
     * construct function
     * @param String dOCTYPE
     */
    private DOCTYPE(String name, String dOCTYPE)
    {
        super(name, dOCTYPE);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static DOCTYPE getEnum(String dOCTYPE)
    {
        return (DOCTYPE)getEnum(DOCTYPE.class, dOCTYPE);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(DOCTYPE.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(DOCTYPE.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(DOCTYPE.class);
    }
}