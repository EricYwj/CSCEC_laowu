package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPassportEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractPassportEntryInfo()
    {
        this("id");
    }
    protected AbstractPassportEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.certificates.PassportInfo getParent()
    {
        return (com.kingdee.eas.zjlw.certificates.PassportInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.certificates.PassportInfo item)
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
     * Object:分录's 护照已发放property 
     */
    public boolean isSend()
    {
        return getBoolean("send");
    }
    public void setSend(boolean item)
    {
        setBoolean("send", item);
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
     * Object:分录's 性别 property 
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
    public java.util.Date getBirthDate()
    {
        return getDate("birthDate");
    }
    public void setBirthDate(java.util.Date item)
    {
        setDate("birthDate", item);
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
     * Object:分录's 护照到期日期property 
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
     * Object:分录's 申请入阿时间property 
     */
    public java.util.Date getApplyDate()
    {
        return getDate("applyDate");
    }
    public void setApplyDate(java.util.Date item)
    {
        setDate("applyDate", item);
    }
    /**
     * Object:分录's 机票时间property 
     */
    public java.util.Date getTickeTime()
    {
        return getDate("tickeTime");
    }
    public void setTickeTime(java.util.Date item)
    {
        setDate("tickeTime", item);
    }
    /**
     * Object:分录's 机票附件挂靠人property 
     */
    public boolean isAffpersonTicket()
    {
        return getBoolean("AffpersonTicket");
    }
    public void setAffpersonTicket(boolean item)
    {
        setBoolean("AffpersonTicket", item);
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
     * Object:分录's 是否使馆注册property 
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
     * Object:分录's 护照签发日期property 
     */
    public java.util.Date getPassportIDate()
    {
        return getDate("passportIDate");
    }
    public void setPassportIDate(java.util.Date item)
    {
        setDate("passportIDate", item);
    }
    /**
     * Object:分录's 护照颁发机构property 
     */
    public com.kingdee.eas.zjlw.certificates.app.PassportOrganEnum getPassportAgency()
    {
        return com.kingdee.eas.zjlw.certificates.app.PassportOrganEnum.getEnum(getString("passportAgency"));
    }
    public void setPassportAgency(com.kingdee.eas.zjlw.certificates.app.PassportOrganEnum item)
    {
		if (item != null) {
        setString("passportAgency", item.getValue());
		}
    }
    /**
     * Object: 分录 's 护照签发地中文 property 
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
    public String getWorkSuffer()
    {
        return getString("workSuffer");
    }
    public void setWorkSuffer(String item)
    {
        setString("workSuffer", item);
    }
    /**
     * Object: 分录 's 指标工种中文 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getPmtProfC()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("pmtProfC");
    }
    public void setPmtProfC(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("pmtProfC", item);
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
    public String getLaborVisaNo()
    {
        return getString("laborVisaNo");
    }
    public void setLaborVisaNo(String item)
    {
        setString("laborVisaNo", item);
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
    public String getDocAffiliated()
    {
        return getString("docAffiliated");
    }
    public void setDocAffiliated(String item)
    {
        setString("docAffiliated", item);
    }
    /**
     * Object:分录's 签证资料收到时间property 
     */
    public java.util.Date getVisaReceiveTime()
    {
        return getDate("VisaReceiveTime");
    }
    public void setVisaReceiveTime(java.util.Date item)
    {
        setDate("VisaReceiveTime", item);
    }
    /**
     * Object:分录's 签证送签时间property 
     */
    public java.util.Date getVisaDeliveTime()
    {
        return getDate("VisaDeliveTime");
    }
    public void setVisaDeliveTime(java.util.Date item)
    {
        setDate("VisaDeliveTime", item);
    }
    /**
     * Object:分录's 签证办理完毕时间property 
     */
    public java.util.Date getVisaprocessTime()
    {
        return getDate("VisaprocessTime");
    }
    public void setVisaprocessTime(java.util.Date item)
    {
        setDate("VisaprocessTime", item);
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
    public String getCopies()
    {
        return getString("copies");
    }
    public void setCopies(String item)
    {
        setString("copies", item);
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
     * Object:分录's 实际专业或工种property 
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
     * Object:分录's 合同签订时间property 
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
     * Object:分录's 合同生效时间property 
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
     * Object:分录's 违规入境property 
     */
    public String getIfUnexpect()
    {
        return getString("ifUnexpect");
    }
    public void setIfUnexpect(String item)
    {
        setString("ifUnexpect", item);
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
        return new BOSObjectType("9CCDCCCF");
    }
}