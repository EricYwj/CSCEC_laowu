package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractForiPersInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractForiPersInfo()
    {
        this("id");
    }
    protected AbstractForiPersInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.social.ForiPersEntryCollection());
    }
    /**
     * Object: 外工参保人员名单 's 分录 property 
     */
    public com.kingdee.eas.zjlw.social.ForiPersEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.social.ForiPersEntryCollection)get("entrys");
    }
    /**
     * Object:外工参保人员名单's 是否生成凭证property 
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
     * Object: 外工参保人员名单 's 指标项目 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getPermitOrg()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("permitOrg");
    }
    public void setPermitOrg(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("permitOrg", item);
    }
    /**
     * Object:外工参保人员名单's 单据状态property 
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
     * Object:外工参保人员名单's 审核日期property 
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
        return new BOSObjectType("32D9D096");
    }
}