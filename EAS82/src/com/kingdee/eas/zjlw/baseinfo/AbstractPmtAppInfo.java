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
     * Object: �ù�ָ������ 's ��Ŀ���� property 
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
     * Object:�ù�ָ������'s ��Ŀ��������property 
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
     * Object:�ù�ָ������'s ������ʱ��property 
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
     * Object:�ù�ָ������'s �ù�ָ��ݽ�����ʱ��property 
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
     * Object:�ù�ָ������'s �ù�ָ������ʱ��property 
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
     * Object:�ù�ָ������'s ����ָ���⹤����property 
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
     * Object:�ù�ָ������'s ����ָ�갢������property 
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
     * Object: �ù�ָ������ 's �����Ͷ��� property 
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