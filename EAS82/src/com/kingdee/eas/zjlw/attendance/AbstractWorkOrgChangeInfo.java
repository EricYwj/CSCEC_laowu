package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWorkOrgChangeInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractWorkOrgChangeInfo()
    {
        this("id");
    }
    protected AbstractWorkOrgChangeInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.attendance.WorkOrgChangeEntryCollection());
    }
    /**
     * Object: 工作项目变动 's 分录 property 
     */
    public com.kingdee.eas.zjlw.attendance.WorkOrgChangeEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.attendance.WorkOrgChangeEntryCollection)get("entrys");
    }
    /**
     * Object: 工作项目变动 's 所属组织 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getAdminOrgid()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("adminOrgid");
    }
    public void setAdminOrgid(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("adminOrgid", item);
    }
    /**
     * Object:工作项目变动's 单据状况property 
     */
    public com.kingdee.eas.zjlw.certificates.app.BillStateEnum getBillstate()
    {
        return com.kingdee.eas.zjlw.certificates.app.BillStateEnum.getEnum(getString("billstate"));
    }
    public void setBillstate(com.kingdee.eas.zjlw.certificates.app.BillStateEnum item)
    {
		if (item != null) {
        setString("billstate", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E652C85F");
    }
}