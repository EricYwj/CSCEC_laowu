package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PassportapplyEntryCollection extends AbstractObjectCollection 
{
    public PassportapplyEntryCollection()
    {
        super(PassportapplyEntryInfo.class);
    }
    public boolean add(PassportapplyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PassportapplyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PassportapplyEntryInfo item)
    {
        return removeObject(item);
    }
    public PassportapplyEntryInfo get(int index)
    {
        return(PassportapplyEntryInfo)getObject(index);
    }
    public PassportapplyEntryInfo get(Object key)
    {
        return(PassportapplyEntryInfo)getObject(key);
    }
    public void set(int index, PassportapplyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PassportapplyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PassportapplyEntryInfo item)
    {
        return super.indexOf(item);
    }
}