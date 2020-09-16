package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PassportEntryCollection extends AbstractObjectCollection 
{
    public PassportEntryCollection()
    {
        super(PassportEntryInfo.class);
    }
    public boolean add(PassportEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PassportEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PassportEntryInfo item)
    {
        return removeObject(item);
    }
    public PassportEntryInfo get(int index)
    {
        return(PassportEntryInfo)getObject(index);
    }
    public PassportEntryInfo get(Object key)
    {
        return(PassportEntryInfo)getObject(key);
    }
    public void set(int index, PassportEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PassportEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PassportEntryInfo item)
    {
        return super.indexOf(item);
    }
}