package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProjectOrgEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractProjectOrgEntryInfo()
    {
        this("id");
    }
    protected AbstractProjectOrgEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo getParent()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.baseinfo.ProjectOrgInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D318FC79");
    }
}