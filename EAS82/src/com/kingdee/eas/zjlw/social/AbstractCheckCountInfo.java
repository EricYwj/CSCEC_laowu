package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCheckCountInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCheckCountInfo()
    {
        this("id");
    }
    protected AbstractCheckCountInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.social.CheckCountEntryCollection());
    }
    /**
     * Object: �����籣���ڱ� 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.social.CheckCountEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.social.CheckCountEntryCollection)get("entrys");
    }
    /**
     * Object:�����籣���ڱ�'s �Ƿ�����ƾ֤property 
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
     * Object: �����籣���ڱ� 's �籣��Ŀ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getPermProj()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("permProj");
    }
    public void setPermProj(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("permProj", item);
    }
    /**
     * Object:�����籣���ڱ�'s ����״̬property 
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
     * Object:�����籣���ڱ�'s �������property 
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
     * Object:�����籣���ڱ�'s Ӧ�α�����property 
     */
    public int getShCount()
    {
        return getInt("shCount");
    }
    public void setShCount(int item)
    {
        setInt("shCount", item);
    }
    /**
     * Object: �����籣���ڱ� 's ���� property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getMonthYearr()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("monthYearr");
    }
    public void setMonthYearr(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("monthYearr", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A14A6DA7");
    }
}