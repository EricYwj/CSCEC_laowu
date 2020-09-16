package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLivepermitEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractLivepermitEntryInfo()
    {
        this("id");
    }
    protected AbstractLivepermitEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.certificates.LivepermitInfo getParent()
    {
        return (com.kingdee.eas.zjlw.certificates.LivepermitInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.certificates.LivepermitInfo item)
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
     * Object:分录's 护照号码property 
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
     * Object:分录's 入阿日期property 
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
     * Object:分录's 劳动证出证日期property 
     */
    public java.util.Date getWPmtGTime()
    {
        return getDate("wPmtGTime");
    }
    public void setWPmtGTime(java.util.Date item)
    {
        setDate("wPmtGTime", item);
    }
    /**
     * Object:分录's 劳动证号property 
     */
    public String getWPmtNum()
    {
        return getString("wPmtNum");
    }
    public void setWPmtNum(String item)
    {
        setString("wPmtNum", item);
    }
    /**
     * Object:分录's 劳动证到期日property 
     */
    public java.util.Date getWPmtSTime()
    {
        return getDate("wPmtSTime");
    }
    public void setWPmtSTime(java.util.Date item)
    {
        setDate("wPmtSTime", item);
    }
    /**
     * Object:分录's 居住证递交资料时间property 
     */
    public java.util.Date getPapSTime()
    {
        return getDate("papSTime");
    }
    public void setPapSTime(java.util.Date item)
    {
        setDate("papSTime", item);
    }
    /**
     * Object:分录's 临居号码property 
     */
    public String getRePmtNum()
    {
        return getString("rePmtNum");
    }
    public void setRePmtNum(String item)
    {
        setString("rePmtNum", item);
    }
    /**
     * Object:分录's 临居到期日期property 
     */
    public java.util.Date getRePmtETime()
    {
        return getDate("rePmtETime");
    }
    public void setRePmtETime(java.util.Date item)
    {
        setDate("rePmtETime", item);
    }
    /**
     * Object:分录's 临居出证日期property 
     */
    public java.util.Date getSRePmtSTime()
    {
        return getDate("sRePmtSTime");
    }
    public void setSRePmtSTime(java.util.Date item)
    {
        setDate("sRePmtSTime", item);
    }
    /**
     * Object:分录's 正式居住证到期日期property 
     */
    public java.util.Date getPmtETime()
    {
        return getDate("pmtETime");
    }
    public void setPmtETime(java.util.Date item)
    {
        setDate("pmtETime", item);
    }
    /**
     * Object:分录's 正式居住证号码property 
     */
    public String getPmtNum()
    {
        return getString("pmtNum");
    }
    public void setPmtNum(String item)
    {
        setString("pmtNum", item);
    }
    /**
     * Object:分录's 第几次报签property 
     */
    public String getDlyChkFrc()
    {
        return getString("dlyChkFrc");
    }
    public void setDlyChkFrc(String item)
    {
        setString("dlyChkFrc", item);
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
     * Object:分录's 居住证类型property 
     */
    public com.kingdee.eas.zjlw.certificates.app.DOCTYPE getDocType()
    {
        return com.kingdee.eas.zjlw.certificates.app.DOCTYPE.getEnum(getString("docType"));
    }
    public void setDocType(com.kingdee.eas.zjlw.certificates.app.DOCTYPE item)
    {
		if (item != null) {
        setString("docType", item.getValue());
		}
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
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getWorkOrg()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("workOrg");
    }
    public void setWorkOrg(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("workOrg", item);
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
     * Object:分录's 指标工种法文property 
     */
    public String getPrmtProf()
    {
        return getString("prmtProf");
    }
    public void setPrmtProf(String item)
    {
        setString("prmtProf", item);
    }
    /**
     * Object:分录's 实际工种property 
     */
    public String getActProf()
    {
        return getString("actProf");
    }
    public void setActProf(String item)
    {
        setString("actProf", item);
    }
    /**
     * Object:分录's 是否未交资料离境property 
     */
    public boolean isDeparture()
    {
        return getBoolean("departure");
    }
    public void setDeparture(boolean item)
    {
        setBoolean("departure", item);
    }
    /**
     * Object:分录's 出生日期property 
     */
    public java.util.Date getBirth()
    {
        return getDate("birth");
    }
    public void setBirth(java.util.Date item)
    {
        setDate("birth", item);
    }
    /**
     * Object:分录's 正式居住证出证日期property 
     */
    public java.util.Date getPmtSTime()
    {
        return getDate("pmtSTime");
    }
    public void setPmtSTime(java.util.Date item)
    {
        setDate("pmtSTime", item);
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
     * Object:分录's 是否停办property 
     */
    public boolean isIsStop()
    {
        return getBoolean("isStop");
    }
    public void setIsStop(boolean item)
    {
        setBoolean("isStop", item);
    }
    /**
     * Object:分录's 停办日期property 
     */
    public java.util.Date getEndTime()
    {
        return getDate("endTime");
    }
    public void setEndTime(java.util.Date item)
    {
        setDate("endTime", item);
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
     * Object:分录's 出生地中文property 
     */
    public String getBirthPlace()
    {
        return getString("birthPlace");
    }
    public void setBirthPlace(String item)
    {
        setString("birthPlace", item);
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
     * Object: 分录 's 国籍 property 
     */
    public com.kingdee.eas.basedata.assistant.CountryInfo getNation()
    {
        return (com.kingdee.eas.basedata.assistant.CountryInfo)get("nation");
    }
    public void setNation(com.kingdee.eas.basedata.assistant.CountryInfo item)
    {
        put("nation", item);
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
    public String getCouplebirthPlace()
    {
        return getString("couplebirthPlace");
    }
    public void setCouplebirthPlace(String item)
    {
        setString("couplebirthPlace", item);
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
     * Object:分录's 是否办理国际健康证红本property 
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
     * Object:分录's 签证号码property 
     */
    public String getVisaNum()
    {
        return getString("VisaNum");
    }
    public void setVisaNum(String item)
    {
        setString("VisaNum", item);
    }
    /**
     * Object:分录's 签证签发日期property 
     */
    public java.util.Date getVsTima()
    {
        return getDate("vsTima");
    }
    public void setVsTima(java.util.Date item)
    {
        setDate("vsTima", item);
    }
    /**
     * Object:分录's 签证到期日期property 
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
     * Object:分录's 劳动证生效日期property 
     */
    public java.util.Date getLaboreffDate()
    {
        return getDate("laboreffDate");
    }
    public void setLaboreffDate(java.util.Date item)
    {
        setDate("laboreffDate", item);
    }
    /**
     * Object:分录's 收到劳动证时间property 
     */
    public java.util.Date getReWorkPmtDate()
    {
        return getDate("reWorkPmtDate");
    }
    public void setReWorkPmtDate(java.util.Date item)
    {
        setDate("reWorkPmtDate", item);
    }
    /**
     * Object:分录's 正式居住证生效日期property 
     */
    public java.util.Date getPmteffDate()
    {
        return getDate("pmteffDate");
    }
    public void setPmteffDate(java.util.Date item)
    {
        setDate("pmteffDate", item);
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
     * Object:分录's 劳动局返签号property 
     */
    public String getLaborVisaNo()
    {
        return getString("laborVisaNo");
    }
    public void setLaborVisaNo(String item)
    {
        setString("laborVisaNo", item);
    }
    /**
     * Object:分录's 返签批件挂靠人property 
     */
    public boolean isDocAffiliate()
    {
        return getBoolean("docAffiliate");
    }
    public void setDocAffiliate(boolean item)
    {
        setBoolean("docAffiliate", item);
    }
    /**
     * Object:分录's 是否办理使馆注册property 
     */
    public boolean isIsEmbassyReg()
    {
        return getBoolean("isEmbassyReg");
    }
    public void setIsEmbassyReg(boolean item)
    {
        setBoolean("isEmbassyReg", item);
    }
    /**
     * Object:分录's 离境日期property 
     */
    public java.util.Date getLeaDate()
    {
        return getDate("leaDate");
    }
    public void setLeaDate(java.util.Date item)
    {
        setDate("leaDate", item);
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("BDDF1E3A");
    }
}