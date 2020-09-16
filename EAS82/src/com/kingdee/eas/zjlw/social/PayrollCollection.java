package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PayrollCollection extends AbstractObjectCollection 
{
    public PayrollCollection()
    {
        super(PayrollInfo.class);
    }
    public boolean add(PayrollInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PayrollCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PayrollInfo item)
    {
        return removeObject(item);
    }
    public PayrollInfo get(int index)
    {
        return(PayrollInfo)getObject(index);
    }
    public PayrollInfo get(Object key)
    {
        return(PayrollInfo)getObject(key);
    }
    public void set(int index, PayrollInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PayrollInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PayrollInfo item)
    {
        return super.indexOf(item);
    }
}