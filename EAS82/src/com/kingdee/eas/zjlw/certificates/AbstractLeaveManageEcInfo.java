package com.kingdee.eas.zjlw.certificates;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLeaveManageEcInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractLeaveManageEcInfo()
    {
        this("id");
    }
    protected AbstractLeaveManageEcInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.certificates.LeaveManageEcEntryCollection());
    }
    /**
     * Object: �뾳����-�༭���� 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.certificates.LeaveManageEcEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.certificates.LeaveManageEcEntryCollection)get("entrys");
    }
    /**
     * Object:�뾳����-�༭����'s �������property 
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
     * Object:�뾳����-�༭����'s ����״̬property 
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
     * Object:�뾳����-�༭����'s ��ǩ���κ�property 
     */
    public String getBNum()
    {
        return getString("bNum");
    }
    public void setBNum(String item)
    {
        setString("bNum", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AF777209");
    }
}