package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAlgAttResEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractAlgAttResEntryInfo()
    {
        this("id");
    }
    protected AbstractAlgAttResEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.attendance.AlgAttResInfo getParent()
    {
        return (com.kingdee.eas.zjlw.attendance.AlgAttResInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.attendance.AlgAttResInfo item)
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
     * Object:分录's 考勤结果property 
     */
    public com.kingdee.eas.zjlw.attendance.app.algResultEnum getAlgResult()
    {
        return com.kingdee.eas.zjlw.attendance.app.algResultEnum.getEnum(getString("algResult"));
    }
    public void setAlgResult(com.kingdee.eas.zjlw.attendance.app.algResultEnum item)
    {
		if (item != null) {
        setString("algResult", item.getValue());
		}
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
     * Object: 分录 's 合作单位 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getCooperation()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("cooperation");
    }
    public void setCooperation(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("cooperation", item);
    }
    /**
     * Object:分录's 合作单位代码property 
     */
    public String getCooperationId()
    {
        return getString("cooperationId");
    }
    public void setCooperationId(String item)
    {
        setString("cooperationId", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F6C2C4FB");
    }
}