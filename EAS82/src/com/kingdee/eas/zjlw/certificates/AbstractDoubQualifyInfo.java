package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDoubQualifyInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDoubQualifyInfo()
    {
        this("id");
    }
    protected AbstractDoubQualifyInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.certificates.DoubQualifyEntryCollection());
    }
    /**
     * Object: ˫��֤ 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.certificates.DoubQualifyEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.certificates.DoubQualifyEntryCollection)get("entrys");
    }
    /**
     * Object:˫��֤'s �Ƿ�����ƾ֤property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object:˫��֤'s ��ǩ���κ�property 
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
     * Object:˫��֤'s ���ʱ��property 
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
     * Object:˫��֤'s ����״̬property 
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
     * Object:˫��֤'s �ϸ��������ʱ��property 
     */
    public java.util.Date getLastaudTime()
    {
        return getDate("lastaudTime");
    }
    public void setLastaudTime(java.util.Date item)
    {
        setDate("lastaudTime", item);
    }
    /**
     * Object: ˫��֤ 's �ϸ������ύ�� property 
     */
    public com.kingdee.eas.base.permission.UserInfo getLsubmitor()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("lsubmitor");
    }
    public void setLsubmitor(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("lsubmitor", item);
    }
    /**
     * Object:˫��֤'s �Ƿ񲹰�property 
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
     * Object:˫��֤'s ��������property 
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
        return new BOSObjectType("2205ACE4");
    }
}