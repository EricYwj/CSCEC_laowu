package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractForiCheckedInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractForiCheckedInfo()
    {
        this("id");
    }
    protected AbstractForiCheckedInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.social.ForiCheckedEntryCollection());
    }
    /**
     * Object: 外工社保考勤表 's 分录 property 
     */
    public com.kingdee.eas.zjlw.social.ForiCheckedEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.social.ForiCheckedEntryCollection)get("entrys");
    }
    /**
     * Object:外工社保考勤表's 是否生成凭证property 
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
     * Object: 外工社保考勤表 's 社保项目 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getPermProj()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("permProj");
    }
    public void setPermProj(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("permProj", item);
    }
    /**
     * Object:外工社保考勤表's 单据状态property 
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
     * Object:外工社保考勤表's 审核日期property 
     */
    public java.util.Date getAuditDate()
    {
        return getDate("AuditDate");
    }
    public void setAuditDate(java.util.Date item)
    {
        setDate("AuditDate", item);
    }
    /**
     * Object:外工社保考勤表's 应参保人数property 
     */
    public int getShCount()
    {
        return getInt("shCount");
    }
    public void setShCount(int item)
    {
        setInt("shCount", item);
    }
    /**
     * Object: 外工社保考勤表 's 年月 property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getMonthyear()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("monthyear");
    }
    public void setMonthyear(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("monthyear", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E6090E07");
    }
}