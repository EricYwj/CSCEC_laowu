package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PoliceOffEntryCollection extends AbstractObjectCollection 
{
    public PoliceOffEntryCollection()
    {
        super(PoliceOffEntryInfo.class);
    }
    public boolean add(PoliceOffEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PoliceOffEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PoliceOffEntryInfo item)
    {
        return removeObject(item);
    }
    public PoliceOffEntryInfo get(int index)
    {
        return(PoliceOffEntryInfo)getObject(index);
    }
    public PoliceOffEntryInfo get(Object key)
    {
        return(PoliceOffEntryInfo)getObject(key);
    }
    public void set(int index, PoliceOffEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PoliceOffEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PoliceOffEntryInfo item)
    {
        return super.indexOf(item);
    }
}