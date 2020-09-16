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
public class authType extends StringEnum
{
    public static final String EDUCATIONAL_VALUE = "0";//alias=学历证书
    public static final String SKILL_VALUE = "1";//alias=技能证书
    public static final String NONE_VALUE = "10";//alias=单独办理工作经验证明

    public static final authType EDUCATIONAL = new authType("EDUCATIONAL", EDUCATIONAL_VALUE);
    public static final authType SKILL = new authType("SKILL", SKILL_VALUE);
    public static final authType NONE = new authType("NONE", NONE_VALUE);

    /**
     * construct function
     * @param String authType
     */
    private authType(String name, String authType)
    {
        super(name, authType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static authType getEnum(String authType)
    {
        return (authType)getEnum(authType.class, authType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(authType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(authType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(authType.class);
    }
}