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
public class auditStatusEnum extends StringEnum
{
    public static final String AUDITED_VALUE = "0";//alias=ÉóºËÍ¨¹ý
    public static final String REFUSE_VALUE = "1";//alias=¾Ü¾ø

    public static final auditStatusEnum AUDITED = new auditStatusEnum("AUDITED", AUDITED_VALUE);
    public static final auditStatusEnum REFUSE = new auditStatusEnum("REFUSE", REFUSE_VALUE);

    /**
     * construct function
     * @param String auditStatusEnum
     */
    private auditStatusEnum(String name, String auditStatusEnum)
    {
        super(name, auditStatusEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static auditStatusEnum getEnum(String auditStatusEnum)
    {
        return (auditStatusEnum)getEnum(auditStatusEnum.class, auditStatusEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(auditStatusEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(auditStatusEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(auditStatusEnum.class);
    }
}