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
     * Object: 分录 's 单据头 property 
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
     * Object:分录's 母亲姓名property 
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
     * Object: 分录 's 工作项目 property 
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
     * Object: 分录 's 国籍 property 
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
     * Object:分录's 子女人数property 
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
     * Object:分录's 配偶是否工作property 
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
     * Object: 分录 's 社保项目 property 
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
     * Object:分录's 备注property 
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
     * Object:分录's 外会人员编码property 
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
    /**
     * Object: 分录 's 社保工种 property 
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
     * Object:分录's 基本工资property 
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
     * Object: 分录 's 出生地 property 
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
     * Object: 分录 's 出生地 property 
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
     * Object: 分录 's 社保工种编码 property 
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
     * Object:分录's 人员编码property 
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
     * Object:分录's 身份证号码property 
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
     * Object:分录's 出生证明号码property 
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