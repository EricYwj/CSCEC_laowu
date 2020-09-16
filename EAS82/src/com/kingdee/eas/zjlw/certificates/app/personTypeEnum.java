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
public class personTypeEnum extends StringEnum
{
    public static final String OWN_VALUE = "0";//alias=自有人员
    public static final String PREMIT_VALUE = "1";//alias=证件人员
    public static final String WORK_VALUE = "2";//alias=工作人员

    public static final personTypeEnum own = new personTypeEnum("own", OWN_VALUE);
    public static final personTypeEnum premit = new personTypeEnum("premit", PREMIT_VALUE);
    public static final personTypeEnum work = new personTypeEnum("work", WORK_VALUE);

    /**
     * construct function
     * @param String personTypeEnum
     */
    private personTypeEnum(String name, String personTypeEnum)
    {
        super(name, personTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static personTypeEnum getEnum(String personTypeEnum)
    {
        return (personTypeEnum)getEnum(personTypeEnum.class, personTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(personTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(personTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(personTypeEnum.class);
    }
}