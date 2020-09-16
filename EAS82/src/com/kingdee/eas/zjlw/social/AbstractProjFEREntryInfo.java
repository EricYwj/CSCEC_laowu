package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProjFEREntryInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractProjFEREntryInfo()
    {
        this("id");
    }
    protected AbstractProjFEREntryInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.social.ProjFEREntryEntryCollection());
    }
    /**
     * Object: 项目外籍员工休假工资返还录入表 's 分录 property 
     */
    public com.kingdee.eas.zjlw.social.ProjFEREntryEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.social.ProjFEREntryEntryCollection)get("entrys");
    }
    /**
     * Object: 项目外籍员工休假工资返还录入表 's 项目名称 property 
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
     * Object:项目外籍员工休假工资返还录入表's 单据状态property 
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
     * Object:项目外籍员工休假工资返还录入表's 审核日期property 
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
     * Object:项目外籍员工休假工资返还录入表's 项目社保号property 
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
     * Object: 项目外籍员工休假工资返还录入表 's 年份 property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getYears()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("years");
    }
    public void setYears(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("years", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("78378BDC");
    }
}