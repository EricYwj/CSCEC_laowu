package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ExtAccountEntryCollection extends AbstractObjectCollection 
{
    public ExtAccountEntryCollection()
    {
        super(ExtAccountEntryInfo.class);
    }
    public boolean add(ExtAccountEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ExtAccountEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ExtAccountEntryInfo item)
    {
        return removeObject(item);
    }
    public ExtAccountEntryInfo get(int index)
    {
        return(ExtAccountEntryInfo)getObject(index);
    }
    public ExtAccountEntryInfo get(Object key)
    {
        return(ExtAccountEntryInfo)getObject(key);
    }
    public void set(int index, ExtAccountEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ExtAccountEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ExtAccountEntryInfo item)
    {
        return super.indexOf(item);
    }
}