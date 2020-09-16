package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PayBillEntryCollection extends AbstractObjectCollection 
{
    public PayBillEntryCollection()
    {
        super(PayBillEntryInfo.class);
    }
    public boolean add(PayBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PayBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PayBillEntryInfo item)
    {
        return removeObject(item);
    }
    public PayBillEntryInfo get(int index)
    {
        return(PayBillEntryInfo)getObject(index);
    }
    public PayBillEntryInfo get(Object key)
    {
        return(PayBillEntryInfo)getObject(key);
    }
    public void set(int index, PayBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PayBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PayBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}