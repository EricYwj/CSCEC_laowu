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
     * Object: 分录 's 单据头 property 
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
     * Object:分录's 姓property 
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
     * Object:分录's 名property 
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
     * Object:分录's 性别property 
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
     * Object:分录's 出生日期property 
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
     * Object:分录's 家庭所在省份property 
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
     * Object:分录's 出生地property 
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
     * Object:分录's 婚姻状况property 
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
     * Object:分录's 父亲姓名property 
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
     * Object:分录's 父亲姓名拼音property 
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
     * Object:分录's 母亲姓名property 
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
     * Object:分录's 母亲姓名拼音property 
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
     * Object:分录's 联系电话property 
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
     * Object:分录's 社保号码property 
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
     * Object:分录's CCP账户property 
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
     * Object:分录's 家庭住址property 
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
     * Object: 分录 's 合作单位 property 
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
     * Object:分录's 合作单位代码property 
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
     * Object: 分录 's 工种 property 
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
     * Object:分录's 合同编号property 
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
     * Object:分录's 进场日期property 
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
     * Object:分录's 合同签订日期property 
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
     * Object:分录's 合同到期日期property 
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
     * Object:分录's 离场日期property 
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