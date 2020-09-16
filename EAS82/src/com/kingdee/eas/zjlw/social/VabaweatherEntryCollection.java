package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class VabaweatherEntryCollection extends AbstractObjectCollection 
{
    public VabaweatherEntryCollection()
    {
        super(VabaweatherEntryInfo.class);
    }
    public boolean add(VabaweatherEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(VabaweatherEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(VabaweatherEntryInfo item)
    {
        return removeObject(item);
    }
    public VabaweatherEntryInfo get(int index)
    {
        return(VabaweatherEntryInfo)getObject(index);
    }
    public VabaweatherEntryInfo get(Object key)
    {
        return(VabaweatherEntryInfo)getObject(key);
    }
    public void set(int index, VabaweatherEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(VabaweatherEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(VabaweatherEntryInfo item)
    {
        return super.indexOf(item);
    }
}