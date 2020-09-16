package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ForiAttDataCollection extends AbstractObjectCollection 
{
    public ForiAttDataCollection()
    {
        super(ForiAttDataInfo.class);
    }
    public boolean add(ForiAttDataInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ForiAttDataCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ForiAttDataInfo item)
    {
        return removeObject(item);
    }
    public ForiAttDataInfo get(int index)
    {
        return(ForiAttDataInfo)getObject(index);
    }
    public ForiAttDataInfo get(Object key)
    {
        return(ForiAttDataInfo)getObject(key);
    }
    public void set(int index, ForiAttDataInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ForiAttDataInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ForiAttDataInfo item)
    {
        return super.indexOf(item);
    }
}