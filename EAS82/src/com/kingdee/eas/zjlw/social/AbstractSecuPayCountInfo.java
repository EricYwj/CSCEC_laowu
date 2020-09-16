package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSecuPayCountInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSecuPayCountInfo()
    {
        this("id");
    }
    protected AbstractSecuPayCountInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.social.SecuPayCountEntryCollection());
    }
    /**
     * Object: ��˾�籣���ݼٹ��ʽ���̨�� 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.social.SecuPayCountEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.social.SecuPayCountEntryCollection)get("entrys");
    }
    /**
     * Object:��˾�籣���ݼٹ��ʽ���̨��'s �Ƿ�����ƾ֤property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object:��˾�籣���ݼٹ��ʽ���̨��'s ����״̬property 
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
     * Object:��˾�籣���ݼٹ��ʽ���̨��'s �������property 
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
     * Object: ��˾�籣���ݼٹ��ʽ���̨�� 's ���� property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getMonthYear()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("monthYear");
    }
    public void setMonthYear(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("monthYear", item);
    }
    /**
     * Object:��˾�籣���ݼٹ��ʽ���̨��'s ��Ŀ��������property 
     */
    public com.kingdee.eas.zjlw.certificates.app.BelongAreaEnum getAera()
    {
        return com.kingdee.eas.zjlw.certificates.app.BelongAreaEnum.getEnum(getString("aera"));
    }
    public void setAera(com.kingdee.eas.zjlw.certificates.app.BelongAreaEnum item)
    {
		if (item != null) {
        setString("aera", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("059A646B");
    }
}