package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLocalBlackListInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractLocalBlackListInfo()
    {
        this("id");
    }
    protected AbstractLocalBlackListInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:阿工不合格人员名单's 社保号property 
     */
    public String getSocialNo()
    {
        return getString("socialNo");
    }
    public void setSocialNo(String item)
    {
        setString("socialNo", item);
    }
    /**
     * Object: 阿工不合格人员名单 's 省份 property 
     */
    public com.kingdee.eas.basedata.assistant.ProvinceInfo getProvince()
    {
        return (com.kingdee.eas.basedata.assistant.ProvinceInfo)get("province");
    }
    public void setProvince(com.kingdee.eas.basedata.assistant.ProvinceInfo item)
    {
        put("province", item);
    }
    /**
     * Object:阿工不合格人员名单's 加入日期property 
     */
    public java.util.Date getJoinTime()
    {
        return getDate("joinTime");
    }
    public void setJoinTime(java.util.Date item)
    {
        setDate("joinTime", item);
    }
    /**
     * Object:阿工不合格人员名单's 加入不合格人员名单事由property 
     */
    public String getReason()
    {
        return getString("reason");
    }
    public void setReason(String item)
    {
        setString("reason", item);
    }
    /**
     * Object:阿工不合格人员名单's 是否禁用property 
     */
    public boolean isIsDisable()
    {
        return getBoolean("isDisable");
    }
    public void setIsDisable(boolean item)
    {
        setBoolean("isDisable", item);
    }
    /**
     * Object:阿工不合格人员名单's 禁用时间property 
     */
    public java.util.Date getDisableTime()
    {
        return getDate("disableTime");
    }
    public void setDisableTime(java.util.Date item)
    {
        setDate("disableTime", item);
    }
    /**
     * Object: 阿工不合格人员名单 's 国籍 property 
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
     * Object:阿工不合格人员名单's 出生日期property 
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
     * Object: 阿工不合格人员名单 's 合作单位 property 
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
        return new BOSObjectType("2D729580");
    }
}