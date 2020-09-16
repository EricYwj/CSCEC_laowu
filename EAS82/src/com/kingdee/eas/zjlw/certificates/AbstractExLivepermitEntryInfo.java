package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractExLivepermitEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractExLivepermitEntryInfo()
    {
        this("id");
    }
    protected AbstractExLivepermitEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.zjlw.certificates.ExLivepermitInfo getParent()
    {
        return (com.kingdee.eas.zjlw.certificates.ExLivepermitInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.certificates.ExLivepermitInfo item)
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
     * Object:��¼'s �뾳����property 
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
     * Object:��¼'s ��ס֤�ݽ�����ʱ��property 
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
     * Object:��¼'s �پӺ���property 
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
     * Object:��¼'s �پӵ�������property 
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
     * Object:��¼'s �پӳ�֤����property 
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
     * Object:��¼'s ָ�깤�֣����ģ�property 
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
     * Object: ��¼ 's ԭָ�깤�� property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo getHquProf()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo)get("HquProf");
    }
    public void setHquProf(com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo item)
    {
        put("HquProf", item);
    }
    /**
     * Object:��¼'s ��������property 
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
     * Object: ��¼ 's ԭָ����Ŀ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getHpmtProj()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("HpmtProj");
    }
    public void setHpmtProj(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("HpmtProj", item);
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
     * Object: ��¼ 's ԭ������Ŀ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getHworkOrg()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("HworkOrg");
    }
    public void setHworkOrg(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("HworkOrg", item);
    }
    /**
     * Object:��¼'s ��ʽ��ס֤��֤����property 
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
     * Object:��¼'s ԭָ�깤��(����)property 
     */
    public String getHprmtProf()
    {
        return getString("HprmtProf");
    }
    public void setHprmtProf(String item)
    {
        setString("HprmtProf", item);
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
     * Object:��¼'s �Ƿ����ʹ��ע��property 
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
     * Object:��¼'s �Ͷ�֤��Ч����property 
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
     * Object:��¼'s �յ���ס֤������ʱ��property 
     */
    public java.util.Date getRePmtTrnDate()
    {
        return getDate("rePmtTrnDate");
    }
    public void setRePmtTrnDate(java.util.Date item)
    {
        setDate("rePmtTrnDate", item);
    }
    /**
     * Object:��¼'s ��ס֤�������ʱ��property 
     */
    public java.util.Date getPmtTrnDate()
    {
        return getDate("pmtTrnDate");
    }
    public void setPmtTrnDate(java.util.Date item)
    {
        setDate("pmtTrnDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("31314547");
    }
}