package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEpEcInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractEpEcInfo()
    {
        this("id");
    }
    protected AbstractEpEcInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.certificates.EpEcEntryCollection());
    }
    /**
     * Object: 使馆注册-编辑界面 's 分录 property 
     */
    public com.kingdee.eas.zjlw.certificates.EpEcEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.certificates.EpEcEntryCollection)get("entrys");
    }
    /**
     * Object:使馆注册-编辑界面's 审核时间property 
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
     * Object:使馆注册-编辑界面's 单据状态property 
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
     * Object:使馆注册-编辑界面's 返签批次号property 
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
     * Object:使馆注册-编辑界面's 是否补办property 
     */
    public boolean isIfNeed()
    {
        return getBoolean("ifNeed");
    }
    public void setIfNeed(boolean item)
    {
        setBoolean("ifNeed", item);
    }
    /**
     * Object:使馆注册-编辑界面's 补办理由property 
     */
    public String getNeedReson()
    {
        return getString("needReson");
    }
    public void setNeedReson(String item)
    {
        setString("needReson", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6FD30C7A");
    }
}