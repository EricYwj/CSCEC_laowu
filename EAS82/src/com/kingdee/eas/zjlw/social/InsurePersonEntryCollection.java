package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class InsurePersonEntryCollection extends AbstractObjectCollection 
{
    public InsurePersonEntryCollection()
    {
        super(InsurePersonEntryInfo.class);
    }
    public boolean add(InsurePersonEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(InsurePersonEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(InsurePersonEntryInfo item)
    {
        return removeObject(item);
    }
    public InsurePersonEntryInfo get(int index)
    {
        return(InsurePersonEntryInfo)getObject(index);
    }
    public InsurePersonEntryInfo get(Object key)
    {
        return(InsurePersonEntryInfo)getObject(key);
    }
    public void set(int index, InsurePersonEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(InsurePersonEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(InsurePersonEntryInfo item)
    {
        return super.indexOf(item);
    }
}