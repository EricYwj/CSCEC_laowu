package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBlackListInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractBlackListInfo()
    {
        this("id");
    }
    protected AbstractBlackListInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 外工不合格人员名单 's 国籍 property 
     */
    public com.kingdee.eas.basedata.hraux.NationalityInfo getNation()
    {
        return (com.kingdee.eas.basedata.hraux.NationalityInfo)get("nation");
    }
    public void setNation(com.kingdee.eas.basedata.hraux.NationalityInfo item)
    {
        put("nation", item);
    }
    /**
     * Object: 外工不合格人员名单 's 省份 property 
     */
    public com.kingdee.eas.basedata.assistant.ProvinceInfo getProvence()
    {
        return (com.kingdee.eas.basedata.assistant.ProvinceInfo)get("Provence");
    }
    public void setProvence(com.kingdee.eas.basedata.assistant.ProvinceInfo item)
    {
        put("Provence", item);
    }
    /**
     * Object:外工不合格人员名单's 加入日期property 
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
     * Object:外工不合格人员名单's 是否生效property 
     */
    public boolean isIsEffect()
    {
        return getBoolean("isEffect");
    }
    public void setIsEffect(boolean item)
    {
        setBoolean("isEffect", item);
    }
    /**
     * Object:外工不合格人员名单's 身份证号property 
     */
    public String getIdNum()
    {
        return getString("IdNum");
    }
    public void setIdNum(String item)
    {
        setString("IdNum", item);
    }
    /**
     * Object:外工不合格人员名单's 社保号property 
     */
    public String getSecurityNo()
    {
        return getString("securityNo");
    }
    public void setSecurityNo(String item)
    {
        setString("securityNo", item);
    }
    /**
     * Object: 外工不合格人员名单 's 国籍 property 
     */
    public com.kingdee.eas.basedata.assistant.CountryInfo getCountry()
    {
        return (com.kingdee.eas.basedata.assistant.CountryInfo)get("country");
    }
    public void setCountry(com.kingdee.eas.basedata.assistant.CountryInfo item)
    {
        put("country", item);
    }
    /**
     * Object:外工不合格人员名单's 是否禁用property 
     */
    public boolean isIfDisable()
    {
        return getBoolean("ifDisable");
    }
    public void setIfDisable(boolean item)
    {
        setBoolean("ifDisable", item);
    }
    /**
     * Object:外工不合格人员名单's 出生日期property 
     */
    public java.util.Date getBirthyDate()
    {
        return getDate("birthyDate");
    }
    public void setBirthyDate(java.util.Date item)
    {
        setDate("birthyDate", item);
    }
    /**
     * Object: 外工不合格人员名单 's 合作单位 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getCooperation()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("cooperation");
    }
    public void setCooperation(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("cooperation", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5565A10F");
    }
}