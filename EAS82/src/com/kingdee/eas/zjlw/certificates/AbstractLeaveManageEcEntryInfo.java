package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLeaveManageEcEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractLeaveManageEcEntryInfo()
    {
        this("id");
    }
    protected AbstractLeaveManageEcEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.zjlw.certificates.LeaveManageEcInfo getParent()
    {
        return (com.kingdee.eas.zjlw.certificates.LeaveManageEcInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.certificates.LeaveManageEcInfo item)
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
     * Object:��¼'s ��������property 
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
    /**
     * Object:��¼'s �Ͷ�֤��property 
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
     * Object:��¼'s �Ͷ�֤��������property 
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
     * Object:��¼'s ��ʽ��ס֤����property 
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
     * Object:��¼'s ��ʽ��ס֤��������property 
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
     * Object:��¼'s �뾳����property 
     */
    public java.util.Date getDptrTime()
    {
        return getDate("dptrTime");
    }
    public void setDptrTime(java.util.Date item)
    {
        setDate("dptrTime", item);
    }
    /**
     * Object:��¼'s һ�����뾳�������ʱ��property 
     */
    public java.util.Date getDptrGTime()
    {
        return getDate("dptrGTime");
    }
    public void setDptrGTime(java.util.Date item)
    {
        setDate("dptrGTime", item);
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
     * Object:��¼'s ָ�깤�ַ���property 
     */
    public String getQuproff()
    {
        return getString("quproff");
    }
    public void setQuproff(String item)
    {
        setString("quproff", item);
    }
    /**
     * Object:��¼'s ʵ��רҵ����property 
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
     * Object:��¼'s �Ͷ�֤ע��ʱ��property 
     */
    public java.util.Date getExitTime()
    {
        return getDate("exitTime");
    }
    public void setExitTime(java.util.Date item)
    {
        setDate("exitTime", item);
    }
    /**
     * Object:��¼'s ���պ�property 
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
     * Object:��¼'s �뾳����property 
     */
    public com.kingdee.eas.zjlw.certificates.app.leaveTypeEnum getLeaveType()
    {
        return com.kingdee.eas.zjlw.certificates.app.leaveTypeEnum.getEnum(getString("leaveType"));
    }
    public void setLeaveType(com.kingdee.eas.zjlw.certificates.app.leaveTypeEnum item)
    {
		if (item != null) {
        setString("leaveType", item.getValue());
		}
    }
    /**
     * Object:��¼'s ��ס֤�黹����ʱ��property 
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
     * Object:��¼'s �����뾳����property 
     */
    public java.util.Date getLeaveApply()
    {
        return getDate("leaveApply");
    }
    public void setLeaveApply(java.util.Date item)
    {
        setDate("leaveApply", item);
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
     * Object:��¼'s ����ǩ������property 
     */
    public java.util.Date getPasspIsDate()
    {
        return getDate("passpIsDate");
    }
    public void setPasspIsDate(java.util.Date item)
    {
        setDate("passpIsDate", item);
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
    public String getFatherNameAl()
    {
        return getString("fatherNameAl");
    }
    public void setFatherNameAl(String item)
    {
        setString("fatherNameAl", item);
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
    public String getMotherNameAl()
    {
        return getString("motherNameAl");
    }
    public void setMotherNameAl(String item)
    {
        setString("motherNameAl", item);
    }
    /**
     * Object:��¼'s ��ס֤����property 
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
     * Object:��¼'s ��ʱ��ס֤����property 
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
     * Object:��¼'s ��ʱ��ס֤��֤����property 
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
     * Object:��¼'s ��ʱ��ס֤��������property 
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
     * Object:��¼'s ��ʽ��ס֤��Ч����property 
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
     * Object:��¼'s һ�����뾳����ʱ��property 
     */
    public java.util.Date getDptrETime()
    {
        return getDate("dptrETime");
    }
    public void setDptrETime(java.util.Date item)
    {
        setDate("dptrETime", item);
    }
    /**
     * Object:��¼'s �Ƿ�Я����ס֤�뾳property 
     */
    public boolean isCarryCertify()
    {
        return getBoolean("carryCertify");
    }
    public void setCarryCertify(boolean item)
    {
        setBoolean("carryCertify", item);
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
     * Object:��¼'s ��IDproperty 
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
        return new BOSObjectType("FEBB83E9");
    }
}