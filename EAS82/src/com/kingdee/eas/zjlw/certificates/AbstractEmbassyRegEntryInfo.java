package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEmbassyRegEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractEmbassyRegEntryInfo()
    {
        this("id");
    }
    protected AbstractEmbassyRegEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.certificates.EmbassyRegInfo getParent()
    {
        return (com.kingdee.eas.zjlw.certificates.EmbassyRegInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.certificates.EmbassyRegInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 中文姓名property 
     */
    public String getNameCn()
    {
        return getString("nameCn");
    }
    public void setNameCn(String item)
    {
        setString("nameCn", item);
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
     * Object:分录's 出生地中文property 
     */
    public String getBirAddr()
    {
        return getString("birAddr");
    }
    public void setBirAddr(String item)
    {
        setString("birAddr", item);
    }
    /**
     * Object:分录's 出生地拼音property 
     */
    public String getBirAdFr()
    {
        return getString("birAdFr");
    }
    public void setBirAdFr(String item)
    {
        setString("birAdFr", item);
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
     * Object:分录's 入阿时间property 
     */
    public java.util.Date getFAlgTime()
    {
        return getDate("fAlgTime");
    }
    public void setFAlgTime(java.util.Date item)
    {
        setDate("fAlgTime", item);
    }
    /**
     * Object:分录's 递送使馆注册资料时间property 
     */
    public java.util.Date getSbmEmbTime()
    {
        return getDate("sbmEmbTime");
    }
    public void setSbmEmbTime(java.util.Date item)
    {
        setDate("sbmEmbTime", item);
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
     * Object:分录's 取回使馆注册时间property 
     */
    public java.util.Date getBackTime()
    {
        return getDate("backTime");
    }
    public void setBackTime(java.util.Date item)
    {
        setDate("backTime", item);
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("595CEDBF");
    }
}