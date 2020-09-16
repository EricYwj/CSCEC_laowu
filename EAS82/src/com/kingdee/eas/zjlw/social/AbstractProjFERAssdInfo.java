package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProjFERAssdInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractProjFERAssdInfo()
    {
        this("id");
    }
    protected AbstractProjFERAssdInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.social.ProjFERAssdEntryCollection());
    }
    /**
     * Object: ��Ŀ�⼮Ա���ݼٹ��ʷ�����̯�� 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.social.ProjFERAssdEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.social.ProjFERAssdEntryCollection)get("entrys");
    }
    /**
     * Object: ��Ŀ�⼮Ա���ݼٹ��ʷ�����̯�� 's ��Ŀ���� property 
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
     * Object:��Ŀ�⼮Ա���ݼٹ��ʷ�����̯��'s ����״̬property 
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
     * Object:��Ŀ�⼮Ա���ݼٹ��ʷ�����̯��'s �������property 
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
     * Object:��Ŀ�⼮Ա���ݼٹ��ʷ�����̯��'s ��Ŀ�籣��property 
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
     * Object: ��Ŀ�⼮Ա���ݼٹ��ʷ�����̯�� 's ��� property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getYears()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("years");
    }
    public void setYears(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("years", item);
    }
    /**
     * Object:��Ŀ�⼮Ա���ݼٹ��ʷ�����̯��'s ������ʽproperty 
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
     * Object:��Ŀ�⼮Ա���ݼٹ��ʷ�����̯��'s ����֧Ʊ��property 
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
     * Object:��Ŀ�⼮Ա���ݼٹ��ʷ�����̯��'s ��Ŀ���������˻�property 
     */
    public String getProjRtBank()
    {
        return getString("projRtBank");
    }
    public void setProjRtBank(String item)
    {
        setString("projRtBank", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A0C63D59");
    }
}