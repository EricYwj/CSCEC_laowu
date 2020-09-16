package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LivepermitECCollection extends AbstractObjectCollection 
{
    public LivepermitECCollection()
    {
        super(LivepermitECInfo.class);
    }
    public boolean add(LivepermitECInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LivepermitECCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LivepermitECInfo item)
    {
        return removeObject(item);
    }
    public LivepermitECInfo get(int index)
    {
        return(LivepermitECInfo)getObject(index);
    }
    public LivepermitECInfo get(Object key)
    {
        return(LivepermitECInfo)getObject(key);
    }
    public void set(int index, LivepermitECInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LivepermitECInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LivepermitECInfo item)
    {
        return super.indexOf(item);
    }
}