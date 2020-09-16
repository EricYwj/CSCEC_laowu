package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractForiPersEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractForiPersEntryInfo()
    {
        this("id");
    }
    protected AbstractForiPersEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.zjlw.social.ForiPersInfo getParent()
    {
        return (com.kingdee.eas.zjlw.social.ForiPersInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.social.ForiPersInfo item)
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
     * Object: ��¼ 's ���� property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo getProf()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo)get("prof");
    }
    public void setProf(com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo item)
    {
        put("prof", item);
    }
    /**
     * Object:��¼'s ��ԱIDproperty 
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
     * Object:��¼'s ��ƴ��property 
     */
    public String getFirstNameApl()
    {
        return getString("firstNameApl");
    }
    public void setFirstNameApl(String item)
    {
        setString("firstNameApl", item);
    }
    /**
     * Object:��¼'s ��ƴ��property 
     */
    public String getLastNameApl()
    {
        return getString("lastNameApl");
    }
    public void setLastNameApl(String item)
    {
        setString("lastNameApl", item);
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
     * Object:��¼'s ��������ƴ��property 
     */
    public String getFatherNameAlphabet()
    {
        return getString("fatherNameAlphabet");
    }
    public void setFatherNameAlphabet(String item)
    {
        setString("fatherNameAlphabet", item);
    }
    /**
     * Object:��¼'s ĸ������ƴ��property 
     */
    public String getMotherNameAlphabet()
    {
        return getString("motherNameAlphabet");
    }
    public void setMotherNameAlphabet(String item)
    {
        setString("motherNameAlphabet", item);
    }
    /**
     * Object:��¼'s ��Ʊʱ��property 
     */
    public java.util.Date getAirportDate()
    {
        return getDate("airportDate");
    }
    public void setAirportDate(java.util.Date item)
    {
        setDate("airportDate", item);
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
     * Object:��¼'s ���֤��property 
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
     * Object:��¼'s ���պ�property 
     */
    public String getPasspNum()
    {
        return getString("passpNum");
    }
    public void setPasspNum(String item)
    {
        setString("passpNum", item);
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
     * Object: ��¼ 's �籣��Ŀ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getSecilProgram()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("secilProgram");
    }
    public void setSecilProgram(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("secilProgram", item);
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A0BF357C");
    }
}