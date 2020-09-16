package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LocalPayPrintCollection extends AbstractObjectCollection 
{
    public LocalPayPrintCollection()
    {
        super(LocalPayPrintInfo.class);
    }
    public boolean add(LocalPayPrintInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LocalPayPrintCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LocalPayPrintInfo item)
    {
        return removeObject(item);
    }
    public LocalPayPrintInfo get(int index)
    {
        return(LocalPayPrintInfo)getObject(index);
    }
    public LocalPayPrintInfo get(Object key)
    {
        return(LocalPayPrintInfo)getObject(key);
    }
    public void set(int index, LocalPayPrintInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LocalPayPrintInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LocalPayPrintInfo item)
    {
        return super.indexOf(item);
    }
}