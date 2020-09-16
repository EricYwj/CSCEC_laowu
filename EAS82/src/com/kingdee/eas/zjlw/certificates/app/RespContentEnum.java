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
public class RespContentEnum extends StringEnum
{
    public static final String SOCIAL_VALUE = "1";//alias=社保
    public static final String DAILYSER_VALUE = "2";//alias=日常劳务
    public static final String WORKPERMIT_VALUE = "3";//alias=劳动证
    public static final String RESIDENPER_VALUE = "4";//alias=居住证
    public static final String WORKANDRES_VALUE = "5";//alias=劳动证+居住证

    public static final RespContentEnum SOCIAL = new RespContentEnum("SOCIAL", SOCIAL_VALUE);
    public static final RespContentEnum DAILYSER = new RespContentEnum("DAILYSER", DAILYSER_VALUE);
    public static final RespContentEnum WORKPERMIT = new RespContentEnum("WORKPERMIT", WORKPERMIT_VALUE);
    public static final RespContentEnum RESIDENPER = new RespContentEnum("RESIDENPER", RESIDENPER_VALUE);
    public static final RespContentEnum WORKANDRES = new RespContentEnum("WORKANDRES", WORKANDRES_VALUE);

    /**
     * construct function
     * @param String respContentEnum
     */
    private RespContentEnum(String name, String respContentEnum)
    {
        super(name, respContentEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static RespContentEnum getEnum(String respContentEnum)
    {
        return (RespContentEnum)getEnum(RespContentEnum.class, respContentEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(RespContentEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(RespContentEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(RespContentEnum.class);
    }
}