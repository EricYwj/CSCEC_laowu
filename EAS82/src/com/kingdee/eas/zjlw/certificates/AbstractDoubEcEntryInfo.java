package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDoubEcEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDoubEcEntryInfo()
    {
        this("id");
    }
    protected AbstractDoubEcEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.zjlw.certificates.DoubEcInfo getParent()
    {
        return (com.kingdee.eas.zjlw.certificates.DoubEcInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.certificates.DoubEcInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s ����property 
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
     * Object:��¼'s ���պ�property 
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
     * Object:��¼'s ��֤��ʼ����ʱ��property 
     */
    public java.util.Date getNotiDate()
    {
        return getDate("notiDate");
    }
    public void setNotiDate(java.util.Date item)
    {
        setDate("notiDate", item);
    }
    /**
     * Object:��¼'s ��֤�������ʱ��property 
     */
    public java.util.Date getNotaDate()
    {
        return getDate("notaDate");
    }
    public void setNotaDate(java.util.Date item)
    {
        setDate("notaDate", item);
    }
    /**
     * Object:��¼'s ��֤��ʼ����ʱ��property 
     */
    public java.util.Date getQualSendDate()
    {
        return getDate("qualSendDate");
    }
    public void setQualSendDate(java.util.Date item)
    {
        setDate("qualSendDate", item);
    }
    /**
     * Object:��¼'s ��֤�������ʱ��property 
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
     * Object:��¼'s ͣ������property 
     */
    public String getStopRes()
    {
        return getString("stopRes");
    }
    public void setStopRes(String item)
    {
        setString("stopRes", item);
    }
    /**
     * Object:��¼'s ͣ��ʱ��property 
     */
    public java.util.Date getStopTime()
    {
        return getDate("stopTime");
    }
    public void setStopTime(java.util.Date item)
    {
        setDate("stopTime", item);
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
     * Object:��¼'s ��֤��֤����property 
     */
    public com.kingdee.eas.zjlw.certificates.app.authType getType()
    {
        return com.kingdee.eas.zjlw.certificates.app.authType.getEnum(getString("type"));
    }
    public void setType(com.kingdee.eas.zjlw.certificates.app.authType item)
    {
		if (item != null) {
        setString("type", item.getValue());
		}
    }
    /**
     * Object: ��¼ 's ָ�깤������ property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo getPmtProf()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo)get("pmtProf");
    }
    public void setPmtProf(com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo item)
    {
        put("pmtProf", item);
    }
    /**
     * Object:��¼'s �Ա�property 
     */
    public com.kingdee.eas.basedata.person.Genders getGenDers()
    {
        return com.kingdee.eas.basedata.person.Genders.getEnum(getInt("genDers"));
    }
    public void setGenDers(com.kingdee.eas.basedata.person.Genders item)
    {
		if (item != null) {
        setInt("genDers", item.getValue());
		}
    }
    /**
     * Object:��¼'s ��֤��֤���κ�property 
     */
    public String getQualbaNum()
    {
        return getString("qualbaNum");
    }
    public void setQualbaNum(String item)
    {
        setString("qualbaNum", item);
    }
    /**
     * Object:��¼'s ��עproperty 
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
     * Object:��¼'s ʵ��רҵ����property 
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
     * Object:��¼'s �Ƿ�ͣ��property 
     */
    public boolean isIfstop()
    {
        return getBoolean("ifstop");
    }
    public void setIfstop(boolean item)
    {
        setBoolean("ifstop", item);
    }
    /**
     * Object:��¼'s �Ƿ�Υ���뾳property 
     */
    public boolean isIsIfilentry()
    {
        return getBoolean("isIfilentry");
    }
    public void setIsIfilentry(boolean item)
    {
        setBoolean("isIfilentry", item);
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
     * Object:��¼'s ����ƴ��property 
     */
    public String getNamePY()
    {
        return getString("namePY");
    }
    public void setNamePY(String item)
    {
        setString("namePY", item);
    }
    /**
     * Object:��¼'s ��������property 
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
     * Object:��¼'s ����������property 
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
     * Object:��¼'s ��������property 
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
     * Object:��¼'s ��֤��֤����property 
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
     * Object:��¼'s ԭ��¼Idproperty 
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
     * Object:��¼'s �Ƿ�ͬʱ����������֤��property 
     */
    public boolean isWkPmtGet()
    {
        return getBoolean("wkPmtGet");
    }
    public void setWkPmtGet(boolean item)
    {
        setBoolean("wkPmtGet", item);
    }
    /**
     * Object:��¼'s ��������֤������property 
     */
    public int getWpCopies()
    {
        return getInt("wpCopies");
    }
    public void setWpCopies(int item)
    {
        setInt("wpCopies", item);
    }
    /**
     * Object:��¼'s ��֤���ʱ��(��������)property 
     */
    public java.util.Date getPmtFiDate()
    {
        return getDate("pmtFiDate");
    }
    public void setPmtFiDate(java.util.Date item)
    {
        setDate("pmtFiDate", item);
    }
    /**
     * Object:��¼'s ˫��֤���ʱ�䣨�������飩property 
     */
    public java.util.Date getDbFiDate()
    {
        return getDate("dbFiDate");
    }
    public void setDbFiDate(java.util.Date item)
    {
        setDate("dbFiDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("86FA2C0B");
    }
}