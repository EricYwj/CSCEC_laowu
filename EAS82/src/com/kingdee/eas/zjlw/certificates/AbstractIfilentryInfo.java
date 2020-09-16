package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractIfilentryInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractIfilentryInfo()
    {
        this("id");
    }
    protected AbstractIfilentryInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.certificates.IfilentryEntryCollection());
    }
    /**
     * Object: Υ���뾳 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.certificates.IfilentryEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.certificates.IfilentryEntryCollection)get("entrys");
    }
    /**
     * Object:Υ���뾳's ���ʱ��property 
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
     * Object:Υ���뾳's ����״̬property 
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
     * Object:Υ���뾳's ��ǩ���κ�property 
     */
    public String getContbNum()
    {
        return getString("contbNum");
    }
    public void setContbNum(String item)
    {
        setString("contbNum", item);
    }
    /**
     * Object: Υ���뾳 's ������������� property 
     */
    public com.kingdee.eas.base.permission.UserInfo getLeaAuditor()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("leaAuditor");
    }
    public void setLeaAuditor(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("leaAuditor", item);
    }
    /**
     * Object:Υ���뾳's �����������ʱ��property 
     */
    public java.util.Date getLeaAudDate()
    {
        return getDate("leaAudDate");
    }
    public void setLeaAudDate(java.util.Date item)
    {
        setDate("leaAudDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8E28A641");
    }
}