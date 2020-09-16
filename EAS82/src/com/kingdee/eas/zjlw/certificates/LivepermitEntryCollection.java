package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LivepermitEntryCollection extends AbstractObjectCollection 
{
    public LivepermitEntryCollection()
    {
        super(LivepermitEntryInfo.class);
    }
    public boolean add(LivepermitEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LivepermitEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LivepermitEntryInfo item)
    {
        return removeObject(item);
    }
    public LivepermitEntryInfo get(int index)
    {
        return(LivepermitEntryInfo)getObject(index);
    }
    public LivepermitEntryInfo get(Object key)
    {
        return(LivepermitEntryInfo)getObject(key);
    }
    public void set(int index, LivepermitEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LivepermitEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LivepermitEntryInfo item)
    {
        return super.indexOf(item);
    }
}