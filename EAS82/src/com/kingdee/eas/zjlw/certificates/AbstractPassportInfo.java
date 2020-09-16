package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPassportInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractPassportInfo()
    {
        this("id");
    }
    protected AbstractPassportInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.certificates.PassportEntryCollection());
    }
    /**
     * Object: ���շ��� 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.certificates.PassportEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.certificates.PassportEntryCollection)get("entrys");
    }
    /**
     * Object:���շ���'s �Ƿ�����ƾ֤property 
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
        return new BOSObjectType("AAE8B163");
    }
}