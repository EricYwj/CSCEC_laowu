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
     * Object: 分录 's null property 
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
     * Object:分录's 职务property 
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
     * Object:分录's 姓名property 
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
     * Object:分录's 出生日期property 
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
     * Object:分录's 工作内容property 
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
     * Object:分录's 婚否property 
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
     * Object:分录's 联系方式电话property 
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
     * Object:分录's 电子邮箱地址property 
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
     * Object:分录's 喜好property 
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
     * Object:分录's 之前的工作经历简述property 
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
     * Object:分录's 子女情况property 
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
     * Object:分录's 家庭住址property 
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