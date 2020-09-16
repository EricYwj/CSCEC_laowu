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
public class visaTypeEnum extends StringEnum
{
    public static final String WORK_VALUE = "0";//alias=����ǩ
    public static final String BUSS_VALUE = "1";//alias=����ǩ
    public static final String LOCAL_VALUE = "2";//alias=���ػ�Ա��
    public static final String NOTCSCES_VALUE = "3";//alias=���н�Ա��

    public static final visaTypeEnum work = new visaTypeEnum("work", WORK_VALUE);
    public static final visaTypeEnum buss = new visaTypeEnum("buss", BUSS_VALUE);
    public static final visaTypeEnum local = new visaTypeEnum("local", LOCAL_VALUE);
    public static final visaTypeEnum notCSCES = new visaTypeEnum("notCSCES", NOTCSCES_VALUE);

    /**
     * construct function
     * @param String visaTypeEnum
     */
    private visaTypeEnum(String name, String visaTypeEnum)
    {
        super(name, visaTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static visaTypeEnum getEnum(String visaTypeEnum)
    {
        return (visaTypeEnum)getEnum(visaTypeEnum.class, visaTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(visaTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(visaTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(visaTypeEnum.class);
    }
}