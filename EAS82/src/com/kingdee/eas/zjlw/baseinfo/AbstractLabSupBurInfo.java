package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLabSupBurInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractLabSupBurInfo()
    {
        this("id");
    }
    protected AbstractLabSupBurInfo(String pkField)
    {
        super(pkField);
        put("Entrys", new com.kingdee.eas.zjlw.baseinfo.LabSupBurEntryCollection());
    }
    /**
     * Object: �Ͷ����� 's ��Ŀ���� property 
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
     * Object: �Ͷ����� 's ����ʡ�� property 
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
     * Object: �Ͷ����� 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.baseinfo.LabSupBurEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.baseinfo.LabSupBurEntryCollection)get("Entrys");
    }
    /**
     * Object:�Ͷ�����'s ��������property 
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
        return new BOSObjectType("C39A7110");
    }
}