package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWorkPmtECInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractWorkPmtECInfo()
    {
        this("id");
    }
    protected AbstractWorkPmtECInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.certificates.WorkPmtECEntryCollection());
    }
    /**
     * Object: 劳动证办理-编辑界面 's 分录 property 
     */
    public com.kingdee.eas.zjlw.certificates.WorkPmtECEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.certificates.WorkPmtECEntryCollection)get("entrys");
    }
    /**
     * Object:劳动证办理-编辑界面's 反签批次号property 
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
     * Object:劳动证办理-编辑界面's 审核时间property 
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
     * Object:劳动证办理-编辑界面's 单据状态property 
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2A0C2133");
    }
}