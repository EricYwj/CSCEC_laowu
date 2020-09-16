package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractASCancelInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractASCancelInfo()
    {
        this("id");
    }
    protected AbstractASCancelInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.certificates.ASCancelEntryCollection());
    }
    /**
     * Object: ��ǩͣ����Ա 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.certificates.ASCancelEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.certificates.ASCancelEntryCollection)get("entrys");
    }
    /**
     * Object:��ǩͣ����Ա's ��ǩ���κ�property 
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
     * Object:��ǩͣ����Ա's ���ʱ��property 
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
     * Object:��ǩͣ����Ա's ����״̬property 
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
     * Object:��ǩͣ����Ա's �ϸ��������ʱ��property 
     */
    public java.util.Date getLSubtime()
    {
        return getDate("lSubtime");
    }
    public void setLSubtime(java.util.Date item)
    {
        setDate("lSubtime", item);
    }
    /**
     * Object: ��ǩͣ����Ա 's ��һ��������� property 
     */
    public com.kingdee.eas.base.permission.UserInfo getISubmitor()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("ISubmitor");
    }
    public void setISubmitor(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("ISubmitor", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5D38767D");
    }
}