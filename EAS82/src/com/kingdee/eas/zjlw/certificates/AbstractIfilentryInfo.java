package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractIfilentryInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractIfilentryInfo()
    {
        this("id");
    }
    protected AbstractIfilentryInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.certificates.IfilentryEntryCollection());
    }
    /**
     * Object: 违规入境 's 分录 property 
     */
    public com.kingdee.eas.zjlw.certificates.IfilentryEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.certificates.IfilentryEntryCollection)get("entrys");
    }
    /**
     * Object:违规入境's 审核时间property 
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
     * Object:违规入境's 单据状态property 
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
     * Object:违规入境's 返签批次号property 
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
     * Object: 违规入境 's 劳务部主管审核人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getLeaAuditor()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("leaAuditor");
    }
    public void setLeaAuditor(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("leaAuditor", item);
    }
    /**
     * Object:违规入境's 劳务部主管审核时间property 
     */
    public java.util.Date getLeaAudDate()
    {
        return getDate("leaAudDate");
    }
    public void setLeaAudDate(java.util.Date item)
    {
        setDate("leaAudDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8E28A641");
    }
}