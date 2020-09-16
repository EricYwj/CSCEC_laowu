package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBusinesscheckInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBusinesscheckInfo()
    {
        this("id");
    }
    protected AbstractBusinesscheckInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.certificates.BusinesscheckEntryCollection());
    }
    /**
     * Object: ����ǩ���� 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.certificates.BusinesscheckEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.certificates.BusinesscheckEntryCollection)get("entrys");
    }
    /**
     * Object:����ǩ����'s �Ƿ�����ƾ֤property 
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
     * Object:����ǩ����'s �������property 
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
     * Object:����ǩ����'s ����״̬property 
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
        return new BOSObjectType("9E268297");
    }
}