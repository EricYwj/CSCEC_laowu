package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractApEcInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractApEcInfo()
    {
        this("id");
    }
    protected AbstractApEcInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.certificates.ApEcEntryCollection());
    }
    /**
     * Object: ���뻤�շ���-�༭���� 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.certificates.ApEcEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.certificates.ApEcEntryCollection)get("entrys");
    }
    /**
     * Object:���뻤�շ���-�༭����'s ���ʱ��property 
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
     * Object:���뻤�շ���-�༭����'s ����״̬property 
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6FD13AFE");
    }
}