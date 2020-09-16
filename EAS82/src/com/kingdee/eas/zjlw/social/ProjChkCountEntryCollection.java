package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProjChkCountEntryCollection extends AbstractObjectCollection 
{
    public ProjChkCountEntryCollection()
    {
        super(ProjChkCountEntryInfo.class);
    }
    public boolean add(ProjChkCountEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProjChkCountEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProjChkCountEntryInfo item)
    {
        return removeObject(item);
    }
    public ProjChkCountEntryInfo get(int index)
    {
        return(ProjChkCountEntryInfo)getObject(index);
    }
    public ProjChkCountEntryInfo get(Object key)
    {
        return(ProjChkCountEntryInfo)getObject(key);
    }
    public void set(int index, ProjChkCountEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProjChkCountEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProjChkCountEntryInfo item)
    {
        return super.indexOf(item);
    }
}