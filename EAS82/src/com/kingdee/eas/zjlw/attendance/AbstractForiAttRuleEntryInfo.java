package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractForiAttRuleEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractForiAttRuleEntryInfo()
    {
        this("id");
    }
    protected AbstractForiAttRuleEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.attendance.ForiAttRuleInfo getParent()
    {
        return (com.kingdee.eas.zjlw.attendance.ForiAttRuleInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.attendance.ForiAttRuleInfo item)
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
     * Object:分录's 打卡间隔property 
     */
    public java.math.BigDecimal getTimeInterval()
    {
        return getBigDecimal("timeInterval");
    }
    public void setTimeInterval(java.math.BigDecimal item)
    {
        setBigDecimal("timeInterval", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("74BC27D9");
    }
}