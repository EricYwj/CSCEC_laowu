package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class NoCCEntryCollection extends AbstractObjectCollection 
{
    public NoCCEntryCollection()
    {
        super(NoCCEntryInfo.class);
    }
    public boolean add(NoCCEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(NoCCEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(NoCCEntryInfo item)
    {
        return removeObject(item);
    }
    public NoCCEntryInfo get(int index)
    {
        return(NoCCEntryInfo)getObject(index);
    }
    public NoCCEntryInfo get(Object key)
    {
        return(NoCCEntryInfo)getObject(key);
    }
    public void set(int index, NoCCEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(NoCCEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(NoCCEntryInfo item)
    {
        return super.indexOf(item);
    }
}