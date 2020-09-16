package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProfDpInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractProfDpInfo()
    {
        this("id");
    }
    protected AbstractProfDpInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 工种库 's 组别 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProfDpTreeInfo getTreeid()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProfDpTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.zjlw.baseinfo.ProfDpTreeInfo item)
    {
        put("treeid", item);
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
    public java.util.Date getForbDate()
    {
        return getDate("forbDate");
    }
    public void setForbDate(java.util.Date item)
    {
        setDate("forbDate", item);
    }
    /**
     * Object:工种库's 人员津贴property 
     */
    public java.math.BigDecimal getAllocation()
    {
        return getBigDecimal("allocation");
    }
    public void setAllocation(java.math.BigDecimal item)
    {
        setBigDecimal("allocation", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("63421733");
    }
}