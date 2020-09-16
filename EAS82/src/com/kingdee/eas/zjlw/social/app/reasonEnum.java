/**
 * output package name
 */
package com.kingdee.eas.zjlw.social.app;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class reasonEnum extends StringEnum
{
    public static final String CONGE_VALUE = "0";//alias=congé休假工资
    public static final String INTEM_VALUE = "1";//alias=intempérie恶劣天气

    public static final reasonEnum CONGE = new reasonEnum("CONGE", CONGE_VALUE);
    public static final reasonEnum INTEM = new reasonEnum("INTEM", INTEM_VALUE);

    /**
     * construct function
     * @param String reasonEnum
     */
    private reasonEnum(String name, String reasonEnum)
    {
        super(name, reasonEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static reasonEnum getEnum(String reasonEnum)
    {
        return (reasonEnum)getEnum(reasonEnum.class, reasonEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(reasonEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(reasonEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(reasonEnum.class);
    }
}