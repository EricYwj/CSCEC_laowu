package com.kingdee.eas.zjlw.social;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLocalPayPrintInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractLocalPayPrintInfo()
    {
        this("id");
    }
    protected AbstractLocalPayPrintInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.zjlw.social.LocalPayPrintEntryCollection());
    }
    /**
     * Object: ���ػ��������ݴ�ӡ 's ��¼ property 
     */
    public com.kingdee.eas.zjlw.social.LocalPayPrintEntryCollection getEntrys()
    {
        return (com.kingdee.eas.zjlw.social.LocalPayPrintEntryCollection)get("entrys");
    }
    /**
     * Object:���ػ��������ݴ�ӡ's �Ƿ�����ƾ֤property 
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
     * Object: ���ػ��������ݴ�ӡ 's ��Ŀ���� property 
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
     * Object:���ػ��������ݴ�ӡ's ��Ŀ�籣��property 
     */
    public String getProjSCNum()
    {
        return getString("projSCNum");
    }
    public void setProjSCNum(String item)
    {
        setString("projSCNum", item);
    }
    /**
     * Object: ���ػ��������ݴ�ӡ 's ��ʼ���� property 
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
     * Object:���ػ��������ݴ�ӡ's ��Ŀ���ڵ�property 
     */
    public String getProjAddress()
    {
        return getString("ProjAddress");
    }
    public void setProjAddress(String item)
    {
        setString("ProjAddress", item);
    }
    /**
     * Object:���ػ��������ݴ�ӡ's �����籣��property 
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
     * Object:���ػ��������ݴ�ӡ's ��property 
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
     * Object:���ػ��������ݴ�ӡ's ��property 
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
     * Object:���ػ��������ݴ�ӡ's ��������property 
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
     * Object: ���ػ��������ݴ�ӡ 's �������� property 
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
     * Object: ���ػ��������ݴ�ӡ 's ������Ŀ property 
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
     * Object: ���ػ��������ݴ�ӡ 's ������λ property 
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
     * Object:���ػ��������ݴ�ӡ's ��Ŀ��������property 
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
     * Object: ���ػ��������ݴ�ӡ 's ��Ŀ����ʡ�� property 
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
     * Object:���ػ��������ݴ�ӡ's bd1property 
     */
    public String getBD1()
    {
        return getString("bD1");
    }
    public void setBD1(String item)
    {
        setString("bD1", item);
    }
    /**
     * Object:���ػ��������ݴ�ӡ's bd2property 
     */
    public String getBD2()
    {
        return getString("bD2");
    }
    public void setBD2(String item)
    {
        setString("bD2", item);
    }
    /**
     * Object:���ػ��������ݴ�ӡ's bM1property 
     */
    public String getBM1()
    {
        return getString("bM1");
    }
    public void setBM1(String item)
    {
        setString("bM1", item);
    }
    /**
     * Object:���ػ��������ݴ�ӡ's bM2property 
     */
    public String getBM2()
    {
        return getString("bM2");
    }
    public void setBM2(String item)
    {
        setString("bM2", item);
    }
    /**
     * Object:���ػ��������ݴ�ӡ's byear1property 
     */
    public String getByear1()
    {
        return getString("byear1");
    }
    public void setByear1(String item)
    {
        setString("byear1", item);
    }
    /**
     * Object:���ػ��������ݴ�ӡ's byear2property 
     */
    public String getByear2()
    {
        return getString("byear2");
    }
    public void setByear2(String item)
    {
        setString("byear2", item);
    }
    /**
     * Object:���ػ��������ݴ�ӡ's iday1property 
     */
    public String getIday1()
    {
        return getString("iday1");
    }
    public void setIday1(String item)
    {
        setString("iday1", item);
    }
    /**
     * Object:���ػ��������ݴ�ӡ's iday2property 
     */
    public String getIday2()
    {
        return getString("iday2");
    }
    public void setIday2(String item)
    {
        setString("iday2", item);
    }
    /**
     * Object:���ػ��������ݴ�ӡ's imon1property 
     */
    public String getImon1()
    {
        return getString("imon1");
    }
    public void setImon1(String item)
    {
        setString("imon1", item);
    }
    /**
     * Object:���ػ��������ݴ�ӡ's imon2property 
     */
    public String getImon2()
    {
        return getString("imon2");
    }
    public void setImon2(String item)
    {
        setString("imon2", item);
    }
    /**
     * Object:���ػ��������ݴ�ӡ's iy1property 
     */
    public String getIy1()
    {
        return getString("iy1");
    }
    public void setIy1(String item)
    {
        setString("iy1", item);
    }
    /**
     * Object:���ػ��������ݴ�ӡ's iy2property 
     */
    public String getIy2()
    {
        return getString("iy2");
    }
    public void setIy2(String item)
    {
        setString("iy2", item);
    }
    /**
     * Object:���ػ��������ݴ�ӡ's od1property 
     */
    public String getOd1()
    {
        return getString("od1");
    }
    public void setOd1(String item)
    {
        setString("od1", item);
    }
    /**
     * Object:���ػ��������ݴ�ӡ's od2property 
     */
    public String getOd2()
    {
        return getString("od2");
    }
    public void setOd2(String item)
    {
        setString("od2", item);
    }
    /**
     * Object:���ػ��������ݴ�ӡ's om1property 
     */
    public String getOm1()
    {
        return getString("om1");
    }
    public void setOm1(String item)
    {
        setString("om1", item);
    }
    /**
     * Object:���ػ��������ݴ�ӡ's om2property 
     */
    public String getOm2()
    {
        return getString("om2");
    }
    public void setOm2(String item)
    {
        setString("om2", item);
    }
    /**
     * Object:���ػ��������ݴ�ӡ's oy1property 
     */
    public String getOy1()
    {
        return getString("oy1");
    }
    public void setOy1(String item)
    {
        setString("oy1", item);
    }
    /**
     * Object:���ػ��������ݴ�ӡ's oy2property 
     */
    public String getOy2()
    {
        return getString("oy2");
    }
    public void setOy2(String item)
    {
        setString("oy2", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("15B29EB0");
    }
}