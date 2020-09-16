package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBlackpersonInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractBlackpersonInfo()
    {
        this("id");
    }
    protected AbstractBlackpersonInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 不合格人员 's 父节点 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.BlackpersonInfo getParent()
    {
        return (com.kingdee.eas.zjlw.baseinfo.BlackpersonInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.baseinfo.BlackpersonInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 不合格人员 's 国籍 property 
     */
    public com.kingdee.eas.basedata.assistant.CountryInfo getNation()
    {
        return (com.kingdee.eas.basedata.assistant.CountryInfo)get("nation");
    }
    public void setNation(com.kingdee.eas.basedata.assistant.CountryInfo item)
    {
        put("nation", item);
    }
    /**
     * Object:不合格人员's 提出日期property 
     */
    public java.util.Date getAppDate()
    {
        return getDate("appDate");
    }
    public void setAppDate(java.util.Date item)
    {
        setDate("appDate", item);
    }
    /**
     * Object:不合格人员's 提出理由property 
     */
    public String getAppReason()
    {
        return getString("appReason");
    }
    public void setAppReason(String item)
    {
        setString("appReason", item);
    }
    /**
     * Object:不合格人员's 备注property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("CFB74766");
    }
}