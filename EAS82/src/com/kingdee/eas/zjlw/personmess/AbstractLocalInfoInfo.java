package com.kingdee.eas.zjlw.personmess;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLocalInfoInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractLocalInfoInfo()
    {
        this("id");
    }
    protected AbstractLocalInfoInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.personmess.LocalInfoEntryCollection());
    }
    /**
     * Object: 属地化员工信息录入 's 分录 property 
     */
    public com.kingdee.eas.zjlw.personmess.LocalInfoEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.personmess.LocalInfoEntryCollection)get("entrys");
    }
    /**
     * Object:属地化员工信息录入's 是否生成凭证property 
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
     * Object:属地化员工信息录入's 审核时间property 
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
     * Object:属地化员工信息录入's 单据状态property 
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
     * Object: 属地化员工信息录入 's 社保项目 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getProCom()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("proCom");
    }
    public void setProCom(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("proCom", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("02055E59");
    }
}