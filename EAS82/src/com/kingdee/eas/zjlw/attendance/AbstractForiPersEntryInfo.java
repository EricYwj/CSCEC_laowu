package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractForiPersEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractForiPersEntryInfo()
    {
        this("id");
    }
    protected AbstractForiPersEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.zjlw.attendance.ForiPersInfo getParent()
    {
        return (com.kingdee.eas.zjlw.attendance.ForiPersInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.attendance.ForiPersInfo item)
    {
        put("parent", item);
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
     * Object:��¼'s ������λ����property 
     */
    public String getCooperationId()
    {
        return getString("cooperationId");
    }
    public void setCooperationId(String item)
    {
        setString("cooperationId", item);
    }
    /**
     * Object: ��¼ 's ���� property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo getProf()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo)get("prof");
    }
    public void setProf(com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo item)
    {
        put("prof", item);
    }
    /**
     * Object:��¼'s ��ԱIDproperty 
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
    public com.kingdee.eas.basedata.assistant.CountryInfo getCountry()
    {
        return (com.kingdee.eas.basedata.assistant.CountryInfo)get("country");
    }
    public void setCountry(com.kingdee.eas.basedata.assistant.CountryInfo item)
    {
        put("country", item);
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
    public String getPasspNum()
    {
        return getString("passpNum");
    }
    public void setPasspNum(String item)
    {
        setString("passpNum", item);
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
     * Object: ��¼ 's ���ڹ��� property 
     */
    public com.kingdee.eas.zjlw.attendance.ForiAttRuleInfo getCheckRuleId()
    {
        return (com.kingdee.eas.zjlw.attendance.ForiAttRuleInfo)get("checkRuleId");
    }
    public void setCheckRuleId(com.kingdee.eas.zjlw.attendance.ForiAttRuleInfo item)
    {
        put("checkRuleId", item);
    }
    /**
     * Object:��¼'s ʵ�ʹ���property 
     */
    public String getRealProf()
    {
        return getString("realProf");
    }
    public void setRealProf(String item)
    {
        setString("realProf", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0AC792F8");
    }
}