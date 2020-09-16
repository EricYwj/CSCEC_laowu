package com.kingdee.eas.zjlw.personmess;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWorkVisaEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractWorkVisaEntryInfo()
    {
        this("id");
    }
    protected AbstractWorkVisaEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.personmess.WorkVisaInfo getParent()
    {
        return (com.kingdee.eas.zjlw.personmess.WorkVisaInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.personmess.WorkVisaInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 中文姓名property 
     */
    public String getName()
    {
        return getString("name");
    }
    public void setName(String item)
    {
        setString("name", item);
    }
    /**
     * Object:分录's 姓拼音property 
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
     * Object:分录's 名拼音property 
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
     * Object:分录's 身份证号property 
     */
    public String getIdNum()
    {
        return getString("idNum");
    }
    public void setIdNum(String item)
    {
        setString("idNum", item);
    }
    /**
     * Object:分录's 护照号码property 
     */
    public String getPassportNo()
    {
        return getString("passportNo");
    }
    public void setPassportNo(String item)
    {
        setString("passportNo", item);
    }
    /**
     * Object:分录's 出生地(中文)property 
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
     * Object:分录's 出生地(法文)property 
     */
    public String getBirthPlaceFr()
    {
        return getString("birthPlaceFr");
    }
    public void setBirthPlaceFr(String item)
    {
        setString("birthPlaceFr", item);
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
    public String getFatherNameAlphabet()
    {
        return getString("fatherNameAlphabet");
    }
    public void setFatherNameAlphabet(String item)
    {
        setString("fatherNameAlphabet", item);
    }
    /**
     * Object:分录's 母亲姓名拼音property 
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
     * Object:分录's 婚姻状态property 
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
     * Object:分录's 配偶姓名property 
     */
    public String getCoupleName()
    {
        return getString("coupleName");
    }
    public void setCoupleName(String item)
    {
        setString("coupleName", item);
    }
    /**
     * Object:分录's 配偶姓名拼音property 
     */
    public String getCoupleNameAlphabet()
    {
        return getString("coupleNameAlphabet");
    }
    public void setCoupleNameAlphabet(String item)
    {
        setString("coupleNameAlphabet", item);
    }
    /**
     * Object:分录's 配偶出生地property 
     */
    public String getCoupleBirthPlace()
    {
        return getString("coupleBirthPlace");
    }
    public void setCoupleBirthPlace(String item)
    {
        setString("coupleBirthPlace", item);
    }
    /**
     * Object:分录's 配偶工作单位或项目property 
     */
    public String getCoupleWorkPlace()
    {
        return getString("coupleWorkPlace");
    }
    public void setCoupleWorkPlace(String item)
    {
        setString("coupleWorkPlace", item);
    }
    /**
     * Object:分录's 配偶劳动证编号property 
     */
    public String getCouplePermitNO()
    {
        return getString("couplePermitNO");
    }
    public void setCouplePermitNO(String item)
    {
        setString("couplePermitNO", item);
    }
    /**
     * Object:分录's 国内联系方式property 
     */
    public String getContactway()
    {
        return getString("contactway");
    }
    public void setContactway(String item)
    {
        setString("contactway", item);
    }
    /**
     * Object:分录's 国内联系详细地址property 
     */
    public String getResidence()
    {
        return getString("residence");
    }
    public void setResidence(String item)
    {
        setString("residence", item);
    }
    /**
     * Object:分录's 旧护照号码property 
     */
    public String getOldPassport()
    {
        return getString("oldPassport");
    }
    public void setOldPassport(String item)
    {
        setString("oldPassport", item);
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
     * Object:分录's 护照签发日期property 
     */
    public java.util.Date getPassportIssueDate()
    {
        return getDate("passportIssueDate");
    }
    public void setPassportIssueDate(java.util.Date item)
    {
        setDate("passportIssueDate", item);
    }
    /**
     * Object:分录's 护照失效日期property 
     */
    public java.util.Date getPassportExpireDate()
    {
        return getDate("passportExpireDate");
    }
    public void setPassportExpireDate(java.util.Date item)
    {
        setDate("passportExpireDate", item);
    }
    /**
     * Object:分录's 配偶出生日期property 
     */
    public java.util.Date getCoupleBirthDate()
    {
        return getDate("coupleBirthDate");
    }
    public void setCoupleBirthDate(java.util.Date item)
    {
        setDate("coupleBirthDate", item);
    }
    /**
     * Object: 分录 's 指标工种 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo getPmtProfC()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo)get("pmtProfC");
    }
    public void setPmtProfC(com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo item)
    {
        put("pmtProfC", item);
    }
    /**
     * Object:分录's 考试成绩property 
     */
    public java.math.BigDecimal getScore()
    {
        return getBigDecimal("score");
    }
    public void setScore(java.math.BigDecimal item)
    {
        setBigDecimal("score", item);
    }
    /**
     * Object:分录's 实际工种property 
     */
    public String getAcProf()
    {
        return getString("acProf");
    }
    public void setAcProf(String item)
    {
        setString("acProf", item);
    }
    /**
     * Object:分录's 是否出国前培训property 
     */
    public boolean isTrainAbroad()
    {
        return getBoolean("TrainAbroad");
    }
    public void setTrainAbroad(boolean item)
    {
        setBoolean("TrainAbroad", item);
    }
    /**
     * Object: 分录 's 指标项目 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getPermitProgram()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("permitProgram");
    }
    public void setPermitProgram(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("permitProgram", item);
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
    public com.kingdee.eas.basedata.assistant.CountryInfo getNational()
    {
        return (com.kingdee.eas.basedata.assistant.CountryInfo)get("national");
    }
    public void setNational(com.kingdee.eas.basedata.assistant.CountryInfo item)
    {
        put("national", item);
    }
    /**
     * Object: 分录 's 配偶国籍 property 
     */
    public com.kingdee.eas.basedata.assistant.CountryInfo getCoupleNational()
    {
        return (com.kingdee.eas.basedata.assistant.CountryInfo)get("coupleNational");
    }
    public void setCoupleNational(com.kingdee.eas.basedata.assistant.CountryInfo item)
    {
        put("coupleNational", item);
    }
    /**
     * Object:分录's 配偶劳动证件工种property 
     */
    public String getCouplePermitPro()
    {
        return getString("couplePermitPro");
    }
    public void setCouplePermitPro(String item)
    {
        setString("couplePermitPro", item);
    }
    /**
     * Object:分录's 护照颁发机构property 
     */
    public String getPassportAgency()
    {
        return getString("passportAgency");
    }
    public void setPassportAgency(String item)
    {
        setString("passportAgency", item);
    }
    /**
     * Object:分录's 护照发放机构property 
     */
    public com.kingdee.eas.zjlw.certificates.app.PassportOrganEnum getPassportAgence()
    {
        return com.kingdee.eas.zjlw.certificates.app.PassportOrganEnum.getEnum(getString("passportAgence"));
    }
    public void setPassportAgence(com.kingdee.eas.zjlw.certificates.app.PassportOrganEnum item)
    {
		if (item != null) {
        setString("passportAgence", item.getValue());
		}
    }
    /**
     * Object: 分录 's 护照签发地(中文) property 
     */
    public com.kingdee.eas.basedata.assistant.ProvinceInfo getPassportCity()
    {
        return (com.kingdee.eas.basedata.assistant.ProvinceInfo)get("passportCity");
    }
    public void setPassportCity(com.kingdee.eas.basedata.assistant.ProvinceInfo item)
    {
        put("passportCity", item);
    }
    /**
     * Object:分录's 工作经验property 
     */
    public String getWorkSuffer()
    {
        return getString("workSuffer");
    }
    public void setWorkSuffer(String item)
    {
        setString("workSuffer", item);
    }
    /**
     * Object:分录's 护照签发地（拼音）property 
     */
    public String getPassportCityF()
    {
        return getString("passportCityF");
    }
    public void setPassportCityF(String item)
    {
        setString("passportCityF", item);
    }
    /**
     * Object:分录's 反签批次号property 
     */
    public String getEtyNumber()
    {
        return getString("etyNumber");
    }
    public void setEtyNumber(String item)
    {
        setString("etyNumber", item);
    }
    /**
     * Object:分录's 报签时间property 
     */
    public java.util.Date getGoSignDate()
    {
        return getDate("goSignDate");
    }
    public void setGoSignDate(java.util.Date item)
    {
        setDate("goSignDate", item);
    }
    /**
     * Object:分录's 离境日期property 
     */
    public java.util.Date getLeaveTime()
    {
        return getDate("leaveTime");
    }
    public void setLeaveTime(java.util.Date item)
    {
        setDate("leaveTime", item);
    }
    /**
     * Object:分录's 入境时间property 
     */
    public java.util.Date getImmiTime()
    {
        return getDate("immiTime");
    }
    public void setImmiTime(java.util.Date item)
    {
        setDate("immiTime", item);
    }
    /**
     * Object:分录's 人员编码property 
     */
    public String getPersonID()
    {
        return getString("personID");
    }
    public void setPersonID(String item)
    {
        setString("personID", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("69119C40");
    }
}