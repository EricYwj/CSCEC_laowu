package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProjSecuProfInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractProjSecuProfInfo()
    {
        this("id");
    }
    protected AbstractProjSecuProfInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:项目社保工种库's 基本工资property 
     */
    public java.math.BigDecimal getBasePay()
    {
        return getBigDecimal("basePay");
    }
    public void setBasePay(java.math.BigDecimal item)
    {
        setBigDecimal("basePay", item);
    }
    /**
     * Object: 项目社保工种库 's 项目名称 property 
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
     * Object: 项目社保工种库 's 标准工种类型 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.SecuProfInfo getProfType()
    {
        return (com.kingdee.eas.zjlw.baseinfo.SecuProfInfo)get("profType");
    }
    public void setProfType(com.kingdee.eas.zjlw.baseinfo.SecuProfInfo item)
    {
        put("profType", item);
    }
    /**
     * Object:项目社保工种库's 标准基本工资property 
     */
    public java.math.BigDecimal getNBasePay()
    {
        return getBigDecimal("nBasePay");
    }
    public void setNBasePay(java.math.BigDecimal item)
    {
        setBigDecimal("nBasePay", item);
    }
    /**
     * Object:项目社保工种库's 是否禁用property 
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
     * Object:项目社保工种库's 禁用时间property 
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
     * Object:项目社保工种库's 备注property 
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
     * Object:项目社保工种库's 项目社保工种property 
     */
    public String getProjProf()
    {
        return getString("projProf");
    }
    public void setProjProf(String item)
    {
        setString("projProf", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("73D81128");
    }
}