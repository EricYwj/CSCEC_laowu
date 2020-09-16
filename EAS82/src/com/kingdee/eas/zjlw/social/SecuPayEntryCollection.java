package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SecuPayEntryCollection extends AbstractObjectCollection 
{
    public SecuPayEntryCollection()
    {
        super(SecuPayEntryInfo.class);
    }
    public boolean add(SecuPayEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SecuPayEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SecuPayEntryInfo item)
    {
        return removeObject(item);
    }
    public SecuPayEntryInfo get(int index)
    {
        return(SecuPayEntryInfo)getObject(index);
    }
    public SecuPayEntryInfo get(Object key)
    {
        return(SecuPayEntryInfo)getObject(key);
    }
    public void set(int index, SecuPayEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SecuPayEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SecuPayEntryInfo item)
    {
        return super.indexOf(item);
    }
}