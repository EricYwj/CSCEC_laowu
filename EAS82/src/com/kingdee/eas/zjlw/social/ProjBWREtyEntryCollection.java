package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProjBWREtyEntryCollection extends AbstractObjectCollection 
{
    public ProjBWREtyEntryCollection()
    {
        super(ProjBWREtyEntryInfo.class);
    }
    public boolean add(ProjBWREtyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProjBWREtyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProjBWREtyEntryInfo item)
    {
        return removeObject(item);
    }
    public ProjBWREtyEntryInfo get(int index)
    {
        return(ProjBWREtyEntryInfo)getObject(index);
    }
    public ProjBWREtyEntryInfo get(Object key)
    {
        return(ProjBWREtyEntryInfo)getObject(key);
    }
    public void set(int index, ProjBWREtyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProjBWREtyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProjBWREtyEntryInfo item)
    {
        return super.indexOf(item);
    }
}