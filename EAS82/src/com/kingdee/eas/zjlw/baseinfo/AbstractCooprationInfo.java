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
     * Object: ������λ 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.baseinfo.CooprationEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.baseinfo.CooprationEntryCollection)get("entrys");
    }
    /**
     * Object:������λ's �Ƿ�����ƾ֤property 
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
     * Object:������λ's ��λ���property 
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
     * Object:������λ's Ӫҵִ��property 
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
     * Object:������λ's ע���ʱ�property 
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
     * Object:������λ's ��֯��������property 
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
     * Object:������λ's ˰��ǼǺ�property 
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
     * Object:������λ's ��������property 
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
     * Object:������λ's ���˴���property 
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
     * Object:������λ's ��Ȩ������property 
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
     * Object:������λ's ��Ȩ��������Чʱ��property 
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
     * Object:������λ's ��Ȩ�����˵���ʱ��property 
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
     * Object:������λ's ��Ȩ���޹�֤property 
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
     * Object:������λ's �Ƿ���ת��Ȩproperty 
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
     * Object:������λ's ��λ��ַproperty 
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
     * Object:������λ's ���ʵȼ�property 
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
     * Object:������λ's �Ƿ���ж���а��ʸ�property 
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
     * Object:������λ's �Ƿ����������������property 
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
     * Object:������λ's ��������property 
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
     * Object: ������λ 's ������λ property 
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
     * Object:������λ's ��ϵ��ʽproperty 
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