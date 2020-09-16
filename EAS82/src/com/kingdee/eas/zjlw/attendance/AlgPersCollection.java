package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AlgPersCollection extends AbstractObjectCollection 
{
    public AlgPersCollection()
    {
        super(AlgPersInfo.class);
    }
    public boolean add(AlgPersInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AlgPersCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AlgPersInfo item)
    {
        return removeObject(item);
    }
    public AlgPersInfo get(int index)
    {
        return(AlgPersInfo)getObject(index);
    }
    public AlgPersInfo get(Object key)
    {
        return(AlgPersInfo)getObject(key);
    }
    public void set(int index, AlgPersInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AlgPersInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AlgPersInfo item)
    {
        return super.indexOf(item);
    }
}