package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWorkPmtECEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractWorkPmtECEntryInfo()
    {
        this("id");
    }
    protected AbstractWorkPmtECEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.certificates.WorkPmtECInfo getParent()
    {
        return (com.kingdee.eas.zjlw.certificates.WorkPmtECInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.certificates.WorkPmtECInfo item)
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
     * Object:分录's 出生日期property 
     */
    public java.util.Date getBirthday()
    {
        return getDate("birthday");
    }
    public void setBirthday(java.util.Date item)
    {
        setDate("birthday", item);
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
    /**
     * Object:分录's 劳动证资料递交日期property 
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
     * Object:分录's 劳动证到期日期property 
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
     * Object:分录's 劳动证类型property 
     */
    public com.kingdee.eas.zjlw.certificates.app.DOCTYPE getPType()
    {
        return com.kingdee.eas.zjlw.certificates.app.DOCTYPE.getEnum(getString("pType"));
    }
    public void setPType(com.kingdee.eas.zjlw.certificates.app.DOCTYPE item)
    {
		if (item != null) {
        setString("pType", item.getValue());
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
     * Object:分录's 指标工种法文property 
     */
    public String getQuprofF()
    {
        return getString("quprofF");
    }
    public void setQuprofF(String item)
    {
        setString("quprofF", item);
    }
    /**
     * Object:分录's 实际专业或工种property 
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
     * Object:分录's 是否离境property 
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
     * Object:分录's 双认证完成时间property 
     */
    public java.util.Date getQualDate()
    {
        return getDate("qualDate");
    }
    public void setQualDate(java.util.Date item)
    {
        setDate("qualDate", item);
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
     * Object:分录's 国内联系方式手机号property 
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
     * Object:分录's 国内联系详细地址省市县property 
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
     * Object:分录's 工作经验property 
     */
    public int getWorkEXP()
    {
        return getInt("workEXP");
    }
    public void setWorkEXP(int item)
    {
        setInt("workEXP", item);
    }
    /**
     * Object:分录's 份数property 
     */
    public int getCopie()
    {
        return getInt("copie");
    }
    public void setCopie(int item)
    {
        setInt("copie", item);
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
     * Object: 分录 's 护照签发地中文 property 
     */
    public com.kingdee.eas.basedata.assistant.ProvinceInfo getPassportCityCC()
    {
        return (com.kingdee.eas.basedata.assistant.ProvinceInfo)get("passportCityCC");
    }
    public void setPassportCityCC(com.kingdee.eas.basedata.assistant.ProvinceInfo item)
    {
        put("passportCityCC", item);
    }
    /**
     * Object:分录's 劳动证申请签收件挂靠人property 
     */
    public boolean isSPAfPerson()
    {
        return getBoolean("sPAfPerson");
    }
    public void setSPAfPerson(boolean item)
    {
        setBoolean("sPAfPerson", item);
    }
    /**
     * Object:分录's 是否办理使馆注册property 
     */
    public boolean isIsEmbassReg()
    {
        return getBoolean("isEmbassReg");
    }
    public void setIsEmbassReg(boolean item)
    {
        setBoolean("isEmbassReg", item);
    }
    /**
     * Object:分录's 旧IDproperty 
     */
    public String getOldEtyId()
    {
        return getString("oldEtyId");
    }
    public void setOldEtyId(String item)
    {
        setString("oldEtyId", item);
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
        return new BOSObjectType("E867BEFF");
    }
}