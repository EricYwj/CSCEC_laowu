package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProjInsVcPayRegInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractProjInsVcPayRegInfo()
    {
        this("id");
    }
    protected AbstractProjInsVcPayRegInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 项目社保和休假工资注册 's 项目名称 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getProjName()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("projName");
    }
    public void setProjName(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("projName", item);
    }
    /**
     * Object:项目社保和休假工资注册's 项目法文名称property 
     */
    public String getProjNameFr()
    {
        return getString("projNameFr");
    }
    public void setProjNameFr(String item)
    {
        setString("projNameFr", item);
    }
    /**
     * Object:项目社保和休假工资注册's 开工令时间property 
     */
    public java.util.Date getActBeginDate()
    {
        return getDate("actBeginDate");
    }
    public void setActBeginDate(java.util.Date item)
    {
        setDate("actBeginDate", item);
    }
    /**
     * Object:项目社保和休假工资注册's 项目银行账户开立完毕时间property 
     */
    public java.util.Date getBankAccCptDate()
    {
        return getDate("BankAccCptDate");
    }
    public void setBankAccCptDate(java.util.Date item)
    {
        setDate("BankAccCptDate", item);
    }
    /**
     * Object:项目社保和休假工资注册's 所属社保局property 
     */
    public String getIESS()
    {
        return getString("IESS");
    }
    public void setIESS(String item)
    {
        setString("IESS", item);
    }
    /**
     * Object:项目社保和休假工资注册's 项目社保注册申请时间property 
     */
    public java.util.Date getInsRegAplDate()
    {
        return getDate("InsRegAplDate");
    }
    public void setInsRegAplDate(java.util.Date item)
    {
        setDate("InsRegAplDate", item);
    }
    /**
     * Object:项目社保和休假工资注册's 项目社保注册完毕时间property 
     */
    public java.util.Date getInsRegCptDate()
    {
        return getDate("InsRegCptDate");
    }
    public void setInsRegCptDate(java.util.Date item)
    {
        setDate("InsRegCptDate", item);
    }
    /**
     * Object:项目社保和休假工资注册's 所属休假工资局property 
     */
    public String getVcPayBru()
    {
        return getString("vcPayBru");
    }
    public void setVcPayBru(String item)
    {
        setString("vcPayBru", item);
    }
    /**
     * Object:项目社保和休假工资注册's 项目休假工资注册申请时间property 
     */
    public java.util.Date getVcPayRegAplDate()
    {
        return getDate("vcPayRegAplDate");
    }
    public void setVcPayRegAplDate(java.util.Date item)
    {
        setDate("vcPayRegAplDate", item);
    }
    /**
     * Object:项目社保和休假工资注册's 项目休假工资注册完毕时间property 
     */
    public java.util.Date getVcPayRegCptDate()
    {
        return getDate("vcPayRegCptDate");
    }
    public void setVcPayRegCptDate(java.util.Date item)
    {
        setDate("vcPayRegCptDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0CF3389C");
    }
}