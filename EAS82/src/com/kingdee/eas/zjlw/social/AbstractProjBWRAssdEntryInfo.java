package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProjBWRAssdEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractProjBWRAssdEntryInfo()
    {
        this("id");
    }
    protected AbstractProjBWRAssdEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.social.ProjBWRAssdInfo getParent()
    {
        return (com.kingdee.eas.zjlw.social.ProjBWRAssdInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.social.ProjBWRAssdInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 分摊组织 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getApportion()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("apportion");
    }
    public void setApportion(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("apportion", item);
    }
    /**
     * Object: 分录 's 分摊组织代码 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getSharOrgnation()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("sharOrgnation");
    }
    public void setSharOrgnation(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("sharOrgnation", item);
    }
    /**
     * Object:分录's 恶劣天气返还人数property 
     */
    public int getWthReturnNum()
    {
        return getInt("wthReturnNum");
    }
    public void setWthReturnNum(int item)
    {
        setInt("wthReturnNum", item);
    }
    /**
     * Object:分录's 恶劣天气返还总金额property 
     */
    public java.math.BigDecimal getWthReturnCount()
    {
        return getBigDecimal("wthReturnCount");
    }
    public void setWthReturnCount(java.math.BigDecimal item)
    {
        setBigDecimal("wthReturnCount", item);
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
        return new BOSObjectType("F7C546AF");
    }
}