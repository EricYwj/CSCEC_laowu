package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAttencePersonInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractAttencePersonInfo()
    {
        this("id");
    }
    protected AbstractAttencePersonInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:外工考勤人员名单's 人员主键property 
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
     * Object:外工考勤人员名单's 性别property 
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
     * Object: 外工考勤人员名单 's 国籍 property 
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
     * Object: 外工考勤人员名单 's 合作单位 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getCooperationid()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("cooperationid");
    }
    public void setCooperationid(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("cooperationid", item);
    }
    /**
     * Object: 外工考勤人员名单 's 工作项目 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getWorkOrgId()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("workOrgId");
    }
    public void setWorkOrgId(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("workOrgId", item);
    }
    /**
     * Object: 外工考勤人员名单 's 考勤规则 property 
     */
    public com.kingdee.eas.zjlw.attendance.CheckRuleInfo getCheckRuleId()
    {
        return (com.kingdee.eas.zjlw.attendance.CheckRuleInfo)get("checkRuleId");
    }
    public void setCheckRuleId(com.kingdee.eas.zjlw.attendance.CheckRuleInfo item)
    {
        put("checkRuleId", item);
    }
    /**
     * Object:外工考勤人员名单's 考勤系统工号property 
     */
    public String getCheckNo()
    {
        return getString("CheckNo");
    }
    public void setCheckNo(String item)
    {
        setString("CheckNo", item);
    }
    /**
     * Object:外工考勤人员名单's 考勤系统部门编号property 
     */
    public String getCheckSysDepNo()
    {
        return getString("CheckSysDepNo");
    }
    public void setCheckSysDepNo(String item)
    {
        setString("CheckSysDepNo", item);
    }
    /**
     * Object:外工考勤人员名单's 身份证号property 
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
     * Object:外工考勤人员名单's 护照号码property 
     */
    public String getPasspNum()
    {
        return getString("passpNum");
    }
    public void setPasspNum(String item)
    {
        setString("passpNum", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("87F1141D");
    }
}