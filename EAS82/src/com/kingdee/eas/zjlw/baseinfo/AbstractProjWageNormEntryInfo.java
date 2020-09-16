package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProjWageNormEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractProjWageNormEntryInfo()
    {
        this("id");
    }
    protected AbstractProjWageNormEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjWageNormInfo getParent()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjWageNormInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.baseinfo.ProjWageNormInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s ���䲹��property 
     */
    public java.math.BigDecimal getSeniWage()
    {
        return getBigDecimal("seniWage");
    }
    public void setSeniWage(java.math.BigDecimal item)
    {
        setBigDecimal("seniWage", item);
    }
    /**
     * Object:��¼'s �����Ͳ���property 
     */
    public java.math.BigDecimal getEatWage()
    {
        return getBigDecimal("eatWage");
    }
    public void setEatWage(java.math.BigDecimal item)
    {
        setBigDecimal("eatWage", item);
    }
    /**
     * Object:��¼'s ��ͨ����property 
     */
    public java.math.BigDecimal getTraWage()
    {
        return getBigDecimal("traWage");
    }
    public void setTraWage(java.math.BigDecimal item)
    {
        setBigDecimal("traWage", item);
    }
    /**
     * Object:��¼'s ������property 
     */
    public java.math.BigDecimal getAreaWage()
    {
        return getBigDecimal("areaWage");
    }
    public void setAreaWage(java.math.BigDecimal item)
    {
        setBigDecimal("areaWage", item);
    }
    /**
     * Object:��¼'s ���Բ���property 
     */
    public java.math.BigDecimal getLangWage()
    {
        return getBigDecimal("langWage");
    }
    public void setLangWage(java.math.BigDecimal item)
    {
        setBigDecimal("langWage", item);
    }
    /**
     * Object:��¼'s Σ������property 
     */
    public java.math.BigDecimal getDisasWage()
    {
        return getBigDecimal("disasWage");
    }
    public void setDisasWage(java.math.BigDecimal item)
    {
        setBigDecimal("disasWage", item);
    }
    /**
     * Object:��¼'s ɥ���޲���property 
     */
    public java.math.BigDecimal getThingsWage()
    {
        return getBigDecimal("thingsWage");
    }
    public void setThingsWage(java.math.BigDecimal item)
    {
        setBigDecimal("thingsWage", item);
    }
    /**
     * Object:��¼'s ��ͥ1�˾�ҵ����property 
     */
    public java.math.BigDecimal getOneWorkWage()
    {
        return getBigDecimal("oneWorkWage");
    }
    public void setOneWorkWage(java.math.BigDecimal item)
    {
        setBigDecimal("oneWorkWage", item);
    }
    /**
     * Object:��¼'s �����property 
     */
    public java.math.BigDecimal getBTripWage()
    {
        return getBigDecimal("bTripWage");
    }
    public void setBTripWage(java.math.BigDecimal item)
    {
        setBigDecimal("bTripWage", item);
    }
    /**
     * Object:��¼'s 7���Ӱཻͨ�Ͳ�����property 
     */
    public java.math.BigDecimal getOverTraWage()
    {
        return getBigDecimal("overTraWage");
    }
    public void setOverTraWage(java.math.BigDecimal item)
    {
        setBigDecimal("overTraWage", item);
    }
    /**
     * Object:��¼'s ҹ�ಹ��property 
     */
    public java.math.BigDecimal getNWorkWage()
    {
        return getBigDecimal("nWorkWage");
    }
    public void setNWorkWage(java.math.BigDecimal item)
    {
        setBigDecimal("nWorkWage", item);
    }
    /**
     * Object:��¼'s �ְಹ��property 
     */
    public java.math.BigDecimal getSwitchWage()
    {
        return getBigDecimal("switchWage");
    }
    public void setSwitchWage(java.math.BigDecimal item)
    {
        setBigDecimal("switchWage", item);
    }
    /**
     * Object:��¼'s ס������property 
     */
    public java.math.BigDecimal getLiveWage()
    {
        return getBigDecimal("liveWage");
    }
    public void setLiveWage(java.math.BigDecimal item)
    {
        setBigDecimal("liveWage", item);
    }
    /**
     * Object:��¼'s ���ѱ���property 
     */
    public java.math.BigDecimal getSpendWage()
    {
        return getBigDecimal("spendWage");
    }
    public void setSpendWage(java.math.BigDecimal item)
    {
        setBigDecimal("spendWage", item);
    }
    /**
     * Object:��¼'s ���һ���Բ���property 
     */
    public java.math.BigDecimal getFireWage()
    {
        return getBigDecimal("fireWage");
    }
    public void setFireWage(java.math.BigDecimal item)
    {
        setBigDecimal("fireWage", item);
    }
    /**
     * Object:��¼'s ����һ���Բ���property 
     */
    public java.math.BigDecimal getRetirWage()
    {
        return getBigDecimal("retirWage");
    }
    public void setRetirWage(java.math.BigDecimal item)
    {
        setBigDecimal("retirWage", item);
    }
    /**
     * Object:��¼'s ����ס����ƫԶ����property 
     */
    public java.math.BigDecimal getFaraWage()
    {
        return getBigDecimal("faraWage");
    }
    public void setFaraWage(java.math.BigDecimal item)
    {
        setBigDecimal("faraWage", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7285F743");
    }
}