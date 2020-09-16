package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractForiAttDataInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractForiAttDataInfo()
    {
        this("id");
    }
    protected AbstractForiAttDataInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.attendance.ForiAttDataEntryCollection());
    }
    /**
     * Object: 外工考勤数据 's 分录 property 
     */
    public com.kingdee.eas.zjlw.attendance.ForiAttDataEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.attendance.ForiAttDataEntryCollection)get("entrys");
    }
    /**
     * Object:外工考勤数据's 是否生成凭证property 
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
     * Object:外工考勤数据's 考勤系统部门编码property 
     */
    public String getCheckSysDepNo()
    {
        return getString("CheckSysDepNo");
    }
    public void setCheckSysDepNo(String item)
    {
        setString("CheckSysDepNo", item);
    }
    /**
     * Object: 外工考勤数据 's 所属项目 property 
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
        return new BOSObjectType("A3B570C7");
    }
}