package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractForiAttDataEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractForiAttDataEntryInfo()
    {
        this("id");
    }
    protected AbstractForiAttDataEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.attendance.ForiAttDataInfo getParent()
    {
        return (com.kingdee.eas.zjlw.attendance.ForiAttDataInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.attendance.ForiAttDataInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 姓名property 
     */
    public String getName()
    {
        return getString("name");
    }
    public void setName(String item)
    {
        setString("name", item);
    }
    /**
     * Object:分录's 人员编号property 
     */
    public String getPersonId()
    {
        return getString("personId");
    }
    public void setPersonId(String item)
    {
        setString("personId", item);
    }
    /**
     * Object:分录's 上班时间property 
     */
    public java.sql.Time getAmOnDuty()
    {
        return getTime("amOnDuty");
    }
    public void setAmOnDuty(java.sql.Time item)
    {
        setTime("amOnDuty", item);
    }
    /**
     * Object:分录's 下班时间property 
     */
    public java.sql.Time getAmOutDuty()
    {
        return getTime("amOutDuty");
    }
    public void setAmOutDuty(java.sql.Time item)
    {
        setTime("amOutDuty", item);
    }
    /**
     * Object:分录's 考勤日期property 
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
        return new BOSObjectType("DBC50BEB");
    }
}