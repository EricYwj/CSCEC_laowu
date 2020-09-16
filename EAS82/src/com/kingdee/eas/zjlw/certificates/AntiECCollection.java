package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AntiECCollection extends AbstractObjectCollection 
{
    public AntiECCollection()
    {
        super(AntiECInfo.class);
    }
    public boolean add(AntiECInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AntiECCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AntiECInfo item)
    {
        return removeObject(item);
    }
    public AntiECInfo get(int index)
    {
        return(AntiECInfo)getObject(index);
    }
    public AntiECInfo get(Object key)
    {
        return(AntiECInfo)getObject(key);
    }
    public void set(int index, AntiECInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AntiECInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AntiECInfo item)
    {
        return super.indexOf(item);
    }
}