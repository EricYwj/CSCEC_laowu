package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BusinessVisaCollection extends AbstractObjectCollection 
{
    public BusinessVisaCollection()
    {
        super(BusinessVisaInfo.class);
    }
    public boolean add(BusinessVisaInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BusinessVisaCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BusinessVisaInfo item)
    {
        return removeObject(item);
    }
    public BusinessVisaInfo get(int index)
    {
        return(BusinessVisaInfo)getObject(index);
    }
    public BusinessVisaInfo get(Object key)
    {
        return(BusinessVisaInfo)getObject(key);
    }
    public void set(int index, BusinessVisaInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BusinessVisaInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BusinessVisaInfo item)
    {
        return super.indexOf(item);
    }
}