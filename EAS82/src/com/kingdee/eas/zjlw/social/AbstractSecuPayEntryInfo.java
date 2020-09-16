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
     * Object: 分录 's 单据头 property 
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
     * Object:分录's 项目社保号property 
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
     * Object:分录's 属地化缴纳社保人数property 
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
     * Object:分录's 外工缴纳社保人数property 
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
     * Object:分录's 社保缴纳总人数property 
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
     * Object:分录's 外工缴纳社保金额property 
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
     * Object:分录's 属地化缴纳社保金额property 
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
     * Object:分录's 外工缴纳休假工资金额property 
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
     * Object:分录's 属地化缴纳休假工资金额property 
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
     * Object:分录's 社保休假工资总金额property 
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("05B61BCE");
    }
}