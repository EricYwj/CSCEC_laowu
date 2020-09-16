package com.kingdee.eas.zjlw.attendance;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAlgattenceResultInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractAlgattenceResultInfo()
    {
        this("id");
    }
    protected AbstractAlgattenceResultInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:�������ڽ��'s ��������property 
     */
    public java.util.Date getCheckDate()
    {
        return getDate("checkDate");
    }
    public void setCheckDate(java.util.Date item)
    {
        setDate("checkDate", item);
    }
    /**
     * Object:�������ڽ��'s ���ڽ��property 
     */
    public com.kingdee.eas.zjlw.attendance.app.algResultEnum getResult()
    {
        return com.kingdee.eas.zjlw.attendance.app.algResultEnum.getEnum(getString("result"));
    }
    public void setResult(com.kingdee.eas.zjlw.attendance.app.algResultEnum item)
    {
		if (item != null) {
        setString("result", item.getValue());
		}
    }
    /**
     * Object:�������ڽ��'s �ٵ�����ʱ��(����)property 
     */
    public int getNoWorkTime()
    {
        return getInt("noWorkTime");
    }
    public void setNoWorkTime(int item)
    {
        setInt("noWorkTime", item);
    }
    /**
     * Object:�������ڽ��'s �ڼ��ռӰ�(Сʱ)property 
     */
    public java.math.BigDecimal getHoOverTime()
    {
        return getBigDecimal("hoOverTime");
    }
    public void setHoOverTime(java.math.BigDecimal item)
    {
        setBigDecimal("hoOverTime", item);
    }
    /**
     * Object:�������ڽ��'s �Ӱ�ʱ��(Сʱ)property 
     */
    public java.math.BigDecimal getOverTime()
    {
        return getBigDecimal("overTime");
    }
    public void setOverTime(java.math.BigDecimal item)
    {
        setBigDecimal("overTime", item);
    }
    /**
     * Object: �������ڽ�� 's ������Ŀ property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getWorkOrgId()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("workOrgId");
    }
    public void setWorkOrgId(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("workOrgId", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("677B89D1");
    }
}