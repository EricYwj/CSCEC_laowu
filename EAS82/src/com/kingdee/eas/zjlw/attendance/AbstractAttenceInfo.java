package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAttenceInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractAttenceInfo()
    {
        this("id");
    }
    protected AbstractAttenceInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.attendance.AttenceEntryCollection());
    }
    /**
     * Object: �⹤�������� 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.attendance.AttenceEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.attendance.AttenceEntryCollection)get("entrys");
    }
    /**
     * Object:�⹤��������'s �Ƿ�����ƾ֤property 
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
     * Object: �⹤�������� 's ������Ŀ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getProCom()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("proCom");
    }
    public void setProCom(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("proCom", item);
    }
    /**
     * Object:�⹤��������'s ���ʱ��property 
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
     * Object:�⹤��������'s ����״̬property 
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
        return new BOSObjectType("53992AA8");
    }
}