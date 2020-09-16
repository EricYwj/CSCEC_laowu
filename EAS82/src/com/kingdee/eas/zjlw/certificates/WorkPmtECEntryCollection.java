package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WorkPmtECEntryCollection extends AbstractObjectCollection 
{
    public WorkPmtECEntryCollection()
    {
        super(WorkPmtECEntryInfo.class);
    }
    public boolean add(WorkPmtECEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WorkPmtECEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WorkPmtECEntryInfo item)
    {
        return removeObject(item);
    }
    public WorkPmtECEntryInfo get(int index)
    {
        return(WorkPmtECEntryInfo)getObject(index);
    }
    public WorkPmtECEntryInfo get(Object key)
    {
        return(WorkPmtECEntryInfo)getObject(key);
    }
    public void set(int index, WorkPmtECEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WorkPmtECEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WorkPmtECEntryInfo item)
    {
        return super.indexOf(item);
    }
}