package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTurnoverCountInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractTurnoverCountInfo()
    {
        this("id");
    }
    protected AbstractTurnoverCountInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.social.TurnoverCountEntryCollection());
    }
    /**
     * Object: 离场人员统计表 's 分录 property 
     */
    public com.kingdee.eas.zjlw.social.TurnoverCountEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.social.TurnoverCountEntryCollection)get("entrys");
    }
    /**
     * Object:离场人员统计表's 是否生成凭证property 
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
     * Object: 离场人员统计表 's 指标项目 property 
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
     * Object:离场人员统计表's 单据状态property 
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
     * Object:离场人员统计表's 审核日期property 
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
        return new BOSObjectType("C83E7FFE");
    }
}