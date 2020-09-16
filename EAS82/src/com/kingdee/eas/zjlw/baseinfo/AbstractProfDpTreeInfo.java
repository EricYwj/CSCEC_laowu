package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProfDpTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractProfDpTreeInfo()
    {
        this("id");
    }
    protected AbstractProfDpTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 工种库组别 's 父节点 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProfDpTreeInfo getParent()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProfDpTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.baseinfo.ProfDpTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("39552D71");
    }
}