package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AlgAccPersCollection extends AbstractObjectCollection 
{
    public AlgAccPersCollection()
    {
        super(AlgAccPersInfo.class);
    }
    public boolean add(AlgAccPersInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AlgAccPersCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AlgAccPersInfo item)
    {
        return removeObject(item);
    }
    public AlgAccPersInfo get(int index)
    {
        return(AlgAccPersInfo)getObject(index);
    }
    public AlgAccPersInfo get(Object key)
    {
        return(AlgAccPersInfo)getObject(key);
    }
    public void set(int index, AlgAccPersInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AlgAccPersInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AlgAccPersInfo item)
    {
        return super.indexOf(item);
    }
}