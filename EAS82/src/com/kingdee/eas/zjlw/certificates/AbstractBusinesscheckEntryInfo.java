package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBusinesscheckEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBusinesscheckEntryInfo()
    {
        this("id");
    }
    protected AbstractBusinesscheckEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.certificates.BusinesscheckInfo getParent()
    {
        return (com.kingdee.eas.zjlw.certificates.BusinesscheckInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.certificates.BusinesscheckInfo item)
    {
        put("parent", item);
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
     * Object:分录's 性别property 
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
     * Object:分录's 护照号property 
     */
    public String getPassNo()
    {
        return getString("passNo");
    }
    public void setPassNo(String item)
    {
        setString("passNo", item);
    }
    /**
     * Object:分录's 护照签发日期property 
     */
    public java.util.Date getPaIssueDate()
    {
        return getDate("paIssueDate");
    }
    public void setPaIssueDate(java.util.Date item)
    {
        setDate("paIssueDate", item);
    }
    /**
     * Object:分录's 护照失效日期property 
     */
    public java.util.Date getPaExpDate()
    {
        return getDate("paExpDate");
    }
    public void setPaExpDate(java.util.Date item)
    {
        setDate("paExpDate", item);
    }
    /**
     * Object: 分录 's 合作单位 property 
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
     * Object: 分录 's 办理项目 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getHaProject()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("haProject");
    }
    public void setHaProject(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("haProject", item);
    }
    /**
     * Object: 分录 's 工作项目 property 
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
     * Object:分录's 签证签发日期property 
     */
    public java.util.Date getViIssueDate()
    {
        return getDate("viIssueDate");
    }
    public void setViIssueDate(java.util.Date item)
    {
        setDate("viIssueDate", item);
    }
    /**
     * Object:分录's 签证到期日期property 
     */
    public java.util.Date getVidueDate()
    {
        return getDate("vidueDate");
    }
    public void setVidueDate(java.util.Date item)
    {
        setDate("vidueDate", item);
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
    /**
     * Object: 分录 's 国籍 property 
     */
    public com.kingdee.eas.basedata.assistant.CountryInfo getCountry()
    {
        return (com.kingdee.eas.basedata.assistant.CountryInfo)get("country");
    }
    public void setCountry(com.kingdee.eas.basedata.assistant.CountryInfo item)
    {
        put("country", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("25469C1B");
    }
}