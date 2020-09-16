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
     * Object: ��¼ 's ����ͷ property 
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
     * Object:��¼'s ��������property 
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
     * Object:��¼'s ���պ���property 
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
     * Object:��¼'s ����ǩ������property 
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
     * Object:��¼'s ���յ�������property 
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
     * Object:��¼'s ����������property 
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
     * Object:��¼'s ��������property 
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
     * Object:��¼'s ��������ƴ��property 
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
     * Object:��¼'s ĸ������property 
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
     * Object:��¼'s ĸ������ƴ��property 
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
     * Object:��¼'s �ݽ��Ͷ���ʱ��property 
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
     * Object:��¼'s �Ա�property 
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
     * Object:��¼'s ����״̬property 
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
     * Object: ��¼ 's ������λ property 
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
     * Object: ��¼ 's ������Ŀ property 
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
     * Object: ��¼ 's ָ����Ŀ property 
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
     * Object: ��¼ 's ָ�깤������ property 
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
     * Object:��¼'s ʵ��רҵ����property 
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
     * Object:��¼'s ��������property 
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
     * Object:��¼'s ���֤��property 
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
     * Object: ��¼ 's ���� property 
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
     * Object:��¼'s ���հ䷢����property 
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
     * Object: ��¼ 's ����ǩ�������� property 
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
     * Object:��¼'s ҵ��ǩ�����ʱ��property 
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
     * Object:��¼'s �Ͷ��ַ�ǩ��property 
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
     * Object:��¼'s ��ǩ�����ҿ���property 
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
     * Object:��¼'s �Ƿ�δ�������ͷ�ָ��property 
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
     * Object:��¼'s �ͷ�ָ��ʱ��property 
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
     * Object:��¼'s δ����������property 
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
    public int getCopies()
    {
        return getInt("copies");
    }
    public void setCopies(int item)
    {
        setInt("copies", item);
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
    public String getCoupleBirthPlace()
    {
        return getString("coupleBirthPlace");
    }
    public void setCoupleBirthPlace(String item)
    {
        setString("coupleBirthPlace", item);
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
     * Object:��¼'s ������ϵ��ʽproperty 
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
     * Object:��¼'s ������ϵ��ϸ��ַproperty 
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
     * Object:��¼'s ���乤�����ʱ��property 
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
    /**
     * Object:��¼'s ��ǩ����ʱ��property 
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
     * Object:��¼'s ��ǩ����ǩ�ռ��ҿ���property 
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
     * Object:��¼'s ��Ա״̬property 
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
     * Object:��¼'s �뾳ʱ��property 
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
     * Object:��¼'s �밢ʱ��property 
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