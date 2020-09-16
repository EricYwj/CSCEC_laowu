package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCertAddInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCertAddInfo()
    {
        this("id");
    }
    protected AbstractCertAddInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:证件通讯录's 姓名property 
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
     * Object:证件通讯录's 性别property 
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
     * Object: 证件通讯录 's 工作项目 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getWorkPro()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("workPro");
    }
    public void setWorkPro(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("workPro", item);
    }
    /**
     * Object: 证件通讯录 's 项目所在省份 property 
     */
    public com.kingdee.eas.basedata.assistant.ProvinceInfo getProProvince()
    {
        return (com.kingdee.eas.basedata.assistant.ProvinceInfo)get("proProvince");
    }
    public void setProProvince(com.kingdee.eas.basedata.assistant.ProvinceInfo item)
    {
        put("proProvince", item);
    }
    /**
     * Object:证件通讯录's 手机号码property 
     */
    public String getPhotoNum()
    {
        return getString("photoNum");
    }
    public void setPhotoNum(String item)
    {
        setString("photoNum", item);
    }
    /**
     * Object:证件通讯录's 电子邮箱property 
     */
    public String getMailbox()
    {
        return getString("mailbox");
    }
    public void setMailbox(String item)
    {
        setString("mailbox", item);
    }
    /**
     * Object:证件通讯录's QQ号码property 
     */
    public String getQqNum()
    {
        return getString("qqNum");
    }
    public void setQqNum(String item)
    {
        setString("qqNum", item);
    }
    /**
     * Object:证件通讯录's 微信号码property 
     */
    public String getWechatNum()
    {
        return getString("wechatNum");
    }
    public void setWechatNum(String item)
    {
        setString("wechatNum", item);
    }
    /**
     * Object:证件通讯录's 备注property 
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
     * Object:证件通讯录's 所属区域property 
     */
    public com.kingdee.eas.zjlw.certificates.app.BelongAreaEnum getBelongArea()
    {
        return com.kingdee.eas.zjlw.certificates.app.BelongAreaEnum.getEnum(getString("belongArea"));
    }
    public void setBelongArea(com.kingdee.eas.zjlw.certificates.app.BelongAreaEnum item)
    {
		if (item != null) {
        setString("belongArea", item.getValue());
		}
    }
    /**
     * Object:证件通讯录's 负责内容property 
     */
    public com.kingdee.eas.zjlw.certificates.app.RespContentEnum getRespContent()
    {
        return com.kingdee.eas.zjlw.certificates.app.RespContentEnum.getEnum(getString("respContent"));
    }
    public void setRespContent(com.kingdee.eas.zjlw.certificates.app.RespContentEnum item)
    {
		if (item != null) {
        setString("respContent", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3F51642F");
    }
}