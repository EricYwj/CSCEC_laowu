package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSecuSplitInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSecuSplitInfo()
    {
        this("id");
    }
    protected AbstractSecuSplitInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.social.SecuSplitEntryCollection());
    }
    /**
     * Object: ��Ŀ�籣���ݼٹ��ʷ�̯�� 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.social.SecuSplitEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.social.SecuSplitEntryCollection)get("entrys");
    }
    /**
     * Object:��Ŀ�籣���ݼٹ��ʷ�̯��'s �Ƿ�����ƾ֤property 
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
     * Object: ��Ŀ�籣���ݼٹ��ʷ�̯�� 's ��Ŀ���� property 
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
     * Object:��Ŀ�籣���ݼٹ��ʷ�̯��'s ����״̬property 
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
     * Object:��Ŀ�籣���ݼٹ��ʷ�̯��'s �������property 
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
     * Object:��Ŀ�籣���ݼٹ��ʷ�̯��'s �⹤�����籣����property 
     */
    public int getForiScCount()
    {
        return getInt("foriScCount");
    }
    public void setForiScCount(int item)
    {
        setInt("foriScCount", item);
    }
    /**
     * Object:��Ŀ�籣���ݼٹ��ʷ�̯��'s ���ػ������籣����property 
     */
    public int getAlgScCount()
    {
        return getInt("algScCount");
    }
    public void setAlgScCount(int item)
    {
        setInt("algScCount", item);
    }
    /**
     * Object:��Ŀ�籣���ݼٹ��ʷ�̯��'s �籣����������property 
     */
    public int getSecuCount()
    {
        return getInt("secuCount");
    }
    public void setSecuCount(int item)
    {
        setInt("secuCount", item);
    }
    /**
     * Object:��Ŀ�籣���ݼٹ��ʷ�̯��'s �⹤�����籣���property 
     */
    public java.math.BigDecimal getForiScMoney()
    {
        return getBigDecimal("foriScMoney");
    }
    public void setForiScMoney(java.math.BigDecimal item)
    {
        setBigDecimal("foriScMoney", item);
    }
    /**
     * Object:��Ŀ�籣���ݼٹ��ʷ�̯��'s ���ػ������籣���property 
     */
    public java.math.BigDecimal getAlgScMoney()
    {
        return getBigDecimal("algScMoney");
    }
    public void setAlgScMoney(java.math.BigDecimal item)
    {
        setBigDecimal("algScMoney", item);
    }
    /**
     * Object:��Ŀ�籣���ݼٹ��ʷ�̯��'s �⹤�����ݼٹ��ʽ��property 
     */
    public java.math.BigDecimal getForiVcMoney()
    {
        return getBigDecimal("foriVcMoney");
    }
    public void setForiVcMoney(java.math.BigDecimal item)
    {
        setBigDecimal("foriVcMoney", item);
    }
    /**
     * Object:��Ŀ�籣���ݼٹ��ʷ�̯��'s ���ػ������ݼٹ��ʽ��property 
     */
    public java.math.BigDecimal getAlgVcMoney()
    {
        return getBigDecimal("algVcMoney");
    }
    public void setAlgVcMoney(java.math.BigDecimal item)
    {
        setBigDecimal("algVcMoney", item);
    }
    /**
     * Object:��Ŀ�籣���ݼٹ��ʷ�̯��'s �籣�ݼٹ����ܽ��property 
     */
    public java.math.BigDecimal getScVcCount()
    {
        return getBigDecimal("scVcCount");
    }
    public void setScVcCount(java.math.BigDecimal item)
    {
        setBigDecimal("scVcCount", item);
    }
    /**
     * Object:��Ŀ�籣���ݼٹ��ʷ�̯��'s ��Ŀ��������property 
     */
    public String getProjFR()
    {
        return getString("projFR");
    }
    public void setProjFR(String item)
    {
        setString("projFR", item);
    }
    /**
     * Object:��Ŀ�籣���ݼٹ��ʷ�̯��'s ��Ŀ�籣��property 
     */
    public String getProjSC()
    {
        return getString("projSC");
    }
    public void setProjSC(String item)
    {
        setString("projSC", item);
    }
    /**
     * Object: ��Ŀ�籣���ݼٹ��ʷ�̯�� 's ���� property 
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
     * Object:��Ŀ�籣���ݼٹ��ʷ�̯��'s �Ƿ��Ѷ�������ṩ���ݽ���У�飬���ݲ����޸�property 
     */
    public boolean isIsOk()
    {
        return getBoolean("isOk");
    }
    public void setIsOk(boolean item)
    {
        setBoolean("isOk", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9C3A0276");
    }
}