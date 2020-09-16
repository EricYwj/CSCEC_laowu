package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractExLivepermitECInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractExLivepermitECInfo()
    {
        this("id");
    }
    protected AbstractExLivepermitECInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.certificates.ExLivepermitECEntryCollection());
    }
    /**
     * Object: 居住证调入-编辑界面 's 分录 property 
     */
    public com.kingdee.eas.zjlw.certificates.ExLivepermitECEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.certificates.ExLivepermitECEntryCollection)get("entrys");
    }
    /**
     * Object:居住证调入-编辑界面's 反签证批次号property 
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
     * Object:居住证调入-编辑界面's 审核日期property 
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
     * Object:居住证调入-编辑界面's 单据状态property 
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
        return new BOSObjectType("0BAE07C9");
    }
}