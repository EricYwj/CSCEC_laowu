package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTurnoverCountEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractTurnoverCountEntryInfo()
    {
        this("id");
    }
    protected AbstractTurnoverCountEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.zjlw.social.TurnoverCountInfo getParent()
    {
        return (com.kingdee.eas.zjlw.social.TurnoverCountInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.social.TurnoverCountInfo item)
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
     * Object:��¼'s ��ͥ����ʡ��property 
     */
    public String getProvince()
    {
        return getString("province");
    }
    public void setProvince(String item)
    {
        setString("province", item);
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
     * Object:��¼'s ��������ƴ��property 
     */
    public String getAlphFName()
    {
        return getString("alphFName");
    }
    public void setAlphFName(String item)
    {
        setString("alphFName", item);
    }
    /**
     * Object:��¼'s ĸ������property 
     */
    public String getMotherName()
    {
        return getString("MotherName");
    }
    public void setMotherName(String item)
    {
        setString("MotherName", item);
    }
    /**
     * Object:��¼'s ĸ������ƴ��property 
     */
    public String getAlphMName()
    {
        return getString("alphMName");
    }
    public void setAlphMName(String item)
    {
        setString("alphMName", item);
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
     * Object: ��¼ 's ���� property 
     */
    public com.kingdee.eas.zjlw.baseinfo.WorkTypeInfo getProfession()
    {
        return (com.kingdee.eas.zjlw.baseinfo.WorkTypeInfo)get("profession");
    }
    public void setProfession(com.kingdee.eas.zjlw.baseinfo.WorkTypeInfo item)
    {
        put("profession", item);
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1B67E714");
    }
}