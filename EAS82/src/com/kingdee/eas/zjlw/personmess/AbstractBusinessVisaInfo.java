package com.kingdee.eas.zjlw.personmess;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBusinessVisaInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBusinessVisaInfo()
    {
        this("id");
    }
    protected AbstractBusinessVisaInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.personmess.BusinessVisaEntryCollection());
    }
    /**
     * Object: 外籍员工商务签信息录入 's 分录 property 
     */
    public com.kingdee.eas.zjlw.personmess.BusinessVisaEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.personmess.BusinessVisaEntryCollection)get("entrys");
    }
    /**
     * Object:外籍员工商务签信息录入's 是否生成凭证property 
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
     * Object:外籍员工商务签信息录入's 返签批次号property 
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
     * Object:外籍员工商务签信息录入's 审核时间property 
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
     * Object:外籍员工商务签信息录入's 单据状态property 
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
        return new BOSObjectType("E80B1881");
    }
}