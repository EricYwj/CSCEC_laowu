package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAttenceResultInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractAttenceResultInfo()
    {
        this("id");
    }
    protected AbstractAttenceResultInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:考勤结果's 人员主键property 
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
     * Object:考勤结果's 实际工种property 
     */
    public String getFactprof()
    {
        return getString("factprof");
    }
    public void setFactprof(String item)
    {
        setString("factprof", item);
    }
    /**
     * Object:考勤结果's 考勤号码property 
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
     * Object:考勤结果's 考勤日期property 
     */
    public java.util.Date getCheckDate()
    {
        return getDate("checkDate");
    }
    public void setCheckDate(java.util.Date item)
    {
        setDate("checkDate", item);
    }
    /**
     * Object:考勤结果's 考勤结果property 
     */
    public com.kingdee.eas.zjlw.attendance.app.checkResultEnum getCheckResult()
    {
        return com.kingdee.eas.zjlw.attendance.app.checkResultEnum.getEnum(getString("checkResult"));
    }
    public void setCheckResult(com.kingdee.eas.zjlw.attendance.app.checkResultEnum item)
    {
		if (item != null) {
        setString("checkResult", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8B5B40E5");
    }
}