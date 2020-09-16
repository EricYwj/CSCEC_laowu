package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractForiPersInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractForiPersInfo()
    {
        this("id");
    }
    protected AbstractForiPersInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.attendance.ForiPersEntryCollection());
    }
    /**
     * Object: �⹤������Ա���� 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.attendance.ForiPersEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.attendance.ForiPersEntryCollection)get("entrys");
    }
    /**
     * Object:�⹤������Ա����'s �Ƿ�����ƾ֤property 
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
     * Object: �⹤������Ա���� 's ������Ŀ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getPermitOrg()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("permitOrg");
    }
    public void setPermitOrg(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("permitOrg", item);
    }
    /**
     * Object:�⹤������Ա����'s ����״̬property 
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
     * Object:�⹤������Ա����'s �������property 
     */
    public java.util.Date getAuditDate()
    {
        return getDate("AuditDate");
    }
    public void setAuditDate(java.util.Date item)
    {
        setDate("AuditDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1B33F59A");
    }
}