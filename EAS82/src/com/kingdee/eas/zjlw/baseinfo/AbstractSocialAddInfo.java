package com.kingdee.eas.zjlw.baseinfo;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSocialAddInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSocialAddInfo()
    {
        this("id");
    }
    protected AbstractSocialAddInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:�籣ͨѶ¼'s ����property 
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
     * Object:�籣ͨѶ¼'s �Ա�property 
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
     * Object: �籣ͨѶ¼ 's ������Ŀ property 
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
     * Object: �籣ͨѶ¼ 's ��Ŀ����ʡ�� property 
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
     * Object:�籣ͨѶ¼'s �ֻ�����property 
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
     * Object:�籣ͨѶ¼'s ��������property 
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
     * Object:�籣ͨѶ¼'s QQ����property 
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
     * Object:�籣ͨѶ¼'s ΢�ź���property 
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
     * Object:�籣ͨѶ¼'s ��עproperty 
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
     * Object:�籣ͨѶ¼'s ��������property 
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
     * Object:�籣ͨѶ¼'s ��������property 
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
        return new BOSObjectType("D91F19C6");
    }
}