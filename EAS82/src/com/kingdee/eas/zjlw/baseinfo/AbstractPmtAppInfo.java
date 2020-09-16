package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPmtAppInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractPmtAppInfo()
    {
        this("id");
    }
    protected AbstractPmtAppInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 用工指标申请 's 项目名称 property 
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
     * Object:用工指标申请's 项目法文名称property 
     */
    public String getProjNameFR()
    {
        return getString("projNameFR");
    }
    public void setProjNameFR(String item)
    {
        setString("projNameFR", item);
    }
    /**
     * Object:用工指标申请's 开工令时间property 
     */
    public java.util.Date getActBeginDate()
    {
        return getDate("actBeginDate");
    }
    public void setActBeginDate(java.util.Date item)
    {
        setDate("actBeginDate", item);
    }
    /**
     * Object:用工指标申请's 用工指标递交申请时间property 
     */
    public java.util.Date getPmtDelrDate()
    {
        return getDate("pmtDelrDate");
    }
    public void setPmtDelrDate(java.util.Date item)
    {
        setDate("pmtDelrDate", item);
    }
    /**
     * Object:用工指标申请's 用工指标批复时间property 
     */
    public java.util.Date getPmtConfirmDate()
    {
        return getDate("pmtConfirmDate");
    }
    public void setPmtConfirmDate(java.util.Date item)
    {
        setDate("pmtConfirmDate", item);
    }
    /**
     * Object:用工指标申请's 批复指标外工总数property 
     */
    public int getCfmFrgPsnAmt()
    {
        return getInt("CfmFrgPsnAmt");
    }
    public void setCfmFrgPsnAmt(int item)
    {
        setInt("CfmFrgPsnAmt", item);
    }
    /**
     * Object:用工指标申请's 批复指标阿工总数property 
     */
    public int getCfmAlgPsnAmt()
    {
        return getInt("CfmAlgPsnAmt");
    }
    public void setCfmAlgPsnAmt(int item)
    {
        setInt("CfmAlgPsnAmt", item);
    }
    /**
     * Object: 用工指标申请 's 所属劳动局 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.LaborBureauInfo getLaborBureau()
    {
        return (com.kingdee.eas.zjlw.baseinfo.LaborBureauInfo)get("LaborBureau");
    }
    public void setLaborBureau(com.kingdee.eas.zjlw.baseinfo.LaborBureauInfo item)
    {
        put("LaborBureau", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("62FD61F8");
    }
}