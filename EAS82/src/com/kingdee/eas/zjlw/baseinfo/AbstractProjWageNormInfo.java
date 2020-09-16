package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProjWageNormInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractProjWageNormInfo()
    {
        this("id");
    }
    protected AbstractProjWageNormInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.baseinfo.ProjWageNormEntryCollection());
    }
    /**
     * Object: ��Ŀ������׼�� 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjWageNormEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjWageNormEntryCollection)get("entrys");
    }
    /**
     * Object:��Ŀ������׼��'s �Ƿ�����ƾ֤property 
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
     * Object: ��Ŀ������׼�� 's ������Ŀ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getProCom()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("proCom");
    }
    public void setProCom(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("proCom", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("45B4CE6F");
    }
}