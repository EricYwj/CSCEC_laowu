package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractVabaweatherEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractVabaweatherEntryInfo()
    {
        this("id");
    }
    protected AbstractVabaweatherEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.social.VabaweatherInfo getParent()
    {
        return (com.kingdee.eas.zjlw.social.VabaweatherInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.social.VabaweatherInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 申报日期property 
     */
    public java.util.Date getRepoDate()
    {
        return getDate("repoDate");
    }
    public void setRepoDate(java.util.Date item)
    {
        setDate("repoDate", item);
    }
    /**
     * Object:分录's 复工日期property 
     */
    public java.util.Date getREDate()
    {
        return getDate("REDate");
    }
    public void setREDate(java.util.Date item)
    {
        setDate("REDate", item);
    }
    /**
     * Object:分录's 收款日期property 
     */
    public String getGetPayDate()
    {
        return getString("getPayDate");
    }
    public void setGetPayDate(String item)
    {
        setString("getPayDate", item);
    }
    /**
     * Object:分录's 金额property 
     */
    public java.math.BigDecimal getMoney()
    {
        return getBigDecimal("money");
    }
    public void setMoney(java.math.BigDecimal item)
    {
        setBigDecimal("money", item);
    }
    /**
     * Object:分录's 支票号property 
     */
    public String getCheckNum()
    {
        return getString("checkNum");
    }
    public void setCheckNum(String item)
    {
        setString("checkNum", item);
    }
    /**
     * Object:分录's 停工日期property 
     */
    public String getStopedDate()
    {
        return getString("stopedDate");
    }
    public void setStopedDate(String item)
    {
        setString("stopedDate", item);
    }
    /**
     * Object:分录's 事由property 
     */
    public com.kingdee.eas.zjlw.social.app.reasonEnum getReason()
    {
        return com.kingdee.eas.zjlw.social.app.reasonEnum.getEnum(getString("reason"));
    }
    public void setReason(com.kingdee.eas.zjlw.social.app.reasonEnum item)
    {
		if (item != null) {
        setString("reason", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C19862C8");
    }
}