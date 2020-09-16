package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWorkPmtInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractWorkPmtInfo()
    {
        this("id");
    }
    protected AbstractWorkPmtInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.certificates.WorkPmtEntryCollection());
    }
    /**
     * Object: �Ͷ�֤���� 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.certificates.WorkPmtEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.certificates.WorkPmtEntryCollection)get("entrys");
    }
    /**
     * Object:�Ͷ�֤����'s ��ǩ���κ�property 
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
     * Object:�Ͷ�֤����'s ���ʱ��property 
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
     * Object:�Ͷ�֤����'s ����״̬property 
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
        return new BOSObjectType("D9F339D5");
    }
}