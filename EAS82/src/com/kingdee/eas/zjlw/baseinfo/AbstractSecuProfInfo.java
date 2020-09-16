package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSecuProfInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSecuProfInfo()
    {
        this("id");
    }
    protected AbstractSecuProfInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:社保标准工种库's 基本工资property 
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
     * Object: 社保标准工种库 's 社保工种 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo getProjName()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo)get("projName");
    }
    public void setProjName(com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo item)
    {
        put("projName", item);
    }
    /**
     * Object:社保标准工种库's 法语名称property 
     */
    public String getProjNamef()
    {
        return getString("projNamef");
    }
    public void setProjNamef(String item)
    {
        setString("projNamef", item);
    }
    /**
     * Object:社保标准工种库's 备注property 
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
        return new BOSObjectType("0F6A5DAB");
    }
}