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
     * Object: ��¼ 's ����ͷ property 
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
     * Object:��¼'s ��������property 
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
     * Object:��¼'s ���֤��property 
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
     * Object:��¼'s ���պ���property 
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
     * Object:��¼'s �����ѷ���property 
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
     * Object:��¼'s ��Ա����property 
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
     * Object:��¼'s ��Դ��¼property 
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
     * Object:��¼'s ��ƴ��property 
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
     * Object:��¼'s ��ƴ��property 
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
     * Object:��¼'s �Ա� property 
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
     * Object:��¼'s ��������property 
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
     * Object: ��¼ 's ���� property 
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
     * Object:��¼'s ���յ�������property 
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
     * Object:��¼'s ǩ֤��������property 
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
     * Object:��¼'s ˫��֤���ʱ��property 
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
     * Object:��¼'s �����밢ʱ��property 
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
     * Object:��¼'s ��Ʊʱ��property 
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
     * Object:��¼'s ��Ʊ�����ҿ���property 
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
     * Object:��¼'s �Ƿ�ͣ��property 
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
     * Object:��¼'s ͣ��ʱ��property 
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
     * Object:��¼'s ͣ������property 
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
     * Object:��¼'s �Ƿ�ʹ��ע��property 
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
     * Object: ��¼ 's ָ����Ŀ property 
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
     * Object: ��¼ 's ������Ŀ property 
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
     * Object: ��¼ 's ������λ property 
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
     * Object:��¼'s ������ϵ��ʽ�ֻ���property 
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
     * Object:��¼'s ������ϵ��ϸ��ַʡ����property 
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
     * Object:��¼'s ��עproperty 
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
     * Object:��¼'s �ɻ��պ���property 
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
     * Object:��¼'s ����������property 
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
     * Object:��¼'s ������ƴ��property 
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
     * Object:��¼'s ����ǩ������property 
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
     * Object:��¼'s ���հ䷢����property 
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
     * Object: ��¼ 's ����ǩ�������� property 
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
     * Object:��¼'s ����ǩ����ƴ��property 
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
     * Object:��¼'s ��������property 
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
     * Object: ��¼ 's ָ�깤������ property 
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
     * Object:��¼'s ָ�깤�ַ���property 
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
     * Object:��¼'s ��������property 
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
     * Object:��¼'s ��������ƴ��property 
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
     * Object:��¼'s ĸ������property 
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
     * Object:��¼'s ĸ������ƴ��property 
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
     * Object:��¼'s ����״̬property 
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
     * Object:��¼'s �Ͷ��ַ�ǩ��property 
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
     * Object:��¼'s ��ǩ��Чʱ��property 
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
     * Object:��¼'s ��ǩ�����ϴ�ʱ��property 
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
     * Object:��¼'s ��ǩ�����ҿ���property 
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
     * Object:��¼'s ǩ֤�����յ�ʱ��property 
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
     * Object:��¼'s ǩ֤��ǩʱ��property 
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
     * Object:��¼'s ǩ֤�������ʱ��property 
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
     * Object:��¼'s ǩ֤����property 
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
     * Object:��¼'s ǩ֤ǩ������property 
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
     * Object:��¼'s �ڼ��α�ǩproperty 
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
     * Object:��¼'s ��֤��֤����property 
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
     * Object:��¼'s ����property 
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
     * Object:��¼'s ��ż����property 
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
     * Object:��¼'s ��ż����ƴ��property 
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
     * Object:��¼'s ��ż��������property 
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
     * Object:��¼'s ��ż������property 
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
     * Object: ��¼ 's ��ż���� property 
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
     * Object:��¼'s ��ż������λ����Ŀproperty 
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
     * Object:��¼'s ʵ��רҵ����property 
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
     * Object:��¼'s ǩ����ͬ��λproperty 
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
     * Object:��¼'s ��ͬǩ��ʱ��property 
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
     * Object:��¼'s ��ͬ��Чʱ��property 
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
     * Object:��¼'s �Ƿ�����property 
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
     * Object:��¼'s �Ƿ������ʽ���֤�챾property 
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
     * Object:��¼'s Υ���뾳property 
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
     * Object:��¼'s ��Ա״̬property 
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
     * Object:��¼'s �Ƿ�����property 
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