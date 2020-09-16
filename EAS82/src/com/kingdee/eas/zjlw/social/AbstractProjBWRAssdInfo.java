package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProjBWRAssdInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractProjBWRAssdInfo()
    {
        this("id");
    }
    protected AbstractProjBWRAssdInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.social.ProjBWRAssdEntryCollection());
    }
    /**
     * Object: ��Ŀ��������������̯�� 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.social.ProjBWRAssdEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.social.ProjBWRAssdEntryCollection)get("entrys");
    }
    /**
     * Object: ��Ŀ��������������̯�� 's ��Ŀ���� property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getProjName()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("projName");
    }
    public void setProjName(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("projName", item);
    }
    /**
     * Object:��Ŀ��������������̯��'s ����״̬property 
     */
    public com.kingdee.eas.zjlw.certificates.app.BillStateEnum getBillSate()
    {
        return com.kingdee.eas.zjlw.certificates.app.BillStateEnum.getEnum(getString("billSate"));
    }
    public void setBillSate(com.kingdee.eas.zjlw.certificates.app.BillStateEnum item)
    {
		if (item != null) {
        setString("billSate", item.getValue());
		}
    }
    /**
     * Object:��Ŀ��������������̯��'s �������property 
     */
    public java.util.Date getAuditDate()
    {
        return getDate("AuditDate");
    }
    public void setAuditDate(java.util.Date item)
    {
        setDate("AuditDate", item);
    }
    /**
     * Object:��Ŀ��������������̯��'s ��Ŀ�籣��property 
     */
    public String getProjSoclNum()
    {
        return getString("projSoclNum");
    }
    public void setProjSoclNum(String item)
    {
        setString("projSoclNum", item);
    }
    /**
     * Object:��Ŀ��������������̯��'s ͣ������property 
     */
    public java.util.Date getStopDate()
    {
        return getDate("stopDate");
    }
    public void setStopDate(java.util.Date item)
    {
        setDate("stopDate", item);
    }
    /**
     * Object:��Ŀ��������������̯��'s ��������property 
     */
    public java.util.Date getRetToWorkDate()
    {
        return getDate("retToWorkDate");
    }
    public void setRetToWorkDate(java.util.Date item)
    {
        setDate("retToWorkDate", item);
    }
    /**
     * Object:��Ŀ��������������̯��'s ͣ��Сʱ��property 
     */
    public int getDownTimeHours()
    {
        return getInt("downTimeHours");
    }
    public void setDownTimeHours(int item)
    {
        setInt("downTimeHours", item);
    }
    /**
     * Object:��Ŀ��������������̯��'s ͣ������property 
     */
    public String getStoppageBy()
    {
        return getString("stoppageBy");
    }
    public void setStoppageBy(String item)
    {
        setString("stoppageBy", item);
    }
    /**
     * Object:��Ŀ��������������̯��'s ������ʽproperty 
     */
    public com.kingdee.eas.zjlw.certificates.app.redeliveryEnum getRedelivery()
    {
        return com.kingdee.eas.zjlw.certificates.app.redeliveryEnum.getEnum(getString("redelivery"));
    }
    public void setRedelivery(com.kingdee.eas.zjlw.certificates.app.redeliveryEnum item)
    {
		if (item != null) {
        setString("redelivery", item.getValue());
		}
    }
    /**
     * Object:��Ŀ��������������̯��'s ����֧Ʊ��property 
     */
    public String getNoRbeCheck()
    {
        return getString("noRbeCheck");
    }
    public void setNoRbeCheck(String item)
    {
        setString("noRbeCheck", item);
    }
    /**
     * Object:��Ŀ��������������̯��'s ��Ŀ���������˻�property 
     */
    public String getProjRtBank()
    {
        return getString("projRtBank");
    }
    public void setProjRtBank(String item)
    {
        setString("projRtBank", item);
    }
    /**
     * Object:��Ŀ��������������̯��'s �������յ�����property 
     */
    public java.util.Date getRptRbatDate()
    {
        return getDate("rptRbatDate");
    }
    public void setRptRbatDate(java.util.Date item)
    {
        setDate("rptRbatDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EBE48B83");
    }
}