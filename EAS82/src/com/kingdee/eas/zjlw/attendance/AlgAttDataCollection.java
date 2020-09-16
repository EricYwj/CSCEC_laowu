package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AlgAttDataCollection extends AbstractObjectCollection 
{
    public AlgAttDataCollection()
    {
        super(AlgAttDataInfo.class);
    }
    public boolean add(AlgAttDataInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AlgAttDataCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AlgAttDataInfo item)
    {
        return removeObject(item);
    }
    public AlgAttDataInfo get(int index)
    {
        return(AlgAttDataInfo)getObject(index);
    }
    public AlgAttDataInfo get(Object key)
    {
        return(AlgAttDataInfo)getObject(key);
    }
    public void set(int index, AlgAttDataInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AlgAttDataInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AlgAttDataInfo item)
    {
        return super.indexOf(item);
    }
}