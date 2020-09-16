package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractImmigrationInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractImmigrationInfo()
    {
        this("id");
    }
    protected AbstractImmigrationInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.certificates.ImmigrationEntryCollection());
    }
    /**
     * Object: 申请入境 's 分录 property 
     */
    public com.kingdee.eas.zjlw.certificates.ImmigrationEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.certificates.ImmigrationEntryCollection)get("entrys");
    }
    /**
     * Object:申请入境's 审核时间property 
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
     * Object:申请入境's 单据状态property 
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
     * Object:申请入境's 反签批次号property 
     */
    public String getContbNum()
    {
        return getString("contbNum");
    }
    public void setContbNum(String item)
    {
        setString("contbNum", item);
    }
    /**
     * Object: 申请入境 's 国内工作部审核人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getInteAuditor()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("inteAuditor");
    }
    public void setInteAuditor(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("inteAuditor", item);
    }
    /**
     * Object:申请入境's 国内工作部审核时间property 
     */
    public java.util.Date getInteADate()
    {
        return getDate("inteADate");
    }
    public void setInteADate(java.util.Date item)
    {
        setDate("inteADate", item);
    }
    /**
     * Object: 申请入境 's 劳务部审核人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getLWAuditor()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("LWAuditor");
    }
    public void setLWAuditor(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("LWAuditor", item);
    }
    /**
     * Object:申请入境's 劳务部审核时间property 
     */
    public java.util.Date getLWAudDate()
    {
        return getDate("LWAudDate");
    }
    public void setLWAudDate(java.util.Date item)
    {
        setDate("LWAudDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("DD9D3C39");
    }
}