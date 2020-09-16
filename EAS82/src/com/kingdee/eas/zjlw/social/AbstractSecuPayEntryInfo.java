package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSecuPayEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSecuPayEntryInfo()
    {
        this("id");
    }
    protected AbstractSecuPayEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.zjlw.social.SecuPayInfo getParent()
    {
        return (com.kingdee.eas.zjlw.social.SecuPayInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.social.SecuPayInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s ��Ŀ�籣��property 
     */
    public String getProjSCNum()
    {
        return getString("projSCNum");
    }
    public void setProjSCNum(String item)
    {
        setString("projSCNum", item);
    }
    /**
     * Object:��¼'s ���ػ������籣����property 
     */
    public int getAlgScCount()
    {
        return getInt("algScCount");
    }
    public void setAlgScCount(int item)
    {
        setInt("algScCount", item);
    }
    /**
     * Object:��¼'s �⹤�����籣����property 
     */
    public int getForiScCount()
    {
        return getInt("foriScCount");
    }
    public void setForiScCount(int item)
    {
        setInt("foriScCount", item);
    }
    /**
     * Object:��¼'s �籣����������property 
     */
    public int getSecuCount()
    {
        return getInt("secuCount");
    }
    public void setSecuCount(int item)
    {
        setInt("secuCount", item);
    }
    /**
     * Object:��¼'s �⹤�����籣���property 
     */
    public java.math.BigDecimal getForiScMoney()
    {
        return getBigDecimal("foriScMoney");
    }
    public void setForiScMoney(java.math.BigDecimal item)
    {
        setBigDecimal("foriScMoney", item);
    }
    /**
     * Object:��¼'s ���ػ������籣���property 
     */
    public java.math.BigDecimal getAlgScMoney()
    {
        return getBigDecimal("algScMoney");
    }
    public void setAlgScMoney(java.math.BigDecimal item)
    {
        setBigDecimal("algScMoney", item);
    }
    /**
     * Object:��¼'s �⹤�����ݼٹ��ʽ��property 
     */
    public java.math.BigDecimal getForiVcMoney()
    {
        return getBigDecimal("foriVcMoney");
    }
    public void setForiVcMoney(java.math.BigDecimal item)
    {
        setBigDecimal("foriVcMoney", item);
    }
    /**
     * Object:��¼'s ���ػ������ݼٹ��ʽ��property 
     */
    public java.math.BigDecimal getAlgVcMoney()
    {
        return getBigDecimal("algVcMoney");
    }
    public void setAlgVcMoney(java.math.BigDecimal item)
    {
        setBigDecimal("algVcMoney", item);
    }
    /**
     * Object:��¼'s �籣�ݼٹ����ܽ��property 
     */
    public java.math.BigDecimal getScVcCount()
    {
        return getBigDecimal("scVcCount");
    }
    public void setScVcCount(java.math.BigDecimal item)
    {
        setBigDecimal("scVcCount", item);
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("05B61BCE");
    }
}