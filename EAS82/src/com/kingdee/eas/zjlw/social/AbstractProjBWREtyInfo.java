package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProjBWREtyInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractProjBWREtyInfo()
    {
        this("id");
    }
    protected AbstractProjBWREtyInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.social.ProjBWREtyEntryCollection());
    }
    /**
     * Object: ��Ŀ������������¼��� 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.social.ProjBWREtyEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.social.ProjBWREtyEntryCollection)get("entrys");
    }
    /**
     * Object: ��Ŀ������������¼��� 's ��Ŀ���� property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getProjName()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("projName");
    }
    public void setProjName(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("projName", item);
    }
    /**
     * Object:��Ŀ������������¼���'s ����״̬property 
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
     * Object:��Ŀ������������¼���'s �������property 
     */
    public java.util.Date getAuditDate()
    {
        return getDate("AuditDate");
    }
    public void setAuditDate(java.util.Date item)
    {
        setDate("AuditDate", item);
    }
    /**
     * Object:��Ŀ������������¼���'s ��Ŀ�籣��property 
     */
    public String getProjSoclNum()
    {
        return getString("projSoclNum");
    }
    public void setProjSoclNum(String item)
    {
        setString("projSoclNum", item);
    }
    /**
     * Object:��Ŀ������������¼���'s ͣ������property 
     */
    public java.util.Date getStopDate()
    {
        return getDate("stopDate");
    }
    public void setStopDate(java.util.Date item)
    {
        setDate("stopDate", item);
    }
    /**
     * Object:��Ŀ������������¼���'s ��������property 
     */
    public java.util.Date getRetToWorkDate()
    {
        return getDate("retToWorkDate");
    }
    public void setRetToWorkDate(java.util.Date item)
    {
        setDate("retToWorkDate", item);
    }
    /**
     * Object:��Ŀ������������¼���'s ͣ��Сʱ��property 
     */
    public int getDownTimeHours()
    {
        return getInt("downTimeHours");
    }
    public void setDownTimeHours(int item)
    {
        setInt("downTimeHours", item);
    }
    /**
     * Object:��Ŀ������������¼���'s ͣ������property 
     */
    public String getStoppageBy()
    {
        return getString("stoppageBy");
    }
    public void setStoppageBy(String item)
    {
        setString("stoppageBy", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0FDE242A");
    }
}