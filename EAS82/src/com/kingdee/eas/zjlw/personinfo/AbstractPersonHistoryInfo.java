package com.kingdee.eas.zjlw.personinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPersonHistoryInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractPersonHistoryInfo()
    {
        this("id");
    }
    protected AbstractPersonHistoryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's �Ƿ�����ƾ֤property 
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
     * Object:��Ա��ʷ��Ϣ's ��������property 
     */
    public String getNameCN()
    {
        return getString("nameCN");
    }
    public void setNameCN(String item)
    {
        setString("nameCN", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's �Ա� property 
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
     * Object:��Ա��ʷ��Ϣ's ��������property 
     */
    public java.util.Date getBirthDate()
    {
        return getDate("birthDate");
    }
    public void setBirthDate(java.util.Date item)
    {
        setDate("birthDate", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ���պ���property 
     */
    public String getPassportNo()
    {
        return getString("passportNo");
    }
    public void setPassportNo(String item)
    {
        setString("passportNo", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ����ǩ������property 
     */
    public java.util.Date getPassportIssueDate()
    {
        return getDate("passportIssueDate");
    }
    public void setPassportIssueDate(java.util.Date item)
    {
        setDate("passportIssueDate", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ����ʧЧ����property 
     */
    public java.util.Date getPassportExpireDate()
    {
        return getDate("passportExpireDate");
    }
    public void setPassportExpireDate(java.util.Date item)
    {
        setDate("passportExpireDate", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's �����أ����ģ�property 
     */
    public String getBirthPlaceCn()
    {
        return getString("birthPlaceCn");
    }
    public void setBirthPlaceCn(String item)
    {
        setString("birthPlaceCn", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's �����أ����ģ�property 
     */
    public String getBirthPlaceFr()
    {
        return getString("birthPlaceFr");
    }
    public void setBirthPlaceFr(String item)
    {
        setString("birthPlaceFr", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ��������property 
     */
    public String getFatherName()
    {
        return getString("fatherName");
    }
    public void setFatherName(String item)
    {
        setString("fatherName", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ��������ƴ��property 
     */
    public String getFatherNameAlphabet()
    {
        return getString("fatherNameAlphabet");
    }
    public void setFatherNameAlphabet(String item)
    {
        setString("fatherNameAlphabet", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ĸ������property 
     */
    public String getMotherName()
    {
        return getString("motherName");
    }
    public void setMotherName(String item)
    {
        setString("motherName", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ĸ������ƴ��property 
     */
    public String getMotherNameAlphabet()
    {
        return getString("motherNameAlphabet");
    }
    public void setMotherNameAlphabet(String item)
    {
        setString("motherNameAlphabet", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ��ż����property 
     */
    public String getCoupleName()
    {
        return getString("coupleName");
    }
    public void setCoupleName(String item)
    {
        setString("coupleName", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ��ż����ƴ��property 
     */
    public String getCoupleNameAlphabet()
    {
        return getString("coupleNameAlphabet");
    }
    public void setCoupleNameAlphabet(String item)
    {
        setString("coupleNameAlphabet", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ��ż��������property 
     */
    public java.util.Date getCoupleBirthDate()
    {
        return getDate("coupleBirthDate");
    }
    public void setCoupleBirthDate(java.util.Date item)
    {
        setDate("coupleBirthDate", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ��ż������property 
     */
    public String getCoupleBirthPlace()
    {
        return getString("coupleBirthPlace");
    }
    public void setCoupleBirthPlace(String item)
    {
        setString("coupleBirthPlace", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ��ż������λ����Ŀproperty 
     */
    public String getCoupleWorkPlace()
    {
        return getString("coupleWorkPlace");
    }
    public void setCoupleWorkPlace(String item)
    {
        setString("coupleWorkPlace", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ������ϵ��ϸ��ַproperty 
     */
    public String getInnerAddress()
    {
        return getString("innerAddress");
    }
    public void setInnerAddress(String item)
    {
        setString("innerAddress", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ������ϵ��ʽproperty 
     */
    public String getContactway()
    {
        return getString("contactway");
    }
    public void setContactway(String item)
    {
        setString("contactway", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's �ɻ��պ���property 
     */
    public String getOldPassport()
    {
        return getString("oldPassport");
    }
    public void setOldPassport(String item)
    {
        setString("oldPassport", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ��עproperty 
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
     * Object:��Ա��ʷ��Ϣ's ��Աҵ��״̬property 
     */
    public com.kingdee.eas.zjlw.certificates.app.perBizStateEnum getBsnisState()
    {
        return com.kingdee.eas.zjlw.certificates.app.perBizStateEnum.getEnum(getString("bsnisState"));
    }
    public void setBsnisState(com.kingdee.eas.zjlw.certificates.app.perBizStateEnum item)
    {
		if (item != null) {
        setString("bsnisState", item.getValue());
		}
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ǩ֤����property 
     */
    public com.kingdee.eas.zjlw.certificates.app.visaTypeEnum getVisaType()
    {
        return com.kingdee.eas.zjlw.certificates.app.visaTypeEnum.getEnum(getString("visaType"));
    }
    public void setVisaType(com.kingdee.eas.zjlw.certificates.app.visaTypeEnum item)
    {
		if (item != null) {
        setString("visaType", item.getValue());
		}
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ��ƴ��property 
     */
    public String getFirstNameAlp()
    {
        return getString("firstNameAlp");
    }
    public void setFirstNameAlp(String item)
    {
        setString("firstNameAlp", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ��ƴ��property 
     */
    public String getLastNameApl()
    {
        return getString("lastNameApl");
    }
    public void setLastNameApl(String item)
    {
        setString("lastNameApl", item);
    }
    /**
     * Object: ��Ա��ʷ��Ϣ 's ָ�깤�� property 
     */
    public com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo getPermitProfession()
    {
        return (com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo)get("permitProfession");
    }
    public void setPermitProfession(com.kingdee.eas.zjlw.baseinfo.ProjectWorkInfo item)
    {
        put("permitProfession", item);
    }
    /**
     * Object: ��Ա��ʷ��Ϣ 's ������Ŀ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getWorkOrg()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("workOrg");
    }
    public void setWorkOrg(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("workOrg", item);
    }
    /**
     * Object: ��Ա��ʷ��Ϣ 's ָ����Ŀ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getPermitOrg()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("permitOrg");
    }
    public void setPermitOrg(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("permitOrg", item);
    }
    /**
     * Object: ��Ա��ʷ��Ϣ 's ������λ property 
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
     * Object:��Ա��ʷ��Ϣ's ���հ䷢����property 
     */
    public String getPassportInst()
    {
        return getString("passportInst");
    }
    public void setPassportInst(String item)
    {
        setString("passportInst", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ����״̬property 
     */
    public com.kingdee.eas.zjlw.certificates.app.mayrStatEnum getMerState()
    {
        return com.kingdee.eas.zjlw.certificates.app.mayrStatEnum.getEnum(getString("merState"));
    }
    public void setMerState(com.kingdee.eas.zjlw.certificates.app.mayrStatEnum item)
    {
		if (item != null) {
        setString("merState", item.getValue());
		}
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ���֤����property 
     */
    public String getIdNum()
    {
        return getString("idNum");
    }
    public void setIdNum(String item)
    {
        setString("idNum", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ʵ�ʹ���property 
     */
    public String getRealProf()
    {
        return getString("realProf");
    }
    public void setRealProf(String item)
    {
        setString("realProf", item);
    }
    /**
     * Object: ��Ա��ʷ��Ϣ 's ���� property 
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
     * Object: ��Ա��ʷ��Ϣ 's ��ż���� property 
     */
    public com.kingdee.eas.basedata.assistant.CountryInfo getCoupleNation()
    {
        return (com.kingdee.eas.basedata.assistant.CountryInfo)get("coupleNation");
    }
    public void setCoupleNation(com.kingdee.eas.basedata.assistant.CountryInfo item)
    {
        put("coupleNation", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's �籣��property 
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
     * Object:��Ա��ʷ��Ϣ's ԭ��Աҵ��״̬property 
     */
    public com.kingdee.eas.zjlw.certificates.app.perBizStateEnum getHBsnisState()
    {
        return com.kingdee.eas.zjlw.certificates.app.perBizStateEnum.getEnum(getString("hBsnisState"));
    }
    public void setHBsnisState(com.kingdee.eas.zjlw.certificates.app.perBizStateEnum item)
    {
		if (item != null) {
        setString("hBsnisState", item.getValue());
		}
    }
    /**
     * Object: ��Ա��ʷ��Ϣ 's ����ǩ�������� property 
     */
    public com.kingdee.eas.basedata.assistant.ProvinceInfo getPassportCity()
    {
        return (com.kingdee.eas.basedata.assistant.ProvinceInfo)get("passportCity");
    }
    public void setPassportCity(com.kingdee.eas.basedata.assistant.ProvinceInfo item)
    {
        put("passportCity", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ����ǩ����ƴ��property 
     */
    public String getPassportCityF()
    {
        return getString("passportCityF");
    }
    public void setPassportCityF(String item)
    {
        setString("passportCityF", item);
    }
    /**
     * Object: ��Ա��ʷ��Ϣ 's ��ʷ������λ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getCoopHis()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("coopHis");
    }
    public void setCoopHis(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("coopHis", item);
    }
    /**
     * Object:��Ա��ʷ��Ϣ's ������λ�����ʷproperty 
     */
    public String getCoopRecord()
    {
        return getString("coopRecord");
    }
    public void setCoopRecord(String item)
    {
        setString("coopRecord", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("45DA3855");
    }
}