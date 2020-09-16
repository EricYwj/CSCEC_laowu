package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCheckInOutInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCheckInOutInfo()
    {
        this("id");
    }
    protected AbstractCheckInOutInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:考勤原始记录表's 姓名property 
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
     * Object:考勤原始记录表's 合作单位property 
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
     * Object:考勤原始记录表's 人员编号property 
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
     * Object:考勤原始记录表's 考勤时间property 
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
     * Object:考勤原始记录表's 考勤状态property 
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
     * Object:考勤原始记录表's 考勤项目property 
     */
    public String getCheAera()
    {
        return getString("cheAera");
    }
    public void setCheAera(String item)
    {
        setString("cheAera", item);
    }
    /**
     * Object:考勤原始记录表's 设备序列号property 
     */
    public String getMachineId()
    {
        return getString("machineId");
    }
    public void setMachineId(String item)
    {
        setString("machineId", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("DC02EC85");
    }
}