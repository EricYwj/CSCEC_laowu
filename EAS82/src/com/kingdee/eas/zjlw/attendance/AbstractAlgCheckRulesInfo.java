package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAlgCheckRulesInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractAlgCheckRulesInfo()
    {
        this("id");
    }
    protected AbstractAlgCheckRulesInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.attendance.AlgCheckRulesEntryCollection());
    }
    /**
     * Object: �������ڹ��� 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.attendance.AlgCheckRulesEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.attendance.AlgCheckRulesEntryCollection)get("entrys");
    }
    /**
     * Object:�������ڹ���'s �Ƿ�����ƾ֤property 
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
     * Object: �������ڹ��� 's ������֯ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getProCom()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("proCom");
    }
    public void setProCom(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("proCom", item);
    }
    /**
     * Object: �������ڹ��� 's ���� property 
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
     * Object:�������ڹ���'s �ٵ���������ֵ(����)property 
     */
    public int getAftBefmins()
    {
        return getInt("aftBefmins");
    }
    public void setAftBefmins(int item)
    {
        setInt("aftBefmins", item);
    }
    /**
     * Object:�������ڹ���'s �������property 
     */
    public java.util.Date getAuditDate()
    {
        return getDate("auditDate");
    }
    public void setAuditDate(java.util.Date item)
    {
        setDate("auditDate", item);
    }
    /**
     * Object:�������ڹ���'s ��������property 
     */
    public String getName()
    {
        return getString("name");
    }
    public void setName(String item)
    {
        setString("name", item);
    }
    /**
     * Object:�������ڹ���'s Ĭ�Ͽ��ڹ���property 
     */
    public boolean isDefaultRule()
    {
        return getBoolean("defaultRule");
    }
    public void setDefaultRule(boolean item)
    {
        setBoolean("defaultRule", item);
    }
    /**
     * Object:�������ڹ���'s �����ϰ�ʱ��property 
     */
    public java.sql.Time getAmOne()
    {
        return getTime("amOne");
    }
    public void setAmOne(java.sql.Time item)
    {
        setTime("amOne", item);
    }
    /**
     * Object:�������ڹ���'s �����°�ʱ��property 
     */
    public java.sql.Time getAmTwo()
    {
        return getTime("amTwo");
    }
    public void setAmTwo(java.sql.Time item)
    {
        setTime("amTwo", item);
    }
    /**
     * Object:�������ڹ���'s �����ϰ�ʱ��property 
     */
    public java.sql.Time getPmOne()
    {
        return getTime("pmOne");
    }
    public void setPmOne(java.sql.Time item)
    {
        setTime("pmOne", item);
    }
    /**
     * Object:�������ڹ���'s �����°�ʱ��property 
     */
    public java.sql.Time getPmTwo()
    {
        return getTime("pmTwo");
    }
    public void setPmTwo(java.sql.Time item)
    {
        setTime("pmTwo", item);
    }
    /**
     * Object: �������ڹ��� 's ������λ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getCooperation()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("cooperation");
    }
    public void setCooperation(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("cooperation", item);
    }
    /**
     * Object:�������ڹ���'s ����״̬property 
     */
    public com.kingdee.eas.zjlw.certificates.app.BillStateEnum getBillSatee()
    {
        return com.kingdee.eas.zjlw.certificates.app.BillStateEnum.getEnum(getString("billSatee"));
    }
    public void setBillSatee(com.kingdee.eas.zjlw.certificates.app.BillStateEnum item)
    {
		if (item != null) {
        setString("billSatee", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("62697447");
    }
}