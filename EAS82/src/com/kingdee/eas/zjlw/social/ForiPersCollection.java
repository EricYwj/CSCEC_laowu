package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ForiPersCollection extends AbstractObjectCollection 
{
    public ForiPersCollection()
    {
        super(ForiPersInfo.class);
    }
    public boolean add(ForiPersInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ForiPersCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ForiPersInfo item)
    {
        return removeObject(item);
    }
    public ForiPersInfo get(int index)
    {
        return(ForiPersInfo)getObject(index);
    }
    public ForiPersInfo get(Object key)
    {
        return(ForiPersInfo)getObject(key);
    }
    public void set(int index, ForiPersInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ForiPersInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ForiPersInfo item)
    {
        return super.indexOf(item);
    }
}