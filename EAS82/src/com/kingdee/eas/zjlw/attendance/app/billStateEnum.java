/**
 * output package name
 */
package com.kingdee.eas.zjlw.attendance.app;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class billStateEnum extends StringEnum
{
    public static final String SUBMITED_VALUE = "0";//alias=已提交
    public static final String AUDITED_VALUE = "1";//alias=审核通过
    public static final String PROOFED_VALUE = "2";//alias=生成凭证

    public static final billStateEnum SUBMITED = new billStateEnum("SUBMITED", SUBMITED_VALUE);
    public static final billStateEnum AUDITED = new billStateEnum("AUDITED", AUDITED_VALUE);
    public static final billStateEnum PROOFED = new billStateEnum("PROOFED", PROOFED_VALUE);

    /**
     * construct function
     * @param String billStateEnum
     */
    private billStateEnum(String name, String billStateEnum)
    {
        super(name, billStateEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static billStateEnum getEnum(String billStateEnum)
    {
        return (billStateEnum)getEnum(billStateEnum.class, billStateEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(billStateEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(billStateEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(billStateEnum.class);
    }
}