package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProjectOrgInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractProjectOrgInfo()
    {
        this("id");
    }
    protected AbstractProjectOrgInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.baseinfo.ProjectOrgEntryCollection());
    }
    /**
     * Object: ��Ŀ������Ϣ 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjectOrgEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjectOrgEntryCollection)get("entrys");
    }
    /**
     * Object:��Ŀ������Ϣ's �Ƿ�����ƾ֤property 
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
     * Object: ��Ŀ������Ϣ 's ��Ŀ���� property 
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
     * Object:��Ŀ������Ϣ's ��Ŀ��������property 
     */
    public String getNameFR()
    {
        return getString("nameFR");
    }
    public void setNameFR(String item)
    {
        setString("nameFR", item);
    }
    /**
     * Object: ��Ŀ������Ϣ 's ������ҵ�� property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getDprtName()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("dprtName");
    }
    public void setDprtName(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("dprtName", item);
    }
    /**
     * Object: ��Ŀ������Ϣ 's ����ʡ�� property 
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
     * Object:��Ŀ������Ϣ's ҵ��property 
     */
    public String getOwner()
    {
        return getString("owner");
    }
    public void setOwner(String item)
    {
        setString("owner", item);
    }
    /**
     * Object:��Ŀ������Ϣ's ��Ŀ����property 
     */
    public String getProjManager()
    {
        return getString("ProjManager");
    }
    public void setProjManager(String item)
    {
        setString("ProjManager", item);
    }
    /**
     * Object:��Ŀ������Ϣ's ��Ŀ״̬property 
     */
    public com.kingdee.eas.zjlw.certificates.app.projStatusEnum getProjStatus()
    {
        return com.kingdee.eas.zjlw.certificates.app.projStatusEnum.getEnum(getString("projStatus"));
    }
    public void setProjStatus(com.kingdee.eas.zjlw.certificates.app.projStatusEnum item)
    {
		if (item != null) {
        setString("projStatus", item.getValue());
		}
    }
    /**
     * Object:��Ŀ������Ϣ's ��ͬ����property 
     */
    public String getContructTime()
    {
        return getString("contructTime");
    }
    public void setContructTime(String item)
    {
        setString("contructTime", item);
    }
    /**
     * Object:��Ŀ������Ϣ's ������ʱ��property 
     */
    public java.util.Date getInitialDate()
    {
        return getDate("initialDate");
    }
    public void setInitialDate(java.util.Date item)
    {
        setDate("initialDate", item);
    }
    /**
     * Object:��Ŀ������Ϣ's ������ʱ��property 
     */
    public java.util.Date getActBeginDate()
    {
        return getDate("actBeginDate");
    }
    public void setActBeginDate(java.util.Date item)
    {
        setDate("actBeginDate", item);
    }
    /**
     * Object:��Ŀ������Ϣ's �����˺�property 
     */
    public String getProjConnector()
    {
        return getString("ProjConnector");
    }
    public void setProjConnector(String item)
    {
        setString("ProjConnector", item);
    }
    /**
     * Object:��Ŀ������Ϣ's �籣�˺�property 
     */
    public String getInsuranceAcc()
    {
        return getString("insuranceAcc");
    }
    public void setInsuranceAcc(String item)
    {
        setString("insuranceAcc", item);
    }
    /**
     * Object:��Ŀ������Ϣ's ����ʱ��property 
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
     * Object:��Ŀ������Ϣ's ����ʱ��property 
     */
    public java.util.Date getActEndDate()
    {
        return getDate("actEndDate");
    }
    public void setActEndDate(java.util.Date item)
    {
        setDate("actEndDate", item);
    }
    /**
     * Object:��Ŀ������Ϣ's ֤�������ֹʱ��property 
     */
    public java.util.Date getPermitEndDate()
    {
        return getDate("permitEndDate");
    }
    public void setPermitEndDate(java.util.Date item)
    {
        setDate("permitEndDate", item);
    }
    /**
     * Object:��Ŀ������Ϣ's �籣�˻��ر�ʱ��property 
     */
    public java.util.Date getInsEndDate()
    {
        return getDate("insEndDate");
    }
    public void setInsEndDate(java.util.Date item)
    {
        setDate("insEndDate", item);
    }
    /**
     * Object:��Ŀ������Ϣ's ��Ŀ��ַproperty 
     */
    public String getAddressFR()
    {
        return getString("addressFR");
    }
    public void setAddressFR(String item)
    {
        setString("addressFR", item);
    }
    /**
     * Object:��Ŀ������Ϣ's �Ƿ����ʹ��ע��property 
     */
    public boolean isIsLogin()
    {
        return getBoolean("isLogin");
    }
    public void setIsLogin(boolean item)
    {
        setBoolean("isLogin", item);
    }
    /**
     * Object:��Ŀ������Ϣ's ��ͬǩ��ʱ��property 
     */
    public java.util.Date getConSgnDate()
    {
        return getDate("conSgnDate");
    }
    public void setConSgnDate(java.util.Date item)
    {
        setDate("conSgnDate", item);
    }
    /**
     * Object:��Ŀ������Ϣ's ��ͬ����ʱ��property 
     */
    public java.util.Date getConExpDate()
    {
        return getDate("conExpDate");
    }
    public void setConExpDate(java.util.Date item)
    {
        setDate("conExpDate", item);
    }
    /**
     * Object:��Ŀ������Ϣ's �ݼٹ����˺�property 
     */
    public String getVcPayAcc()
    {
        return getString("vcPayAcc");
    }
    public void setVcPayAcc(String item)
    {
        setString("vcPayAcc", item);
    }
    /**
     * Object:��Ŀ������Ϣ's �ݼٹ����˻��ر�ʱ��property 
     */
    public java.util.Date getVPAccEndDate()
    {
        return getDate("VPAccEndDate");
    }
    public void setVPAccEndDate(java.util.Date item)
    {
        setDate("VPAccEndDate", item);
    }
    /**
     * Object:��Ŀ������Ϣ's ֤��ȫ��ע��ʱ��property 
     */
    public java.util.Date getPmtEndDate()
    {
        return getDate("pmtEndDate");
    }
    public void setPmtEndDate(java.util.Date item)
    {
        setDate("pmtEndDate", item);
    }
    /**
     * Object:��Ŀ������Ϣ's ��������property 
     */
    public com.kingdee.eas.zjlw.certificates.app.BelongAreaEnum getArea()
    {
        return com.kingdee.eas.zjlw.certificates.app.BelongAreaEnum.getEnum(getString("area"));
    }
    public void setArea(com.kingdee.eas.zjlw.certificates.app.BelongAreaEnum item)
    {
		if (item != null) {
        setString("area", item.getValue());
		}
    }
    /**
     * Object:��Ŀ������Ϣ's ��������property 
     */
    public String getInPoliceOff()
    {
        return getString("inPoliceOff");
    }
    public void setInPoliceOff(String item)
    {
        setString("inPoliceOff", item);
    }
    /**
     * Object: ��Ŀ������Ϣ 's �����Ͷ��� property 
     */
    public com.kingdee.eas.basedata.assistant.ProvinceInfo getInLaborBureau()
    {
        return (com.kingdee.eas.basedata.assistant.ProvinceInfo)get("inLaborBureau");
    }
    public void setInLaborBureau(com.kingdee.eas.basedata.assistant.ProvinceInfo item)
    {
        put("inLaborBureau", item);
    }
    /**
     * Object:��Ŀ������Ϣ's �����籣��property 
     */
    public String getInSocialSeBur()
    {
        return getString("inSocialSeBur");
    }
    public void setInSocialSeBur(String item)
    {
        setString("inSocialSeBur", item);
    }
    /**
     * Object:��Ŀ������Ϣ's �����ݼٹ��ʾ�property 
     */
    public String getInLeaveOff()
    {
        return getString("inLeaveOff");
    }
    public void setInLeaveOff(String item)
    {
        setString("inLeaveOff", item);
    }
    /**
     * Object:��Ŀ������Ϣ's �����Ͷ�����property 
     */
    public String getInLabSupBur()
    {
        return getString("inLabSupBur");
    }
    public void setInLabSupBur(String item)
    {
        setString("inLabSupBur", item);
    }
    /**
     * Object:��Ŀ������Ϣ's ������ҵ��property 
     */
    public String getInEmploBur()
    {
        return getString("inEmploBur");
    }
    public void setInEmploBur(String item)
    {
        setString("inEmploBur", item);
    }
    /**
     * Object:��Ŀ������Ϣ's ����������property 
     */
    public String getInDistrGov()
    {
        return getString("inDistrGov");
    }
    public void setInDistrGov(String item)
    {
        setString("inDistrGov", item);
    }
    /**
     * Object:��Ŀ������Ϣ's �籣���property 
     */
    public String getInExtAccount()
    {
        return getString("inExtAccount");
    }
    public void setInExtAccount(String item)
    {
        setString("inExtAccount", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4494DF79");
    }
}