package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AntiECEntryCollection extends AbstractObjectCollection 
{
    public AntiECEntryCollection()
    {
        super(AntiECEntryInfo.class);
    }
    public boolean add(AntiECEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AntiECEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AntiECEntryInfo item)
    {
        return removeObject(item);
    }
    public AntiECEntryInfo get(int index)
    {
        return(AntiECEntryInfo)getObject(index);
    }
    public AntiECEntryInfo get(Object key)
    {
        return(AntiECEntryInfo)getObject(key);
    }
    public void set(int index, AntiECEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AntiECEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AntiECEntryInfo item)
    {
        return super.indexOf(item);
    }
}