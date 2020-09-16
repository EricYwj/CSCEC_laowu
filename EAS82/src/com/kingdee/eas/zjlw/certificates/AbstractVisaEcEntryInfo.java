package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractVisaEcEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractVisaEcEntryInfo()
    {
        this("id");
    }
    protected AbstractVisaEcEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.certificates.VisaEcInfo getParent()
    {
        return (com.kingdee.eas.zjlw.certificates.VisaEcInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.certificates.VisaEcInfo item)
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
    public String getPasspNo()
    {
        return getString("passpNo");
    }
    public void setPasspNo(String item)
    {
        setString("passpNo", item);
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
     * Object:分录's 返签批件上传时间property 
     */
    public java.util.Date getAnSgetDate()
    {
        return getDate("anSgetDate");
    }
    public void setAnSgetDate(java.util.Date item)
    {
        setDate("anSgetDate", item);
    }
    /**
     * Object:分录's 护照到期日期property 
     */
    public java.util.Date getPasspDate()
    {
        return getDate("passpDate");
    }
    public void setPasspDate(java.util.Date item)
    {
        setDate("passpDate", item);
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
     * Object:分录's 签证办理完毕时间property 
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
     * Object: 分录 's 指标工种中文 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo getPmtProfc()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo)get("pmtProfc");
    }
    public void setPmtProfc(com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo item)
    {
        put("pmtProfc", item);
    }
    /**
     * Object:分录's 指标工种法文property 
     */
    public String getCuproff()
    {
        return getString("cuproff");
    }
    public void setCuproff(String item)
    {
        setString("cuproff", item);
    }
    /**
     * Object:分录's 实际专业或工种property 
     */
    public String getActProff()
    {
        return getString("actProff");
    }
    public void setActProff(String item)
    {
        setString("actProff", item);
    }
    /**
     * Object:分录's 出生日期property 
     */
    public java.util.Date getBornDate()
    {
        return getDate("bornDate");
    }
    public void setBornDate(java.util.Date item)
    {
        setDate("bornDate", item);
    }
    /**
     * Object:分录's 护照签发日期property 
     */
    public java.util.Date getPassoTime()
    {
        return getDate("passoTime");
    }
    public void setPassoTime(java.util.Date item)
    {
        setDate("passoTime", item);
    }
    /**
     * Object: 分录 's 指标项目 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getPrmtPro()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("prmtPro");
    }
    public void setPrmtPro(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("prmtPro", item);
    }
    /**
     * Object: 分录 's 工作项目 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getWorkPro()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("workPro");
    }
    public void setWorkPro(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("workPro", item);
    }
    /**
     * Object:分录's 备注property 
     */
    public String getDesCription()
    {
        return getString("desCription");
    }
    public void setDesCription(String item)
    {
        setString("desCription", item);
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
    public String getStopRsn()
    {
        return getString("stopRsn");
    }
    public void setStopRsn(String item)
    {
        setString("stopRsn", item);
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
     * Object:分录's 原分录idproperty 
     */
    public String getOldEtyId()
    {
        return getString("oldEtyId");
    }
    public void setOldEtyId(String item)
    {
        setString("oldEtyId", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B4EC0C02");
    }
}