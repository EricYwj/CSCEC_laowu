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
public class antiPerStEmun extends StringEnum
{
    public static final String ANTI_VALUE = "1";//alias=反签办理
    public static final String LOGOUT_VALUE = "2";//alias=已注销

    public static final antiPerStEmun ANTI = new antiPerStEmun("ANTI", ANTI_VALUE);
    public static final antiPerStEmun LOGOUT = new antiPerStEmun("LOGOUT", LOGOUT_VALUE);

    /**
     * construct function
     * @param String antiPerStEmun
     */
    private antiPerStEmun(String name, String antiPerStEmun)
    {
        super(name, antiPerStEmun);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static antiPerStEmun getEnum(String antiPerStEmun)
    {
        return (antiPerStEmun)getEnum(antiPerStEmun.class, antiPerStEmun);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(antiPerStEmun.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(antiPerStEmun.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(antiPerStEmun.class);
    }
}