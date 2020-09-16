package com.kingdee.eas.zjlw.personmess;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWorkVisaInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractWorkVisaInfo()
    {
        this("id");
    }
    protected AbstractWorkVisaInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.personmess.WorkVisaEntryCollection());
    }
    /**
     * Object: 外籍员工工作签信息录入 's 分录 property 
     */
    public com.kingdee.eas.zjlw.personmess.WorkVisaEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.personmess.WorkVisaEntryCollection)get("entrys");
    }
    /**
     * Object:外籍员工工作签信息录入's 是否生成凭证property 
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
     * Object:外籍员工工作签信息录入's 返签批次号property 
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
     * Object:外籍员工工作签信息录入's 国内工作部审核时间property 
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
     * Object:外籍员工工作签信息录入's 单据状态property 
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
     * Object:外籍员工工作签信息录入's 指标项目业务人员审核时间property 
     */
    public java.util.Date getProgramAuditDate()
    {
        return getDate("programAuditDate");
    }
    public void setProgramAuditDate(java.util.Date item)
    {
        setDate("programAuditDate", item);
    }
    /**
     * Object:外籍员工工作签信息录入's 指标项目经理审核时间property 
     */
    public java.util.Date getProjectAuditDate()
    {
        return getDate("projectAuditDate");
    }
    public void setProjectAuditDate(java.util.Date item)
    {
        setDate("projectAuditDate", item);
    }
    /**
     * Object: 外籍员工工作签信息录入 's 指标项目业务人员审核人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getProgramAuditor()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("programAuditor");
    }
    public void setProgramAuditor(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("programAuditor", item);
    }
    /**
     * Object: 外籍员工工作签信息录入 's 指标项目经理审核人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getProjectAuditor()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("projectAuditor");
    }
    public void setProjectAuditor(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("projectAuditor", item);
    }
    /**
     * Object: 外籍员工工作签信息录入 's 指标项目 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getProCom()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("proCom");
    }
    public void setProCom(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("proCom", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("570B3F52");
    }
}