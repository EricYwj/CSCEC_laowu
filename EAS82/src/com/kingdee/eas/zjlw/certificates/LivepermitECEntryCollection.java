package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LivepermitECEntryCollection extends AbstractObjectCollection 
{
    public LivepermitECEntryCollection()
    {
        super(LivepermitECEntryInfo.class);
    }
    public boolean add(LivepermitECEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LivepermitECEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LivepermitECEntryInfo item)
    {
        return removeObject(item);
    }
    public LivepermitECEntryInfo get(int index)
    {
        return(LivepermitECEntryInfo)getObject(index);
    }
    public LivepermitECEntryInfo get(Object key)
    {
        return(LivepermitECEntryInfo)getObject(key);
    }
    public void set(int index, LivepermitECEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LivepermitECEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LivepermitECEntryInfo item)
    {
        return super.indexOf(item);
    }
}