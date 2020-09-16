package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TurnoverCountCollection extends AbstractObjectCollection 
{
    public TurnoverCountCollection()
    {
        super(TurnoverCountInfo.class);
    }
    public boolean add(TurnoverCountInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TurnoverCountCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TurnoverCountInfo item)
    {
        return removeObject(item);
    }
    public TurnoverCountInfo get(int index)
    {
        return(TurnoverCountInfo)getObject(index);
    }
    public TurnoverCountInfo get(Object key)
    {
        return(TurnoverCountInfo)getObject(key);
    }
    public void set(int index, TurnoverCountInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TurnoverCountInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TurnoverCountInfo item)
    {
        return super.indexOf(item);
    }
}