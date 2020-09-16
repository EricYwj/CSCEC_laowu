package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCooprationEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCooprationEntryInfo()
    {
        this("id");
    }
    protected AbstractCooprationEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.CooprationInfo getParent()
    {
        return (com.kingdee.eas.zjlw.baseinfo.CooprationInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.baseinfo.CooprationInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6CAD1554");
    }
}