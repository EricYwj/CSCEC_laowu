package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCheckInOutTableInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCheckInOutTableInfo()
    {
        this("id");
    }
    protected AbstractCheckInOutTableInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:考勤原始记录's 人员编号property 
     */
    public String getPerId()
    {
        return getString("perId");
    }
    public void setPerId(String item)
    {
        setString("perId", item);
    }
    /**
     * Object:考勤原始记录's 姓名property 
     */
    public String getPerName()
    {
        return getString("perName");
    }
    public void setPerName(String item)
    {
        setString("perName", item);
    }
    /**
     * Object:考勤原始记录's 合作单位 property 
     */
    public String getPerProj()
    {
        return getString("perProj");
    }
    public void setPerProj(String item)
    {
        setString("perProj", item);
    }
    /**
     * Object:考勤原始记录's 考勤状态property 
     */
    public String getCheckType()
    {
        return getString("checkType");
    }
    public void setCheckType(String item)
    {
        setString("checkType", item);
    }
    /**
     * Object:考勤原始记录's 考勤项目property 
     */
    public String getCheckAera()
    {
        return getString("checkAera");
    }
    public void setCheckAera(String item)
    {
        setString("checkAera", item);
    }
    /**
     * Object:考勤原始记录's 设备序列号property 
     */
    public String getMachineId()
    {
        return getString("machineId");
    }
    public void setMachineId(String item)
    {
        setString("machineId", item);
    }
    /**
     * Object:考勤原始记录's 考勤时间property 
     */
    public String getCheckTime()
    {
        return getString("checkTime");
    }
    public void setCheckTime(String item)
    {
        setString("checkTime", item);
    }
    /**
     * Object:考勤原始记录's 考勤时间property 
     */
    public java.util.Date getChkTime()
    {
        return getDate("chkTime");
    }
    public void setChkTime(java.util.Date item)
    {
        setDate("chkTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F4B26A49");
    }
}