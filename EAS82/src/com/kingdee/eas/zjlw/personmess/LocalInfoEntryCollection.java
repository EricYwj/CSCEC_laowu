package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LocalInfoEntryCollection extends AbstractObjectCollection 
{
    public LocalInfoEntryCollection()
    {
        super(LocalInfoEntryInfo.class);
    }
    public boolean add(LocalInfoEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LocalInfoEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LocalInfoEntryInfo item)
    {
        return removeObject(item);
    }
    public LocalInfoEntryInfo get(int index)
    {
        return(LocalInfoEntryInfo)getObject(index);
    }
    public LocalInfoEntryInfo get(Object key)
    {
        return(LocalInfoEntryInfo)getObject(key);
    }
    public void set(int index, LocalInfoEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LocalInfoEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LocalInfoEntryInfo item)
    {
        return super.indexOf(item);
    }
}