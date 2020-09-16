package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAlgAttEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractAlgAttEntryInfo()
    {
        this("id");
    }
    protected AbstractAlgAttEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.attendance.AlgAttInfo getParent()
    {
        return (com.kingdee.eas.zjlw.attendance.AlgAttInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.attendance.AlgAttInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 人员主键property 
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
     * Object:分录's 迟到早退时间(分钟)property 
     */
    public int getNoWorkTime()
    {
        return getInt("noWorkTime");
    }
    public void setNoWorkTime(int item)
    {
        setInt("noWorkTime", item);
    }
    /**
     * Object:分录's 节假日加班(小时)property 
     */
    public java.math.BigDecimal getHoOverTime()
    {
        return getBigDecimal("hoOverTime");
    }
    public void setHoOverTime(java.math.BigDecimal item)
    {
        setBigDecimal("hoOverTime", item);
    }
    /**
     * Object:分录's 加班时间(小时)property 
     */
    public java.math.BigDecimal getOverTime()
    {
        return getBigDecimal("overTime");
    }
    public void setOverTime(java.math.BigDecimal item)
    {
        setBigDecimal("overTime", item);
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
    /**
     * Object:分录's 迟到早退时间(分钟)property 
     */
    public int getCnoWorkTime()
    {
        return getInt("CnoWorkTime");
    }
    public void setCnoWorkTime(int item)
    {
        setInt("CnoWorkTime", item);
    }
    /**
     * Object:分录's 加班时间(小时)property 
     */
    public java.math.BigDecimal getCoverTime()
    {
        return getBigDecimal("CoverTime");
    }
    public void setCoverTime(java.math.BigDecimal item)
    {
        setBigDecimal("CoverTime", item);
    }
    /**
     * Object:分录's 节假日加班(小时)property 
     */
    public java.math.BigDecimal getChoOverTime()
    {
        return getBigDecimal("ChoOverTime");
    }
    public void setChoOverTime(java.math.BigDecimal item)
    {
        setBigDecimal("ChoOverTime", item);
    }
    /**
     * Object:分录's 出勤天数property 
     */
    public java.math.BigDecimal getWorkDay()
    {
        return getBigDecimal("workDay");
    }
    public void setWorkDay(java.math.BigDecimal item)
    {
        setBigDecimal("workDay", item);
    }
    /**
     * Object:分录's 出勤天数property 
     */
    public java.math.BigDecimal getCworkDay()
    {
        return getBigDecimal("CworkDay");
    }
    public void setCworkDay(java.math.BigDecimal item)
    {
        setBigDecimal("CworkDay", item);
    }
    /**
     * Object:分录's 出差天数property 
     */
    public int getTraDays()
    {
        return getInt("traDays");
    }
    public void setTraDays(int item)
    {
        setInt("traDays", item);
    }
    /**
     * Object:分录's 出差天数property 
     */
    public int getCtraDays()
    {
        return getInt("CtraDays");
    }
    public void setCtraDays(int item)
    {
        setInt("CtraDays", item);
    }
    /**
     * Object:分录's 考勤正常天数property 
     */
    public int getCchkNormal()
    {
        return getInt("CchkNormal");
    }
    public void setCchkNormal(int item)
    {
        setInt("CchkNormal", item);
    }
    /**
     * Object:分录's 考勤正常天数property 
     */
    public int getChcNormal()
    {
        return getInt("chcNormal");
    }
    public void setChcNormal(int item)
    {
        setInt("chcNormal", item);
    }
    /**
     * Object:分录's 考勤缺勤天数property 
     */
    public int getChkDis()
    {
        return getInt("chkDis");
    }
    public void setChkDis(int item)
    {
        setInt("chkDis", item);
    }
    /**
     * Object:分录's 考勤缺勤天数property 
     */
    public int getCchkDis()
    {
        return getInt("CchkDis");
    }
    public void setCchkDis(int item)
    {
        setInt("CchkDis", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("CB9CB3C9");
    }
}