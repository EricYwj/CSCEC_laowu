package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractExLivepermitECInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractExLivepermitECInfo()
    {
        this("id");
    }
    protected AbstractExLivepermitECInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.certificates.ExLivepermitECEntryCollection());
    }
    /**
     * Object: ��ס֤����-�༭���� 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.certificates.ExLivepermitECEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.certificates.ExLivepermitECEntryCollection)get("entrys");
    }
    /**
     * Object:��ס֤����-�༭����'s ��ǩ֤���κ�property 
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
     * Object:��ס֤����-�༭����'s �������property 
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
     * Object:��ס֤����-�༭����'s ����״̬property 
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
        return new BOSObjectType("0BAE07C9");
    }
}