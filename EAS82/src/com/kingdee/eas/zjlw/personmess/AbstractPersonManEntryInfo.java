package com.kingdee.eas.zjlw.personmess;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPersonManEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractPersonManEntryInfo()
    {
        this("id");
    }
    protected AbstractPersonManEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.personmess.PersonManInfo getParent()
    {
        return (com.kingdee.eas.zjlw.personmess.PersonManInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.personmess.PersonManInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7AE0860D");
    }
}