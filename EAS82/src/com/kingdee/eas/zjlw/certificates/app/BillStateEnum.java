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
public class BillStateEnum extends StringEnum
{
    public static final String NEW_VALUE = "10";//alias=�Ƶ�
    public static final String DRAFT_VALUE = "20";//alias=�ݴ�
    public static final String SUBMIT_VALUE = "30";//alias=���ύ
    public static final String CHECKED_VALUE = "40";//alias=���ͨ��
    public static final String CHECKING_VALUE = "50";//alias=�����
    public static final String CHECKFAILD_VALUE = "60";//alias=���δͨ��
    public static final String DSTRY_VALUE = "70";//alias=��ע��
    public static final String LEAVE_VALUE = "80";//alias=���뾳
    public static final String ANTI_VALUE = "90";//alias=��ǩ����

    public static final BillStateEnum NEW = new BillStateEnum("NEW", NEW_VALUE);
    public static final BillStateEnum DRAFT = new BillStateEnum("DRAFT", DRAFT_VALUE);
    public static final BillStateEnum SUBMIT = new BillStateEnum("SUBMIT", SUBMIT_VALUE);
    public static final BillStateEnum CHECKED = new BillStateEnum("CHECKED", CHECKED_VALUE);
    public static final BillStateEnum CHECKING = new BillStateEnum("CHECKING", CHECKING_VALUE);
    public static final BillStateEnum CHECKFAILD = new BillStateEnum("CHECKFAILD", CHECKFAILD_VALUE);
    public static final BillStateEnum DSTRY = new BillStateEnum("DSTRY", DSTRY_VALUE);
    public static final BillStateEnum LEAVE = new BillStateEnum("LEAVE", LEAVE_VALUE);
    public static final BillStateEnum ANTI = new BillStateEnum("ANTI", ANTI_VALUE);

    /**
     * construct function
     * @param String billStateEnum
     */
    private BillStateEnum(String name, String billStateEnum)
    {
        super(name, billStateEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static BillStateEnum getEnum(String billStateEnum)
    {
        return (BillStateEnum)getEnum(BillStateEnum.class, billStateEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(BillStateEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(BillStateEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(BillStateEnum.class);
    }
}