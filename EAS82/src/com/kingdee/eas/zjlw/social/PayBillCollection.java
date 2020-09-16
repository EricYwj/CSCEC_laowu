package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PayBillCollection extends AbstractObjectCollection 
{
    public PayBillCollection()
    {
        super(PayBillInfo.class);
    }
    public boolean add(PayBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PayBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PayBillInfo item)
    {
        return removeObject(item);
    }
    public PayBillInfo get(int index)
    {
        return(PayBillInfo)getObject(index);
    }
    public PayBillInfo get(Object key)
    {
        return(PayBillInfo)getObject(key);
    }
    public void set(int index, PayBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PayBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PayBillInfo item)
    {
        return super.indexOf(item);
    }
}