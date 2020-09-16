package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProjWageInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractProjWageInfo()
    {
        this("id");
    }
    protected AbstractProjWageInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:项目津贴库's 金额property 
     */
    public java.math.BigDecimal getMoney()
    {
        return getBigDecimal("money");
    }
    public void setMoney(java.math.BigDecimal item)
    {
        setBigDecimal("money", item);
    }
    /**
     * Object: 项目津贴库 's 标准金额 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.WageInfo getType()
    {
        return (com.kingdee.eas.zjlw.baseinfo.WageInfo)get("type");
    }
    public void setType(com.kingdee.eas.zjlw.baseinfo.WageInfo item)
    {
        put("type", item);
    }
    /**
     * Object: 项目津贴库 's 所属项目 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getProCom()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("proCom");
    }
    public void setProCom(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("proCom", item);
    }
    /**
     * Object:项目津贴库's 是否禁用property 
     */
    public boolean isIsStop()
    {
        return getBoolean("isStop");
    }
    public void setIsStop(boolean item)
    {
        setBoolean("isStop", item);
    }
    /**
     * Object:项目津贴库's 禁用时间property 
     */
    public java.util.Date getStopTimes()
    {
        return getDate("stopTimes");
    }
    public void setStopTimes(java.util.Date item)
    {
        setDate("stopTimes", item);
    }
    /**
     * Object: 项目津贴库 's 单位 property 
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
     * Object: 项目津贴库 's 标准津贴类型 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.WageInfo getWageType()
    {
        return (com.kingdee.eas.zjlw.baseinfo.WageInfo)get("wageType");
    }
    public void setWageType(com.kingdee.eas.zjlw.baseinfo.WageInfo item)
    {
        put("wageType", item);
    }
    /**
     * Object:项目津贴库's 单位property 
     */
    public String getUnit()
    {
        return getString("unit");
    }
    public void setUnit(String item)
    {
        setString("unit", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9B59EC13");
    }
}