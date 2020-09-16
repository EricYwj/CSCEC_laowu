package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PoliceOffCollection extends AbstractObjectCollection 
{
    public PoliceOffCollection()
    {
        super(PoliceOffInfo.class);
    }
    public boolean add(PoliceOffInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PoliceOffCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PoliceOffInfo item)
    {
        return removeObject(item);
    }
    public PoliceOffInfo get(int index)
    {
        return(PoliceOffInfo)getObject(index);
    }
    public PoliceOffInfo get(Object key)
    {
        return(PoliceOffInfo)getObject(key);
    }
    public void set(int index, PoliceOffInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PoliceOffInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PoliceOffInfo item)
    {
        return super.indexOf(item);
    }
}