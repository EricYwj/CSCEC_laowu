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
     * Object: 分录 's 单据头 property 
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
     * Object:分录's 人员主键property 
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
     * Object:分录's 姓名property 
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
     * Object:分录's 身份证号property 
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
     * Object:分录's 性别property 
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
     * Object: 分录 's 国籍 property 
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
     * Object: 分录 's 合作单位 property 
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
     * Object: 分录 's 原工作项目 property 
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
     * Object: 分录 's 证件项目 property 
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
     * Object: 分录 's 现工作项目 property 
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
     * Object:分录's 变更日期property 
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
     * Object:分录's 生效日期property 
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
     * Object:分录's 备注property 
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