package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAlgCheckRulesEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractAlgCheckRulesEntryInfo()
    {
        this("id");
    }
    protected AbstractAlgCheckRulesEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.attendance.AlgCheckRulesInfo getParent()
    {
        return (com.kingdee.eas.zjlw.attendance.AlgCheckRulesInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.attendance.AlgCheckRulesInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 天property 
     */
    public int getDay()
    {
        return getInt("day");
    }
    public void setDay(int item)
    {
        setInt("day", item);
    }
    /**
     * Object:分录's 星期property 
     */
    public com.kingdee.eas.cp.wfs.WeekEnum getWeek()
    {
        return com.kingdee.eas.cp.wfs.WeekEnum.getEnum(getInt("week"));
    }
    public void setWeek(com.kingdee.eas.cp.wfs.WeekEnum item)
    {
		if (item != null) {
        setInt("week", item.getValue());
		}
    }
    /**
     * Object:分录's 上午上班时间property 
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
     * Object:分录's 上午下班时间property 
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
     * Object:分录's 下午上班时间property 
     */
    public java.sql.Time getPmOnDuty()
    {
        return getTime("pmOnDuty");
    }
    public void setPmOnDuty(java.sql.Time item)
    {
        setTime("pmOnDuty", item);
    }
    /**
     * Object:分录's 下午下班时间property 
     */
    public java.sql.Time getPmOutDuty()
    {
        return getTime("pmOutDuty");
    }
    public void setPmOutDuty(java.sql.Time item)
    {
        setTime("pmOutDuty", item);
    }
    /**
     * Object:分录's 是否节假日property 
     */
    public boolean isHoliday()
    {
        return getBoolean("holiday");
    }
    public void setHoliday(boolean item)
    {
        setBoolean("holiday", item);
    }
    /**
     * Object:分录's 备注property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object:分录's 夜班下班property 
     */
    public boolean isOffWork()
    {
        return getBoolean("offWork");
    }
    public void setOffWork(boolean item)
    {
        setBoolean("offWork", item);
    }
    /**
     * Object:分录's 夜班上班property 
     */
    public boolean isGoWork()
    {
        return getBoolean("goWork");
    }
    public void setGoWork(boolean item)
    {
        setBoolean("goWork", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2687386B");
    }
}