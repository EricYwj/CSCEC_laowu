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
public class checkdepatEnum extends StringEnum
{
    public static final String SECU_VALUE = "0";//alias=社保局
    public static final String LABO_VALUE = "1";//alias=劳动监察局
    public static final String HOLI_VALUE = "2";//alias=休假工资局

    public static final checkdepatEnum SECU = new checkdepatEnum("SECU", SECU_VALUE);
    public static final checkdepatEnum LABO = new checkdepatEnum("LABO", LABO_VALUE);
    public static final checkdepatEnum HOLI = new checkdepatEnum("HOLI", HOLI_VALUE);

    /**
     * construct function
     * @param String checkdepatEnum
     */
    private checkdepatEnum(String name, String checkdepatEnum)
    {
        super(name, checkdepatEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static checkdepatEnum getEnum(String checkdepatEnum)
    {
        return (checkdepatEnum)getEnum(checkdepatEnum.class, checkdepatEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(checkdepatEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(checkdepatEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(checkdepatEnum.class);
    }
}