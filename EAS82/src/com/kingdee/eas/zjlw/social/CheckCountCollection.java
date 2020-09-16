package com.kingdee.eas.zjlw.social;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CheckCountCollection extends AbstractObjectCollection 
{
    public CheckCountCollection()
    {
        super(CheckCountInfo.class);
    }
    public boolean add(CheckCountInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CheckCountCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CheckCountInfo item)
    {
        return removeObject(item);
    }
    public CheckCountInfo get(int index)
    {
        return(CheckCountInfo)getObject(index);
    }
    public CheckCountInfo get(Object key)
    {
        return(CheckCountInfo)getObject(key);
    }
    public void set(int index, CheckCountInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CheckCountInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CheckCountInfo item)
    {
        return super.indexOf(item);
    }
}