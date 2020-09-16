package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEpEcInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractEpEcInfo()
    {
        this("id");
    }
    protected AbstractEpEcInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.certificates.EpEcEntryCollection());
    }
    /**
     * Object: ʹ��ע��-�༭���� 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.certificates.EpEcEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.certificates.EpEcEntryCollection)get("entrys");
    }
    /**
     * Object:ʹ��ע��-�༭����'s ���ʱ��property 
     */
    public java.util.Date getAuditDate()
    {
        return getDate("auditDate");
    }
    public void setAuditDate(java.util.Date item)
    {
        setDate("auditDate", item);
    }
    /**
     * Object:ʹ��ע��-�༭����'s ����״̬property 
     */
    public com.kingdee.eas.zjlw.certificates.app.BillStateEnum getBillSate()
    {
        return com.kingdee.eas.zjlw.certificates.app.BillStateEnum.getEnum(getString("billSate"));
    }
    public void setBillSate(com.kingdee.eas.zjlw.certificates.app.BillStateEnum item)
    {
		if (item != null) {
        setString("billSate", item.getValue());
		}
    }
    /**
     * Object:ʹ��ע��-�༭����'s ��ǩ���κ�property 
     */
    public String getBNum()
    {
        return getString("bNum");
    }
    public void setBNum(String item)
    {
        setString("bNum", item);
    }
    /**
     * Object:ʹ��ע��-�༭����'s �Ƿ񲹰�property 
     */
    public boolean isIfNeed()
    {
        return getBoolean("ifNeed");
    }
    public void setIfNeed(boolean item)
    {
        setBoolean("ifNeed", item);
    }
    /**
     * Object:ʹ��ע��-�༭����'s ��������property 
     */
    public String getNeedReson()
    {
        return getString("needReson");
    }
    public void setNeedReson(String item)
    {
        setString("needReson", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6FD30C7A");
    }
}