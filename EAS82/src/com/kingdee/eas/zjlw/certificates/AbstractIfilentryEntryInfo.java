package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractIfilentryEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractIfilentryEntryInfo()
    {
        this("id");
    }
    protected AbstractIfilentryEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.certificates.IfilentryInfo getParent()
    {
        return (com.kingdee.eas.zjlw.certificates.IfilentryInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.certificates.IfilentryInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 姓名property 
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
     * Object:分录's 身份证号property 
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
     * Object:分录's 护照号property 
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
     * Object:分录's 护照失效日期property 
     */
    public java.util.Date getPasspExDate()
    {
        return getDate("passpExDate");
    }
    public void setPasspExDate(java.util.Date item)
    {
        setDate("passpExDate", item);
    }
    /**
     * Object:分录's 签证办理完成时间property 
     */
    public java.util.Date getVcompTime()
    {
        return getDate("vcompTime");
    }
    public void setVcompTime(java.util.Date item)
    {
        setDate("vcompTime", item);
    }
    /**
     * Object:分录's 签证失效日期property 
     */
    public java.util.Date getVeTime()
    {
        return getDate("veTime");
    }
    public void setVeTime(java.util.Date item)
    {
        setDate("veTime", item);
    }
    /**
     * Object:分录's 双认证办理完成时间property 
     */
    public java.util.Date getDbCmpTime()
    {
        return getDate("dbCmpTime");
    }
    public void setDbCmpTime(java.util.Date item)
    {
        setDate("dbCmpTime", item);
    }
    /**
     * Object:分录's 合同签订日期property 
     */
    public java.util.Date getContSTime()
    {
        return getDate("contSTime");
    }
    public void setContSTime(java.util.Date item)
    {
        setDate("contSTime", item);
    }
    /**
     * Object:分录's 申请入阿时间property 
     */
    public java.util.Date getApAlgTime()
    {
        return getDate("apAlgTime");
    }
    public void setApAlgTime(java.util.Date item)
    {
        setDate("apAlgTime", item);
    }
    /**
     * Object: 分录 's 合作单位 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getPartner()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("partner");
    }
    public void setPartner(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("partner", item);
    }
    /**
     * Object: 分录 's 指标项目 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getPmtProj()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("pmtProj");
    }
    public void setPmtProj(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("pmtProj", item);
    }
    /**
     * Object: 分录 's 工作项目 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getTaskProj()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("taskProj");
    }
    public void setTaskProj(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("taskProj", item);
    }
    /**
     * Object:分录's 签订合同单位property 
     */
    public String getContDepart()
    {
        return getString("contDepart");
    }
    public void setContDepart(String item)
    {
        setString("contDepart", item);
    }
    /**
     * Object:分录's 合同生效日期property 
     */
    public java.util.Date getContOtime()
    {
        return getDate("contOtime");
    }
    public void setContOtime(java.util.Date item)
    {
        setDate("contOtime", item);
    }
    /**
     * Object:分录's 合同失效日期property 
     */
    public java.util.Date getContItime()
    {
        return getDate("contItime");
    }
    public void setContItime(java.util.Date item)
    {
        setDate("contItime", item);
    }
    /**
     * Object:分录's 备注property 
     */
    public String getDescription()
    {
        return getString("description");
    }
    public void setDescription(String item)
    {
        setString("description", item);
    }
    /**
     * Object:分录's 是否购买保险property 
     */
    public boolean isIfbuyInsure()
    {
        return getBoolean("ifbuyInsure");
    }
    public void setIfbuyInsure(boolean item)
    {
        setBoolean("ifbuyInsure", item);
    }
    /**
     * Object:分录's 人员主键property 
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
     * Object:分录's 来源分录property 
     */
    public String getSourceEntryID()
    {
        return getString("sourceEntryID");
    }
    public void setSourceEntryID(String item)
    {
        setString("sourceEntryID", item);
    }
    /**
     * Object: 分录 's 指标工种 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo getQuProf()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo)get("quProf");
    }
    public void setQuProf(com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo item)
    {
        put("quProf", item);
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
     * Object: 分录 's 国籍 property 
     */
    public com.kingdee.eas.basedata.assistant.CountryInfo getNatioNal()
    {
        return (com.kingdee.eas.basedata.assistant.CountryInfo)get("natioNal");
    }
    public void setNatioNal(com.kingdee.eas.basedata.assistant.CountryInfo item)
    {
        put("natioNal", item);
    }
    /**
     * Object:分录's 是否办理国际健康证property 
     */
    public boolean isIsHand()
    {
        return getBoolean("isHand");
    }
    public void setIsHand(boolean item)
    {
        setBoolean("isHand", item);
    }
    /**
     * Object:分录's 入境申请报告挂靠人property 
     */
    public boolean isReportAffiliated()
    {
        return getBoolean("reportAffiliated");
    }
    public void setReportAffiliated(boolean item)
    {
        setBoolean("reportAffiliated", item);
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
     * Object:分录's 出生地中文property 
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
     * Object:分录's 出生地拼音property 
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
     * Object:分录's 护照颁发机构property 
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
     * Object: 分录 's 护照签发地中文 property 
     */
    public com.kingdee.eas.basedata.assistant.ProvinceInfo getPassportCityC()
    {
        return (com.kingdee.eas.basedata.assistant.ProvinceInfo)get("passportCityC");
    }
    public void setPassportCityC(com.kingdee.eas.basedata.assistant.ProvinceInfo item)
    {
        put("passportCityC", item);
    }
    /**
     * Object:分录's 护照签发地拼音property 
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
     * Object:分录's 工作经验property 
     */
    public int getWorkSuffer()
    {
        return getInt("workSuffer");
    }
    public void setWorkSuffer(int item)
    {
        setInt("workSuffer", item);
    }
    /**
     * Object:分录's 指标工种法文property 
     */
    public String getPmtProfFr()
    {
        return getString("pmtProfFr");
    }
    public void setPmtProfFr(String item)
    {
        setString("pmtProfFr", item);
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
     * Object:分录's 劳动局返签号property 
     */
    public String getLaborSignNo()
    {
        return getString("laborSignNo");
    }
    public void setLaborSignNo(String item)
    {
        setString("laborSignNo", item);
    }
    /**
     * Object:分录's 返签生效时间property 
     */
    public java.util.Date getAntiSgTime()
    {
        return getDate("antiSgTime");
    }
    public void setAntiSgTime(java.util.Date item)
    {
        setDate("antiSgTime", item);
    }
    /**
     * Object:分录's 返签批件上传时间property 
     */
    public java.util.Date getDocUpDate()
    {
        return getDate("docUpDate");
    }
    public void setDocUpDate(java.util.Date item)
    {
        setDate("docUpDate", item);
    }
    /**
     * Object:分录's 返签批件挂靠人property 
     */
    public boolean isDocAffiliated()
    {
        return getBoolean("docAffiliated");
    }
    public void setDocAffiliated(boolean item)
    {
        setBoolean("docAffiliated", item);
    }
    /**
     * Object:分录's 签证资料收到时间property 
     */
    public java.util.Date getVgetTime()
    {
        return getDate("vgetTime");
    }
    public void setVgetTime(java.util.Date item)
    {
        setDate("vgetTime", item);
    }
    /**
     * Object:分录's 签证送签时间property 
     */
    public java.util.Date getVSentTime()
    {
        return getDate("vSentTime");
    }
    public void setVSentTime(java.util.Date item)
    {
        setDate("vSentTime", item);
    }
    /**
     * Object:分录's 签证号码property 
     */
    public String getVisaNum()
    {
        return getString("visaNum");
    }
    public void setVisaNum(String item)
    {
        setString("visaNum", item);
    }
    /**
     * Object:分录's 签证签发日期property 
     */
    public java.util.Date getVsTime()
    {
        return getDate("vsTime");
    }
    public void setVsTime(java.util.Date item)
    {
        setDate("vsTime", item);
    }
    /**
     * Object:分录's 第几次报签property 
     */
    public String getSignNum()
    {
        return getString("signNum");
    }
    public void setSignNum(String item)
    {
        setString("signNum", item);
    }
    /**
     * Object:分录's 公证认证类型property 
     */
    public com.kingdee.eas.zjlw.certificates.app.authType getAuthType()
    {
        return com.kingdee.eas.zjlw.certificates.app.authType.getEnum(getString("authType"));
    }
    public void setAuthType(com.kingdee.eas.zjlw.certificates.app.authType item)
    {
		if (item != null) {
        setString("authType", item.getValue());
		}
    }
    /**
     * Object:分录's 份数property 
     */
    public int getCopies()
    {
        return getInt("copies");
    }
    public void setCopies(int item)
    {
        setInt("copies", item);
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
     * Object:分录's 实际专业或工种property 
     */
    public String getActproff()
    {
        return getString("actproff");
    }
    public void setActproff(String item)
    {
        setString("actproff", item);
    }
    /**
     * Object:分录's 人员状态property 
     */
    public com.kingdee.eas.zjlw.certificates.app.BillStateEnum getPersonState()
    {
        return com.kingdee.eas.zjlw.certificates.app.BillStateEnum.getEnum(getString("personState"));
    }
    public void setPersonState(com.kingdee.eas.zjlw.certificates.app.BillStateEnum item)
    {
		if (item != null) {
        setString("personState", item.getValue());
		}
    }
    /**
     * Object:分录's 是否推送property 
     */
    public boolean isIsPush()
    {
        return getBoolean("isPush");
    }
    public void setIsPush(boolean item)
    {
        setBoolean("isPush", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C23A32B1");
    }
}