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
     * Object:�������ϸ���Ա����'s �籣��property 
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
     * Object: �������ϸ���Ա���� 's ʡ�� property 
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
     * Object:�������ϸ���Ա����'s ��������property 
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
     * Object:�������ϸ���Ա����'s ���벻�ϸ���Ա��������property 
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
     * Object:�������ϸ���Ա����'s �Ƿ����property 
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
     * Object:�������ϸ���Ա����'s ����ʱ��property 
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
     * Object: �������ϸ���Ա���� 's ���� property 
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
     * Object:�������ϸ���Ա����'s ��������property 
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
     * Object: �������ϸ���Ա���� 's ������λ property 
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