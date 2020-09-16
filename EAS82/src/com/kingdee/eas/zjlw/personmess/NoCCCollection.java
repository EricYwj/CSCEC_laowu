package com.kingdee.eas.zjlw.personmess;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class NoCCCollection extends AbstractObjectCollection 
{
    public NoCCCollection()
    {
        super(NoCCInfo.class);
    }
    public boolean add(NoCCInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(NoCCCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(NoCCInfo item)
    {
        return removeObject(item);
    }
    public NoCCInfo get(int index)
    {
        return(NoCCInfo)getObject(index);
    }
    public NoCCInfo get(Object key)
    {
        return(NoCCInfo)getObject(key);
    }
    public void set(int index, NoCCInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(NoCCInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(NoCCInfo item)
    {
        return super.indexOf(item);
    }
}