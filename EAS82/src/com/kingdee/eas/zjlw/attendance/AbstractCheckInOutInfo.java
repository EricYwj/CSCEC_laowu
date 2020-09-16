package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCheckInOutInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCheckInOutInfo()
    {
        this("id");
    }
    protected AbstractCheckInOutInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:����ԭʼ��¼��'s ����property 
     */
    public String getPerName()
    {
        return getString("perName");
    }
    public void setPerName(String item)
    {
        setString("perName", item);
    }
    /**
     * Object:����ԭʼ��¼��'s ������λproperty 
     */
    public String getPerProj()
    {
        return getString("perProj");
    }
    public void setPerProj(String item)
    {
        setString("perProj", item);
    }
    /**
     * Object:����ԭʼ��¼��'s ��Ա���property 
     */
    public String getPerId()
    {
        return getString("perId");
    }
    public void setPerId(String item)
    {
        setString("perId", item);
    }
    /**
     * Object:����ԭʼ��¼��'s ����ʱ��property 
     */
    public String getCheckTime()
    {
        return getString("checkTime");
    }
    public void setCheckTime(String item)
    {
        setString("checkTime", item);
    }
    /**
     * Object:����ԭʼ��¼��'s ����״̬property 
     */
    public String getCheckType()
    {
        return getString("checkType");
    }
    public void setCheckType(String item)
    {
        setString("checkType", item);
    }
    /**
     * Object:����ԭʼ��¼��'s ������Ŀproperty 
     */
    public String getCheAera()
    {
        return getString("cheAera");
    }
    public void setCheAera(String item)
    {
        setString("cheAera", item);
    }
    /**
     * Object:����ԭʼ��¼��'s �豸���к�property 
     */
    public String getMachineId()
    {
        return getString("machineId");
    }
    public void setMachineId(String item)
    {
        setString("machineId", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("DC02EC85");
    }
}