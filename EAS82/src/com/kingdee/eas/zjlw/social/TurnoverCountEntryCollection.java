package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TurnoverCountEntryCollection extends AbstractObjectCollection 
{
    public TurnoverCountEntryCollection()
    {
        super(TurnoverCountEntryInfo.class);
    }
    public boolean add(TurnoverCountEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TurnoverCountEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TurnoverCountEntryInfo item)
    {
        return removeObject(item);
    }
    public TurnoverCountEntryInfo get(int index)
    {
        return(TurnoverCountEntryInfo)getObject(index);
    }
    public TurnoverCountEntryInfo get(Object key)
    {
        return(TurnoverCountEntryInfo)getObject(key);
    }
    public void set(int index, TurnoverCountEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TurnoverCountEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TurnoverCountEntryInfo item)
    {
        return super.indexOf(item);
    }
}