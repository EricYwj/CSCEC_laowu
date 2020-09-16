package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAntiECInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractAntiECInfo()
    {
        this("id");
    }
    protected AbstractAntiECInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.certificates.AntiECEntryCollection());
    }
    /**
     * Object: 反签-编辑界面 's 分录 property 
     */
    public com.kingdee.eas.zjlw.certificates.AntiECEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.certificates.AntiECEntryCollection)get("entrys");
    }
    /**
     * Object:反签-编辑界面's 返签批次号property 
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
     * Object:反签-编辑界面's 审核时间property 
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
     * Object:反签-编辑界面's 单据状态property 
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
     * Object:反签-编辑界面's 上个流程审核时间property 
     */
    public java.util.Date getLSubtime()
    {
        return getDate("lSubtime");
    }
    public void setLSubtime(java.util.Date item)
    {
        setDate("lSubtime", item);
    }
    /**
     * Object: 反签-编辑界面 's 上一流程审核人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getISubmitor()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("ISubmitor");
    }
    public void setISubmitor(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("ISubmitor", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C067C111");
    }
}