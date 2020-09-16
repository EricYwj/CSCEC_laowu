package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProjSecuProfInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractProjSecuProfInfo()
    {
        this("id");
    }
    protected AbstractProjSecuProfInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:��Ŀ�籣���ֿ�'s ��������property 
     */
    public java.math.BigDecimal getBasePay()
    {
        return getBigDecimal("basePay");
    }
    public void setBasePay(java.math.BigDecimal item)
    {
        setBigDecimal("basePay", item);
    }
    /**
     * Object: ��Ŀ�籣���ֿ� 's ��Ŀ���� property 
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
     * Object: ��Ŀ�籣���ֿ� 's ��׼�������� property 
     */
    public com.kingdee.eas.zjlw.baseinfo.SecuProfInfo getProfType()
    {
        return (com.kingdee.eas.zjlw.baseinfo.SecuProfInfo)get("profType");
    }
    public void setProfType(com.kingdee.eas.zjlw.baseinfo.SecuProfInfo item)
    {
        put("profType", item);
    }
    /**
     * Object:��Ŀ�籣���ֿ�'s ��׼��������property 
     */
    public java.math.BigDecimal getNBasePay()
    {
        return getBigDecimal("nBasePay");
    }
    public void setNBasePay(java.math.BigDecimal item)
    {
        setBigDecimal("nBasePay", item);
    }
    /**
     * Object:��Ŀ�籣���ֿ�'s �Ƿ����property 
     */
    public boolean isIsStop()
    {
        return getBoolean("isStop");
    }
    public void setIsStop(boolean item)
    {
        setBoolean("isStop", item);
    }
    /**
     * Object:��Ŀ�籣���ֿ�'s ����ʱ��property 
     */
    public java.util.Date getStopTimes()
    {
        return getDate("stopTimes");
    }
    public void setStopTimes(java.util.Date item)
    {
        setDate("stopTimes", item);
    }
    /**
     * Object:��Ŀ�籣���ֿ�'s ��עproperty 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object:��Ŀ�籣���ֿ�'s ��Ŀ�籣����property 
     */
    public String getProjProf()
    {
        return getString("projProf");
    }
    public void setProjProf(String item)
    {
        setString("projProf", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("73D81128");
    }
}