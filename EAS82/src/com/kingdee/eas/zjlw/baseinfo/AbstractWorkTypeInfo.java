package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWorkTypeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractWorkTypeInfo()
    {
        this("id");
    }
    protected AbstractWorkTypeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:工种库's 启用日期property 
     */
    public java.util.Date getStartDate()
    {
        return getDate("startDate");
    }
    public void setStartDate(java.util.Date item)
    {
        setDate("startDate", item);
    }
    /**
     * Object:工种库's 是否禁用property 
     */
    public boolean isIsForbidden()
    {
        return getBoolean("isForbidden");
    }
    public void setIsForbidden(boolean item)
    {
        setBoolean("isForbidden", item);
    }
    /**
     * Object:工种库's 禁用日期property 
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
     * Object:工种库's 工资标准property 
     */
    public java.math.BigDecimal getWageStandard()
    {
        return getBigDecimal("wageStandard");
    }
    public void setWageStandard(java.math.BigDecimal item)
    {
        setBigDecimal("wageStandard", item);
    }
    /**
     * Object:工种库's 人员津贴property 
     */
    public java.math.BigDecimal getAllowance()
    {
        return getBigDecimal("allowance");
    }
    public void setAllowance(java.math.BigDecimal item)
    {
        setBigDecimal("allowance", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D8FB13D9");
    }
}