package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProjFERAssdEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractProjFERAssdEntryInfo()
    {
        this("id");
    }
    protected AbstractProjFERAssdEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.zjlw.social.ProjFERAssdInfo getParent()
    {
        return (com.kingdee.eas.zjlw.social.ProjFERAssdInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.social.ProjFERAssdInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��¼ 's ��̯��֯���� property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getSharOrgnation()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("sharOrgnation");
    }
    public void setSharOrgnation(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("sharOrgnation", item);
    }
    /**
     * Object: ��¼ 's ��̯��֯ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getApportion()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("apportion");
    }
    public void setApportion(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("apportion", item);
    }
    /**
     * Object:��¼'s �⹤�ݼٹ��ʷ�������property 
     */
    public int getForgWorkerNum()
    {
        return getInt("forgWorkerNum");
    }
    public void setForgWorkerNum(int item)
    {
        setInt("forgWorkerNum", item);
    }
    /**
     * Object:��¼'s �⹤�ݼٹ��ʷ����ܽ��property 
     */
    public java.math.BigDecimal getFWorkCount()
    {
        return getBigDecimal("fWorkCount");
    }
    public void setFWorkCount(java.math.BigDecimal item)
    {
        setBigDecimal("fWorkCount", item);
    }
    /**
     * Object:��¼'s ��עproperty 
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
        return new BOSObjectType("9E774A99");
    }
}