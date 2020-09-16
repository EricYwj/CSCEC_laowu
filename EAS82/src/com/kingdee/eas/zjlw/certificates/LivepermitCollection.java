package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LivepermitCollection extends AbstractObjectCollection 
{
    public LivepermitCollection()
    {
        super(LivepermitInfo.class);
    }
    public boolean add(LivepermitInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LivepermitCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LivepermitInfo item)
    {
        return removeObject(item);
    }
    public LivepermitInfo get(int index)
    {
        return(LivepermitInfo)getObject(index);
    }
    public LivepermitInfo get(Object key)
    {
        return(LivepermitInfo)getObject(key);
    }
    public void set(int index, LivepermitInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LivepermitInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LivepermitInfo item)
    {
        return super.indexOf(item);
    }
}