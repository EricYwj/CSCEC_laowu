package com.kingdee.eas.zjlw.baseinfo;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WorkTypeCollection extends AbstractObjectCollection 
{
    public WorkTypeCollection()
    {
        super(WorkTypeInfo.class);
    }
    public boolean add(WorkTypeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WorkTypeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WorkTypeInfo item)
    {
        return removeObject(item);
    }
    public WorkTypeInfo get(int index)
    {
        return(WorkTypeInfo)getObject(index);
    }
    public WorkTypeInfo get(Object key)
    {
        return(WorkTypeInfo)getObject(key);
    }
    public void set(int index, WorkTypeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WorkTypeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WorkTypeInfo item)
    {
        return super.indexOf(item);
    }
}