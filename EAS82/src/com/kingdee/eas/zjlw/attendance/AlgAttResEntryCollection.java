package com.kingdee.eas.zjlw.attendance;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AlgAttResEntryCollection extends AbstractObjectCollection 
{
    public AlgAttResEntryCollection()
    {
        super(AlgAttResEntryInfo.class);
    }
    public boolean add(AlgAttResEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AlgAttResEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AlgAttResEntryInfo item)
    {
        return removeObject(item);
    }
    public AlgAttResEntryInfo get(int index)
    {
        return(AlgAttResEntryInfo)getObject(index);
    }
    public AlgAttResEntryInfo get(Object key)
    {
        return(AlgAttResEntryInfo)getObject(key);
    }
    public void set(int index, AlgAttResEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AlgAttResEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AlgAttResEntryInfo item)
    {
        return super.indexOf(item);
    }
}