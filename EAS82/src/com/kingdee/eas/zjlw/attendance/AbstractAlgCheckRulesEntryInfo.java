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
     * Object: ��¼ 's ����ͷ property 
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
     * Object:��¼'s ��property 
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
     * Object:��¼'s ����property 
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
     * Object:��¼'s �����ϰ�ʱ��property 
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
     * Object:��¼'s �����°�ʱ��property 
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
     * Object:��¼'s �����ϰ�ʱ��property 
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
     * Object:��¼'s �����°�ʱ��property 
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
     * Object:��¼'s �Ƿ�ڼ���property 
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
     * Object:��¼'s ��עproperty 
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
     * Object:��¼'s ҹ���°�property 
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
     * Object:��¼'s ҹ���ϰ�property 
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