package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AlgAttEntryCollection extends AbstractObjectCollection 
{
    public AlgAttEntryCollection()
    {
        super(AlgAttEntryInfo.class);
    }
    public boolean add(AlgAttEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AlgAttEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AlgAttEntryInfo item)
    {
        return removeObject(item);
    }
    public AlgAttEntryInfo get(int index)
    {
        return(AlgAttEntryInfo)getObject(index);
    }
    public AlgAttEntryInfo get(Object key)
    {
        return(AlgAttEntryInfo)getObject(key);
    }
    public void set(int index, AlgAttEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AlgAttEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AlgAttEntryInfo item)
    {
        return super.indexOf(item);
    }
}