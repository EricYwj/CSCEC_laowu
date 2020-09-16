package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAntiSignedEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractAntiSignedEntryInfo()
    {
        this("id");
    }
    protected AbstractAntiSignedEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.certificates.AntiSignedInfo getParent()
    {
        return (com.kingdee.eas.zjlw.certificates.AntiSignedInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.certificates.AntiSignedInfo item)
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
     * Object:分录's 出生日期property 
     */
    public java.util.Date getBirDate()
    {
        return getDate("birDate");
    }
    public void setBirDate(java.util.Date item)
    {
        setDate("birDate", item);
    }
    /**
     * Object:分录's 护照号码property 
     */
    public String getPasspNo()
    {
        return getString("passpNo");
    }
    public void setPasspNo(String item)
    {
        setString("passpNo", item);
    }
    /**
     * Object:分录's 护照签发日期property 
     */
    public java.util.Date getPasspIssDate()
    {
        return getDate("passpIssDate");
    }
    public void setPasspIssDate(java.util.Date item)
    {
        setDate("passpIssDate", item);
    }
    /**
     * Object:分录's 护照到期日期property 
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
     * Object:分录's 出生地中文property 
     */
    public String getBirAddrCn()
    {
        return getString("birAddrCn");
    }
    public void setBirAddrCn(String item)
    {
        setString("birAddrCn", item);
    }
    /**
     * Object:分录's 父亲姓名property 
     */
    public String getFName()
    {
        return getString("fName");
    }
    public void setFName(String item)
    {
        setString("fName", item);
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
    public String getMName()
    {
        return getString("mName");
    }
    public void setMName(String item)
    {
        setString("mName", item);
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
     * Object:分录's 递交劳动局时间property 
     */
    public java.util.Date getSendLaBuDate()
    {
        return getDate("sendLaBuDate");
    }
    public void setSendLaBuDate(java.util.Date item)
    {
        setDate("sendLaBuDate", item);
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
     * Object:分录's 婚姻状态property 
     */
    public com.kingdee.eas.zjlw.certificates.app.mayrStatEnum getMayrStat()
    {
        return com.kingdee.eas.zjlw.certificates.app.mayrStatEnum.getEnum(getString("mayrStat"));
    }
    public void setMayrStat(com.kingdee.eas.zjlw.certificates.app.mayrStatEnum item)
    {
		if (item != null) {
        setString("mayrStat", item.getValue());
		}
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
     * Object: 分录 's 指标工种中文 property 
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
     * Object:分录's 工作经验property 
     */
    public int getWorkExp()
    {
        return getInt("workExp");
    }
    public void setWorkExp(int item)
    {
        setInt("workExp", item);
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
     * Object:分录's 是否停办property 
     */
    public boolean isIsCancel()
    {
        return getBoolean("isCancel");
    }
    public void setIsCancel(boolean item)
    {
        setBoolean("isCancel", item);
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
     * Object:分录's 业主签字完成时间property 
     */
    public java.util.Date getOwnerSignDate()
    {
        return getDate("ownerSignDate");
    }
    public void setOwnerSignDate(java.util.Date item)
    {
        setDate("ownerSignDate", item);
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
     * Object:分录's 是否未交资料释放指标property 
     */
    public boolean isIsLogout()
    {
        return getBoolean("isLogout");
    }
    public void setIsLogout(boolean item)
    {
        setBoolean("isLogout", item);
    }
    /**
     * Object:分录's 释放指标时间property 
     */
    public java.util.Date getLogoutDate()
    {
        return getDate("logoutDate");
    }
    public void setLogoutDate(java.util.Date item)
    {
        setDate("logoutDate", item);
    }
    /**
     * Object:分录's 未交资料理由property 
     */
    public String getLogoutReson()
    {
        return getString("logoutReson");
    }
    public void setLogoutReson(String item)
    {
        setString("logoutReson", item);
    }
    /**
     * Object:分录's 停办时间property 
     */
    public java.util.Date getCancelDate()
    {
        return getDate("cancelDate");
    }
    public void setCancelDate(java.util.Date item)
    {
        setDate("cancelDate", item);
    }
    /**
     * Object:分录's 停办理由property 
     */
    public String getCancelReson()
    {
        return getString("cancelReson");
    }
    public void setCancelReson(String item)
    {
        setString("cancelReson", item);
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
     * Object:分录's 分配工种完成时间property 
     */
    public java.util.Date getAssignDate()
    {
        return getDate("assignDate");
    }
    public void setAssignDate(java.util.Date item)
    {
        setDate("assignDate", item);
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
    /**
     * Object:分录's 返签到期时间property 
     */
    public java.util.Date getAntiEndTime()
    {
        return getDate("antiEndTime");
    }
    public void setAntiEndTime(java.util.Date item)
    {
        setDate("antiEndTime", item);
    }
    /**
     * Object:分录's 返签申请签收件挂靠人property 
     */
    public boolean isAppAffiliated()
    {
        return getBoolean("appAffiliated");
    }
    public void setAppAffiliated(boolean item)
    {
        setBoolean("appAffiliated", item);
    }
    /**
     * Object:分录's 人员状态property 
     */
    public com.kingdee.eas.zjlw.certificates.app.antiPerStEmun getPerSt()
    {
        return com.kingdee.eas.zjlw.certificates.app.antiPerStEmun.getEnum(getString("perSt"));
    }
    public void setPerSt(com.kingdee.eas.zjlw.certificates.app.antiPerStEmun item)
    {
		if (item != null) {
        setString("perSt", item.getValue());
		}
    }
    /**
     * Object:分录's 离境时间property 
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
     * Object:分录's 入阿时间property 
     */
    public java.util.Date getImmiTime()
    {
        return getDate("immiTime");
    }
    public void setImmiTime(java.util.Date item)
    {
        setDate("immiTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("99CE7B83");
    }
}