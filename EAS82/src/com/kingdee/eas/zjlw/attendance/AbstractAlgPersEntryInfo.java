package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAlgPersEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractAlgPersEntryInfo()
    {
        this("id");
    }
    protected AbstractAlgPersEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.attendance.AlgPersInfo getParent()
    {
        return (com.kingdee.eas.zjlw.attendance.AlgPersInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.attendance.AlgPersInfo item)
    {
        put("parent", item);
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
     * Object: 分录 's 合作单位 property 
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
     * Object:分录's 合作单位代码property 
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
     * Object:分录's 人员编码property 
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
     * Object: 分录 's 考勤规则 property 
     */
    public com.kingdee.eas.zjlw.attendance.AlgCheckRulesInfo getCheckRuleId()
    {
        return (com.kingdee.eas.zjlw.attendance.AlgCheckRulesInfo)get("checkRuleId");
    }
    public void setCheckRuleId(com.kingdee.eas.zjlw.attendance.AlgCheckRulesInfo item)
    {
        put("checkRuleId", item);
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2438A4A4");
    }
}