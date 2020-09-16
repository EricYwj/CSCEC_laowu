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
     * Object: 分录 's 单据头 property 
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
     * Object:分录's 姓property 
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
     * Object:分录's 名property 
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
     * Object:分录's 进场日期property 
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
     * Object:分录's 基本工资property 
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
     * Object:分录's 月工作天数/小时数property 
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
     * Object:分录's 缺勤小时/天数property 
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
     * Object:分录's 缺勤扣款property 
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
     * Object:分录's 平时加班property 
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
     * Object:分录's 1.75倍加班property 
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
     * Object:分录's 节假日加班property 
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
     * Object:分录's 职责补助property 
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
     * Object:分录's 额外职责补助property 
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
     * Object:分录's 社保扣款property 
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
     * Object:分录's 休假工资扣款property 
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
     * Object:分录's 个人所得税property 
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
     * Object:分录's 中工补助property 
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
     * Object:分录's 阿工补助property 
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
     * Object:分录's 交通补贴property 
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
     * Object:分录's 差旅补助property 
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
     * Object:分录's 家庭一人就业补贴property 
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
     * Object:分录's 风险补助property 
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
     * Object:分录's 危害补贴property 
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
     * Object:分录's 工作餐补property 
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
     * Object:分录's 7点后加班补贴property 
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
     * Object:分录's 区域补贴property 
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
     * Object:分录's 丧葬婚假补贴property 
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
     * Object:分录's 轮班补贴property 
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
     * Object:分录's 夜班补贴property 
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
     * Object:分录's 住房补贴property 
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
     * Object:分录's 花费补贴property 
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
     * Object:分录's 解雇一次性补贴property 
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
     * Object:分录's 退休一次性补贴property 
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
     * Object:分录's 特殊住所和偏远地区补贴property 
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
     * Object:分录's 岗位奖金property 
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
     * Object:分录's 语言补贴property 
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
     * Object:分录's 鼓励补贴property 
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
     * Object:分录's 月奖金property 
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
     * Object:分录's 独立工资property 
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
     * Object:分录's 净工资property 
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
     * Object:分录's 合同到期不续签补贴property 
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
     * Object:分录's 工龄补贴property 
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
     * Object:分录's 妻子待业补助property 
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
     * Object:分录's 家庭津贴property 
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
     * Object:分录's 就学补贴property 
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
     * Object:分录's 奖金（扣社保休假）部分property 
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
     * Object:分录's 性别property 
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
     * Object:分录's 婚否property 
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
     * Object: 分录 's 工种 property 
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