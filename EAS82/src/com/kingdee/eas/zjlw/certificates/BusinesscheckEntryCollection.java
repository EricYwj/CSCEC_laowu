package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BusinesscheckEntryCollection extends AbstractObjectCollection 
{
    public BusinesscheckEntryCollection()
    {
        super(BusinesscheckEntryInfo.class);
    }
    public boolean add(BusinesscheckEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BusinesscheckEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BusinesscheckEntryInfo item)
    {
        return removeObject(item);
    }
    public BusinesscheckEntryInfo get(int index)
    {
        return(BusinesscheckEntryInfo)getObject(index);
    }
    public BusinesscheckEntryInfo get(Object key)
    {
        return(BusinesscheckEntryInfo)getObject(key);
    }
    public void set(int index, BusinesscheckEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BusinesscheckEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BusinesscheckEntryInfo item)
    {
        return super.indexOf(item);
    }
}