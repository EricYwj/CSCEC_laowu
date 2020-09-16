package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWorkVisacancelEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractWorkVisacancelEntryInfo()
    {
        this("id");
    }
    protected AbstractWorkVisacancelEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.zjlw.certificates.WorkVisacancelInfo getParent()
    {
        return (com.kingdee.eas.zjlw.certificates.WorkVisacancelInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.certificates.WorkVisacancelInfo item)
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
    public String getPasspNo()
    {
        return getString("passpNo");
    }
    public void setPasspNo(String item)
    {
        setString("passpNo", item);
    }
    /**
     * Object:��¼'s ǩ֤�����յ�ʱ��property 
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
     * Object:��¼'s ��ǩ�����յ�ʱ��property 
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
     * Object:��¼'s ����ʧЧ����property 
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
     * Object:��¼'s ǩ֤��ǩʱ�䣨�ݽ�ʹ�����ڣ�property 
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
     * Object:��¼'s ǩ֤�������ʱ��property 
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
     * Object: ��¼ 's ָ�깤�� property 
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
     * Object:��¼'s ָ�깤�֣����property 
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
     * Object:��¼'s ��������property 
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
     * Object:��¼'s ����ǩ������property 
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
     * Object: ��¼ 's ָ����Ŀ property 
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
     * Object: ��¼ 's ������Ŀ property 
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
    public String getStopRsn()
    {
        return getString("stopRsn");
    }
    public void setStopRsn(String item)
    {
        setString("stopRsn", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("554601F5");
    }
}