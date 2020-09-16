package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WorkVisacancelCollection extends AbstractObjectCollection 
{
    public WorkVisacancelCollection()
    {
        super(WorkVisacancelInfo.class);
    }
    public boolean add(WorkVisacancelInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WorkVisacancelCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WorkVisacancelInfo item)
    {
        return removeObject(item);
    }
    public WorkVisacancelInfo get(int index)
    {
        return(WorkVisacancelInfo)getObject(index);
    }
    public WorkVisacancelInfo get(Object key)
    {
        return(WorkVisacancelInfo)getObject(key);
    }
    public void set(int index, WorkVisacancelInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WorkVisacancelInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WorkVisacancelInfo item)
    {
        return super.indexOf(item);
    }
}