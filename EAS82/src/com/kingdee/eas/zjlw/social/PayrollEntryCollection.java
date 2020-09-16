package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PayrollEntryCollection extends AbstractObjectCollection 
{
    public PayrollEntryCollection()
    {
        super(PayrollEntryInfo.class);
    }
    public boolean add(PayrollEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PayrollEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PayrollEntryInfo item)
    {
        return removeObject(item);
    }
    public PayrollEntryInfo get(int index)
    {
        return(PayrollEntryInfo)getObject(index);
    }
    public PayrollEntryInfo get(Object key)
    {
        return(PayrollEntryInfo)getObject(key);
    }
    public void set(int index, PayrollEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PayrollEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PayrollEntryInfo item)
    {
        return super.indexOf(item);
    }
}