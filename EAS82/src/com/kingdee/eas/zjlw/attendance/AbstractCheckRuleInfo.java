package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCheckRuleInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCheckRuleInfo()
    {
        this("id");
    }
    protected AbstractCheckRuleInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:外工考勤规则's 上班打卡时间property 
     */
    public java.sql.Time getStatTime()
    {
        return getTime("statTime");
    }
    public void setStatTime(java.sql.Time item)
    {
        setTime("statTime", item);
    }
    /**
     * Object:外工考勤规则's 下班打卡时间property 
     */
    public java.sql.Time getEndTime()
    {
        return getTime("endTime");
    }
    public void setEndTime(java.sql.Time item)
    {
        setTime("endTime", item);
    }
    /**
     * Object:外工考勤规则's 打卡间隔property 
     */
    public java.math.BigDecimal getTimeInterval()
    {
        return getBigDecimal("timeInterval");
    }
    public void setTimeInterval(java.math.BigDecimal item)
    {
        setBigDecimal("timeInterval", item);
    }
    /**
     * Object:外工考勤规则's 启用日期property 
     */
    public java.util.Date getEffectDate()
    {
        return getDate("effectDate");
    }
    public void setEffectDate(java.util.Date item)
    {
        setDate("effectDate", item);
    }
    /**
     * Object:外工考勤规则's 禁用日期property 
     */
    public java.util.Date getForbiddenDate()
    {
        return getDate("forbiddenDate");
    }
    public void setForbiddenDate(java.util.Date item)
    {
        setDate("forbiddenDate", item);
    }
    /**
     * Object:外工考勤规则's 启用property 
     */
    public boolean isIsused()
    {
        return getBoolean("isused");
    }
    public void setIsused(boolean item)
    {
        setBoolean("isused", item);
    }
    /**
     * Object:外工考勤规则's 上班打卡时间二property 
     */
    public java.sql.Time getStatAftTime()
    {
        return getTime("statAftTime");
    }
    public void setStatAftTime(java.sql.Time item)
    {
        setTime("statAftTime", item);
    }
    /**
     * Object:外工考勤规则's 下班打卡时间二property 
     */
    public java.sql.Time getEndAftTime()
    {
        return getTime("endAftTime");
    }
    public void setEndAftTime(java.sql.Time item)
    {
        setTime("endAftTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FEDB02E0");
    }
}