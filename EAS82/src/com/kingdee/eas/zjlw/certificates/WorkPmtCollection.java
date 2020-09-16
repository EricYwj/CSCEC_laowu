package com.kingdee.eas.zjlw.certificates;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WorkPmtCollection extends AbstractObjectCollection 
{
    public WorkPmtCollection()
    {
        super(WorkPmtInfo.class);
    }
    public boolean add(WorkPmtInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WorkPmtCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WorkPmtInfo item)
    {
        return removeObject(item);
    }
    public WorkPmtInfo get(int index)
    {
        return(WorkPmtInfo)getObject(index);
    }
    public WorkPmtInfo get(Object key)
    {
        return(WorkPmtInfo)getObject(key);
    }
    public void set(int index, WorkPmtInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WorkPmtInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WorkPmtInfo item)
    {
        return super.indexOf(item);
    }
}