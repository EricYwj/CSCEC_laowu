package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPayPrintEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractPayPrintEntryInfo()
    {
        this("id");
    }
    protected AbstractPayPrintEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.zjlw.social.PayPrintInfo getParent()
    {
        return (com.kingdee.eas.zjlw.social.PayPrintInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.social.PayPrintInfo item)
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
     * Object:��¼'s ְλproperty 
     */
    public String getPosition()
    {
        return getString("position");
    }
    public void setPosition(String item)
    {
        setString("position", item);
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
     * Object:��¼'s ��������/�����property 
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
     * Object:��¼'s ˰�����루����˰��property 
     */
    public java.math.BigDecimal getAftTaxPay()
    {
        return getBigDecimal("aftTaxPay");
    }
    public void setAftTaxPay(java.math.BigDecimal item)
    {
        setBigDecimal("aftTaxPay", item);
    }
    /**
     * Object:��¼'s ë����property 
     */
    public java.math.BigDecimal getGrossPay()
    {
        return getBigDecimal("grossPay");
    }
    public void setGrossPay(java.math.BigDecimal item)
    {
        setBigDecimal("grossPay", item);
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
     * Object:��¼'s ��λ����property 
     */
    public java.math.BigDecimal getPosiPay()
    {
        return getBigDecimal("posiPay");
    }
    public void setPosiPay(java.math.BigDecimal item)
    {
        setBigDecimal("posiPay", item);
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
     * Object:��¼'s �����Լ�һ���Բ���property 
     */
    public java.math.BigDecimal getOneTimeWage()
    {
        return getBigDecimal("oneTimeWage");
    }
    public void setOneTimeWage(java.math.BigDecimal item)
    {
        setBigDecimal("oneTimeWage", item);
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
     * Object:��¼'s ��������property 
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
     * Object:��¼'s ��Ŀ������property 
     */
    public java.math.BigDecimal getPOverAward()
    {
        return getBigDecimal("pOverAward");
    }
    public void setPOverAward(java.math.BigDecimal item)
    {
        setBigDecimal("pOverAward", item);
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
     * Object: ��¼ 's ���� property 
     */
    public com.kingdee.eas.basedata.assistant.CountryInfo getCountry()
    {
        return (com.kingdee.eas.basedata.assistant.CountryInfo)get("country");
    }
    public void setCountry(com.kingdee.eas.basedata.assistant.CountryInfo item)
    {
        put("country", item);
    }
    /**
     * Object: ��¼ 's ������Ŀ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getWorkProgram()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("workProgram");
    }
    public void setWorkProgram(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("workProgram", item);
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
     * Object:��¼'s ��Ա���property 
     */
    public String getPersonID()
    {
        return getString("personID");
    }
    public void setPersonID(String item)
    {
        setString("personID", item);
    }
    /**
     * Object:��¼'s �����Ա���property 
     */
    public String getForiPersID()
    {
        return getString("foriPersID");
    }
    public void setForiPersID(String item)
    {
        setString("foriPersID", item);
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
    /**
     * Object: ��¼ 's �籣���� property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo getSecuProf()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo)get("secuProf");
    }
    public void setSecuProf(com.kingdee.eas.zjlw.baseinfo.ProjSecuProfInfo item)
    {
        put("secuProf", item);
    }
    /**
     * Object:��¼'s IRG�ۿ�������property 
     */
    public java.math.BigDecimal getIRGDeduction()
    {
        return getBigDecimal("IRGDeduction");
    }
    public void setIRGDeduction(java.math.BigDecimal item)
    {
        setBigDecimal("IRGDeduction", item);
    }
    /**
     * Object:��¼'s �籣���ջ���property 
     */
    public java.math.BigDecimal getSociaLevyBase()
    {
        return getBigDecimal("SociaLevyBase");
    }
    public void setSociaLevyBase(java.math.BigDecimal item)
    {
        setBigDecimal("SociaLevyBase", item);
    }
    /**
     * Object:��¼'s IRG�ۿ��������˰property 
     */
    public java.math.BigDecimal getIRGDPerson()
    {
        return getBigDecimal("IRGDPerson");
    }
    public void setIRGDPerson(java.math.BigDecimal item)
    {
        setBigDecimal("IRGDPerson", item);
    }
    /**
     * Object:��¼'s ����״̬property 
     */
    public com.kingdee.eas.zjlw.certificates.app.mayrStatEnum getMaritalStatus()
    {
        return com.kingdee.eas.zjlw.certificates.app.mayrStatEnum.getEnum(getString("maritalStatus"));
    }
    public void setMaritalStatus(com.kingdee.eas.zjlw.certificates.app.mayrStatEnum item)
    {
		if (item != null) {
        setString("maritalStatus", item.getValue());
		}
    }
    /**
     * Object:��¼'s �³��ڹ���property 
     */
    public java.math.BigDecimal getAttMthWage()
    {
        return getBigDecimal("attMthWage");
    }
    public void setAttMthWage(java.math.BigDecimal item)
    {
        setBigDecimal("attMthWage", item);
    }
    /**
     * Object:��¼'s ƽʱ�Ӱ�Сʱ���ʻ���property 
     */
    public java.math.BigDecimal getNmlBsWgPerHour()
    {
        return getBigDecimal("nmlBsWgPerHour");
    }
    public void setNmlBsWgPerHour(java.math.BigDecimal item)
    {
        setBigDecimal("nmlBsWgPerHour", item);
    }
    /**
     * Object:��¼'s �ڼ��ռӰ�Сʱ���ʻ���property 
     */
    public java.math.BigDecimal getHldBsWgPerHour()
    {
        return getBigDecimal("hldBsWgPerHour");
    }
    public void setHldBsWgPerHour(java.math.BigDecimal item)
    {
        setBigDecimal("hldBsWgPerHour", item);
    }
    /**
     * Object:��¼'s ƽʱ�Ӱ๤���ܶ�property 
     */
    public java.math.BigDecimal getTotNmlBsWg()
    {
        return getBigDecimal("totNmlBsWg");
    }
    public void setTotNmlBsWg(java.math.BigDecimal item)
    {
        setBigDecimal("totNmlBsWg", item);
    }
    /**
     * Object:��¼'s �ڼ��ռӰ๤���ܶ�property 
     */
    public java.math.BigDecimal getTotHldBsWg()
    {
        return getBigDecimal("totHldBsWg");
    }
    public void setTotHldBsWg(java.math.BigDecimal item)
    {
        setBigDecimal("totHldBsWg", item);
    }
    /**
     * Object:��¼'s IRG���ջ���property 
     */
    public java.math.BigDecimal getIRGLBase()
    {
        return getBigDecimal("IRGLBase");
    }
    public void setIRGLBase(java.math.BigDecimal item)
    {
        setBigDecimal("IRGLBase", item);
    }
    /**
     * Object:��¼'s �ۿ��ܶ�property 
     */
    public java.math.BigDecimal getTotCharge()
    {
        return getBigDecimal("totCharge");
    }
    public void setTotCharge(java.math.BigDecimal item)
    {
        setBigDecimal("totCharge", item);
    }
    /**
     * Object:��¼'s �籣���ջ���������property 
     */
    public java.math.BigDecimal getSoLevyBaseW()
    {
        return getBigDecimal("soLevyBaseW");
    }
    public void setSoLevyBaseW(java.math.BigDecimal item)
    {
        setBigDecimal("soLevyBaseW", item);
    }
    /**
     * Object:��¼'s IRG���ջ���������property 
     */
    public java.math.BigDecimal getIRGLBaseW()
    {
        return getBigDecimal("IRGLBaseW");
    }
    public void setIRGLBaseW(java.math.BigDecimal item)
    {
        setBigDecimal("IRGLBaseW", item);
    }
    /**
     * Object:��¼'s �籣��property 
     */
    public String getSecurityNo()
    {
        return getString("securityNo");
    }
    public void setSecurityNo(String item)
    {
        setString("securityNo", item);
    }
    /**
     * Object:��¼'s CCP�˻�property 
     */
    public String getCCPNo()
    {
        return getString("CCPNo");
    }
    public void setCCPNo(String item)
    {
        setString("CCPNo", item);
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
     * Object:��¼'s ��������/��property 
     */
    public java.math.BigDecimal getNWorkDay()
    {
        return getBigDecimal("nWorkDay");
    }
    public void setNWorkDay(java.math.BigDecimal item)
    {
        setBigDecimal("nWorkDay", item);
    }
    /**
     * Object:��¼'s ͨѶ�����ܶ�property 
     */
    public java.math.BigDecimal getPhoneWageC()
    {
        return getBigDecimal("phoneWageC");
    }
    public void setPhoneWageC(java.math.BigDecimal item)
    {
        setBigDecimal("phoneWageC", item);
    }
    /**
     * Object:��¼'s itmperieTolproperty 
     */
    public java.math.BigDecimal getItmperieTol()
    {
        return getBigDecimal("itmperieTol");
    }
    public void setItmperieTol(java.math.BigDecimal item)
    {
        setBigDecimal("itmperieTol", item);
    }
    /**
     * Object:��¼'s abcdefgproperty 
     */
    public java.math.BigDecimal getAbcdefg()
    {
        return getBigDecimal("abcdefg");
    }
    public void setAbcdefg(java.math.BigDecimal item)
    {
        setBigDecimal("abcdefg", item);
    }
    /**
     * Object:��¼'s �Ƚ�ֵproperty 
     */
    public java.math.BigDecimal getAaa()
    {
        return getBigDecimal("aaa");
    }
    public void setAaa(java.math.BigDecimal item)
    {
        setBigDecimal("aaa", item);
    }
    /**
     * Object:��¼'s �볡ʱ��property 
     */
    public java.util.Date getInDate()
    {
        return getDate("inDate");
    }
    public void setInDate(java.util.Date item)
    {
        setDate("inDate", item);
    }
    /**
     * Object:��¼'s ����ʱ��property 
     */
    public java.util.Date getOutDate()
    {
        return getDate("outDate");
    }
    public void setOutDate(java.util.Date item)
    {
        setDate("outDate", item);
    }
    /**
     * Object:��¼'s �籣���ַ�������property 
     */
    public String getSecuProfFr()
    {
        return getString("secuProfFr");
    }
    public void setSecuProfFr(String item)
    {
        setString("secuProfFr", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.util.Date getBirthdate()
    {
        return getDate("birthdate");
    }
    public void setBirthdate(java.util.Date item)
    {
        setDate("birthdate", item);
    }
    /**
     * Object:��¼'s ������property 
     */
    public String getCfbirthplacecn()
    {
        return getString("cfbirthplacecn");
    }
    public void setCfbirthplacecn(String item)
    {
        setString("cfbirthplacecn", item);
    }
    /**
     * Object:��¼'s ԭ��������property 
     */
    public String getMonthYear()
    {
        return getString("monthYear");
    }
    public void setMonthYear(String item)
    {
        setString("monthYear", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3BF29FCD");
    }
}