package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAlgAttDataEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractAlgAttDataEntryInfo()
    {
        this("id");
    }
    protected AbstractAlgAttDataEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.zjlw.attendance.AlgAttDataInfo getParent()
    {
        return (com.kingdee.eas.zjlw.attendance.AlgAttDataInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.attendance.AlgAttDataInfo item)
    {
        put("parent", item);
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
     * Object:��¼'s ��Ա���property 
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
     * Object:��¼'s �����ϰ�ʱ��property 
     */
    public java.sql.Time getAmOnDuty()
    {
        return getTime("amOnDuty");
    }
    public void setAmOnDuty(java.sql.Time item)
    {
        setTime("amOnDuty", item);
    }
    /**
     * Object:��¼'s �����°�ʱ��property 
     */
    public java.sql.Time getAmOutDuty()
    {
        return getTime("amOutDuty");
    }
    public void setAmOutDuty(java.sql.Time item)
    {
        setTime("amOutDuty", item);
    }
    /**
     * Object:��¼'s �����ϰ�ʱ��property 
     */
    public java.sql.Time getPmOnDuty()
    {
        return getTime("pmOnDuty");
    }
    public void setPmOnDuty(java.sql.Time item)
    {
        setTime("pmOnDuty", item);
    }
    /**
     * Object:��¼'s �����°�ʱ��property 
     */
    public java.sql.Time getPmOutDuty()
    {
        return getTime("pmOutDuty");
    }
    public void setPmOutDuty(java.sql.Time item)
    {
        setTime("pmOutDuty", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.util.Date getAttDate()
    {
        return getDate("attDate");
    }
    public void setAttDate(java.util.Date item)
    {
        setDate("attDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("88BC8ABF");
    }
}