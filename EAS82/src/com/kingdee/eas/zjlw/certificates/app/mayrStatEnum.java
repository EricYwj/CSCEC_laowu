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
public class mayrStatEnum extends StringEnum
{
    public static final String UNMARRIED_VALUE = "0";//alias=C
    public static final String MARRIED_VALUE = "1";//alias=M
    public static final String DIVORCED_VALUE = "2";//alias=D
    public static final String WIDOWED_VALUE = "3";//alias=V

    public static final mayrStatEnum unmarried = new mayrStatEnum("unmarried", UNMARRIED_VALUE);
    public static final mayrStatEnum married = new mayrStatEnum("married", MARRIED_VALUE);
    public static final mayrStatEnum divorced = new mayrStatEnum("divorced", DIVORCED_VALUE);
    public static final mayrStatEnum widowed = new mayrStatEnum("widowed", WIDOWED_VALUE);

    /**
     * construct function
     * @param String mayrStatEnum
     */
    private mayrStatEnum(String name, String mayrStatEnum)
    {
        super(name, mayrStatEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static mayrStatEnum getEnum(String mayrStatEnum)
    {
        return (mayrStatEnum)getEnum(mayrStatEnum.class, mayrStatEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(mayrStatEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(mayrStatEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(mayrStatEnum.class);
    }
}