package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractVabaweatherInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractVabaweatherInfo()
    {
        this("id");
    }
    protected AbstractVabaweatherInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.social.VabaweatherEntryCollection());
    }
    /**
     * Object: 休假与恶劣天气返还 's 分录 property 
     */
    public com.kingdee.eas.zjlw.social.VabaweatherEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.social.VabaweatherEntryCollection)get("entrys");
    }
    /**
     * Object:休假与恶劣天气返还's 是否生成凭证property 
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
     * Object: 休假与恶劣天气返还 's 项目名称 property 
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
     * Object:休假与恶劣天气返还's 项目社保号property 
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
     * Object:休假与恶劣天气返还's 单据状态property 
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
     * Object:休假与恶劣天气返还's 审核日期property 
     */
    public java.util.Date getAuditDate()
    {
        return getDate("AuditDate");
    }
    public void setAuditDate(java.util.Date item)
    {
        setDate("AuditDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0E7483CA");
    }
}