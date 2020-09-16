package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ImmigrationEntryCollection extends AbstractObjectCollection 
{
    public ImmigrationEntryCollection()
    {
        super(ImmigrationEntryInfo.class);
    }
    public boolean add(ImmigrationEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ImmigrationEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ImmigrationEntryInfo item)
    {
        return removeObject(item);
    }
    public ImmigrationEntryInfo get(int index)
    {
        return(ImmigrationEntryInfo)getObject(index);
    }
    public ImmigrationEntryInfo get(Object key)
    {
        return(ImmigrationEntryInfo)getObject(key);
    }
    public void set(int index, ImmigrationEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ImmigrationEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ImmigrationEntryInfo item)
    {
        return super.indexOf(item);
    }
}