package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractForiPayrollInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractForiPayrollInfo()
    {
        this("id");
    }
    protected AbstractForiPayrollInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.social.ForiPayrollEntryCollection());
    }
    /**
     * Object: �⹤�������� 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.social.ForiPayrollEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.social.ForiPayrollEntryCollection)get("entrys");
    }
    /**
     * Object:�⹤��������'s �Ƿ�����ƾ֤property 
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
     * Object:�⹤��������'s ����״̬property 
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
     * Object:�⹤��������'s �������property 
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
     * Object: �⹤�������� 's ��Ŀ���� property 
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
     * Object:�⹤��������'s ��Ŀ�籣��property 
     */
    public String getProjSCNum()
    {
        return getString("projSCNum");
    }
    public void setProjSCNum(String item)
    {
        setString("projSCNum", item);
    }
    /**
     * Object: �⹤�������� 's ���� property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getMonthYearr()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("monthYearr");
    }
    public void setMonthYearr(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("monthYearr", item);
    }
    /**
     * Object: �⹤�������� 's �籣��Ŀ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getSecurityProj()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("securityProj");
    }
    public void setSecurityProj(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("securityProj", item);
    }
    /**
     * Object:�⹤��������'s �Ƿ��Ѷ�������ṩ���ݽ���У�飬���ݲ����޸�property 
     */
    public boolean isIsOK()
    {
        return getBoolean("isOK");
    }
    public void setIsOK(boolean item)
    {
        setBoolean("isOK", item);
    }
    /**
     * Object:�⹤��������'s ����property 
     */
    public String getAcountRow()
    {
        return getString("acountRow");
    }
    public void setAcountRow(String item)
    {
        setString("acountRow", item);
    }
    /**
     * Object:�⹤��������'s ��Ŀ���ڵ�property 
     */
    public String getProjAddress()
    {
        return getString("projAddress");
    }
    public void setProjAddress(String item)
    {
        setString("projAddress", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8AE8DB85");
    }
}