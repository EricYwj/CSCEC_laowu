package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ForiAttDataEntryCollection extends AbstractObjectCollection 
{
    public ForiAttDataEntryCollection()
    {
        super(ForiAttDataEntryInfo.class);
    }
    public boolean add(ForiAttDataEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ForiAttDataEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ForiAttDataEntryInfo item)
    {
        return removeObject(item);
    }
    public ForiAttDataEntryInfo get(int index)
    {
        return(ForiAttDataEntryInfo)getObject(index);
    }
    public ForiAttDataEntryInfo get(Object key)
    {
        return(ForiAttDataEntryInfo)getObject(key);
    }
    public void set(int index, ForiAttDataEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ForiAttDataEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ForiAttDataEntryInfo item)
    {
        return super.indexOf(item);
    }
}