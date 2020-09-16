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
public class perBizStateEnum extends StringEnum
{
    public static final String ADDNEW_VALUE = "10";//alias=����
    public static final String MESSINPUT_VALUE = "20";//alias=��Ϣ¼��
    public static final String INDEXALLOT_VALUE = "30";//alias=ָ�����
    public static final String CERTIFICATION_VALUE = "40";//alias=˫��֤����
    public static final String ANTISIGNED_VALUE = "50";//alias=��ǩ����
    public static final String VISA_VALUE = "60";//alias=ǩ֤����
    public static final String IMMIGRATION_VALUE = "70";//alias=�����뾳
    public static final String REGISTERED_VALUE = "80";//alias=ʹ��ע��
    public static final String WORKPERMIT_VALUE = "90";//alias=�Ͷ�֤
    public static final String RESIDENCE_VALUE = "100";//alias=��ס֤
    public static final String DEPARTURE_VALUE = "110";//alias=���뾳
    public static final String CANCEL_VALUE = "120";//alias=����ͣ��
    public static final String CERTISTOP_VALUE = "130";//alias=˫��֤ͣ��
    public static final String ANTISTOP_VALUE = "140";//alias=��ǩͣ�첢ע��
    public static final String VISASTOP_VALUE = "150";//alias=ǩ֤ͣ�첢ע��
    public static final String WKDSTRY_VALUE = "160";//alias=�Ͷ�֤ע��
    public static final String LIVEDSTRY_VALUE = "170";//alias=��ס֤ע��
    public static final String ANTIDSTRY_VALUE = "180";//alias=��ǩ���ڻ���
    public static final String IMMIGRATIONSTOP_VALUE = "190";//alias=�뾳ͣ��
    public static final String IMMIGRATIONOUT_VALUE = "200";//alias=Υ���뾳
    public static final String PASSPORTISSUED_VALUE = "210";//alias=���Ż���
    public static final String PASSPORTISSUEDSTOP_VALUE = "220";//alias=���շ���ͣ��
    public static final String VISADSTRY_VALUE = "230";//alias=ǩ֤���ڻ���
    public static final String ANTINOT_VALUE = "240";//alias=��ǩδ��
    public static final String APPLEAVE_VALUE = "250";//alias=�����뾳

    public static final perBizStateEnum ADDNEW = new perBizStateEnum("ADDNEW", ADDNEW_VALUE);
    public static final perBizStateEnum MESSINPUT = new perBizStateEnum("MESSINPUT", MESSINPUT_VALUE);
    public static final perBizStateEnum INDEXALLOT = new perBizStateEnum("INDEXALLOT", INDEXALLOT_VALUE);
    public static final perBizStateEnum CERTIFICATION = new perBizStateEnum("CERTIFICATION", CERTIFICATION_VALUE);
    public static final perBizStateEnum ANTISIGNED = new perBizStateEnum("ANTISIGNED", ANTISIGNED_VALUE);
    public static final perBizStateEnum VISA = new perBizStateEnum("VISA", VISA_VALUE);
    public static final perBizStateEnum IMMIGRATION = new perBizStateEnum("IMMIGRATION", IMMIGRATION_VALUE);
    public static final perBizStateEnum REGISTERED = new perBizStateEnum("REGISTERED", REGISTERED_VALUE);
    public static final perBizStateEnum WORKPERMIT = new perBizStateEnum("WORKPERMIT", WORKPERMIT_VALUE);
    public static final perBizStateEnum RESIDENCE = new perBizStateEnum("RESIDENCE", RESIDENCE_VALUE);
    public static final perBizStateEnum DEPARTURE = new perBizStateEnum("DEPARTURE", DEPARTURE_VALUE);
    public static final perBizStateEnum CANCEL = new perBizStateEnum("CANCEL", CANCEL_VALUE);
    public static final perBizStateEnum CERTISTOP = new perBizStateEnum("CERTISTOP", CERTISTOP_VALUE);
    public static final perBizStateEnum ANTISTOP = new perBizStateEnum("ANTISTOP", ANTISTOP_VALUE);
    public static final perBizStateEnum VISASTOP = new perBizStateEnum("VISASTOP", VISASTOP_VALUE);
    public static final perBizStateEnum WKDSTRY = new perBizStateEnum("WKDSTRY", WKDSTRY_VALUE);
    public static final perBizStateEnum LIVEDSTRY = new perBizStateEnum("LIVEDSTRY", LIVEDSTRY_VALUE);
    public static final perBizStateEnum ANTIDSTRY = new perBizStateEnum("ANTIDSTRY", ANTIDSTRY_VALUE);
    public static final perBizStateEnum IMMIGRATIONSTOP = new perBizStateEnum("IMMIGRATIONSTOP", IMMIGRATIONSTOP_VALUE);
    public static final perBizStateEnum IMMIGRATIONOUT = new perBizStateEnum("IMMIGRATIONOUT", IMMIGRATIONOUT_VALUE);
    public static final perBizStateEnum PASSPORTISSUED = new perBizStateEnum("PASSPORTISSUED", PASSPORTISSUED_VALUE);
    public static final perBizStateEnum PASSPORTISSUEDSTOP = new perBizStateEnum("PASSPORTISSUEDSTOP", PASSPORTISSUEDSTOP_VALUE);
    public static final perBizStateEnum VISADSTRY = new perBizStateEnum("VISADSTRY", VISADSTRY_VALUE);
    public static final perBizStateEnum ANTINOT = new perBizStateEnum("ANTINOT", ANTINOT_VALUE);
    public static final perBizStateEnum APPLEAVE = new perBizStateEnum("APPLEAVE", APPLEAVE_VALUE);

    /**
     * construct function
     * @param String perBizStateEnum
     */
    private perBizStateEnum(String name, String perBizStateEnum)
    {
        super(name, perBizStateEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static perBizStateEnum getEnum(String perBizStateEnum)
    {
        return (perBizStateEnum)getEnum(perBizStateEnum.class, perBizStateEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(perBizStateEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(perBizStateEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(perBizStateEnum.class);
    }
}