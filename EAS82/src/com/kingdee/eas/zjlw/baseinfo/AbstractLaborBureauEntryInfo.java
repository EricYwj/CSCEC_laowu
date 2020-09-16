package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLaborBureauEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractLaborBureauEntryInfo()
    {
        this("id");
    }
    protected AbstractLaborBureauEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's null property 
     */
    public com.kingdee.eas.zjlw.baseinfo.LaborBureauInfo getParent()
    {
        return (com.kingdee.eas.zjlw.baseinfo.LaborBureauInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.zjlw.baseinfo.LaborBureauInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s ְ��property 
     */
    public String getPost()
    {
        return getString("post");
    }
    public void setPost(String item)
    {
        setString("post", item);
    }
    /**
     * Object:��¼'s ����property 
     */
    public String getFullName()
    {
        return getString("fullName");
    }
    public void setFullName(String item)
    {
        setString("fullName", item);
    }
    /**
     * Object:��¼'s ��������property 
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
     * Object:��¼'s ��������property 
     */
    public String getJobContent()
    {
        return getString("jobContent");
    }
    public void setJobContent(String item)
    {
        setString("jobContent", item);
    }
    /**
     * Object:��¼'s ���property 
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
     * Object:��¼'s ��ϵ��ʽ�绰property 
     */
    public String getTelephone()
    {
        return getString("telephone");
    }
    public void setTelephone(String item)
    {
        setString("telephone", item);
    }
    /**
     * Object:��¼'s ���������ַproperty 
     */
    public String getEmail()
    {
        return getString("email");
    }
    public void setEmail(String item)
    {
        setString("email", item);
    }
    /**
     * Object:��¼'s ϲ��property 
     */
    public String getFond()
    {
        return getString("fond");
    }
    public void setFond(String item)
    {
        setString("fond", item);
    }
    /**
     * Object:��¼'s ֮ǰ�Ĺ�����������property 
     */
    public String getWorkExper()
    {
        return getString("workExper");
    }
    public void setWorkExper(String item)
    {
        setString("workExper", item);
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
     * Object:��¼'s ��Ů���property 
     */
    public String getChildCase()
    {
        return getString("childCase");
    }
    public void setChildCase(String item)
    {
        setString("childCase", item);
    }
    /**
     * Object:��¼'s ��ͥסַproperty 
     */
    public String getHomeAddress()
    {
        return getString("homeAddress");
    }
    public void setHomeAddress(String item)
    {
        setString("homeAddress", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7A7765B6");
    }
}