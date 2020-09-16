package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProjChkCountInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractProjChkCountInfo()
    {
        this("id");
    }
    protected AbstractProjChkCountInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.social.ProjChkCountEntryCollection());
    }
    /**
     * Object: 项目检查统计表 's 分录 property 
     */
    public com.kingdee.eas.zjlw.social.ProjChkCountEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.social.ProjChkCountEntryCollection)get("entrys");
    }
    /**
     * Object:项目检查统计表's 是否生成凭证property 
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
     * Object:项目检查统计表's 单据状态property 
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
     * Object:项目检查统计表's 审核时间property 
     */
    public java.util.Date getAuditDate()
    {
        return getDate("auditDate");
    }
    public void setAuditDate(java.util.Date item)
    {
        setDate("auditDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A69B8F46");
    }
}