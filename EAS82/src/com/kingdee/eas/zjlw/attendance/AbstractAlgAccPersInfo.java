package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAlgAccPersInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractAlgAccPersInfo()
    {
        this("id");
    }
    protected AbstractAlgAccPersInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:����������Ա����'s �Ա�property 
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
     * Object: ����������Ա���� 's ������Ŀ property 
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
     * Object:����������Ա����'s ����ϵͳ���ű��property 
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
     * Object:����������Ա����'s �籣��property 
     */
    public String getSecuNum()
    {
        return getString("secuNum");
    }
    public void setSecuNum(String item)
    {
        setString("secuNum", item);
    }
    /**
     * Object: ����������Ա���� 's ���ڹ��� property 
     */
    public com.kingdee.eas.zjlw.attendance.AlgCheckRulesInfo getCheckRule()
    {
        return (com.kingdee.eas.zjlw.attendance.AlgCheckRulesInfo)get("checkRule");
    }
    public void setCheckRule(com.kingdee.eas.zjlw.attendance.AlgCheckRulesInfo item)
    {
        put("checkRule", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("016A8E9F");
    }
}