package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWorkOrgChangeEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractWorkOrgChangeEntryInfo()
    {
        this("id");
    }
    protected AbstractWorkOrgChangeEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.zjlw.attendance.WorkOrgChangeInfo getParent()
    {
        return (com.kingdee.eas.zjlw.attendance.WorkOrgChangeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.attendance.WorkOrgChangeInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s ��Ա����property 
     */
    public String getPersonid()
    {
        return getString("personid");
    }
    public void setPersonid(String item)
    {
        setString("personid", item);
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
        return getString("idNum");
    }
    public void setIdNum(String item)
    {
        setString("idNum", item);
    }
    /**
     * Object:��¼'s �Ա�property 
     */
    public com.kingdee.eas.basedata.person.Genders getSex()
    {
        return com.kingdee.eas.basedata.person.Genders.getEnum(getInt("Sex"));
    }
    public void setSex(com.kingdee.eas.basedata.person.Genders item)
    {
		if (item != null) {
        setInt("Sex", item.getValue());
		}
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
     * Object: ��¼ 's ������λ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getCooperationId()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("cooperationId");
    }
    public void setCooperationId(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("cooperationId", item);
    }
    /**
     * Object: ��¼ 's ԭ������Ŀ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getOldWorkOrgId()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("oldWorkOrgId");
    }
    public void setOldWorkOrgId(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("oldWorkOrgId", item);
    }
    /**
     * Object: ��¼ 's ֤����Ŀ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getPermitOrgId()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("permitOrgId");
    }
    public void setPermitOrgId(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("permitOrgId", item);
    }
    /**
     * Object: ��¼ 's �ֹ�����Ŀ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getNewWorkOrgId()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("newWorkOrgId");
    }
    public void setNewWorkOrgId(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("newWorkOrgId", item);
    }
    /**
     * Object:��¼'s �������property 
     */
    public java.util.Date getChangeDate()
    {
        return getDate("changeDate");
    }
    public void setChangeDate(java.util.Date item)
    {
        setDate("changeDate", item);
    }
    /**
     * Object:��¼'s ��Ч����property 
     */
    public java.util.Date getEffectDate()
    {
        return getDate("effectDate");
    }
    public void setEffectDate(java.util.Date item)
    {
        setDate("effectDate", item);
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2C46B353");
    }
}