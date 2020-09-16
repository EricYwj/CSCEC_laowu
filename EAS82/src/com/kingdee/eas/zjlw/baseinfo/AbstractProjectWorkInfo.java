package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProjectWorkInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractProjectWorkInfo()
    {
        this("id");
    }
    protected AbstractProjectWorkInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:项目工种库's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object:项目工种库's 工种名称property 
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
     * Object:项目工种库's 工种总量property 
     */
    public int getTotalAmount()
    {
        return getInt("totalAmount");
    }
    public void setTotalAmount(int item)
    {
        setInt("totalAmount", item);
    }
    /**
     * Object:项目工种库's 使用数量property 
     */
    public int getUseAmount()
    {
        return getInt("useAmount");
    }
    public void setUseAmount(int item)
    {
        setInt("useAmount", item);
    }
    /**
     * Object:项目工种库's 工种生效日期property 
     */
    public java.util.Date getEffectDate()
    {
        return getDate("effectDate");
    }
    public void setEffectDate(java.util.Date item)
    {
        setDate("effectDate", item);
    }
    /**
     * Object:项目工种库's 工种停办日期property 
     */
    public java.util.Date getEnddate()
    {
        return getDate("enddate");
    }
    public void setEnddate(java.util.Date item)
    {
        setDate("enddate", item);
    }
    /**
     * Object:项目工种库's 剩余数量property 
     */
    public int getLeftAmount()
    {
        return getInt("leftAmount");
    }
    public void setLeftAmount(int item)
    {
        setInt("leftAmount", item);
    }
    /**
     * Object: 项目工种库 's 所属组织 property 
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
     * Object:项目工种库's 工种名称(法文)property 
     */
    public String getNameFR()
    {
        return getString("nameFR");
    }
    public void setNameFR(String item)
    {
        setString("nameFR", item);
    }
    /**
     * Object: 项目工种库 's 工种类型 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.WorkTypeInfo getType()
    {
        return (com.kingdee.eas.zjlw.baseinfo.WorkTypeInfo)get("type");
    }
    public void setType(com.kingdee.eas.zjlw.baseinfo.WorkTypeInfo item)
    {
        put("type", item);
    }
    /**
     * Object:项目工种库's 基本工资property 
     */
    public java.math.BigDecimal getBasePay()
    {
        return getBigDecimal("basePay");
    }
    public void setBasePay(java.math.BigDecimal item)
    {
        setBigDecimal("basePay", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4E0AA91C");
    }
}