package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFiIncomeInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFiIncomeInfo()
    {
        this("id");
    }
    protected AbstractFiIncomeInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.certificates.FiIncomeEntryCollection());
    }
    /**
     * Object: 分配工种 's 分录 property 
     */
    public com.kingdee.eas.zjlw.certificates.FiIncomeEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.certificates.FiIncomeEntryCollection)get("entrys");
    }
    /**
     * Object:分配工种's 返签批次号property 
     */
    public String getBNum()
    {
        return getString("bNum");
    }
    public void setBNum(String item)
    {
        setString("bNum", item);
    }
    /**
     * Object:分配工种's 审核日期property 
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
     * Object:分配工种's 单据状态property 
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
     * Object:分配工种's 国内工作部审核时间property 
     */
    public java.util.Date getNAuditime()
    {
        return getDate("nAuditime");
    }
    public void setNAuditime(java.util.Date item)
    {
        setDate("nAuditime", item);
    }
    /**
     * Object:分配工种's 指标项目经理审核时间property 
     */
    public java.util.Date getPCauditime()
    {
        return getDate("pCauditime");
    }
    public void setPCauditime(java.util.Date item)
    {
        setDate("pCauditime", item);
    }
    /**
     * Object:分配工种's 指标项目业务人员审核时间property 
     */
    public java.util.Date getPAudiTime()
    {
        return getDate("pAudiTime");
    }
    public void setPAudiTime(java.util.Date item)
    {
        setDate("pAudiTime", item);
    }
    /**
     * Object: 分配工种 's 国内工作部信息审核人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getNAuditor()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("nAuditor");
    }
    public void setNAuditor(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("nAuditor", item);
    }
    /**
     * Object: 分配工种 's 指标项目业务人员审核人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getPAuditor()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("pAuditor");
    }
    public void setPAuditor(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("pAuditor", item);
    }
    /**
     * Object: 分配工种 's 指标项目经理审核人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getPCauditor()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("pCauditor");
    }
    public void setPCauditor(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("pCauditor", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FB56E19D");
    }
}