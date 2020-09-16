package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractExtAccountInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractExtAccountInfo()
    {
        this("id");
    }
    protected AbstractExtAccountInfo(String pkField)
    {
        super(pkField);
        put("Entrys", new com.kingdee.eas.zjlw.baseinfo.ExtAccountEntryCollection());
    }
    /**
     * Object: 外会 's 项目名称 property 
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
     * Object: 外会 's 所属省份 property 
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
     * Object: 外会 's 分录 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ExtAccountEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ExtAccountEntryCollection)get("Entrys");
    }
    /**
     * Object:外会's 机构名称property 
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
        return new BOSObjectType("CA22973A");
    }
}