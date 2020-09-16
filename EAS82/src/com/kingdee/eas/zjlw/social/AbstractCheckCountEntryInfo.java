package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCheckCountEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCheckCountEntryInfo()
    {
        this("id");
    }
    protected AbstractCheckCountEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.social.CheckCountInfo getParent()
    {
        return (com.kingdee.eas.zjlw.social.CheckCountInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.social.CheckCountInfo item)
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
     * Object:分录's 出生日期property 
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
     * Object: 分录 's 家庭所在省份 property 
     */
    public com.kingdee.eas.basedata.assistant.ProvinceInfo getProvince()
    {
        return (com.kingdee.eas.basedata.assistant.ProvinceInfo)get("province");
    }
    public void setProvince(com.kingdee.eas.basedata.assistant.ProvinceInfo item)
    {
        put("province", item);
    }
    /**
     * Object:分录's 出生地property 
     */
    public String getBirthPlace()
    {
        return getString("birthPlace");
    }
    public void setBirthPlace(String item)
    {
        setString("birthPlace", item);
    }
    /**
     * Object:分录's 婚姻状况property 
     */
    public com.kingdee.eas.zjlw.certificates.app.mayrStatEnum getMariState()
    {
        return com.kingdee.eas.zjlw.certificates.app.mayrStatEnum.getEnum(getString("MariState"));
    }
    public void setMariState(com.kingdee.eas.zjlw.certificates.app.mayrStatEnum item)
    {
		if (item != null) {
        setString("MariState", item.getValue());
		}
    }
    /**
     * Object:分录's 社保号码property 
     */
    public String getSecuNum()
    {
        return getString("secuNum");
    }
    public void setSecuNum(String item)
    {
        setString("secuNum", item);
    }
    /**
     * Object:分录's CCP账户property 
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
     * Object:分录's 家庭住址property 
     */
    public String getAddress()
    {
        return getString("address");
    }
    public void setAddress(String item)
    {
        setString("address", item);
    }
    /**
     * Object: 分录 's 工作项目 property 
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
     * Object: 分录 's 合作单位 property 
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
     * Object:分录's 合作单位代码property 
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
     * Object:分录's 进场日期property 
     */
    public java.util.Date getApprTime()
    {
        return getDate("apprTime");
    }
    public void setApprTime(java.util.Date item)
    {
        setDate("apprTime", item);
    }
    /**
     * Object:分录's 合同签订日期property 
     */
    public java.util.Date getContSDate()
    {
        return getDate("contSDate");
    }
    public void setContSDate(java.util.Date item)
    {
        setDate("contSDate", item);
    }
    /**
     * Object:分录's 合同到期日期property 
     */
    public java.util.Date getContEDate()
    {
        return getDate("contEDate");
    }
    public void setContEDate(java.util.Date item)
    {
        setDate("contEDate", item);
    }
    /**
     * Object: 分录 's 社保（证件）项目 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getSecuProj()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("secuProj");
    }
    public void setSecuProj(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("secuProj", item);
    }
    /**
     * Object:分录's 注册日期property 
     */
    public java.util.Date getStartDate()
    {
        return getDate("startDate");
    }
    public void setStartDate(java.util.Date item)
    {
        setDate("startDate", item);
    }
    /**
     * Object:分录's 离场日期property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    /**
     * Object:分录's 出勤天数/小时废弃property 
     */
    public int getNWorkDays()
    {
        return getInt("nWorkDays");
    }
    public void setNWorkDays(int item)
    {
        setInt("nWorkDays", item);
    }
    /**
     * Object:分录's 节日加班property 
     */
    public int getNGalaOver()
    {
        return getInt("nGalaOver");
    }
    public void setNGalaOver(int item)
    {
        setInt("nGalaOver", item);
    }
    /**
     * Object:分录's 工龄property 
     */
    public int getNSeniority()
    {
        return getInt("nSeniority");
    }
    public void setNSeniority(int item)
    {
        setInt("nSeniority", item);
    }
    /**
     * Object:分录's 基本工资property 
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
     * Object:分录's 工龄工资property 
     */
    public java.math.BigDecimal getSeniPay()
    {
        return getBigDecimal("seniPay");
    }
    public void setSeniPay(java.math.BigDecimal item)
    {
        setBigDecimal("seniPay", item);
    }
    /**
     * Object: 分录 's 交通补贴/天 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjWageInfo getTraWage()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjWageInfo)get("traWage");
    }
    public void setTraWage(com.kingdee.eas.zjlw.baseinfo.ProjWageInfo item)
    {
        put("traWage", item);
    }
    /**
     * Object:分录's 交通补贴总额property 
     */
    public java.math.BigDecimal getTraWageC()
    {
        return getBigDecimal("traWageC");
    }
    public void setTraWageC(java.math.BigDecimal item)
    {
        setBigDecimal("traWageC", item);
    }
    /**
     * Object: 分录 's 工作餐补/天 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjWageInfo getEWage()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjWageInfo)get("eWage");
    }
    public void setEWage(com.kingdee.eas.zjlw.baseinfo.ProjWageInfo item)
    {
        put("eWage", item);
    }
    /**
     * Object:分录's 工作餐补总额property 
     */
    public java.math.BigDecimal getEWageC()
    {
        return getBigDecimal("eWageC");
    }
    public void setEWageC(java.math.BigDecimal item)
    {
        setBigDecimal("eWageC", item);
    }
    /**
     * Object: 分录 's 7点后加班交通餐补补贴/次 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjWageInfo getSevWage()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjWageInfo)get("sevWage");
    }
    public void setSevWage(com.kingdee.eas.zjlw.baseinfo.ProjWageInfo item)
    {
        put("sevWage", item);
    }
    /**
     * Object:分录's 7点后加班交通餐补次数property 
     */
    public int getSevTimes()
    {
        return getInt("sevTimes");
    }
    public void setSevTimes(int item)
    {
        setInt("sevTimes", item);
    }
    /**
     * Object:分录's 7点后加班交通餐补总额property 
     */
    public java.math.BigDecimal getSevWageC()
    {
        return getBigDecimal("sevWageC");
    }
    public void setSevWageC(java.math.BigDecimal item)
    {
        setBigDecimal("sevWageC", item);
    }
    /**
     * Object: 分录 's 出差补贴/次 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjWageInfo getOutWage()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjWageInfo)get("outWage");
    }
    public void setOutWage(com.kingdee.eas.zjlw.baseinfo.ProjWageInfo item)
    {
        put("outWage", item);
    }
    /**
     * Object:分录's 出差补贴次数property 
     */
    public int getOutTimes()
    {
        return getInt("outTimes");
    }
    public void setOutTimes(int item)
    {
        setInt("outTimes", item);
    }
    /**
     * Object:分录's 出差补贴总额property 
     */
    public java.math.BigDecimal getOutWageC()
    {
        return getBigDecimal("outWageC");
    }
    public void setOutWageC(java.math.BigDecimal item)
    {
        setBigDecimal("outWageC", item);
    }
    /**
     * Object: 分录 's 出差住宿补贴 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjWageInfo getOveWage()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjWageInfo)get("oveWage");
    }
    public void setOveWage(com.kingdee.eas.zjlw.baseinfo.ProjWageInfo item)
    {
        put("oveWage", item);
    }
    /**
     * Object:分录's 出差住宿次数property 
     */
    public int getOveTimes()
    {
        return getInt("oveTimes");
    }
    public void setOveTimes(int item)
    {
        setInt("oveTimes", item);
    }
    /**
     * Object: 分录 's 现场风险补助/天 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjWageInfo getDengWage()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjWageInfo)get("dengWage");
    }
    public void setDengWage(com.kingdee.eas.zjlw.baseinfo.ProjWageInfo item)
    {
        put("dengWage", item);
    }
    /**
     * Object: 分录 's 危害补贴 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjWageInfo getVaWage()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjWageInfo)get("vaWage");
    }
    public void setVaWage(com.kingdee.eas.zjlw.baseinfo.ProjWageInfo item)
    {
        put("vaWage", item);
    }
    /**
     * Object:分录's 危害补助总额property 
     */
    public java.math.BigDecimal getVaWageC()
    {
        return getBigDecimal("vaWageC");
    }
    public void setVaWageC(java.math.BigDecimal item)
    {
        setBigDecimal("vaWageC", item);
    }
    /**
     * Object:分录's 鼓励补贴property 
     */
    public java.math.BigDecimal getNUrgeWage()
    {
        return getBigDecimal("nUrgeWage");
    }
    public void setNUrgeWage(java.math.BigDecimal item)
    {
        setBigDecimal("nUrgeWage", item);
    }
    /**
     * Object:分录's 奖金及一次性补贴property 
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
     * Object: 分录 's 丧葬婚嫁补贴/次 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjWageInfo getThingsWage()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjWageInfo)get("thingsWage");
    }
    public void setThingsWage(com.kingdee.eas.zjlw.baseinfo.ProjWageInfo item)
    {
        put("thingsWage", item);
    }
    /**
     * Object:分录's 丧葬嫁娶次数property 
     */
    public int getThingsTimes()
    {
        return getInt("thingsTimes");
    }
    public void setThingsTimes(int item)
    {
        setInt("thingsTimes", item);
    }
    /**
     * Object:分录's 丧葬嫁娶补贴总额property 
     */
    public java.math.BigDecimal getThingsWageC()
    {
        return getBigDecimal("thingsWageC");
    }
    public void setThingsWageC(java.math.BigDecimal item)
    {
        setBigDecimal("thingsWageC", item);
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
     * Object: 分录 's 家庭津贴 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjWageInfo getFamilyWage()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjWageInfo)get("familyWage");
    }
    public void setFamilyWage(com.kingdee.eas.zjlw.baseinfo.ProjWageInfo item)
    {
        put("familyWage", item);
    }
    /**
     * Object: 分录 's 就学补贴 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjWageInfo getStudyWage()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjWageInfo)get("studyWage");
    }
    public void setStudyWage(com.kingdee.eas.zjlw.baseinfo.ProjWageInfo item)
    {
        put("studyWage", item);
    }
    /**
     * Object: 分录 's 区域补贴 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjWageInfo getAreaWage()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjWageInfo)get("areaWage");
    }
    public void setAreaWage(com.kingdee.eas.zjlw.baseinfo.ProjWageInfo item)
    {
        put("areaWage", item);
    }
    /**
     * Object:分录's 夜班次数property 
     */
    public int getNWorkTimes()
    {
        return getInt("nWorkTimes");
    }
    public void setNWorkTimes(int item)
    {
        setInt("nWorkTimes", item);
    }
    /**
     * Object: 分录 's 夜班补贴/次 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjWageInfo getNWorkWage()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjWageInfo)get("nWorkWage");
    }
    public void setNWorkWage(com.kingdee.eas.zjlw.baseinfo.ProjWageInfo item)
    {
        put("nWorkWage", item);
    }
    /**
     * Object:分录's 夜班补贴总额property 
     */
    public java.math.BigDecimal getNWorkWageC()
    {
        return getBigDecimal("nWorkWageC");
    }
    public void setNWorkWageC(java.math.BigDecimal item)
    {
        setBigDecimal("nWorkWageC", item);
    }
    /**
     * Object: 分录 's 轮班补贴/次 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjWageInfo getSwitchWage()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjWageInfo)get("switchWage");
    }
    public void setSwitchWage(com.kingdee.eas.zjlw.baseinfo.ProjWageInfo item)
    {
        put("switchWage", item);
    }
    /**
     * Object:分录's 轮班次数property 
     */
    public int getSwitchTimes()
    {
        return getInt("switchTimes");
    }
    public void setSwitchTimes(int item)
    {
        setInt("switchTimes", item);
    }
    /**
     * Object:分录's 轮班补贴总额property 
     */
    public java.math.BigDecimal getSwitchWageC()
    {
        return getBigDecimal("switchWageC");
    }
    public void setSwitchWageC(java.math.BigDecimal item)
    {
        setBigDecimal("switchWageC", item);
    }
    /**
     * Object: 分录 's 住房补贴 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjWageInfo getLiveWage()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjWageInfo)get("liveWage");
    }
    public void setLiveWage(com.kingdee.eas.zjlw.baseinfo.ProjWageInfo item)
    {
        put("liveWage", item);
    }
    /**
     * Object:分录's 车辆补贴property 
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
     * Object:分录's 特殊住所和偏远补贴property 
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
     * Object:分录's 项目竣工奖property 
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
     * Object:分录's 人员编号property 
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
     * Object:分录's 外会人员编号property 
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
    /**
     * Object: 分录 's 社保工种 property 
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
     * Object: 分录 's 国籍 property 
     */
    public com.kingdee.eas.basedata.assistant.CountryInfo getNation()
    {
        return (com.kingdee.eas.basedata.assistant.CountryInfo)get("nation");
    }
    public void setNation(com.kingdee.eas.basedata.assistant.CountryInfo item)
    {
        put("nation", item);
    }
    /**
     * Object: 分录 's 一人就业补贴标准 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjWageInfo getOneWorkWage()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjWageInfo)get("oneWorkWage");
    }
    public void setOneWorkWage(com.kingdee.eas.zjlw.baseinfo.ProjWageInfo item)
    {
        put("oneWorkWage", item);
    }
    /**
     * Object:分录's 现场风险补贴总额property 
     */
    public java.math.BigDecimal getTotRiskWage()
    {
        return getBigDecimal("totRiskWage");
    }
    public void setTotRiskWage(java.math.BigDecimal item)
    {
        setBigDecimal("totRiskWage", item);
    }
    /**
     * Object:分录's 一人就业补贴总额property 
     */
    public java.math.BigDecimal getTotOneWage()
    {
        return getBigDecimal("totOneWage");
    }
    public void setTotOneWage(java.math.BigDecimal item)
    {
        setBigDecimal("totOneWage", item);
    }
    /**
     * Object:分录's 区域补贴总额property 
     */
    public java.math.BigDecimal getTotAreaWage()
    {
        return getBigDecimal("totAreaWage");
    }
    public void setTotAreaWage(java.math.BigDecimal item)
    {
        setBigDecimal("totAreaWage", item);
    }
    /**
     * Object:分录's 偏远和艰苦项目总额property 
     */
    public java.math.BigDecimal getTotFaraWage()
    {
        return getBigDecimal("totFaraWage");
    }
    public void setTotFaraWage(java.math.BigDecimal item)
    {
        setBigDecimal("totFaraWage", item);
    }
    /**
     * Object: 分录 's 语言补贴 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjWageInfo getLangWage()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjWageInfo)get("langWage");
    }
    public void setLangWage(com.kingdee.eas.zjlw.baseinfo.ProjWageInfo item)
    {
        put("langWage", item);
    }
    /**
     * Object:分录's 备注property 
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
     * Object:分录's 平时加班小时property 
     */
    public java.math.BigDecimal getNUlOver()
    {
        return getBigDecimal("nUlOver");
    }
    public void setNUlOver(java.math.BigDecimal item)
    {
        setBigDecimal("nUlOver", item);
    }
    /**
     * Object:分录's 假日加班小时property 
     */
    public java.math.BigDecimal getNHlOver()
    {
        return getBigDecimal("nHlOver");
    }
    public void setNHlOver(java.math.BigDecimal item)
    {
        setBigDecimal("nHlOver", item);
    }
    /**
     * Object:分录's 出勤天数/天property 
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
     * Object:分录's 项目社保号property 
     */
    public String getProjSocialNo()
    {
        return getString("projSocialNo");
    }
    public void setProjSocialNo(String item)
    {
        setString("projSocialNo", item);
    }
    /**
     * Object:分录's 通讯补贴总额property 
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
     * Object:分录's itmperieproperty 
     */
    public java.math.BigDecimal getItmperie()
    {
        return getBigDecimal("itmperie");
    }
    public void setItmperie(java.math.BigDecimal item)
    {
        setBigDecimal("itmperie", item);
    }
    /**
     * Object:分录's itmperieTolproperty 
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
     * Object:分录's 身份证号码property 
     */
    public String getIDNumber()
    {
        return getString("IDNumber");
    }
    public void setIDNumber(String item)
    {
        setString("IDNumber", item);
    }
    /**
     * Object:分录's 出生证明号码property 
     */
    public String getBirthIDNumber()
    {
        return getString("birthIDNumber");
    }
    public void setBirthIDNumber(String item)
    {
        setString("birthIDNumber", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("BE2B1B0B");
    }
}