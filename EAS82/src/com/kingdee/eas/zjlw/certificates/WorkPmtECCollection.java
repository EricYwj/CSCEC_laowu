package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WorkPmtECCollection extends AbstractObjectCollection 
{
    public WorkPmtECCollection()
    {
        super(WorkPmtECInfo.class);
    }
    public boolean add(WorkPmtECInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WorkPmtECCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WorkPmtECInfo item)
    {
        return removeObject(item);
    }
    public WorkPmtECInfo get(int index)
    {
        return(WorkPmtECInfo)getObject(index);
    }
    public WorkPmtECInfo get(Object key)
    {
        return(WorkPmtECInfo)getObject(key);
    }
    public void set(int index, WorkPmtECInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WorkPmtECInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WorkPmtECInfo item)
    {
        return super.indexOf(item);
    }
}