package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSecuPayCountEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSecuPayCountEntryInfo()
    {
        this("id");
    }
    protected AbstractSecuPayCountEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.zjlw.social.SecuPayCountInfo getParent()
    {
        return (com.kingdee.eas.zjlw.social.SecuPayCountInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.social.SecuPayCountInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s �籣֧Ʊ��property 
     */
    public String getSecuChNum()
    {
        return getString("secuChNum");
    }
    public void setSecuChNum(String item)
    {
        setString("secuChNum", item);
    }
    /**
     * Object:��¼'s �籣���ɽ��property 
     */
    public java.math.BigDecimal getSecuPay()
    {
        return getBigDecimal("secuPay");
    }
    public void setSecuPay(java.math.BigDecimal item)
    {
        setBigDecimal("secuPay", item);
    }
    /**
     * Object:��¼'s �ݼٹ���֧Ʊ��property 
     */
    public String getVcPayChNum()
    {
        return getString("vcPayChNum");
    }
    public void setVcPayChNum(String item)
    {
        setString("vcPayChNum", item);
    }
    /**
     * Object:��¼'s �ݼٹ��ʽ����ܽ��property 
     */
    public java.math.BigDecimal getVcPayMoney()
    {
        return getBigDecimal("vcPayMoney");
    }
    public void setVcPayMoney(java.math.BigDecimal item)
    {
        setBigDecimal("vcPayMoney", item);
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
    /**
     * Object: ��¼ 's ��Ŀ���� property 
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
     * Object:��¼'s ��Ŀ�籣��property 
     */
    public String getProjSCNum()
    {
        return getString("projSCNum");
    }
    public void setProjSCNum(String item)
    {
        setString("projSCNum", item);
    }
    /**
     * Object:��¼'s �籣֧Ʊ�˻�property 
     */
    public String getSeceAcc()
    {
        return getString("seceAcc");
    }
    public void setSeceAcc(String item)
    {
        setString("seceAcc", item);
    }
    /**
     * Object:��¼'s �籣֧Ʊ��ǩ��property 
     */
    public String getSecuSinger()
    {
        return getString("secuSinger");
    }
    public void setSecuSinger(String item)
    {
        setString("secuSinger", item);
    }
    /**
     * Object:��¼'s �籣������property 
     */
    public String getSecuCount()
    {
        return getString("secuCount");
    }
    public void setSecuCount(String item)
    {
        setString("secuCount", item);
    }
    /**
     * Object:��¼'s �ݼٹ���֧Ʊ�˻�property 
     */
    public String getVcAcc()
    {
        return getString("vcAcc");
    }
    public void setVcAcc(String item)
    {
        setString("vcAcc", item);
    }
    /**
     * Object:��¼'s �ݼٹ���֧Ʊ��ǩ��property 
     */
    public String getVcSinger()
    {
        return getString("vcSinger");
    }
    public void setVcSinger(String item)
    {
        setString("vcSinger", item);
    }
    /**
     * Object:��¼'s �籣���ݼٽ����ܽ��property 
     */
    public java.math.BigDecimal getScvcPay()
    {
        return getBigDecimal("scvcPay");
    }
    public void setScvcPay(java.math.BigDecimal item)
    {
        setBigDecimal("scvcPay", item);
    }
    /**
     * Object:��¼'s ��Ŀ����ʡ��property 
     */
    public String getProjPrev()
    {
        return getString("projPrev");
    }
    public void setProjPrev(String item)
    {
        setString("projPrev", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C9DABEC7");
    }
}