package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAttenceDataInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractAttenceDataInfo()
    {
        this("id");
    }
    protected AbstractAttenceDataInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:��������'s ����ϵͳ���ű���property 
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
     * Object:��������'s ����property 
     */
    public java.util.Date getDate()
    {
        return getDate("date");
    }
    public void setDate(java.util.Date item)
    {
        setDate("date", item);
    }
    /**
     * Object:��������'s ��ʱ��property 
     */
    public java.sql.Time getCheckTime()
    {
        return getTime("checkTime");
    }
    public void setCheckTime(java.sql.Time item)
    {
        setTime("checkTime", item);
    }
    /**
     * Object:��������'s ���ڻ����property 
     */
    public String getCheckMachineNo()
    {
        return getString("checkMachineNo");
    }
    public void setCheckMachineNo(String item)
    {
        setString("checkMachineNo", item);
    }
    /**
     * Object:��������'s ���ڿ���property 
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
     * Object: �������� 's ������Ŀ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getProCom()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("proCom");
    }
    public void setProCom(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("proCom", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3853FA72");
    }
}