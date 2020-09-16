package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LocalPayPrintEntryCollection extends AbstractObjectCollection 
{
    public LocalPayPrintEntryCollection()
    {
        super(LocalPayPrintEntryInfo.class);
    }
    public boolean add(LocalPayPrintEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LocalPayPrintEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LocalPayPrintEntryInfo item)
    {
        return removeObject(item);
    }
    public LocalPayPrintEntryInfo get(int index)
    {
        return(LocalPayPrintEntryInfo)getObject(index);
    }
    public LocalPayPrintEntryInfo get(Object key)
    {
        return(LocalPayPrintEntryInfo)getObject(key);
    }
    public void set(int index, LocalPayPrintEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LocalPayPrintEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LocalPayPrintEntryInfo item)
    {
        return super.indexOf(item);
    }
}