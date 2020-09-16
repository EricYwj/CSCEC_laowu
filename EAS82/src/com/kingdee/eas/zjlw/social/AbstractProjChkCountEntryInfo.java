package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProjChkCountEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractProjChkCountEntryInfo()
    {
        this("id");
    }
    protected AbstractProjChkCountEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.zjlw.social.ProjChkCountInfo getParent()
    {
        return (com.kingdee.eas.zjlw.social.ProjChkCountInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.social.ProjChkCountInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 项目名称 property 
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
     * Object: 分录 's 省份 property 
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
     * Object:分录's 检查部门property 
     */
    public com.kingdee.eas.zjlw.certificates.app.checkdepatEnum getCheckdepat()
    {
        return com.kingdee.eas.zjlw.certificates.app.checkdepatEnum.getEnum(getString("checkdepat"));
    }
    public void setCheckdepat(com.kingdee.eas.zjlw.certificates.app.checkdepatEnum item)
    {
		if (item != null) {
        setString("checkdepat", item.getValue());
		}
    }
    /**
     * Object:分录's 检查时间property 
     */
    public java.util.Date getCheckDate()
    {
        return getDate("checkDate");
    }
    public void setCheckDate(java.util.Date item)
    {
        setDate("checkDate", item);
    }
    /**
     * Object:分录's 账本property 
     */
    public boolean isBooks()
    {
        return getBoolean("books");
    }
    public void setBooks(boolean item)
    {
        setBoolean("books", item);
    }
    /**
     * Object:分录's 工资明细property 
     */
    public boolean isPayDetail()
    {
        return getBoolean("payDetail");
    }
    public void setPayDetail(boolean item)
    {
        setBoolean("payDetail", item);
    }
    /**
     * Object:分录's 人员异动登记本property 
     */
    public boolean isPersMove()
    {
        return getBoolean("persMove");
    }
    public void setPersMove(boolean item)
    {
        setBoolean("persMove", item);
    }
    /**
     * Object:分录's 阿工人员异动登记本property 
     */
    public boolean isAlgPersM()
    {
        return getBoolean("algPersM");
    }
    public void setAlgPersM(boolean item)
    {
        setBoolean("algPersM", item);
    }
    /**
     * Object:分录's 税务表property 
     */
    public boolean isTaxBooks()
    {
        return getBoolean("taxBooks");
    }
    public void setTaxBooks(boolean item)
    {
        setBoolean("taxBooks", item);
    }
    /**
     * Object:分录's 税务申报表property 
     */
    public boolean isTaxRepoBok()
    {
        return getBoolean("taxRepoBok");
    }
    public void setTaxRepoBok(boolean item)
    {
        setBoolean("taxRepoBok", item);
    }
    /**
     * Object:分录's 公司章程property 
     */
    public boolean isCompRule()
    {
        return getBoolean("compRule");
    }
    public void setCompRule(boolean item)
    {
        setBoolean("compRule", item);
    }
    /**
     * Object:分录's 营业号property 
     */
    public boolean isBusiNum()
    {
        return getBoolean("busiNum");
    }
    public void setBusiNum(boolean item)
    {
        setBoolean("busiNum", item);
    }
    /**
     * Object:分录's 总经理证件property 
     */
    public boolean isGManaNum()
    {
        return getBoolean("gManaNum");
    }
    public void setGManaNum(boolean item)
    {
        setBoolean("gManaNum", item);
    }
    /**
     * Object:分录's 原因property 
     */
    public String getReason()
    {
        return getString("reason");
    }
    public void setReason(String item)
    {
        setString("reason", item);
    }
    /**
     * Object:分录's 检查结束时间property 
     */
    public java.util.Date getChkEDate()
    {
        return getDate("chkEDate");
    }
    public void setChkEDate(java.util.Date item)
    {
        setDate("chkEDate", item);
    }
    /**
     * Object:分录's 检查结果property 
     */
    public String getChkResult()
    {
        return getString("chkResult");
    }
    public void setChkResult(String item)
    {
        setString("chkResult", item);
    }
    /**
     * Object:分录's 催告时间property 
     */
    public java.util.Date getNotiDate()
    {
        return getDate("notiDate");
    }
    public void setNotiDate(java.util.Date item)
    {
        setDate("notiDate", item);
    }
    /**
     * Object:分录's 地方委员会property 
     */
    public java.util.Date getLocaComm()
    {
        return getDate("locaComm");
    }
    public void setLocaComm(java.util.Date item)
    {
        setDate("locaComm", item);
    }
    /**
     * Object:分录's 国家委员会property 
     */
    public java.util.Date getNatiComm()
    {
        return getDate("natiComm");
    }
    public void setNatiComm(java.util.Date item)
    {
        setDate("natiComm", item);
    }
    /**
     * Object:分录's 司法 property 
     */
    public java.util.Date getJudicial()
    {
        return getDate("judicial");
    }
    public void setJudicial(java.util.Date item)
    {
        setDate("judicial", item);
    }
    /**
     * Object:分录's 补缴property 
     */
    public java.math.BigDecimal getFillPay()
    {
        return getBigDecimal("fillPay");
    }
    public void setFillPay(java.math.BigDecimal item)
    {
        setBigDecimal("fillPay", item);
    }
    /**
     * Object:分录's 滞纳金property 
     */
    public java.math.BigDecimal getPenalty()
    {
        return getBigDecimal("Penalty");
    }
    public void setPenalty(java.math.BigDecimal item)
    {
        setBigDecimal("Penalty", item);
    }
    /**
     * Object:分录's 罚款property 
     */
    public java.math.BigDecimal getFine()
    {
        return getBigDecimal("fine");
    }
    public void setFine(java.math.BigDecimal item)
    {
        setBigDecimal("fine", item);
    }
    /**
     * Object:分录's 初补缴property 
     */
    public java.math.BigDecimal getFFillPay()
    {
        return getBigDecimal("fFillPay");
    }
    public void setFFillPay(java.math.BigDecimal item)
    {
        setBigDecimal("fFillPay", item);
    }
    /**
     * Object:分录's 初滞纳金property 
     */
    public java.math.BigDecimal getFPenalty()
    {
        return getBigDecimal("fPenalty");
    }
    public void setFPenalty(java.math.BigDecimal item)
    {
        setBigDecimal("fPenalty", item);
    }
    /**
     * Object:分录's 初罚款property 
     */
    public java.math.BigDecimal getFFine()
    {
        return getBigDecimal("fFine");
    }
    public void setFFine(java.math.BigDecimal item)
    {
        setBigDecimal("fFine", item);
    }
    /**
     * Object:分录's 最终罚款总额property 
     */
    public java.math.BigDecimal getEndTolFine()
    {
        return getBigDecimal("endTolFine");
    }
    public void setEndTolFine(java.math.BigDecimal item)
    {
        setBigDecimal("endTolFine", item);
    }
    /**
     * Object:分录's 结案时间property 
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C2B924CC");
    }
}