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
     * Object: 项目社保和休假工资分摊表 's 分录 property 
     */
    public com.kingdee.eas.zjlw.social.SecuSplitEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.social.SecuSplitEntryCollection)get("entrys");
    }
    /**
     * Object:项目社保和休假工资分摊表's 是否生成凭证property 
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
     * Object: 项目社保和休假工资分摊表 's 项目名称 property 
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
     * Object:项目社保和休假工资分摊表's 单据状态property 
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
     * Object:项目社保和休假工资分摊表's 审核日期property 
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
     * Object:项目社保和休假工资分摊表's 外工缴纳社保人数property 
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
     * Object:项目社保和休假工资分摊表's 属地化缴纳社保人数property 
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
     * Object:项目社保和休假工资分摊表's 社保缴纳总人数property 
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
     * Object:项目社保和休假工资分摊表's 外工缴纳社保金额property 
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
     * Object:项目社保和休假工资分摊表's 属地化缴纳社保金额property 
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
     * Object:项目社保和休假工资分摊表's 外工缴纳休假工资金额property 
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
     * Object:项目社保和休假工资分摊表's 属地化缴纳休假工资金额property 
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
     * Object:项目社保和休假工资分摊表's 社保休假工资总金额property 
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
     * Object:项目社保和休假工资分摊表's 项目法文名称property 
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
     * Object:项目社保和休假工资分摊表's 项目社保号property 
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
     * Object: 项目社保和休假工资分摊表 's 年月 property 
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
     * Object:项目社保和休假工资分摊表's 是否已对照外会提供数据进行校验，数据不再修改property 
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