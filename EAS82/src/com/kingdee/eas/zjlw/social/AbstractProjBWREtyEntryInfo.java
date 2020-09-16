package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProjBWREtyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractProjBWREtyEntryInfo()
    {
        this("id");
    }
    protected AbstractProjBWREtyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.zjlw.social.ProjBWREtyInfo getParent()
    {
        return (com.kingdee.eas.zjlw.social.ProjBWREtyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.social.ProjBWREtyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s �����籣��property 
     */
    public String getPersonSoclNum()
    {
        return getString("personSoclNum");
    }
    public void setPersonSoclNum(String item)
    {
        setString("personSoclNum", item);
    }
    /**
     * Object:��¼'s ��property 
     */
    public String getLastName()
    {
        return getString("lastName");
    }
    public void setLastName(String item)
    {
        setString("lastName", item);
    }
    /**
     * Object:��¼'s ��property 
     */
    public String getFirstName()
    {
        return getString("firstName");
    }
    public void setFirstName(String item)
    {
        setString("firstName", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.util.Date getBirthDate()
    {
        return getDate("birthDate");
    }
    public void setBirthDate(java.util.Date item)
    {
        setDate("birthDate", item);
    }
    /**
     * Object: ��¼ 's �籣���� property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo getSocialJobs()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo)get("socialJobs");
    }
    public void setSocialJobs(com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo item)
    {
        put("socialJobs", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.util.Date getArrivalDate()
    {
        return getDate("arrivalDate");
    }
    public void setArrivalDate(java.util.Date item)
    {
        setDate("arrivalDate", item);
    }
    /**
     * Object:��¼'s ����Сʱproperty 
     */
    public java.math.BigDecimal getHourWage()
    {
        return getBigDecimal("hourWage");
    }
    public void setHourWage(java.math.BigDecimal item)
    {
        setBigDecimal("hourWage", item);
    }
    /**
     * Object:��¼'s ���˷������property 
     */
    public java.math.BigDecimal getPersonCredits()
    {
        return getBigDecimal("personCredits");
    }
    public void setPersonCredits(java.math.BigDecimal item)
    {
        setBigDecimal("personCredits", item);
    }
    /**
     * Object: ��¼ 's ������λ���� property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getCooperCode()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("cooperCode");
    }
    public void setCooperCode(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("cooperCode", item);
    }
    /**
     * Object:��¼'s ������λproperty 
     */
    public String getCooperation()
    {
        return getString("cooperation");
    }
    public void setCooperation(String item)
    {
        setString("cooperation", item);
    }
    /**
     * Object:��¼'s ��עproperty 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E503FE68");
    }
}