package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCooprationInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCooprationInfo()
    {
        this("id");
    }
    protected AbstractCooprationInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.baseinfo.CooprationEntryCollection());
    }
    /**
     * Object: 合作单位 's 分录 property 
     */
    public com.kingdee.eas.zjlw.baseinfo.CooprationEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.baseinfo.CooprationEntryCollection)get("entrys");
    }
    /**
     * Object:合作单位's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object:合作单位's 单位简称property 
     */
    public String getShortName()
    {
        return getString("shortName");
    }
    public void setShortName(String item)
    {
        setString("shortName", item);
    }
    /**
     * Object:合作单位's 营业执照property 
     */
    public String getBsLicCode()
    {
        return getString("bsLicCode");
    }
    public void setBsLicCode(String item)
    {
        setString("bsLicCode", item);
    }
    /**
     * Object:合作单位's 注册资本property 
     */
    public java.math.BigDecimal getCapital()
    {
        return getBigDecimal("capital");
    }
    public void setCapital(java.math.BigDecimal item)
    {
        setBigDecimal("capital", item);
    }
    /**
     * Object:合作单位's 组织机构代码property 
     */
    public String getOrgNumber()
    {
        return getString("orgNumber");
    }
    public void setOrgNumber(String item)
    {
        setString("orgNumber", item);
    }
    /**
     * Object:合作单位's 税务登记号property 
     */
    public String getTaxCode()
    {
        return getString("taxCode");
    }
    public void setTaxCode(String item)
    {
        setString("taxCode", item);
    }
    /**
     * Object:合作单位's 开户银行property 
     */
    public String getBank()
    {
        return getString("bank");
    }
    public void setBank(String item)
    {
        setString("bank", item);
    }
    /**
     * Object:合作单位's 法人代表property 
     */
    public String getLegalPerson()
    {
        return getString("legalPerson");
    }
    public void setLegalPerson(String item)
    {
        setString("legalPerson", item);
    }
    /**
     * Object:合作单位's 授权代理人property 
     */
    public String getSptor()
    {
        return getString("sptor");
    }
    public void setSptor(String item)
    {
        setString("sptor", item);
    }
    /**
     * Object:合作单位's 授权代理人生效时间property 
     */
    public java.util.Date getRspEffTime()
    {
        return getDate("rspEffTime");
    }
    public void setRspEffTime(java.util.Date item)
    {
        setDate("rspEffTime", item);
    }
    /**
     * Object:合作单位's 授权代理人到期时间property 
     */
    public java.util.Date getRspEndTime()
    {
        return getDate("rspEndTime");
    }
    public void setRspEndTime(java.util.Date item)
    {
        setDate("rspEndTime", item);
    }
    /**
     * Object:合作单位's 授权有无公证property 
     */
    public boolean isIsRspIdf()
    {
        return getBoolean("isRspIdf");
    }
    public void setIsRspIdf(boolean item)
    {
        setBoolean("isRspIdf", item);
    }
    /**
     * Object:合作单位's 是否有转授权property 
     */
    public boolean isIsRspTran()
    {
        return getBoolean("isRspTran");
    }
    public void setIsRspTran(boolean item)
    {
        setBoolean("isRspTran", item);
    }
    /**
     * Object:合作单位's 单位地址property 
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
     * Object:合作单位's 资质等级property 
     */
    public com.kingdee.eas.zjlw.certificates.app.levelEnum getLevel()
    {
        return com.kingdee.eas.zjlw.certificates.app.levelEnum.getEnum(getString("level"));
    }
    public void setLevel(com.kingdee.eas.zjlw.certificates.app.levelEnum item)
    {
		if (item != null) {
        setString("level", item.getValue());
		}
    }
    /**
     * Object:合作单位's 是否具有对外承包资格property 
     */
    public boolean isIsHaveConQlf()
    {
        return getBoolean("isHaveConQlf");
    }
    public void setIsHaveConQlf(boolean item)
    {
        setBoolean("isHaveConQlf", item);
    }
    /**
     * Object:合作单位's 是否具有外派劳务资质property 
     */
    public boolean isIsHaveLbrExp()
    {
        return getBoolean("isHaveLbrExp");
    }
    public void setIsHaveLbrExp(boolean item)
    {
        setBoolean("isHaveLbrExp", item);
    }
    /**
     * Object:合作单位's 电子邮箱property 
     */
    public String getMail()
    {
        return getString("mail");
    }
    public void setMail(String item)
    {
        setString("mail", item);
    }
    /**
     * Object: 合作单位 's 合作单位 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getProCom()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("proCom");
    }
    public void setProCom(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("proCom", item);
    }
    /**
     * Object:合作单位's 联系方式property 
     */
    public String getTelphone()
    {
        return getString("telphone");
    }
    public void setTelphone(String item)
    {
        setString("telphone", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("738569BE");
    }
}