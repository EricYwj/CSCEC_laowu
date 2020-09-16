package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CheckCountEntryCollection extends AbstractObjectCollection 
{
    public CheckCountEntryCollection()
    {
        super(CheckCountEntryInfo.class);
    }
    public boolean add(CheckCountEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CheckCountEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CheckCountEntryInfo item)
    {
        return removeObject(item);
    }
    public CheckCountEntryInfo get(int index)
    {
        return(CheckCountEntryInfo)getObject(index);
    }
    public CheckCountEntryInfo get(Object key)
    {
        return(CheckCountEntryInfo)getObject(key);
    }
    public void set(int index, CheckCountEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CheckCountEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CheckCountEntryInfo item)
    {
        return super.indexOf(item);
    }
}