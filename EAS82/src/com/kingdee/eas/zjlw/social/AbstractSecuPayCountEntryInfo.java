package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSecuPayCountEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSecuPayCountEntryInfo()
    {
        this("id");
    }
    protected AbstractSecuPayCountEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.social.SecuPayCountInfo getParent()
    {
        return (com.kingdee.eas.zjlw.social.SecuPayCountInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.social.SecuPayCountInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 社保支票号property 
     */
    public String getSecuChNum()
    {
        return getString("secuChNum");
    }
    public void setSecuChNum(String item)
    {
        setString("secuChNum", item);
    }
    /**
     * Object:分录's 社保缴纳金额property 
     */
    public java.math.BigDecimal getSecuPay()
    {
        return getBigDecimal("secuPay");
    }
    public void setSecuPay(java.math.BigDecimal item)
    {
        setBigDecimal("secuPay", item);
    }
    /**
     * Object:分录's 休假工资支票号property 
     */
    public String getVcPayChNum()
    {
        return getString("vcPayChNum");
    }
    public void setVcPayChNum(String item)
    {
        setString("vcPayChNum", item);
    }
    /**
     * Object:分录's 休假工资缴纳总金额property 
     */
    public java.math.BigDecimal getVcPayMoney()
    {
        return getBigDecimal("vcPayMoney");
    }
    public void setVcPayMoney(java.math.BigDecimal item)
    {
        setBigDecimal("vcPayMoney", item);
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
     * Object: 分录 's 项目名称 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getProjName()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("projName");
    }
    public void setProjName(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("projName", item);
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
     * Object:分录's 社保支票账户property 
     */
    public String getSeceAcc()
    {
        return getString("seceAcc");
    }
    public void setSeceAcc(String item)
    {
        setString("seceAcc", item);
    }
    /**
     * Object:分录's 社保支票会签人property 
     */
    public String getSecuSinger()
    {
        return getString("secuSinger");
    }
    public void setSecuSinger(String item)
    {
        setString("secuSinger", item);
    }
    /**
     * Object:分录's 社保总人数property 
     */
    public String getSecuCount()
    {
        return getString("secuCount");
    }
    public void setSecuCount(String item)
    {
        setString("secuCount", item);
    }
    /**
     * Object:分录's 休假工资支票账户property 
     */
    public String getVcAcc()
    {
        return getString("vcAcc");
    }
    public void setVcAcc(String item)
    {
        setString("vcAcc", item);
    }
    /**
     * Object:分录's 休假工资支票会签人property 
     */
    public String getVcSinger()
    {
        return getString("vcSinger");
    }
    public void setVcSinger(String item)
    {
        setString("vcSinger", item);
    }
    /**
     * Object:分录's 社保和休假缴纳总金额property 
     */
    public java.math.BigDecimal getScvcPay()
    {
        return getBigDecimal("scvcPay");
    }
    public void setScvcPay(java.math.BigDecimal item)
    {
        setBigDecimal("scvcPay", item);
    }
    /**
     * Object:分录's 项目所在省份property 
     */
    public String getProjPrev()
    {
        return getString("projPrev");
    }
    public void setProjPrev(String item)
    {
        setString("projPrev", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C9DABEC7");
    }
}