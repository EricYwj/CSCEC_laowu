package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CooprationEntryCollection extends AbstractObjectCollection 
{
    public CooprationEntryCollection()
    {
        super(CooprationEntryInfo.class);
    }
    public boolean add(CooprationEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CooprationEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CooprationEntryInfo item)
    {
        return removeObject(item);
    }
    public CooprationEntryInfo get(int index)
    {
        return(CooprationEntryInfo)getObject(index);
    }
    public CooprationEntryInfo get(Object key)
    {
        return(CooprationEntryInfo)getObject(key);
    }
    public void set(int index, CooprationEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CooprationEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CooprationEntryInfo item)
    {
        return super.indexOf(item);
    }
}