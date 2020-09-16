package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProjBWRAssdEntryCollection extends AbstractObjectCollection 
{
    public ProjBWRAssdEntryCollection()
    {
        super(ProjBWRAssdEntryInfo.class);
    }
    public boolean add(ProjBWRAssdEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProjBWRAssdEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProjBWRAssdEntryInfo item)
    {
        return removeObject(item);
    }
    public ProjBWRAssdEntryInfo get(int index)
    {
        return(ProjBWRAssdEntryInfo)getObject(index);
    }
    public ProjBWRAssdEntryInfo get(Object key)
    {
        return(ProjBWRAssdEntryInfo)getObject(key);
    }
    public void set(int index, ProjBWRAssdEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProjBWRAssdEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProjBWRAssdEntryInfo item)
    {
        return super.indexOf(item);
    }
}