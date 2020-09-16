package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAlgAttInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractAlgAttInfo()
    {
        this("id");
    }
    protected AbstractAlgAttInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.attendance.AlgAttEntryCollection());
    }
    /**
     * Object: 阿工考勤表 's 分录 property 
     */
    public com.kingdee.eas.zjlw.attendance.AlgAttEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.attendance.AlgAttEntryCollection)get("entrys");
    }
    /**
     * Object:阿工考勤表's 是否生成凭证property 
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
     * Object: 阿工考勤表 's 所属项目 property 
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
     * Object:阿工考勤表's 审核时间property 
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
     * Object:阿工考勤表's 单据状态property 
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
     * Object: 阿工考勤表 's 考勤月份 property 
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
     * Object:阿工考勤表's 考勤开始日期property 
     */
    public java.util.Date getBeginDate()
    {
        return getDate("beginDate");
    }
    public void setBeginDate(java.util.Date item)
    {
        setDate("beginDate", item);
    }
    /**
     * Object:阿工考勤表's 考勤结束日期property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("54CFD629");
    }
}