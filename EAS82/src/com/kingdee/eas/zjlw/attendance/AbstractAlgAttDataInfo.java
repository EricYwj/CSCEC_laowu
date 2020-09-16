package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAlgAttDataInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractAlgAttDataInfo()
    {
        this("id");
    }
    protected AbstractAlgAttDataInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.attendance.AlgAttDataEntryCollection());
    }
    /**
     * Object: 阿工考勤数据 's 分录 property 
     */
    public com.kingdee.eas.zjlw.attendance.AlgAttDataEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.attendance.AlgAttDataEntryCollection)get("entrys");
    }
    /**
     * Object:阿工考勤数据's 是否生成凭证property 
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
     * Object:阿工考勤数据's 考勤系统部门编码property 
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
     * Object: 阿工考勤数据 's 所属项目 property 
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
     * Object:阿工考勤数据's 考勤时间property 
     */
    public java.util.Date getAttDate()
    {
        return getDate("attDate");
    }
    public void setAttDate(java.util.Date item)
    {
        setDate("attDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1F56FD73");
    }
}