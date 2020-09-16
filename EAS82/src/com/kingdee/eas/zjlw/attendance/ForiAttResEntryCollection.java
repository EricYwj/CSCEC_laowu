package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ForiAttResEntryCollection extends AbstractObjectCollection 
{
    public ForiAttResEntryCollection()
    {
        super(ForiAttResEntryInfo.class);
    }
    public boolean add(ForiAttResEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ForiAttResEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ForiAttResEntryInfo item)
    {
        return removeObject(item);
    }
    public ForiAttResEntryInfo get(int index)
    {
        return(ForiAttResEntryInfo)getObject(index);
    }
    public ForiAttResEntryInfo get(Object key)
    {
        return(ForiAttResEntryInfo)getObject(key);
    }
    public void set(int index, ForiAttResEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ForiAttResEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ForiAttResEntryInfo item)
    {
        return super.indexOf(item);
    }
}