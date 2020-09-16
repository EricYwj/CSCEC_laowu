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
public class PassportOrganEnum extends StringEnum
{
    public static final String FOREIGN_VALUE = "10";//alias=外交部
    public static final String EMBASSY_VALUE = "20";//alias=大使馆
    public static final String ENTRYANDEXIT_VALUE = "30";//alias=出入境管理
    public static final String IMMI_VALUE = "40";//alias=移民管理局

    public static final PassportOrganEnum FOREIGN = new PassportOrganEnum("FOREIGN", FOREIGN_VALUE);
    public static final PassportOrganEnum EMBASSY = new PassportOrganEnum("EMBASSY", EMBASSY_VALUE);
    public static final PassportOrganEnum ENTRYANDEXIT = new PassportOrganEnum("ENTRYANDEXIT", ENTRYANDEXIT_VALUE);
    public static final PassportOrganEnum IMMI = new PassportOrganEnum("IMMI", IMMI_VALUE);

    /**
     * construct function
     * @param String passportOrganEnum
     */
    private PassportOrganEnum(String name, String passportOrganEnum)
    {
        super(name, passportOrganEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static PassportOrganEnum getEnum(String passportOrganEnum)
    {
        return (PassportOrganEnum)getEnum(PassportOrganEnum.class, passportOrganEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(PassportOrganEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(PassportOrganEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(PassportOrganEnum.class);
    }
}