package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWkPmtDstryECEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractWkPmtDstryECEntryInfo()
    {
        this("id");
    }
    protected AbstractWkPmtDstryECEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.zjlw.certificates.WkPmtDstryECInfo getParent()
    {
        return (com.kingdee.eas.zjlw.certificates.WkPmtDstryECInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.certificates.WkPmtDstryECInfo item)
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
     * Object:��¼'s ����ʧЧ����property 
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
     * Object:��¼'s �ݽ���������property 
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
     * Object:��¼'s �Ͷ�֤��֤����property 
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
     * Object:��¼'s �Ͷ�֤������property 
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
     * Object:��¼'s ��ǩ����property 
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
     * Object:��¼'s ֤������property 
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
     * Object: ��¼ 's ������Ŀ property 
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
     * Object: ��¼ 's ָ�깤�� property 
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
     * Object:��¼'s ʵ�ʹ���property 
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
     * Object:��¼'s ע������property 
     */
    public java.util.Date getDstryTime()
    {
        return getDate("dstryTime");
    }
    public void setDstryTime(java.util.Date item)
    {
        setDate("dstryTime", item);
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
     * Object:��¼'s ��ǩ�����ҿ���property 
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
     * Object:��¼'s �Ͷ�֤ע�����ҿ���property 
     */
    public boolean isWkpmtDstryp()
    {
        return getBoolean("wkpmtDstryp");
    }
    public void setWkpmtDstryp(boolean item)
    {
        setBoolean("wkpmtDstryp", item);
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
     * Object:��¼'s ��Idproperty 
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
        return new BOSObjectType("A63F163A");
    }
}