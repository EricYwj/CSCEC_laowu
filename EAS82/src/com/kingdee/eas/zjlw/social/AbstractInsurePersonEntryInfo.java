package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractInsurePersonEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractInsurePersonEntryInfo()
    {
        this("id");
    }
    protected AbstractInsurePersonEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.zjlw.social.InsurePersonInfo getParent()
    {
        return (com.kingdee.eas.zjlw.social.InsurePersonInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.social.InsurePersonInfo item)
    {
        put("parent", item);
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
     * Object:��¼'s �Ա�property 
     */
    public com.kingdee.eas.basedata.person.Genders getSex()
    {
        return com.kingdee.eas.basedata.person.Genders.getEnum(getInt("sex"));
    }
    public void setSex(com.kingdee.eas.basedata.person.Genders item)
    {
		if (item != null) {
        setInt("sex", item.getValue());
		}
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.util.Date getBirthdate()
    {
        return getDate("birthdate");
    }
    public void setBirthdate(java.util.Date item)
    {
        setDate("birthdate", item);
    }
    /**
     * Object:��¼'s ������property 
     */
    public String getBirthPlaceCn()
    {
        return getString("birthPlaceCn");
    }
    public void setBirthPlaceCn(String item)
    {
        setString("birthPlaceCn", item);
    }
    /**
     * Object:��¼'s ����״��property 
     */
    public com.kingdee.eas.zjlw.certificates.app.mayrStatEnum getMaritalStatus()
    {
        return com.kingdee.eas.zjlw.certificates.app.mayrStatEnum.getEnum(getString("MaritalStatus"));
    }
    public void setMaritalStatus(com.kingdee.eas.zjlw.certificates.app.mayrStatEnum item)
    {
		if (item != null) {
        setString("MaritalStatus", item.getValue());
		}
    }
    /**
     * Object:��¼'s �籣����property 
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
     * Object:��¼'s CCP�˻�property 
     */
    public String getCCPNo()
    {
        return getString("CCPNo");
    }
    public void setCCPNo(String item)
    {
        setString("CCPNo", item);
    }
    /**
     * Object:��¼'s ��ͥסַproperty 
     */
    public String getAddress()
    {
        return getString("address");
    }
    public void setAddress(String item)
    {
        setString("address", item);
    }
    /**
     * Object: ��¼ 's ������Ŀ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getWorkProgram()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("workProgram");
    }
    public void setWorkProgram(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("workProgram", item);
    }
    /**
     * Object: ��¼ 's ������λ property 
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
     * Object:��¼'s ������λ����property 
     */
    public String getCooperationId()
    {
        return getString("cooperationId");
    }
    public void setCooperationId(String item)
    {
        setString("cooperationId", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.util.Date getApproachTime()
    {
        return getDate("approachTime");
    }
    public void setApproachTime(java.util.Date item)
    {
        setDate("approachTime", item);
    }
    /**
     * Object:��¼'s �볡����property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    /**
     * Object:��¼'s �籣(֤��)��Ŀproperty 
     */
    public String getSecuProj()
    {
        return getString("secuProj");
    }
    public void setSecuProj(String item)
    {
        setString("secuProj", item);
    }
    /**
     * Object:��¼'s �Ƿ�α�property 
     */
    public boolean isJoin()
    {
        return getBoolean("join");
    }
    public void setJoin(boolean item)
    {
        setBoolean("join", item);
    }
    /**
     * Object:��¼'s ��Ա����property 
     */
    public String getPersonID()
    {
        return getString("personID");
    }
    public void setPersonID(String item)
    {
        setString("personID", item);
    }
    /**
     * Object:��¼'s �����Ա���property 
     */
    public String getForiPersID()
    {
        return getString("foriPersID");
    }
    public void setForiPersID(String item)
    {
        setString("foriPersID", item);
    }
    /**
     * Object: ��¼ 's �籣���� property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo getSecuProf()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo)get("secuProf");
    }
    public void setSecuProf(com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo item)
    {
        put("secuProf", item);
    }
    /**
     * Object:��¼'s ��������property 
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
     * Object:��¼'s �籣ע��ʱ��property 
     */
    public java.util.Date getSecuRegDate()
    {
        return getDate("secuRegDate");
    }
    public void setSecuRegDate(java.util.Date item)
    {
        setDate("secuRegDate", item);
    }
    /**
     * Object: ��¼ 's ���� property 
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
     * Object:��¼'s �籣ע��ǩ�ռ��ҿ���property 
     */
    public boolean isSecuSigner()
    {
        return getBoolean("secuSigner");
    }
    public void setSecuSigner(boolean item)
    {
        setBoolean("secuSigner", item);
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
    /**
     * Object:��¼'s ��Ŀ�籣��property 
     */
    public String getProjSocialNo()
    {
        return getString("projSocialNo");
    }
    public void setProjSocialNo(String item)
    {
        setString("projSocialNo", item);
    }
    /**
     * Object:��¼'s ���gproperty 
     */
    public int getNSeniority()
    {
        return getInt("nSeniority");
    }
    public void setNSeniority(int item)
    {
        setInt("nSeniority", item);
    }
    /**
     * Object:��¼'s ���乤��property 
     */
    public java.math.BigDecimal getSeniPay()
    {
        return getBigDecimal("seniPay");
    }
    public void setSeniPay(java.math.BigDecimal item)
    {
        setBigDecimal("seniPay", item);
    }
    /**
     * Object:��¼'s ���֤����property 
     */
    public String getIDNumber()
    {
        return getString("IDNumber");
    }
    public void setIDNumber(String item)
    {
        setString("IDNumber", item);
    }
    /**
     * Object:��¼'s ����֤������property 
     */
    public String getBirthIDNumber()
    {
        return getString("birthIDNumber");
    }
    public void setBirthIDNumber(String item)
    {
        setString("birthIDNumber", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AC117643");
    }
}