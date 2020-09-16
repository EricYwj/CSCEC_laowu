package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAlgAttEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractAlgAttEntryInfo()
    {
        this("id");
    }
    protected AbstractAlgAttEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.zjlw.attendance.AlgAttInfo getParent()
    {
        return (com.kingdee.eas.zjlw.attendance.AlgAttInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.attendance.AlgAttInfo item)
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
     * Object:��¼'s �ٵ�����ʱ��(����)property 
     */
    public int getNoWorkTime()
    {
        return getInt("noWorkTime");
    }
    public void setNoWorkTime(int item)
    {
        setInt("noWorkTime", item);
    }
    /**
     * Object:��¼'s �ڼ��ռӰ�(Сʱ)property 
     */
    public java.math.BigDecimal getHoOverTime()
    {
        return getBigDecimal("hoOverTime");
    }
    public void setHoOverTime(java.math.BigDecimal item)
    {
        setBigDecimal("hoOverTime", item);
    }
    /**
     * Object:��¼'s �Ӱ�ʱ��(Сʱ)property 
     */
    public java.math.BigDecimal getOverTime()
    {
        return getBigDecimal("overTime");
    }
    public void setOverTime(java.math.BigDecimal item)
    {
        setBigDecimal("overTime", item);
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
    /**
     * Object:��¼'s �ٵ�����ʱ��(����)property 
     */
    public int getCnoWorkTime()
    {
        return getInt("CnoWorkTime");
    }
    public void setCnoWorkTime(int item)
    {
        setInt("CnoWorkTime", item);
    }
    /**
     * Object:��¼'s �Ӱ�ʱ��(Сʱ)property 
     */
    public java.math.BigDecimal getCoverTime()
    {
        return getBigDecimal("CoverTime");
    }
    public void setCoverTime(java.math.BigDecimal item)
    {
        setBigDecimal("CoverTime", item);
    }
    /**
     * Object:��¼'s �ڼ��ռӰ�(Сʱ)property 
     */
    public java.math.BigDecimal getChoOverTime()
    {
        return getBigDecimal("ChoOverTime");
    }
    public void setChoOverTime(java.math.BigDecimal item)
    {
        setBigDecimal("ChoOverTime", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.math.BigDecimal getWorkDay()
    {
        return getBigDecimal("workDay");
    }
    public void setWorkDay(java.math.BigDecimal item)
    {
        setBigDecimal("workDay", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.math.BigDecimal getCworkDay()
    {
        return getBigDecimal("CworkDay");
    }
    public void setCworkDay(java.math.BigDecimal item)
    {
        setBigDecimal("CworkDay", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public int getTraDays()
    {
        return getInt("traDays");
    }
    public void setTraDays(int item)
    {
        setInt("traDays", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public int getCtraDays()
    {
        return getInt("CtraDays");
    }
    public void setCtraDays(int item)
    {
        setInt("CtraDays", item);
    }
    /**
     * Object:��¼'s ������������property 
     */
    public int getCchkNormal()
    {
        return getInt("CchkNormal");
    }
    public void setCchkNormal(int item)
    {
        setInt("CchkNormal", item);
    }
    /**
     * Object:��¼'s ������������property 
     */
    public int getChcNormal()
    {
        return getInt("chcNormal");
    }
    public void setChcNormal(int item)
    {
        setInt("chcNormal", item);
    }
    /**
     * Object:��¼'s ����ȱ������property 
     */
    public int getChkDis()
    {
        return getInt("chkDis");
    }
    public void setChkDis(int item)
    {
        setInt("chkDis", item);
    }
    /**
     * Object:��¼'s ����ȱ������property 
     */
    public int getCchkDis()
    {
        return getInt("CchkDis");
    }
    public void setCchkDis(int item)
    {
        setInt("CchkDis", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("CB9CB3C9");
    }
}