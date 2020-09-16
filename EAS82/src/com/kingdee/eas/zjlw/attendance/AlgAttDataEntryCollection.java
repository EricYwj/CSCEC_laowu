package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AlgAttDataEntryCollection extends AbstractObjectCollection 
{
    public AlgAttDataEntryCollection()
    {
        super(AlgAttDataEntryInfo.class);
    }
    public boolean add(AlgAttDataEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AlgAttDataEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AlgAttDataEntryInfo item)
    {
        return removeObject(item);
    }
    public AlgAttDataEntryInfo get(int index)
    {
        return(AlgAttDataEntryInfo)getObject(index);
    }
    public AlgAttDataEntryInfo get(Object key)
    {
        return(AlgAttDataEntryInfo)getObject(key);
    }
    public void set(int index, AlgAttDataEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AlgAttDataEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AlgAttDataEntryInfo item)
    {
        return super.indexOf(item);
    }
}