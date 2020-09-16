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
     * Object: 外工工资数据 's 分录 property 
     */
    public com.kingdee.eas.zjlw.social.ForiPayrollEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.social.ForiPayrollEntryCollection)get("entrys");
    }
    /**
     * Object:外工工资数据's 是否生成凭证property 
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
     * Object:外工工资数据's 单据状态property 
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
     * Object:外工工资数据's 审核日期property 
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
     * Object: 外工工资数据 's 项目名称 property 
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
     * Object:外工工资数据's 项目社保号property 
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
     * Object: 外工工资数据 's 年月 property 
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
     * Object: 外工工资数据 's 社保项目 property 
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
     * Object:外工工资数据's 是否已对照外会提供数据进行校验，数据不再修改property 
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
     * Object:外工工资数据's 计数property 
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
     * Object:外工工资数据's 项目所在地property 
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