package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPayPrintInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractPayPrintInfo()
    {
        this("id");
    }
    protected AbstractPayPrintInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.social.PayPrintEntryCollection());
    }
    /**
     * Object: ���ʵ���ӡ 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.social.PayPrintEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.social.PayPrintEntryCollection)get("entrys");
    }
    /**
     * Object: ���ʵ���ӡ 's ��Ŀ���� property 
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
     * Object: ���ʵ���ӡ 's ��ʼ���� property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getMonthYearr()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("monthYearr");
    }
    public void setMonthYearr(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("monthYearr", item);
    }
    /**
     * Object: ���ʵ���ӡ 's �������� property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getEndDate()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("endDate");
    }
    public void setEndDate(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("endDate", item);
    }
    /**
     * Object:���ʵ���ӡ's �����籣��property 
     */
    public String getPSecuNumber()
    {
        return getString("pSecuNumber");
    }
    public void setPSecuNumber(String item)
    {
        setString("pSecuNumber", item);
    }
    /**
     * Object: ���ʵ���ӡ 's ������λ property 
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
     * Object:���ʵ���ӡ's ��Ŀ�籣��property 
     */
    public String getProjSecuNumber()
    {
        return getString("projSecuNumber");
    }
    public void setProjSecuNumber(String item)
    {
        setString("projSecuNumber", item);
    }
    /**
     * Object:���ʵ���ӡ's ��property 
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
     * Object:���ʵ���ӡ's ��property 
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
     * Object:���ʵ���ӡ's ��������property 
     */
    public java.util.Date getBirthday()
    {
        return getDate("birthday");
    }
    public void setBirthday(java.util.Date item)
    {
        setDate("birthday", item);
    }
    /**
     * Object: ���ʵ���ӡ 's ������Ŀ property 
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
     * Object: ���ʵ���ӡ 's ��Ŀ����ʡ�� property 
     */
    public com.kingdee.eas.basedata.assistant.ProvinceInfo getProjPri()
    {
        return (com.kingdee.eas.basedata.assistant.ProvinceInfo)get("projPri");
    }
    public void setProjPri(com.kingdee.eas.basedata.assistant.ProvinceInfo item)
    {
        put("projPri", item);
    }
    /**
     * Object:���ʵ���ӡ's ��Ŀ���Ʒ���property 
     */
    public String getProjNameFr()
    {
        return getString("projNameFr");
    }
    public void setProjNameFr(String item)
    {
        setString("projNameFr", item);
    }
    /**
     * Object:���ʵ���ӡ's ��Ŀ��ַ����property 
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
     * Object:���ʵ���ӡ's ��Ŀ�籣��property 
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
     * Object:���ʵ���ӡ's ������������1property 
     */
    public String getBirthdayDay1()
    {
        return getString("birthdayDay1");
    }
    public void setBirthdayDay1(String item)
    {
        setString("birthdayDay1", item);
    }
    /**
     * Object:���ʵ���ӡ's ������������2property 
     */
    public String getBirthdayDay2()
    {
        return getString("birthdayDay2");
    }
    public void setBirthdayDay2(String item)
    {
        setString("birthdayDay2", item);
    }
    /**
     * Object:���ʵ���ӡ's ���������·�1property 
     */
    public String getBirthdayMonth1()
    {
        return getString("birthdayMonth1");
    }
    public void setBirthdayMonth1(String item)
    {
        setString("birthdayMonth1", item);
    }
    /**
     * Object:���ʵ���ӡ's ���������·�2property 
     */
    public String getBirthdayMonth2()
    {
        return getString("birthdayMonth2");
    }
    public void setBirthdayMonth2(String item)
    {
        setString("birthdayMonth2", item);
    }
    /**
     * Object:���ʵ���ӡ's ����������1property 
     */
    public String getBirthdayYear1()
    {
        return getString("birthdayYear1");
    }
    public void setBirthdayYear1(String item)
    {
        setString("birthdayYear1", item);
    }
    /**
     * Object:���ʵ���ӡ's ����������2property 
     */
    public String getBirthdayYear2()
    {
        return getString("birthdayYear2");
    }
    public void setBirthdayYear2(String item)
    {
        setString("birthdayYear2", item);
    }
    /**
     * Object:���ʵ���ӡ's �볡��������1property 
     */
    public String getInDayDay1()
    {
        return getString("inDayDay1");
    }
    public void setInDayDay1(String item)
    {
        setString("inDayDay1", item);
    }
    /**
     * Object:���ʵ���ӡ's �볡��������2property 
     */
    public String getInDayDay2()
    {
        return getString("inDayDay2");
    }
    public void setInDayDay2(String item)
    {
        setString("inDayDay2", item);
    }
    /**
     * Object:���ʵ���ӡ's �볡�����·�1property 
     */
    public String getInDayMonth1()
    {
        return getString("inDayMonth1");
    }
    public void setInDayMonth1(String item)
    {
        setString("inDayMonth1", item);
    }
    /**
     * Object:���ʵ���ӡ's �볡�����·�2property 
     */
    public String getInDayMonth2()
    {
        return getString("inDayMonth2");
    }
    public void setInDayMonth2(String item)
    {
        setString("inDayMonth2", item);
    }
    /**
     * Object:���ʵ���ӡ's �볡������1property 
     */
    public String getInDayYear1()
    {
        return getString("inDayYear1");
    }
    public void setInDayYear1(String item)
    {
        setString("inDayYear1", item);
    }
    /**
     * Object:���ʵ���ӡ's �볡������2property 
     */
    public String getInDayYear2()
    {
        return getString("inDayYear2");
    }
    public void setInDayYear2(String item)
    {
        setString("inDayYear2", item);
    }
    /**
     * Object:���ʵ���ӡ's �볡��������1property 
     */
    public String getOutDayDay1()
    {
        return getString("outDayDay1");
    }
    public void setOutDayDay1(String item)
    {
        setString("outDayDay1", item);
    }
    /**
     * Object:���ʵ���ӡ's �볡��������2property 
     */
    public String getOutDayDay2()
    {
        return getString("outDayDay2");
    }
    public void setOutDayDay2(String item)
    {
        setString("outDayDay2", item);
    }
    /**
     * Object:���ʵ���ӡ's �볡�����·�1property 
     */
    public String getOutDayMonth1()
    {
        return getString("outDayMonth1");
    }
    public void setOutDayMonth1(String item)
    {
        setString("outDayMonth1", item);
    }
    /**
     * Object:���ʵ���ӡ's �볡�����·�2property 
     */
    public String getOutDayMonth2()
    {
        return getString("outDayMonth2");
    }
    public void setOutDayMonth2(String item)
    {
        setString("outDayMonth2", item);
    }
    /**
     * Object:���ʵ���ӡ's �볡������1property 
     */
    public String getOutDayYear1()
    {
        return getString("outDayYear1");
    }
    public void setOutDayYear1(String item)
    {
        setString("outDayYear1", item);
    }
    /**
     * Object:���ʵ���ӡ's �볡������2property 
     */
    public String getOutDayYear2()
    {
        return getString("outDayYear2");
    }
    public void setOutDayYear2(String item)
    {
        setString("outDayYear2", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("67AF77A5");
    }
}