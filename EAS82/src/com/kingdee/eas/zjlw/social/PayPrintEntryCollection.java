package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PayPrintEntryCollection extends AbstractObjectCollection 
{
    public PayPrintEntryCollection()
    {
        super(PayPrintEntryInfo.class);
    }
    public boolean add(PayPrintEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PayPrintEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PayPrintEntryInfo item)
    {
        return removeObject(item);
    }
    public PayPrintEntryInfo get(int index)
    {
        return(PayPrintEntryInfo)getObject(index);
    }
    public PayPrintEntryInfo get(Object key)
    {
        return(PayPrintEntryInfo)getObject(key);
    }
    public void set(int index, PayPrintEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PayPrintEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PayPrintEntryInfo item)
    {
        return super.indexOf(item);
    }
}