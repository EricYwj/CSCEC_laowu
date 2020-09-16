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
     * Object: 阿工考勤规则 's 分录 property 
     */
    public com.kingdee.eas.zjlw.attendance.AlgCheckRulesEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.attendance.AlgCheckRulesEntryCollection)get("entrys");
    }
    /**
     * Object:阿工考勤规则's 是否生成凭证property 
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
     * Object: 阿工考勤规则 's 所属组织 property 
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
     * Object: 阿工考勤规则 's 年月 property 
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
     * Object:阿工考勤规则's 迟到早退允许值(分钟)property 
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
     * Object:阿工考勤规则's 审核日期property 
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
     * Object:阿工考勤规则's 规则名称property 
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
     * Object:阿工考勤规则's 默认考勤规则property 
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
     * Object:阿工考勤规则's 上午上班时间property 
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
     * Object:阿工考勤规则's 上午下班时间property 
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
     * Object:阿工考勤规则's 下午上班时间property 
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
     * Object:阿工考勤规则's 下午下班时间property 
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
     * Object: 阿工考勤规则 's 合作单位 property 
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
     * Object:阿工考勤规则's 单据状态property 
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