package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractForiAttResInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractForiAttResInfo()
    {
        this("id");
    }
    protected AbstractForiAttResInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.attendance.ForiAttResEntryCollection());
    }
    /**
     * Object: 外工考勤结果 's 分录 property 
     */
    public com.kingdee.eas.zjlw.attendance.ForiAttResEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.attendance.ForiAttResEntryCollection)get("entrys");
    }
    /**
     * Object:外工考勤结果's 是否生成凭证property 
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
     * Object: 外工考勤结果 's 所属项目 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getProCom()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("proCom");
    }
    public void setProCom(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("proCom", item);
    }
    /**
     * Object:外工考勤结果's 审核时间property 
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
     * Object:外工考勤结果's 考勤日期property 
     */
    public java.util.Date getAttDate()
    {
        return getDate("attDate");
    }
    public void setAttDate(java.util.Date item)
    {
        setDate("attDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("05481FE3");
    }
}