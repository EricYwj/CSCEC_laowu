package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProfDpInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractProfDpInfo()
    {
        this("id");
    }
    protected AbstractProfDpInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ���ֿ� 's ��� property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProfDpTreeInfo getTreeid()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProfDpTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.zjlw.baseinfo.ProfDpTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:���ֿ�'s ���ʱ�׼property 
     */
    public java.math.BigDecimal getWageStandard()
    {
        return getBigDecimal("wageStandard");
    }
    public void setWageStandard(java.math.BigDecimal item)
    {
        setBigDecimal("wageStandard", item);
    }
    /**
     * Object:���ֿ�'s ��������property 
     */
    public java.util.Date getStartDate()
    {
        return getDate("startDate");
    }
    public void setStartDate(java.util.Date item)
    {
        setDate("startDate", item);
    }
    /**
     * Object:���ֿ�'s �Ƿ����property 
     */
    public boolean isIsForbidden()
    {
        return getBoolean("isForbidden");
    }
    public void setIsForbidden(boolean item)
    {
        setBoolean("isForbidden", item);
    }
    /**
     * Object:���ֿ�'s ��������property 
     */
    public java.util.Date getForbDate()
    {
        return getDate("forbDate");
    }
    public void setForbDate(java.util.Date item)
    {
        setDate("forbDate", item);
    }
    /**
     * Object:���ֿ�'s ��Ա����property 
     */
    public java.math.BigDecimal getAllocation()
    {
        return getBigDecimal("allocation");
    }
    public void setAllocation(java.math.BigDecimal item)
    {
        setBigDecimal("allocation", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("63421733");
    }
}