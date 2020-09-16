package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AttenceEntryCollection extends AbstractObjectCollection 
{
    public AttenceEntryCollection()
    {
        super(AttenceEntryInfo.class);
    }
    public boolean add(AttenceEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AttenceEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AttenceEntryInfo item)
    {
        return removeObject(item);
    }
    public AttenceEntryInfo get(int index)
    {
        return(AttenceEntryInfo)getObject(index);
    }
    public AttenceEntryInfo get(Object key)
    {
        return(AttenceEntryInfo)getObject(key);
    }
    public void set(int index, AttenceEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AttenceEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AttenceEntryInfo item)
    {
        return super.indexOf(item);
    }
}