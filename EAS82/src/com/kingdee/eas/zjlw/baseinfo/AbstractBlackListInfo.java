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
     * Object: �⹤���ϸ���Ա���� 's ���� property 
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
     * Object: �⹤���ϸ���Ա���� 's ʡ�� property 
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
     * Object:�⹤���ϸ���Ա����'s ��������property 
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
     * Object:�⹤���ϸ���Ա����'s �Ƿ���Чproperty 
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
     * Object:�⹤���ϸ���Ա����'s ���֤��property 
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
     * Object:�⹤���ϸ���Ա����'s �籣��property 
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
     * Object: �⹤���ϸ���Ա���� 's ���� property 
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
     * Object:�⹤���ϸ���Ա����'s �Ƿ����property 
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
     * Object:�⹤���ϸ���Ա����'s ��������property 
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
     * Object: �⹤���ϸ���Ա���� 's ������λ property 
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