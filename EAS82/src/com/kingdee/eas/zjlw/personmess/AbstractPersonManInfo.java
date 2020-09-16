package com.kingdee.eas.zjlw.personmess;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPersonManInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractPersonManInfo()
    {
        this("id");
    }
    protected AbstractPersonManInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.personmess.PersonManEntryCollection());
    }
    /**
     * Object: 人员合同管理 's 分录 property 
     */
    public com.kingdee.eas.zjlw.personmess.PersonManEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.personmess.PersonManEntryCollection)get("entrys");
    }
    /**
     * Object:人员合同管理's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7CBAA965");
    }
}