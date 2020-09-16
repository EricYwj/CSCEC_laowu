package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAttenceEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractAttenceEntryInfo()
    {
        this("id");
    }
    protected AbstractAttenceEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.attendance.AttenceInfo getParent()
    {
        return (com.kingdee.eas.zjlw.attendance.AttenceInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.attendance.AttenceInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 考勤系统部门编码property 
     */
    public String getCheckSysDepNo()
    {
        return getString("CheckSysDepNo");
    }
    public void setCheckSysDepNo(String item)
    {
        setString("CheckSysDepNo", item);
    }
    /**
     * Object:分录's 考勤卡号property 
     */
    public String getCheckNo()
    {
        return getString("CheckNo");
    }
    public void setCheckNo(String item)
    {
        setString("CheckNo", item);
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
     * Object:分录's 日期property 
     */
    public java.util.Date getDate()
    {
        return getDate("date");
    }
    public void setDate(java.util.Date item)
    {
        setDate("date", item);
    }
    /**
     * Object:分录's 打卡时间property 
     */
    public java.sql.Time getCheckTime()
    {
        return getTime("checkTime");
    }
    public void setCheckTime(java.sql.Time item)
    {
        setTime("checkTime", item);
    }
    /**
     * Object:分录's 考勤机编号property 
     */
    public String getCheckMachineNo()
    {
        return getString("checkMachineNo");
    }
    public void setCheckMachineNo(String item)
    {
        setString("checkMachineNo", item);
    }
    /**
     * Object:分录's 是否工作日property 
     */
    public boolean isWorkDay()
    {
        return getBoolean("workDay");
    }
    public void setWorkDay(boolean item)
    {
        setBoolean("workDay", item);
    }
    /**
     * Object:分录's 人员主键property 
     */
    public String getPersonid()
    {
        return getString("personid");
    }
    public void setPersonid(String item)
    {
        setString("personid", item);
    }
    /**
     * Object: 分录 's 合作单位 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getCooperationid()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("cooperationid");
    }
    public void setCooperationid(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("cooperationid", item);
    }
    /**
     * Object: 分录 's 工作项目 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getWorkOrgId()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("workOrgId");
    }
    public void setWorkOrgId(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("workOrgId", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D23F56AA");
    }
}