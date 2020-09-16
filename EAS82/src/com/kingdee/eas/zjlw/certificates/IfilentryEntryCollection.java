package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class IfilentryEntryCollection extends AbstractObjectCollection 
{
    public IfilentryEntryCollection()
    {
        super(IfilentryEntryInfo.class);
    }
    public boolean add(IfilentryEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(IfilentryEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(IfilentryEntryInfo item)
    {
        return removeObject(item);
    }
    public IfilentryEntryInfo get(int index)
    {
        return(IfilentryEntryInfo)getObject(index);
    }
    public IfilentryEntryInfo get(Object key)
    {
        return(IfilentryEntryInfo)getObject(key);
    }
    public void set(int index, IfilentryEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(IfilentryEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(IfilentryEntryInfo item)
    {
        return super.indexOf(item);
    }
}