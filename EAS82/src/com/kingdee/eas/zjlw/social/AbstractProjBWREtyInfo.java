package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProjBWREtyInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractProjBWREtyInfo()
    {
        this("id");
    }
    protected AbstractProjBWREtyInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.social.ProjBWREtyEntryCollection());
    }
    /**
     * Object: 项目恶劣天气返还录入表 's 分录 property 
     */
    public com.kingdee.eas.zjlw.social.ProjBWREtyEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.social.ProjBWREtyEntryCollection)get("entrys");
    }
    /**
     * Object: 项目恶劣天气返还录入表 's 项目名称 property 
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
     * Object:项目恶劣天气返还录入表's 单据状态property 
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
     * Object:项目恶劣天气返还录入表's 审核日期property 
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
     * Object:项目恶劣天气返还录入表's 项目社保号property 
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
     * Object:项目恶劣天气返还录入表's 停工日期property 
     */
    public java.util.Date getStopDate()
    {
        return getDate("stopDate");
    }
    public void setStopDate(java.util.Date item)
    {
        setDate("stopDate", item);
    }
    /**
     * Object:项目恶劣天气返还录入表's 复工日期property 
     */
    public java.util.Date getRetToWorkDate()
    {
        return getDate("retToWorkDate");
    }
    public void setRetToWorkDate(java.util.Date item)
    {
        setDate("retToWorkDate", item);
    }
    /**
     * Object:项目恶劣天气返还录入表's 停工小时数property 
     */
    public int getDownTimeHours()
    {
        return getInt("downTimeHours");
    }
    public void setDownTimeHours(int item)
    {
        setInt("downTimeHours", item);
    }
    /**
     * Object:项目恶劣天气返还录入表's 停工事由property 
     */
    public String getStoppageBy()
    {
        return getString("stoppageBy");
    }
    public void setStoppageBy(String item)
    {
        setString("stoppageBy", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0FDE242A");
    }
}