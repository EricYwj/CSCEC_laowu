package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AlgPersEntryCollection extends AbstractObjectCollection 
{
    public AlgPersEntryCollection()
    {
        super(AlgPersEntryInfo.class);
    }
    public boolean add(AlgPersEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AlgPersEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AlgPersEntryInfo item)
    {
        return removeObject(item);
    }
    public AlgPersEntryInfo get(int index)
    {
        return(AlgPersEntryInfo)getObject(index);
    }
    public AlgPersEntryInfo get(Object key)
    {
        return(AlgPersEntryInfo)getObject(key);
    }
    public void set(int index, AlgPersEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AlgPersEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AlgPersEntryInfo item)
    {
        return super.indexOf(item);
    }
}