package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProjectWorkInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractProjectWorkInfo()
    {
        this("id");
    }
    protected AbstractProjectWorkInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:��Ŀ���ֿ�'s �Ƿ�����ƾ֤property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object:��Ŀ���ֿ�'s ��������property 
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
     * Object:��Ŀ���ֿ�'s ��������property 
     */
    public int getTotalAmount()
    {
        return getInt("totalAmount");
    }
    public void setTotalAmount(int item)
    {
        setInt("totalAmount", item);
    }
    /**
     * Object:��Ŀ���ֿ�'s ʹ������property 
     */
    public int getUseAmount()
    {
        return getInt("useAmount");
    }
    public void setUseAmount(int item)
    {
        setInt("useAmount", item);
    }
    /**
     * Object:��Ŀ���ֿ�'s ������Ч����property 
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
     * Object:��Ŀ���ֿ�'s ����ͣ������property 
     */
    public java.util.Date getEnddate()
    {
        return getDate("enddate");
    }
    public void setEnddate(java.util.Date item)
    {
        setDate("enddate", item);
    }
    /**
     * Object:��Ŀ���ֿ�'s ʣ������property 
     */
    public int getLeftAmount()
    {
        return getInt("leftAmount");
    }
    public void setLeftAmount(int item)
    {
        setInt("leftAmount", item);
    }
    /**
     * Object: ��Ŀ���ֿ� 's ������֯ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getProCom()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("proCom");
    }
    public void setProCom(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("proCom", item);
    }
    /**
     * Object:��Ŀ���ֿ�'s ��������(����)property 
     */
    public String getNameFR()
    {
        return getString("nameFR");
    }
    public void setNameFR(String item)
    {
        setString("nameFR", item);
    }
    /**
     * Object: ��Ŀ���ֿ� 's �������� property 
     */
    public com.kingdee.eas.zjlw.baseinfo.WorkTypeInfo getType()
    {
        return (com.kingdee.eas.zjlw.baseinfo.WorkTypeInfo)get("type");
    }
    public void setType(com.kingdee.eas.zjlw.baseinfo.WorkTypeInfo item)
    {
        put("type", item);
    }
    /**
     * Object:��Ŀ���ֿ�'s ��������property 
     */
    public java.math.BigDecimal getBasePay()
    {
        return getBigDecimal("basePay");
    }
    public void setBasePay(java.math.BigDecimal item)
    {
        setBigDecimal("basePay", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4E0AA91C");
    }
}