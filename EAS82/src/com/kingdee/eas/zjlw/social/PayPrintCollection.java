package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PayPrintCollection extends AbstractObjectCollection 
{
    public PayPrintCollection()
    {
        super(PayPrintInfo.class);
    }
    public boolean add(PayPrintInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PayPrintCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PayPrintInfo item)
    {
        return removeObject(item);
    }
    public PayPrintInfo get(int index)
    {
        return(PayPrintInfo)getObject(index);
    }
    public PayPrintInfo get(Object key)
    {
        return(PayPrintInfo)getObject(key);
    }
    public void set(int index, PayPrintInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PayPrintInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PayPrintInfo item)
    {
        return super.indexOf(item);
    }
}