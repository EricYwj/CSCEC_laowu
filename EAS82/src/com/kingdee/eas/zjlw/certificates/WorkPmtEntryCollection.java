package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WorkPmtEntryCollection extends AbstractObjectCollection 
{
    public WorkPmtEntryCollection()
    {
        super(WorkPmtEntryInfo.class);
    }
    public boolean add(WorkPmtEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WorkPmtEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WorkPmtEntryInfo item)
    {
        return removeObject(item);
    }
    public WorkPmtEntryInfo get(int index)
    {
        return(WorkPmtEntryInfo)getObject(index);
    }
    public WorkPmtEntryInfo get(Object key)
    {
        return(WorkPmtEntryInfo)getObject(key);
    }
    public void set(int index, WorkPmtEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WorkPmtEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WorkPmtEntryInfo item)
    {
        return super.indexOf(item);
    }
}