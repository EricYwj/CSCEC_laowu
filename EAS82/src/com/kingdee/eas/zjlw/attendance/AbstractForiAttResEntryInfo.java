package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractForiAttResEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractForiAttResEntryInfo()
    {
        this("id");
    }
    protected AbstractForiAttResEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.zjlw.attendance.ForiAttResInfo getParent()
    {
        return (com.kingdee.eas.zjlw.attendance.ForiAttResInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.attendance.ForiAttResInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s ��Ա����property 
     */
    public String getPersonId()
    {
        return getString("personId");
    }
    public void setPersonId(String item)
    {
        setString("personId", item);
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
     * Object:��¼'s ���ڽ��property 
     */
    public com.kingdee.eas.zjlw.attendance.app.checkResultEnum getAlgResult()
    {
        return com.kingdee.eas.zjlw.attendance.app.checkResultEnum.getEnum(getString("algResult"));
    }
    public void setAlgResult(com.kingdee.eas.zjlw.attendance.app.checkResultEnum item)
    {
		if (item != null) {
        setString("algResult", item.getValue());
		}
    }
    /**
     * Object:��¼'s ���֤��property 
     */
    public String getIDNum()
    {
        return getString("IDNum");
    }
    public void setIDNum(String item)
    {
        setString("IDNum", item);
    }
    /**
     * Object:��¼'s ���պ�property 
     */
    public String getPsspNum()
    {
        return getString("psspNum");
    }
    public void setPsspNum(String item)
    {
        setString("psspNum", item);
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
    public String getCooperationid()
    {
        return getString("cooperationid");
    }
    public void setCooperationid(String item)
    {
        setString("cooperationid", item);
    }
    /**
     * Object: ��¼ 's ָ�깤�� property 
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
        return new BOSObjectType("754F6E4F");
    }
}