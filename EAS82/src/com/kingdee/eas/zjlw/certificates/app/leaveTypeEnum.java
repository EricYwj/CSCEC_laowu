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
public class leaveTypeEnum extends StringEnum
{
    public static final String NORMAL_VALUE = "0";//alias=正常离境
    public static final String WORKNO_VALUE = "1";//alias=劳动证未办
    public static final String LEAVENO_VALUE = "2";//alias=居住证未办
    public static final String TAKEBACK_VALUE = "3";//alias=携带居住证回国
    public static final String WORKSTOP_VALUE = "4";//alias=劳动证停办
    public static final String LEAVESTOP_VALUE = "5";//alias=居住证停办

    public static final leaveTypeEnum NORMAL = new leaveTypeEnum("NORMAL", NORMAL_VALUE);
    public static final leaveTypeEnum WORKNO = new leaveTypeEnum("WORKNO", WORKNO_VALUE);
    public static final leaveTypeEnum LEAVENO = new leaveTypeEnum("LEAVENO", LEAVENO_VALUE);
    public static final leaveTypeEnum TAKEBACK = new leaveTypeEnum("TAKEBACK", TAKEBACK_VALUE);
    public static final leaveTypeEnum WORKSTOP = new leaveTypeEnum("WORKSTOP", WORKSTOP_VALUE);
    public static final leaveTypeEnum LEAVESTOP = new leaveTypeEnum("LEAVESTOP", LEAVESTOP_VALUE);

    /**
     * construct function
     * @param String leaveTypeEnum
     */
    private leaveTypeEnum(String name, String leaveTypeEnum)
    {
        super(name, leaveTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static leaveTypeEnum getEnum(String leaveTypeEnum)
    {
        return (leaveTypeEnum)getEnum(leaveTypeEnum.class, leaveTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(leaveTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(leaveTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(leaveTypeEnum.class);
    }
}