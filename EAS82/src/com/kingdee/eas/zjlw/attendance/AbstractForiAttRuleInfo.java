package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractForiAttRuleInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractForiAttRuleInfo()
    {
        this("id");
    }
    protected AbstractForiAttRuleInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.attendance.ForiAttRuleEntryCollection());
    }
    /**
     * Object: 外工考勤规则 's 分录 property 
     */
    public com.kingdee.eas.zjlw.attendance.ForiAttRuleEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.attendance.ForiAttRuleEntryCollection)get("entrys");
    }
    /**
     * Object:外工考勤规则's 是否生成凭证property 
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
     * Object: 外工考勤规则 's 所属组织 property 
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
     * Object: 外工考勤规则 's 年月 property 
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
     * Object:外工考勤规则's 审核日期property 
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
     * Object:外工考勤规则's 规则名称property 
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
     * Object:外工考勤规则's 默认考勤规则property 
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
     * Object:外工考勤规则's 打卡间隔(小时)property 
     */
    public java.math.BigDecimal getTimeInterval()
    {
        return getBigDecimal("timeInterval");
    }
    public void setTimeInterval(java.math.BigDecimal item)
    {
        setBigDecimal("timeInterval", item);
    }
    /**
     * Object:外工考勤规则's 单据状态property 
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
        return new BOSObjectType("A3BC1819");
    }
}