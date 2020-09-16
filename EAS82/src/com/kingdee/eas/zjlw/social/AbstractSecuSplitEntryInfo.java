package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSecuSplitEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSecuSplitEntryInfo()
    {
        this("id");
    }
    protected AbstractSecuSplitEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.zjlw.social.SecuSplitInfo getParent()
    {
        return (com.kingdee.eas.zjlw.social.SecuSplitInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.social.SecuSplitInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��¼ 's ������λ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getCooperation()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("cooperation");
    }
    public void setCooperation(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("cooperation", item);
    }
    /**
     * Object:��¼'s ������λ����property 
     */
    public String getCoopCode()
    {
        return getString("coopCode");
    }
    public void setCoopCode(String item)
    {
        setString("coopCode", item);
    }
    /**
     * Object:��¼'s ������λ���������籣����property 
     */
    public int getCoopAlgSc()
    {
        return getInt("coopAlgSc");
    }
    public void setCoopAlgSc(int item)
    {
        setInt("coopAlgSc", item);
    }
    /**
     * Object:��¼'s ������λ�⹤�����籣����property 
     */
    public int getCoopForiSc()
    {
        return getInt("coopForiSc");
    }
    public void setCoopForiSc(int item)
    {
        setInt("coopForiSc", item);
    }
    /**
     * Object:��¼'s ������λ�����籣������property 
     */
    public int getCoopScPers()
    {
        return getInt("coopScPers");
    }
    public void setCoopScPers(int item)
    {
        setInt("coopScPers", item);
    }
    /**
     * Object:��¼'s ������λ�籣�����ܽ��property 
     */
    public java.math.BigDecimal getCoopScMoney()
    {
        return getBigDecimal("coopScMoney");
    }
    public void setCoopScMoney(java.math.BigDecimal item)
    {
        setBigDecimal("coopScMoney", item);
    }
    /**
     * Object:��¼'s ������λ�⹤�����ݼٹ��ʽ��property 
     */
    public java.math.BigDecimal getCoopForiVcM()
    {
        return getBigDecimal("coopForiVcM");
    }
    public void setCoopForiVcM(java.math.BigDecimal item)
    {
        setBigDecimal("coopForiVcM", item);
    }
    /**
     * Object:��¼'s ������λ���������ݼٹ��ʽ��property 
     */
    public java.math.BigDecimal getCoopAlgVcM()
    {
        return getBigDecimal("coopAlgVcM");
    }
    public void setCoopAlgVcM(java.math.BigDecimal item)
    {
        setBigDecimal("coopAlgVcM", item);
    }
    /**
     * Object:��¼'s ������λ���������籣���property 
     */
    public java.math.BigDecimal getCoopAlgScM()
    {
        return getBigDecimal("coopAlgScM");
    }
    public void setCoopAlgScM(java.math.BigDecimal item)
    {
        setBigDecimal("coopAlgScM", item);
    }
    /**
     * Object:��¼'s ������λ�⹤�����籣���property 
     */
    public java.math.BigDecimal getCoopForiScM()
    {
        return getBigDecimal("coopForiScM");
    }
    public void setCoopForiScM(java.math.BigDecimal item)
    {
        setBigDecimal("coopForiScM", item);
    }
    /**
     * Object:��¼'s ���ػ�Ա��IRG�����ܶ�property 
     */
    public java.math.BigDecimal getLocalIRGC()
    {
        return getBigDecimal("localIRGC");
    }
    public void setLocalIRGC(java.math.BigDecimal item)
    {
        setBigDecimal("localIRGC", item);
    }
    /**
     * Object:��¼'s �⼮Ա��IRG�����ܶ�property 
     */
    public java.math.BigDecimal getForiIRGC()
    {
        return getBigDecimal("foriIRGC");
    }
    public void setForiIRGC(java.math.BigDecimal item)
    {
        setBigDecimal("foriIRGC", item);
    }
    /**
     * Object:��¼'s �ݼٹ��ʽ����ܶ�property 
     */
    public java.math.BigDecimal getVcCount()
    {
        return getBigDecimal("vcCount");
    }
    public void setVcCount(java.math.BigDecimal item)
    {
        setBigDecimal("vcCount", item);
    }
    /**
     * Object:��¼'s IRG�����ܶ�property 
     */
    public java.math.BigDecimal getIRGCount()
    {
        return getBigDecimal("IRGCount");
    }
    public void setIRGCount(java.math.BigDecimal item)
    {
        setBigDecimal("IRGCount", item);
    }
    /**
     * Object: ��¼ 's ������Ŀ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getWorkProj()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("workProj");
    }
    public void setWorkProj(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("workProj", item);
    }
    /**
     * Object:��¼'s ���ػ��籣��������property 
     */
    public java.math.BigDecimal getCoopAlgScNew()
    {
        return getBigDecimal("coopAlgScNew");
    }
    public void setCoopAlgScNew(java.math.BigDecimal item)
    {
        setBigDecimal("coopAlgScNew", item);
    }
    /**
     * Object:��¼'s �⼮Ա���籣��������property 
     */
    public java.math.BigDecimal getCoopForiScNew()
    {
        return getBigDecimal("coopForiScNew");
    }
    public void setCoopForiScNew(java.math.BigDecimal item)
    {
        setBigDecimal("coopForiScNew", item);
    }
    /**
     * Object:��¼'s �籣����������property 
     */
    public java.math.BigDecimal getCoopScPersNew()
    {
        return getBigDecimal("coopScPersNew");
    }
    public void setCoopScPersNew(java.math.BigDecimal item)
    {
        setBigDecimal("coopScPersNew", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2F132F9C");
    }
}