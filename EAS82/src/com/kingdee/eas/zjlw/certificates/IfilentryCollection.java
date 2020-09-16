package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class IfilentryCollection extends AbstractObjectCollection 
{
    public IfilentryCollection()
    {
        super(IfilentryInfo.class);
    }
    public boolean add(IfilentryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(IfilentryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(IfilentryInfo item)
    {
        return removeObject(item);
    }
    public IfilentryInfo get(int index)
    {
        return(IfilentryInfo)getObject(index);
    }
    public IfilentryInfo get(Object key)
    {
        return(IfilentryInfo)getObject(key);
    }
    public void set(int index, IfilentryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(IfilentryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(IfilentryInfo item)
    {
        return super.indexOf(item);
    }
}