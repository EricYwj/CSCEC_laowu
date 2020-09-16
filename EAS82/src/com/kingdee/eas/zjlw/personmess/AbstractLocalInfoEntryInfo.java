package com.kingdee.eas.zjlw.personmess;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLocalInfoEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractLocalInfoEntryInfo()
    {
        this("id");
    }
    protected AbstractLocalInfoEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.zjlw.personmess.LocalInfoInfo getParent()
    {
        return (com.kingdee.eas.zjlw.personmess.LocalInfoInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.personmess.LocalInfoInfo item)
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
     * Object:��¼'s ��������property 
     */
    public String getFatherName()
    {
        return getString("fatherName");
    }
    public void setFatherName(String item)
    {
        setString("fatherName", item);
    }
    /**
     * Object:��¼'s ĸ������property 
     */
    public String getMotherName()
    {
        return getString("motherName");
    }
    public void setMotherName(String item)
    {
        setString("motherName", item);
    }
    /**
     * Object:��¼'s ��ϵ�绰property 
     */
    public String getTelephone()
    {
        return getString("telephone");
    }
    public void setTelephone(String item)
    {
        setString("telephone", item);
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
     * Object:��¼'s ��ͬ���property 
     */
    public String getContractNo()
    {
        return getString("contractNo");
    }
    public void setContractNo(String item)
    {
        setString("contractNo", item);
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
     * Object:��¼'s ��ͬǩ������property 
     */
    public java.util.Date getContrachSigDate()
    {
        return getDate("contrachSigDate");
    }
    public void setContrachSigDate(java.util.Date item)
    {
        setDate("contrachSigDate", item);
    }
    /**
     * Object:��¼'s ��ͬ��������property 
     */
    public java.util.Date getContractTime()
    {
        return getDate("contractTime");
    }
    public void setContractTime(java.util.Date item)
    {
        setDate("contractTime", item);
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
     * Object:��¼'s ��Ů����property 
     */
    public int getChildCount()
    {
        return getInt("childCount");
    }
    public void setChildCount(int item)
    {
        setInt("childCount", item);
    }
    /**
     * Object:��¼'s ��ż�Ƿ���property 
     */
    public boolean isCoupleWork()
    {
        return getBoolean("coupleWork");
    }
    public void setCoupleWork(boolean item)
    {
        setBoolean("coupleWork", item);
    }
    /**
     * Object: ��¼ 's �籣��Ŀ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getSecuProj()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("secuProj");
    }
    public void setSecuProj(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("secuProj", item);
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
     * Object:��¼'s �����Ա����property 
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
     * Object: ��¼ 's ������ property 
     */
    public com.kingdee.eas.basedata.assistant.ProvinceInfo getBirthPlace()
    {
        return (com.kingdee.eas.basedata.assistant.ProvinceInfo)get("birthPlace");
    }
    public void setBirthPlace(com.kingdee.eas.basedata.assistant.ProvinceInfo item)
    {
        put("birthPlace", item);
    }
    /**
     * Object: ��¼ 's ������ property 
     */
    public com.kingdee.eas.basedata.assistant.ProvinceInfo getBirthPlaceF()
    {
        return (com.kingdee.eas.basedata.assistant.ProvinceInfo)get("birthPlaceF");
    }
    public void setBirthPlaceF(com.kingdee.eas.basedata.assistant.ProvinceInfo item)
    {
        put("birthPlaceF", item);
    }
    /**
     * Object: ��¼ 's �籣���ֱ��� property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo getSecuNumber()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo)get("secuNumber");
    }
    public void setSecuNumber(com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo item)
    {
        put("secuNumber", item);
    }
    /**
     * Object:��¼'s ��Ա����property 
     */
    public String getPersonId()
    {
        return getString("personId");
    }
    public void setPersonId(String item)
    {
        setString("personId", item);
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
        return new BOSObjectType("7C84C999");
    }
}