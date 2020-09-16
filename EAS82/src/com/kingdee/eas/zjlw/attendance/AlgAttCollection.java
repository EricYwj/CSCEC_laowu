package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AlgAttCollection extends AbstractObjectCollection 
{
    public AlgAttCollection()
    {
        super(AlgAttInfo.class);
    }
    public boolean add(AlgAttInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AlgAttCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AlgAttInfo item)
    {
        return removeObject(item);
    }
    public AlgAttInfo get(int index)
    {
        return(AlgAttInfo)getObject(index);
    }
    public AlgAttInfo get(Object key)
    {
        return(AlgAttInfo)getObject(key);
    }
    public void set(int index, AlgAttInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AlgAttInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AlgAttInfo item)
    {
        return super.indexOf(item);
    }
}