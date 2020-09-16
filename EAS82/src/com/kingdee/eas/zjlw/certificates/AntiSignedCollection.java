package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AntiSignedCollection extends AbstractObjectCollection 
{
    public AntiSignedCollection()
    {
        super(AntiSignedInfo.class);
    }
    public boolean add(AntiSignedInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AntiSignedCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AntiSignedInfo item)
    {
        return removeObject(item);
    }
    public AntiSignedInfo get(int index)
    {
        return(AntiSignedInfo)getObject(index);
    }
    public AntiSignedInfo get(Object key)
    {
        return(AntiSignedInfo)getObject(key);
    }
    public void set(int index, AntiSignedInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AntiSignedInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AntiSignedInfo item)
    {
        return super.indexOf(item);
    }
}