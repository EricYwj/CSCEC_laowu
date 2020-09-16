package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WorkVisacancelEntryCollection extends AbstractObjectCollection 
{
    public WorkVisacancelEntryCollection()
    {
        super(WorkVisacancelEntryInfo.class);
    }
    public boolean add(WorkVisacancelEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WorkVisacancelEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WorkVisacancelEntryInfo item)
    {
        return removeObject(item);
    }
    public WorkVisacancelEntryInfo get(int index)
    {
        return(WorkVisacancelEntryInfo)getObject(index);
    }
    public WorkVisacancelEntryInfo get(Object key)
    {
        return(WorkVisacancelEntryInfo)getObject(key);
    }
    public void set(int index, WorkVisacancelEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WorkVisacancelEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WorkVisacancelEntryInfo item)
    {
        return super.indexOf(item);
    }
}