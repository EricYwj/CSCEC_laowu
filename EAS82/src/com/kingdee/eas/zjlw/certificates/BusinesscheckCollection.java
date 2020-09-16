package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BusinesscheckCollection extends AbstractObjectCollection 
{
    public BusinesscheckCollection()
    {
        super(BusinesscheckInfo.class);
    }
    public boolean add(BusinesscheckInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BusinesscheckCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BusinesscheckInfo item)
    {
        return removeObject(item);
    }
    public BusinesscheckInfo get(int index)
    {
        return(BusinesscheckInfo)getObject(index);
    }
    public BusinesscheckInfo get(Object key)
    {
        return(BusinesscheckInfo)getObject(key);
    }
    public void set(int index, BusinesscheckInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BusinesscheckInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BusinesscheckInfo item)
    {
        return super.indexOf(item);
    }
}