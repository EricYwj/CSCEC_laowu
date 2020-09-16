package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLeaveOffInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractLeaveOffInfo()
    {
        this("id");
    }
    protected AbstractLeaveOffInfo(String pkField)
    {
        super(pkField);
        put("Entrys", new com.kingdee.eas.zjlw.baseinfo.LeaveOffEntryCollection());
    }
    /**
     * Object: �ݼٹ��ʾ� 's ��Ŀ���� property 
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
     * Object: �ݼٹ��ʾ� 's ����ʡ�� property 
     */
    public com.kingdee.eas.basedata.assistant.ProvinceInfo getProvince()
    {
        return (com.kingdee.eas.basedata.assistant.ProvinceInfo)get("province");
    }
    public void setProvince(com.kingdee.eas.basedata.assistant.ProvinceInfo item)
    {
        put("province", item);
    }
    /**
     * Object: �ݼٹ��ʾ� 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.baseinfo.LeaveOffEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.baseinfo.LeaveOffEntryCollection)get("Entrys");
    }
    /**
     * Object:�ݼٹ��ʾ�'s ��������property 
     */
    public String getOrganizational()
    {
        return getString("organizational");
    }
    public void setOrganizational(String item)
    {
        setString("organizational", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("34EF9126");
    }
}