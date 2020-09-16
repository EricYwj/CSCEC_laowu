package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPayBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractPayBillEntryInfo()
    {
        this("id");
    }
    protected AbstractPayBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.zjlw.social.PayBillInfo getParent()
    {
        return (com.kingdee.eas.zjlw.social.PayBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.social.PayBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s ��property 
     */
    public String getLastName()
    {
        return getString("lastName");
    }
    public void setLastName(String item)
    {
        setString("lastName", item);
    }
    /**
     * Object:��¼'s ��property 
     */
    public String getFirstName()
    {
        return getString("firstName");
    }
    public void setFirstName(String item)
    {
        setString("firstName", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.util.Date getEnterDate()
    {
        return getDate("enterDate");
    }
    public void setEnterDate(java.util.Date item)
    {
        setDate("enterDate", item);
    }
    /**
     * Object:��¼'s ��������property 
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
     * Object:��¼'s �¹�������/Сʱ��property 
     */
    public int getMonthWork()
    {
        return getInt("monthWork");
    }
    public void setMonthWork(int item)
    {
        setInt("monthWork", item);
    }
    /**
     * Object:��¼'s ȱ��Сʱ/����property 
     */
    public int getAbsence()
    {
        return getInt("absence");
    }
    public void setAbsence(int item)
    {
        setInt("absence", item);
    }
    /**
     * Object:��¼'s ȱ�ڿۿ�property 
     */
    public java.math.BigDecimal getAbsDebit()
    {
        return getBigDecimal("absDebit");
    }
    public void setAbsDebit(java.math.BigDecimal item)
    {
        setBigDecimal("absDebit", item);
    }
    /**
     * Object:��¼'s ƽʱ�Ӱ�property 
     */
    public java.math.BigDecimal getNormalOver()
    {
        return getBigDecimal("normalOver");
    }
    public void setNormalOver(java.math.BigDecimal item)
    {
        setBigDecimal("normalOver", item);
    }
    /**
     * Object:��¼'s 1.75���Ӱ�property 
     */
    public java.math.BigDecimal getMoreOver()
    {
        return getBigDecimal("moreOver");
    }
    public void setMoreOver(java.math.BigDecimal item)
    {
        setBigDecimal("moreOver", item);
    }
    /**
     * Object:��¼'s �ڼ��ռӰ�property 
     */
    public java.math.BigDecimal getFestOver()
    {
        return getBigDecimal("festOver");
    }
    public void setFestOver(java.math.BigDecimal item)
    {
        setBigDecimal("festOver", item);
    }
    /**
     * Object:��¼'s ְ����property 
     */
    public java.math.BigDecimal getProfWage()
    {
        return getBigDecimal("profWage");
    }
    public void setProfWage(java.math.BigDecimal item)
    {
        setBigDecimal("profWage", item);
    }
    /**
     * Object:��¼'s ����ְ����property 
     */
    public java.math.BigDecimal getExtProfWage()
    {
        return getBigDecimal("extProfWage");
    }
    public void setExtProfWage(java.math.BigDecimal item)
    {
        setBigDecimal("extProfWage", item);
    }
    /**
     * Object:��¼'s �籣�ۿ�property 
     */
    public java.math.BigDecimal getSecuDebit()
    {
        return getBigDecimal("secuDebit");
    }
    public void setSecuDebit(java.math.BigDecimal item)
    {
        setBigDecimal("secuDebit", item);
    }
    /**
     * Object:��¼'s �ݼٹ��ʿۿ�property 
     */
    public java.math.BigDecimal getVacaDebit()
    {
        return getBigDecimal("vacaDebit");
    }
    public void setVacaDebit(java.math.BigDecimal item)
    {
        setBigDecimal("vacaDebit", item);
    }
    /**
     * Object:��¼'s ��������˰property 
     */
    public java.math.BigDecimal getPersTax()
    {
        return getBigDecimal("persTax");
    }
    public void setPersTax(java.math.BigDecimal item)
    {
        setBigDecimal("persTax", item);
    }
    /**
     * Object:��¼'s �й�����property 
     */
    public java.math.BigDecimal getChineWage()
    {
        return getBigDecimal("chineWage");
    }
    public void setChineWage(java.math.BigDecimal item)
    {
        setBigDecimal("chineWage", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.math.BigDecimal getAlgerWage()
    {
        return getBigDecimal("algerWage");
    }
    public void setAlgerWage(java.math.BigDecimal item)
    {
        setBigDecimal("algerWage", item);
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
     * Object:��¼'s ���ò���property 
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
     * Object:��¼'s ��ͥһ�˾�ҵ����property 
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
     * Object:��¼'s ���ղ���property 
     */
    public java.math.BigDecimal getRiskWage()
    {
        return getBigDecimal("riskWage");
    }
    public void setRiskWage(java.math.BigDecimal item)
    {
        setBigDecimal("riskWage", item);
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
     * Object:��¼'s �����Ͳ�property 
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
     * Object:��¼'s 7���Ӱಹ��property 
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
     * Object:��¼'s ɥ���ٲ���property 
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
     * Object:��¼'s ���Ѳ���property 
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
     * Object:��¼'s ����ס����ƫԶ��������property 
     */
    public java.math.BigDecimal getFaraWage()
    {
        return getBigDecimal("faraWage");
    }
    public void setFaraWage(java.math.BigDecimal item)
    {
        setBigDecimal("faraWage", item);
    }
    /**
     * Object:��¼'s ��λ����property 
     */
    public java.math.BigDecimal getProfAward()
    {
        return getBigDecimal("profAward");
    }
    public void setProfAward(java.math.BigDecimal item)
    {
        setBigDecimal("profAward", item);
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
     * Object:��¼'s ��������property 
     */
    public java.math.BigDecimal getUrgeWage()
    {
        return getBigDecimal("urgeWage");
    }
    public void setUrgeWage(java.math.BigDecimal item)
    {
        setBigDecimal("urgeWage", item);
    }
    /**
     * Object:��¼'s �½���property 
     */
    public java.math.BigDecimal getMonthAward()
    {
        return getBigDecimal("monthAward");
    }
    public void setMonthAward(java.math.BigDecimal item)
    {
        setBigDecimal("monthAward", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.math.BigDecimal getIndPay()
    {
        return getBigDecimal("indPay");
    }
    public void setIndPay(java.math.BigDecimal item)
    {
        setBigDecimal("indPay", item);
    }
    /**
     * Object:��¼'s ������property 
     */
    public java.math.BigDecimal getNetPay()
    {
        return getBigDecimal("netPay");
    }
    public void setNetPay(java.math.BigDecimal item)
    {
        setBigDecimal("netPay", item);
    }
    /**
     * Object:��¼'s ��ͬ���ڲ���ǩ����property 
     */
    public String getUnSignWage()
    {
        return getString("unSignWage");
    }
    public void setUnSignWage(String item)
    {
        setString("unSignWage", item);
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
     * Object:��¼'s ���Ӵ�ҵ����property 
     */
    public java.math.BigDecimal getWifeUnWage()
    {
        return getBigDecimal("wifeUnWage");
    }
    public void setWifeUnWage(java.math.BigDecimal item)
    {
        setBigDecimal("wifeUnWage", item);
    }
    /**
     * Object:��¼'s ��ͥ����property 
     */
    public java.math.BigDecimal getFamilyWage()
    {
        return getBigDecimal("FamilyWage");
    }
    public void setFamilyWage(java.math.BigDecimal item)
    {
        setBigDecimal("FamilyWage", item);
    }
    /**
     * Object:��¼'s ��ѧ����property 
     */
    public java.math.BigDecimal getStudyWage()
    {
        return getBigDecimal("studyWage");
    }
    public void setStudyWage(java.math.BigDecimal item)
    {
        setBigDecimal("studyWage", item);
    }
    /**
     * Object:��¼'s ���𣨿��籣�ݼ٣�����property 
     */
    public java.math.BigDecimal getUnSCVCWage()
    {
        return getBigDecimal("unSCVCWage");
    }
    public void setUnSCVCWage(java.math.BigDecimal item)
    {
        setBigDecimal("unSCVCWage", item);
    }
    /**
     * Object:��¼'s �Ա�property 
     */
    public com.kingdee.eas.basedata.person.Genders getSex()
    {
        return com.kingdee.eas.basedata.person.Genders.getEnum(getInt("sex"));
    }
    public void setSex(com.kingdee.eas.basedata.person.Genders item)
    {
		if (item != null) {
        setInt("sex", item.getValue());
		}
    }
    /**
     * Object:��¼'s ���property 
     */
    public boolean isIsMarry()
    {
        return getBoolean("isMarry");
    }
    public void setIsMarry(boolean item)
    {
        setBoolean("isMarry", item);
    }
    /**
     * Object: ��¼ 's ���� property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo getProf()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo)get("prof");
    }
    public void setProf(com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo item)
    {
        put("prof", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("646EE9A3");
    }
}