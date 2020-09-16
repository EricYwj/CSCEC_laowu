package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ForiPersEntryCollection extends AbstractObjectCollection 
{
    public ForiPersEntryCollection()
    {
        super(ForiPersEntryInfo.class);
    }
    public boolean add(ForiPersEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ForiPersEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ForiPersEntryInfo item)
    {
        return removeObject(item);
    }
    public ForiPersEntryInfo get(int index)
    {
        return(ForiPersEntryInfo)getObject(index);
    }
    public ForiPersEntryInfo get(Object key)
    {
        return(ForiPersEntryInfo)getObject(key);
    }
    public void set(int index, ForiPersEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ForiPersEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ForiPersEntryInfo item)
    {
        return super.indexOf(item);
    }
}